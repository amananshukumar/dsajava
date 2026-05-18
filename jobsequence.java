import java.util.*;

public class jobsequence {

    static class Job {
        int deadline;
        int profit;
        int id;

        // Correct constructor name
        public Job(int i, int d, int p) {
            id = i;
            deadline = d;
            profit = p;
        }
    }

    public static void main(String[] args) {

        int jobsInfo[][] = { {4,20}, {1,10}, {1,40}, {1,30} };

        ArrayList<Job> jobs = new ArrayList<>();

        for (int i = 0; i < jobsInfo.length; i++) {
            jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1]));
        }

        // Sort jobs according to profit in descending order
        Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit);

        ArrayList<Integer> ans = new ArrayList<>();

        int time = 0;

        for (int i = 0; i < jobs.size(); i++) {
            Job curr = jobs.get(i);

            if (time < curr.deadline) {
                time++;
                ans.add(curr.id);
            }
        }

        System.out.println("Max jobs = " + ans.size());

        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
}