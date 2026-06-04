import java.util.*;
public class floodfill {
    public void helper(int[][] image, int sr, int sc, int color,boolean vis[][],int orgColor){ 
       if(sc<0 || sc>=image[0].length || sr<0 || sr>=image.length || vis[sr][sc]==true || image[sr][sc]!=orgColor) return image;
        //left
        helper(image, sr, sc-1, color, vis, orgColor);
        //right
        helper(image, sr, sc+1, color, vis, orgColor);
        //top
        helper(image, sr-1, sc, color, vis, orgColor);
        //bottom
        helper(image, sr+1, sc, color, vis, orgColor);
       
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean vis[][]=new boolean[image.length][image[0].length];
        helper(image, sr, sc, color, vis, image[sr][sc]);
        return image;
    }

    public static void main(String[] args) {
        floodFill()
    }
}