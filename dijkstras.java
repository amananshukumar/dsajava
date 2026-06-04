import java.util.ArrayList;
import java.util.PriorityQueue;

public class dijkstras {
    static class Edge {
    
        int src;
        int dest;
        int wt;
    
        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
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

    static class Pair implements Comparable<Pair> {
        int v;
        int path;
        public Pair(int v, int path) {
            this.v = v;
            this.path = path;
        }
        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path;
        }
    }

    public static void dijkstra(ArrayList<Edge> graph[],int src) {
        int dist[] = new int[graph.length];

        for (int i = 0; i < dist.length; i++) {
            if( i!=src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        boolean vis[]=new boolean[graph.length];
        PriorityQueue<Pair> pq= new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr=pq.remove();
            if(!vis[curr.v]){
                vis[curr.v]=true;
                for (int i = 0; i < graph[curr.v].size(); i++) {
                    Edge e=graph[curr.v].get(i);
                    int u= e.src;
                    int v=e.dest;
                    int wt=e.wt;
                    if(dist[v]>dist[u]+wt){
                        dist[v]=dist[u]+wt;
                        pq.add(new Pair(v,dist[v]));
                    }
                }
            }
        }
        for (int i = 0; i < dist.length; i++) {
            System.out.println(dist[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int V=5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        int src=0;
        dijkstra(graph, src);
    }
}
