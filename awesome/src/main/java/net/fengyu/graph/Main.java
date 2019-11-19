package net.fengyu.graph;

import com.google.common.collect.Maps;
import com.google.common.graph.*;
import net.fengyu.graph.path.DijkstraDistance;
import net.fengyu.graph.path.LongestDistance;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {



        MutableValueGraph<Integer, Double> weightedGraph = ValueGraphBuilder.directed().allowsSelfLoops(true).build();


        weightedGraph.putEdgeValue(1, 2, 0.5);

        weightedGraph.putEdgeValue(2, 3, 1.1);
        weightedGraph.putEdgeValue(2, 5, 1.3);
        weightedGraph.putEdgeValue(3, 4, 2.5);
        weightedGraph.putEdgeValue(5, 4, 3.1);
        weightedGraph.putEdgeValue(4, 7, 0.8);
        weightedGraph.putEdgeValue(5, 6, 0.7);
        weightedGraph.putEdgeValue(6, 7, 1.5);
        weightedGraph.putEdgeValue(4, 6, 0.4);



        System.out.println(weightedGraph.toString());

//        weightedGraph.removeNode(1);
//        System.out.println(weightedGraph.toString());
        //System.out.println(weightedGraph.successors(1));

        LongestDistance distance = new LongestDistance(weightedGraph,1);

        MutableValueGraph<Integer, Double>  graph = distance.getCalculatedGraph();

        System.out.println(graph.toString());

    }
}
