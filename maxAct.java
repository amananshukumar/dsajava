import java.util.*;

public class maxAct {
    public static void main(String[] args) {

        int start[] = {1, 3, 0, 5, 8, 5};
        int end[]   = {2, 4, 6, 7, 9, 9};

        int n = start.length;

        // activity array -> {index, start, end}
        int activities[][] = new int[n][3];

        for (int i = 0; i < n; i++) {
            activities[i][0] = i;       // original index
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        // sort by end time
        Arrays.sort(activities, Comparator.comparingInt(o -> o[2]));

        ArrayList<Integer> list = new ArrayList<>();

        // first activity
        list.add(activities[0][0]);
        int maxAct = 1;
        int lastEnd = activities[0][2];

        // select non-overlapping activities
        for (int i = 1; i < n; i++) {

            if (activities[i][1] >= lastEnd) {
                list.add(activities[i][0]);
                maxAct++;
                lastEnd = activities[i][2];
            }
        }

        System.out.println("Maximum Activities = " + maxAct);

        System.out.print("Selected Activities: ");
        for (int idx : list) {
            System.out.print("A" + idx + " ");
        }
    }
}