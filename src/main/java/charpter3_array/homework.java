package charpter3_array;

import java.util.HashSet;

public class homework {
    /**
     * 帅哥
     * @param arr
     * @return
     */
    public static int removeDuplicates(int[] arr) {
        HashSet<Integer> set = new HashSet<>();//使用HashSet存储数组中的重复元素

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

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 4, 5};
//        int[] arr={0,2,2,2,2,2,5};

        int count = removeDuplicates(arr);

        printArr(arr, count);
    }

    private static void printArr(int[] arr, int length) {
        for (int i = 0; i < length; i++) {
            System.out.println(arr[i]);
        }
    }
}
