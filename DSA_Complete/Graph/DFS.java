package Graph;

import java.util.ArrayList;

public class DFS {
    public static void dfsHelper(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ls){
        vis[node] = true; // mark the node as visited
        ls.add(node); // add the node to the list

        for(int it: adj.get(node)){ // iterate through the adjacent nodes
            if(!vis[it]){ // if the node is not visited
                dfsHelper(it, vis, adj, ls); // call the dfsHelper function recursively
            }
        }
    }


    public ArrayList<Integer> dfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ls = new ArrayList<>();
        boolean[] vis = new boolean[v + 1];
        vis[0] = true;
        dfsHelper(0, vis, adj, ls);
        return ls;
    }
}
