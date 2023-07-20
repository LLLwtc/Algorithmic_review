package charpter3_array;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class homework {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 4, 5};
//        int[] arr={0,2,2,2,2,2,5};
        int count = solve(arr);

        for (int i = 0; i < count; i++) {
            System.out.println(arr[i]);
        }


    }

    public static int solve(int[] arr) {
        HashSet<Integer> set = new HashSet<>();

        int len = arr.length;
        int slow = 0;
        for (int fast = 1; fast < len; fast++, slow++) {
            if (arr[fast] == arr[slow]) {
                set.add(arr[fast]);
            }
        }

        slow = 0;
        for (int fast = 0; fast < len; fast++) {
            if (!set.contains(arr[fast])) {
                arr[slow] = arr[fast];
                slow++;
            }
        }
        return slow;
    }
}
