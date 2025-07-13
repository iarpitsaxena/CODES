package Graph;

public class FloodFill {


    class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            int prevColor = image[sr][sc];
            if(prevColor != color){
                dfs(image,sr,sc,prevColor,color);
            }
            return image;
        }

        private void dfs(int[][] image, int r, int c,int prevColor,int color){
            if(image[r][c] == prevColor){
                image[r][c] = color;
                if(r >= 1){  //to check if we are not going out of bounds
                    dfs(image,r - 1,c,prevColor,color);
                }
                if(c >= 1){  //to check if we are not going out of bounds
                    dfs(image,r,c - 1, prevColor,color);
                }
                if(r+1 < image.length){ // to check if we are not going out of bounds
                    dfs(image,r+1,c,prevColor,color);
                }
                if(c+1 < image[0].length){ // to check if we are not going out of bounds
                    dfs(image,r,c+1,prevColor,color);
                }
            }
        }
    }


}

