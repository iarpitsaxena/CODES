package Graph;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;

public class BFS {
    public ArrayList<Integer> bfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] vis = new boolean[v];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        vis[0] = true;

        while(!q.isEmpty()){
            Integer node = q.poll();
            bfs.add(node);
            for(int it: adj.get(node)){
                if(vis[it] == false){ // !vis[it]
                    vis[it] = true;
                    q.add(it);
                }
            }
        }
        return bfs;

    }
}
