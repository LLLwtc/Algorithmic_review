package charpter3_array;


public class homework {
    public static void main(String[] args) {
        int[] arr={1,1,2,2,3,4,5};
//        int[] arr={0,2,2,2,2,2,5};
        System.out.println(solve(arr));
    }

    public static int solve(int[] arr) {
        int len = arr.length;
        int ans = 1;

        int slow = 0;
        int fast = 0;

        while (fast < len && slow <= fast) {
            if (arr[slow] == arr[fast]) fast++;
            else {
                if(fast-slow==1)ans++;
                slow=fast;
            }
        }
        return ans;

    }
}
