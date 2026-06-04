public class disjointsetDS {
    static int n=7;
    static int par[]=new int[n];
    static int rank[]=new int[n];
    
    public static void init(){
        for(int i=0;i<n;i++){
            par[i]=i;
            rank[i]=1;
        }
    }

    public static int find(int x){
        if(par[x]==x){
            return x;
        }
        return par[x]=find(par[x]);
    }

    public static void union(int a,int b){
        int parA=find(a);
        int parB=find(b);

        if(rank[parA]>rank[parB]){
            par[parB]=parA;
        }
        else if(rank[parA]<rank[parB]){
            par[parA]=parB;
        }
        else{
            par[parB]=parA;
            rank[parA]++;
        }
    }

    public static void main(String[] args) {
        init();
        union(0,1);
        union(1,2);
        union(3,4);
        union(4,5);
        union(5,6);
        System.out.println(find(3));
    }
}
