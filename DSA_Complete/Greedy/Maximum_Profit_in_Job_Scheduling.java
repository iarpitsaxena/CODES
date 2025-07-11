package Greedy;
import java.util.*;

public class Maximum_Profit_in_Job_Scheduling {
    public static void main(String[] args) {
        // Sample input
        int[] startTime = {1, 2, 3, 4, 6};
        int[] endTime =   {3, 5, 10, 6, 9};
        int[] profit =    {20, 20, 100, 70, 60};

        // Create Solution object
         Solution solution = new Solution();

        // Call the method and print the result
        int maxProfit = solution.jobScheduling(startTime, endTime, profit);
        System.out.println("Maximum Profit: " + maxProfit);
    }

    static class Solution {
        private record Job(int startTime, int endTime, int profit) {}

        public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
            final int n = startTime.length;
            Job[] jobs = new Job[n];

            for (int i = 0; i < n; ++i) {
                jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
            }

            Arrays.sort(jobs, Comparator.comparingInt(Job::startTime));

            for (int i = 0; i < n; i++) {
                startTime[i] = jobs[i].startTime();
            }

            return getMaxProfit(jobs);
        }

        private int getMaxProfit(Job[] jobs) {
            int maxProfit = 0;
            Queue<Job> minHeap = new PriorityQueue<>(Comparator.comparingInt(Job::endTime));

            for (Job job : jobs) {
                while (!minHeap.isEmpty() && job.startTime() >= minHeap.peek().endTime()) {
                    maxProfit = Math.max(maxProfit, minHeap.poll().profit());
                }
                minHeap.offer(new Job(job.startTime(), job.endTime(), job.profit() + maxProfit));
            }

            while (!minHeap.isEmpty()) {
                maxProfit = Math.max(maxProfit, minHeap.poll().profit());
            }

            return maxProfit;
        }
    }

}
