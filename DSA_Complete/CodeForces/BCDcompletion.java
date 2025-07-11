package CodeForces;

import java.util.*;

public class BCDcompletion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }

        if (set.size() < 2) {
            System.out.println("NO");
            return;
        }

        List<Integer> num = new ArrayList<>(set);
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < num.size(); i++) {
            adj.add(new ArrayList<>());
        }

        // For example, let's compute GCD of first two distinct elements
        int result = GCD(num.get(0), num.get(1));
        System.out.println("GCD of first two unique elements: " + result);
    }

    public static int GCD(int a, int b) {
        while (b != 0) {
            int rem = a % b;
            a = b;
            b = rem;
        }
        return a;
    }
}
