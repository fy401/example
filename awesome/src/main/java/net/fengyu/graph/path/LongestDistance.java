package net.fengyu.graph.path;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.graph.EndpointPair;
import com.google.common.graph.Graphs;
import com.google.common.graph.MutableValueGraph;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * 只支持不小于0的Double类型作为边（EdgeValue）的值
 * @param <N>
 */
public class LongestDistance<N> {

    //原始图
    private final MutableValueGraph<N, Double> originalGraph;
    //工作图
    private MutableValueGraph<N, Double> graph;
    //起始节点
    private final N sourceNode;

    public boolean calculated = false;


    public LongestDistance(MutableValueGraph<N, Double> graph , N sourceNode) {
        this.originalGraph = graph;
        this.sourceNode = sourceNode;
        this.check();
        //复制一个图用于计算，避免篡改传进来的原始图
        this.graph = Graphs.copyOf(this.originalGraph);
    }

    private void check() {
        Preconditions.checkArgument(
                originalGraph.nodes().contains(sourceNode), "Specified source node %s  is not part of graph %s", sourceNode, originalGraph);

        Set<EndpointPair<N>> set = originalGraph.edges();
        for(EndpointPair<N> e : set) {
            Preconditions.checkArgument(originalGraph.edgeValue(e).get() >= 0.0,"This parameter edgeValue %s does not allow negative numbers",e);
        }
    }

    /**
     * 返回处理后的图
     * @return
     */
    public MutableValueGraph<N, Double> getCalculatedGraph() {
        if(!calculated) {
            synchronized (this.getClass()) {
                if(!calculated) {
                    calculate();
                    calculated = true;
                }
            }
        }
        return this.graph;
    }


    public void calculate() {

        List<N> topologicalSortingList = Lists.newArrayList();

        //sourceNode没有前驱节点，入度为0
        topologicalSortingList.add(sourceNode);
        //移除sourceNode
        graph.removeNode(sourceNode);
        //生成图的拓扑排序,这是求最大路径的关键
        while (graph.nodes().size()>0) {
            for (N node : graph.nodes()) {
                if (graph.inDegree(node) == 0) {
                    topologicalSortingList.add(node);
                    graph.removeNode(node);
                    break;
                }
            }
        }
        //打印拓扑排序
//        System.out.println(topologicalSortingList);

        //恢复graph
        graph = Graphs.copyOf(this.originalGraph);

        //
        initPathFromSourceNode(sourceNode);
        //更新临接节点的距离
        for(int i=0; i<topologicalSortingList.size(); i++) {
            N currentVisitNode = topologicalSortingList.get(i);

            for(N node : graph.successors(currentVisitNode)) {
                if(currentVisitNode.equals(node)) {
                    continue;
                }
                double edgeValue = graph.edgeValue(sourceNode, currentVisitNode).get()
                        + graph.edgeValue(currentVisitNode, node).get();
                double currentPathValue = graph.edgeValue(sourceNode, node).get();
                if(edgeValue > 0) {
                    graph.putEdgeValue(sourceNode, node, Math.max(edgeValue, currentPathValue));
                }
            }
        }
//        System.out.println(graph);
    }

    private void initPathFromSourceNode(N sourceNode) {
        graph.nodes().stream().filter(
                node -> !graph.adjacentNodes(sourceNode).contains(node))
                .forEach(node -> graph.putEdgeValue(sourceNode, node, 0D));
        graph.putEdgeValue(sourceNode, sourceNode, 0D);
    }


}
