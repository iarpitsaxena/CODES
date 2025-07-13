package Graph;

import java.util.ArrayList;

public class NumberOfProvinces {

    private static void dfsHelper(int node, int[] vis, ArrayList<ArrayList<Integer>> adjLst) {
        vis[node] = 1; // mark the node as visited
        for(int it : adjLst.get(node)){
            if(vis[it] == 0){
                dfsHelper(it,vis, adjLst); // call the dfsHelper function recursively
            }
        }
    }
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        ArrayList<ArrayList<Integer>> adjLst = new ArrayList<>();
        for(int i = 0; i < V;i++){
            adjLst.add(new ArrayList<>());
        }

        // to change adjLst to matrix
        for(int i = 0; i < V;i++){
            for(int j = 0;j < V;j++){
                if(adj.get(i).get(j) ==1 && i!=j){
                    adjLst.get(i).add(j);
                    adjLst.get(j).add(i);
                }
            }
        }
        int[] vis = new int[V];
        int count = 0;
        for(int i = 0; i < V ; i++){
            if(vis[i] == 0){
                count ++;
                dfsHelper(i,vis,adjLst);
            }
        }
        return count;
    }
}
