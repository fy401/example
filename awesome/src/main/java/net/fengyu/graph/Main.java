package net.fengyu.graph;


import com.google.common.graph.*;

import net.fengyu.graph.path.LongestDistance;
import net.fengyu.graph.path.Vertex;

import java.util.Objects;
import java.util.Set;


public class Main {
    public static void main(String[] args) {


/*
        MutableValueGraph<Integer, Double> weightedGraph = ValueGraphBuilder.directed().allowsSelfLoops(true).build();


        weightedGraph.putEdgeValue(1, 2, 0.5);

        weightedGraph.putEdgeValue(2, 3, 0D);
        weightedGraph.putEdgeValue(2, 5, 1.3);
        weightedGraph.putEdgeValue(3, 4, 2.5);
        weightedGraph.putEdgeValue(5, 4, 0D);
        weightedGraph.putEdgeValue(4, 7, 0.8);
        weightedGraph.putEdgeValue(5, 6, 1.7);
        weightedGraph.putEdgeValue(6, 7, 1.5);
        weightedGraph.putEdgeValue(4, 6, 0.4);

        System.out.println(weightedGraph.toString());

        Set<Integer> afternodes = weightedGraph.successors(5);
        Set<Integer> prenodes = weightedGraph.predecessors(5);

        System.out.println(afternodes);
        System.out.println(prenodes);

        for(Integer pnode :prenodes) {
            for(Integer apnode :afternodes) {
                weightedGraph.putEdgeValue(pnode,apnode,weightedGraph.edgeValue(pnode,5).get()
                        + weightedGraph.edgeValue(5,apnode).get());
            }
        }

        weightedGraph.removeNode(5);


        System.out.println(weightedGraph.toString());

 */

//------------------------------------------------



        Vertex v1 = new Vertex(1,"node1");
        Vertex v2 = new Vertex(2,"node2");
        Vertex v3 = new Vertex(3,"node3");
        Vertex v4 = new Vertex(4,"node4");   //name=node4是网关
        Vertex v5 = new Vertex(5,"node5");
        Vertex v6 = new Vertex(6,"node6");
        Vertex v7 = new Vertex(7,"node7");
        Vertex v8 = new Vertex(8,"node8");



//        Vertex v6 = new Vertex(1,"node1");
//        System.out.println(v1.equals(v1));
//        System.out.println(v1.equals(v2));
//        System.out.println(v1.equals(v6));

//        System.out.println(Objects.hashCode(v1));
//        System.out.println(Objects.hashCode(v2));

        MutableValueGraph<Vertex, Double> testGraph = ValueGraphBuilder.directed().allowsSelfLoops(true).build();
        testGraph.putEdgeValue(v1, v2, 1.5);
        testGraph.putEdgeValue(v2, v3, 1.1);
        testGraph.putEdgeValue(v2, v4, 0D);
        testGraph.putEdgeValue(v3, v8, 1.8);
        testGraph.putEdgeValue(v4, v5, 2.5);
        testGraph.putEdgeValue(v5, v8, 0.7);
        testGraph.putEdgeValue(v4, v6, 1.2);
        testGraph.putEdgeValue(v6, v7, 3.4);
        testGraph.putEdgeValue(v7, v8, 0.2);

        //打印原始图
        System.out.println(testGraph.toString());


        //裁剪node4网关节点
        Set<Vertex> afternodes = testGraph.successors(v4);
        Set<Vertex> prenodes = testGraph.predecessors(v4);
        for(Vertex pnode :prenodes) {
            for(Vertex apnode :afternodes) {
                if(apnode.equals(v6)) {     //v6为网关节点不走的路径
                    continue;
                }
                testGraph.putEdgeValue(pnode,apnode,testGraph.edgeValue(pnode,v4).get()
                        + testGraph.edgeValue(v4,apnode).get());
            }
        }
        testGraph.removeNode(v4);
        //打印删除v4后的图
        System.out.println(testGraph.toString());

        //删除无头节点
        boolean loop = false;  //循环结束标记，如果没有找到要删的无头节点，结束循环
        do {
            loop = false;
            for (Vertex node : testGraph.nodes()) {
                if (testGraph.inDegree(node) == 0 ) {
                    if(!node.equals(v1)) {//这个节点不是初始节点
                        testGraph.removeNode(node);
                        loop = true;
                        break;
                    }
                }
            }
        } while (loop);

        //打印删除无头节点后的图
        System.out.println(testGraph.toString());


        LongestDistance distanceVertex = new LongestDistance(testGraph,v1);
        MutableValueGraph<Vertex, Double>  graphVertex = distanceVertex.getCalculatedGraph();
        System.out.println(graphVertex.toString());
    }
}
