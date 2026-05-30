import java.util.*;
public class graph {
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }

    public static void dfs(ArrayList<Edge> graph[]){
        boolean vis[]=new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            dfsUtil(graph, i, vis);
        }
    }

    public static void dfsUtil(ArrayList<Edge> graph[],int curr,boolean vis[]){
       // visit
       System.out.println(curr+" ");
       vis[curr]=true;

       for (int i = 0; i < graph[curr].size(); i++) {
           Edge e=graph[curr].get(i);
           if(!vis[e.dest]){
               dfsUtil(graph, curr, vis);
           }
       }
    }

    public static boolean detectCycle(ArrayList<Edge> graph[]) {
        boolean vis[]=new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if(!vis[i]){
               if( detectCycleUtil(graph, vis, i, -1)){
                   return true;
               }
                }
            }        
        return false;
    } 

    public static boolean  detectCycleUtil(ArrayList<Edge> graph[],boolean vis[],int curr,int par) {
        vis[curr]=true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e=graph[curr].get(i);
            if(!vis[e.dest]){
                if(detectCycleUtil(graph, vis, e.dest, curr)){
                    return true;
                }
            }
            else if(e.dest!=par){
                return true;
            }
        }
        return false;
    }

    public static boolean isBipartite(ArrayList<Edge> graph[]) {
        int col[]=new int[graph.length];
        for (int i = 0; i < col.length; i++) {
            col[i]=-1;
        }
        Queue<Integer> q=new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if(col[i]==-1){
                q.add(i);
                col[i]=0;
                while (!q.isEmpty()) {
                    int curr=q.remove();
                    for (int j = 0; j < col.length; j++) {
                        Edge e = graph[curr].get(j);
                        if(col[e.dest]==-1){
                            int nextCol=col[curr]==0?1:0;
                            col[e.dest]=nextCol;
                            q.add(e.dest);
                        }else if(col[e.dest]==col[curr]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static boolean isCycle(ArrayList<Edge> graph[]) {
        boolean vis[]=new boolean[graph.length];
        boolean stack[]=new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if(!vis[i]){
                if(isCycleUtil(graph, vis, stack, i)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge> graph[],boolean vis[],boolean stack[],int curr) {
        vis[curr]=true;
        stack[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e =graph[curr].get(i);
            if(stack[e.dest]){
                return true;
            }
            if(!vis[e.dest] && isCycleUtil(graph, vis, stack, e.dest)){
                return true;
            }
        }
        stack[curr]=false;
        return false;
    }

    public static void topologicalSort(ArrayList<Edge> graph[]) {
        boolean vis[]=new boolean[graph.length];
        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i < graph.length; i++) {
            if(!vis[i]){
                topologicalSortUtil(graph, vis, stack, i);
            }
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    public static void topologicalSortUtil(ArrayList<Edge> graph[],boolean vis[],Stack<Integer> stack,int curr) {
        vis[curr]=true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e=graph[curr].get(i);
            if(!vis[e.dest]){
                topologicalSortUtil(graph, vis, stack, e.dest);
            }
        }
        stack.push(curr);
    }

    public static boolean hasPath(ArrayList<Edge> graph[],int src,int dest,boolean vis[]){
        if (src==dest) {
            return true;
        }
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e=graph[src].get(i);
            //e.dest=neighbour
            if(!vis[e.dest] && hasPath(graph,e.dest,dest,vis)){
                return true;
            }
        }
        return false;
    }

    public static void bfs(ArrayList<Edge> graph[]){
        boolean vis[]=new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if(!vis[i]){
                bfsUtil(graph);
            }
        }

    }

    public static void bfsUtil(ArrayList<Edge> graph[]){
        Queue<Integer> q=new LinkedList<>();
        boolean vis[]=new boolean[graph.length];
        q.add(0);
        while (!q.isEmpty()) {
            int curr=q.remove();
            if(!vis[curr]){
                System.out.println(curr+" ");
                vis[curr]=true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e=graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        int V=5;;
        ArrayList<Edge> graph[]=new ArrayList[5];
        for(int i=0;i<V;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,1));
        graph[0].add(new Edge(0,2,1));
        graph[1].add(new Edge(1,0,1));
        graph[1].add(new Edge(1,3,1));
        graph[2].add(new Edge(2,0,1));
        graph[2].add(new Edge(2,4,1));
        graph[3].add(new Edge(3,1,1));
        graph[3].add(new Edge(3,4,1));
        graph[4].add(new Edge(4,2,1));
        graph[4].add(new Edge(4,3,1));

        for (int i = 0; i < graph[2].size(); i++) {
            Edge e=graph[2].get(i);
            System.out.println(e.src+" "+e.dest+" "+e.wt);
        }
    }
}
