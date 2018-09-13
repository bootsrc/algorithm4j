package com.appjishu.algorithm4j.datastructure.dijkstra;

import java.util.ArrayList;
import java.util.List;

/**
 * Dijkstra算法是最短路径算法中为人熟知的一种，是单起点全路径算法。该算法被称为
 * 是“贪心算法”的成功典范。本文接下来将尝试以最通俗的语言来介绍这个伟大的算法，
 * 并赋予java实现代码。
 * 参考博客https://www.cnblogs.com/junyuhuang/p/4544747.html
 */
public class DijkstraTest {

    public static void main(String[] args){
        List<Vertex> vertexs = new ArrayList<Vertex>();
        Vertex a = new Vertex("A", 0);
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex f = new Vertex("F");
        vertexs.add(a);
        vertexs.add(b);
        vertexs.add(c);
        vertexs.add(d);
        vertexs.add(e);
        vertexs.add(f);
        int[][] edges = {
                {Integer.MAX_VALUE,6,3,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE},
                {6,Integer.MAX_VALUE,2,5,Integer.MAX_VALUE,Integer.MAX_VALUE},
                {3,2,Integer.MAX_VALUE,3,4,Integer.MAX_VALUE},
                {Integer.MAX_VALUE,5,3,Integer.MAX_VALUE,5,3},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,4,5,Integer.MAX_VALUE,5},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,3,5,Integer.MAX_VALUE}

        };
        Graph graph = new Graph(vertexs, edges);
        graph.printGraph();
        graph.search();
    }

}
