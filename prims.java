import java.util.ArrayList;
import java.util.PriorityQueue;

public class prims {
    static class Edge{
        int src;
        int dest;
        int wt;
        
        public Edge (int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }
    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
    }

    static class Pair implements Comparable<Pair>{
        int v;
        int cost;

        public Pair (int v,int c){
            this.v=v;
            this.cost=c;
        }
    
        @Override
        public int compareTo(Pair p2){
            return this.cost-p2.cost;
        }
        
    }

    public static void prims(ArrayList<Edge> graph[]){
        boolean vis[]= new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        int finalcost=0;
        while (!pq.isEmpty()) {
            Pair curr= pq.remove();
            if(!vis[curr.v]){
                vis[curr.v]=true;
                finalcost+=curr.cost;

                for (int i = 0; i < graph[curr.v].size(); i++) {
                    Edge e= graph[curr.v].get(i);
                    pq.add(new Pair(e.dest, e.wt));

                }
            }
        }
        System.out.println("final cost = "+ finalcost);
    }

    public static void main(String[] args) {
        int V=5;
        ArrayList<Edge> graph[]= new ArrayList[V];
        createGraph(graph);
        prims(graph);
    }
}
