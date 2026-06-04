import java.util.*;
public class topSortBFS {
    static class Edge{
        int src;
        int dest;
        
        public Edge(int s,int d){
            this.src=s;
            this.dest=d;
        }     
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>(); 
        }
        
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));
        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));
        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
    }

    public static void calcIndeg(ArrayList<Edge> graph[],int indeg[]) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                indeg[graph[i].get(j).dest]++;
            }
        }
    }

    public static void topSort(ArrayList<Edge> graph[]) {
        int indeg[]=new int[graph.length];
        Queue<Integer> q=new LinkedList<>();

        for (int i = 0; i < indeg.length; i++) {
            if(indeg[i]==0){
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int curr=q.remove();
            System.out.print(curr+" ");
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e=graph[curr].get(i);
                indeg[e.dest]--;
                if(indeg[e.dest]==0){
                    q.add(e.dest);
                }
            }
        }
    }

    public static void printAllPath(ArrayList<Edge> graph[],int src,int dest,String path) {
        if(src==dest){
            System.out.println(path+dest);
            return;
        }
        for(int i=0;i<graph[src].size();i++){
            Edge e=graph[src].get(i);
            printAllPath(graph, e.dest, dest, path+src+" ");
        }
    }

    public static void main(String[] args) {
        int V=5;
        int src=0; 
        int dest=4;
        ArrayList<Edge> graph[]=new ArrayList[5];
        createGraph(graph);
        topSort(graph);
    }
}
