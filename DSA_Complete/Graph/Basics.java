package Graph;

import java.util.ArrayList;

public class Basics {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        int n = 3, m =3;
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<Integer>());
        }
//        int[][] edges = new int[n+1][n+1];
//        edges[1][2] = 1;
//        edges[2][1] = 1;
//        edges[2][3] = 1;
//        edges[3][2] = 1;
//        edges[1][3] = 1;
//        edges[3][1] = 1;

        //edge from 1 to 2
        adj.get(1).add(2);
        adj.get(2).add(1);

        //edge from 2 to 3
        adj.get(2).add(3);
        adj.get(3).add(2);

        //edge from 1 to 3
        adj.get(1).add(3);
        adj.get(3).add(1);


        for(int i = 1; i <= n; i++) {
//            System.out.print(i + " -> ");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }

    }
}
