import java.util.ArrayList;

public class pairsum2 {

    public boolean pairSum(ArrayList<Integer> list, int target) {
        int bp = -1;
        int n = list.size();

        // Find breaking point (pivot)
        for (int i = 0; i < n - 1; i++) {     // FIX: i < n-1
            if (list.get(i) > list.get(i + 1)) {
                bp = i;
                break;
            }
        }

        // If no breaking point, array is normally sorted
        if (bp == -1) bp = n - 1;

        int lp = (bp + 1) % n;  // smallest element
        int rp = bp;            // largest element

        while (lp != rp) {
            int sum = list.get(lp) + list.get(rp);

            if (sum == target) {
                System.out.println("Pair found: (" + list.get(lp) + ", " + list.get(rp) + ")");
                return true;
            }

            if (sum < target) {
                lp = (lp + 1) % n;
            } else {
                rp = (n + rp - 1) % n;
            }
        }

        System.out.println("No pair found with the given sum.");
        return false;
    }

    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);

        int target = 16;

        pairsum2 p = new pairsum2();   // FIX
        System.out.println(p.pairSum(list, target));  // FIX
    }
}
