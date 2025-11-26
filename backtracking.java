public class backtracking {

    public static void findsubsets(String str,String ans,int i){
        //base case
        if(i==str.length()){
            if(ans.length()==0){
                System.out.println("null");
            }
            else{
                System.out.println(ans);
            }
            return;
        }

        //include
        findsubsets(str, ans+str.charAt(i), i+1);

        //exclude
        findsubsets(str, ans, i+1);
    }

    public static void findpermutation(String str, String ans){
        //base case
        if(str.length()==0){
            System.out.println(ans);
            return;
        }

        for(int i=0;i<str.length();i++){
            char curr=str.charAt(i);
            String newstr=str.substring(0,i)+str.substring(i+1);
            findpermutation(newstr, ans+curr);
        }
    }

    public static void main(String args[]){
        String str="abc";
        findsubsets(str, "", 0);

    }
}
