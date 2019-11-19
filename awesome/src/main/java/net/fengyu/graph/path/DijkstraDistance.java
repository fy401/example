package net.fengyu.graph.path;

import static java.util.Comparator.comparingDouble;
import com.google.common.base.Preconditions;
import com.google.common.graph.Graphs;

import com.google.common.graph.MutableValueGraph;


import java.util.*;
import java.util.function.Function;

/**
 * @author fengyu
 * @param <N>
 */
public class DijkstraDistance<N>  {
    private final MutableValueGraph<N, Double> graph;
    //private final N source;
//    protected Function<? super E, ? extends Number> nev;
////    protected Map<N, SourceData> sourceMap; // a map of source nodes to an instance of SourceData
//    protected boolean cached;
//    protected double maxDistance;

    /**
     * 算法会改变传进来的graph，用一个拷贝的graph进行运算
     */
//    protected Network<N, E> workGraph;

    //支持的最大结束（目标）节点数量
    protected int maxTargets;

    /**
     *
     * @param graph
     */
    public DijkstraDistance(MutableValueGraph<N,Double> graph) {
        this.graph = graph;
    }



    public Double getDistance(N source, N target) {
        Preconditions.checkArgument(
                graph.nodes().contains(target), "Specified target node %s  is not part of graph %s", target, graph);
        Preconditions.checkArgument(
                graph.nodes().contains(source), "Specified source node %s  is not part of graph %s", source, graph);

        //执行运算的图
        MutableValueGraph<N, Double> workGraph = Graphs.copyOf(graph);
        Set<N> notVisitedNodes = new HashSet<>(workGraph.nodes());

        workGraph.nodes().stream().filter(
                node -> !workGraph.adjacentNodes(source).contains(node))
                .forEach(node -> workGraph.putEdgeValue(source, node, Double.POSITIVE_INFINITY));
        workGraph.putEdgeValue(source, source, 0.0);


        //第一次循环，初始节点为source
        N currentVisitNode = source;

        while(!notVisitedNodes.isEmpty()) {
            N nextVisitNode = findNextNode(workGraph, source, currentVisitNode, notVisitedNodes);
            if(nextVisitNode == null) {
                break;
            }
            notVisitedNodes.remove(currentVisitNode);
        currentVisitNode = nextVisitNode;
    }


        return workGraph.edgeValue(source,target).get();

    }


//    public Map<N, Number> getDistanceMap(N source) {
//        return null;
//        //return getDistanceMap(source, Math.min(g.nodes().size(), maxTargets));
//    }


    /**
     * 查找后续节点
     * @param workGraph
     * @param currentVisitNode
     * @param notVisitedNodes
     * @return
     */
    private N findNextNode(MutableValueGraph<N, Double> workGraph, N source, N currentVisitNode, Set<N> notVisitedNodes) {
        Double shortestPath = Double.MAX_VALUE;
        N nextVisitNode = null;

        for (N node : workGraph.nodes()) {
            if(currentVisitNode.equals(node) || !notVisitedNodes.contains(node)) {
                continue;
            }

            if(workGraph.successors(currentVisitNode).contains(node)) {

                double edgeValue = workGraph.edgeValue(source, currentVisitNode).get()
                        + workGraph.edgeValue(currentVisitNode, node).get();
                double currentPathValue = workGraph.edgeValue(source, node).get();
                if(edgeValue > 0) {
                    workGraph.putEdgeValue(source, node, Math.min(edgeValue, currentPathValue));
                }

                if(workGraph.edgeValue(source, node).get() < shortestPath) {
                    shortestPath = workGraph.edgeValue(source, node).get();
                    nextVisitNode = node;
                }
            }
        }

        return nextVisitNode;
    }

}
