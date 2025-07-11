package Greedy;

import java.util.HashMap;
import java.util.Map;

public class DinnerParty {
    public static int bestDish(int[] arr) {
        Map<Integer, Integer> dishCount = new HashMap<>();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            boolean isAdjacentSame = false;

            if (i > 0 && arr[i] == arr[i - 1]) {
                isAdjacentSame = true;
            }
            if (i < n - 1 && arr[i] == arr[i + 1]) {
                isAdjacentSame = true;
            }

            if (!isAdjacentSame) {
                dishCount.put(arr[i], dishCount.getOrDefault(arr[i], 0) + 1);
            }
        }

        int maxCount = 0;
        int bestDish = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : dishCount.entrySet()) {
            int dish = entry.getKey();
            int count = entry.getValue();

            if (count > maxCount || (count == maxCount && dish < bestDish)) {
                maxCount = count;
                bestDish = dish;
            }
        }

        return bestDish;
    }

    public static void main(String[] args) {
        int[][] testCases = {
                {1, 2, 2, 1, 2},
                {1, 1, 1, 1, 1, 1},
                {1, 2, 2, 2, 3, 4, 2, 1}
        };

        for (int[] testCase : testCases) {
            System.out.println(bestDish(testCase));
        }
    }
}
