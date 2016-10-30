import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Edmond on 10/28/16.
 */
public class US_Giants_5 {
    /**
     * 82. Single Number.
     * @param A : an integer array
     * @return : a integer
     */
    public int singleNumber(int[] A) {
        int result = 0;
        for (int num : A) {
            result = result ^ num;
        }
        return result;
    }

    /**
     * 46. Majority Number.
     * @param nums: a list of integers
     * @return find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        Collections.sort(nums);
        return nums.get(nums.size() / 2);
    }

    /**
     * 178. Gas Station.
     * @param gas: an array of integers
     * @param cost: an array of integers
     * @return an integer
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = gas.length - 1;
        int end = 0;
        int sum = gas[start] - cost[start];
        while (end < start) {
            if (sum >= 0) {
                sum += gas[end] - cost[end];
                end++;
            } else {
                start--;
                sum += gas[start] - cost[start];
            }
        }
        if (sum >= 0) {
            return start;
        } else {
            return -1;
        }
    }

    /**
     * 184. Largest Number.
     * @param num: A list of non negative integers
     * @return A string
     */
    public static String largestNumber(int[] num) {
        String[] strs = new String[num.length];
        for (int i = 0; i < num.length; i++) {
            strs[i] = Integer.toString(num[i]);
        }
        Arrays.sort(strs, new strComparator());
        String result = "";
        for (String str : strs) {
            result += str;
        }
        System.out.println(result);
        int index = 0;
        while (index < result.length()) {
            if (result.charAt(index) != '0') {
                break;
            }
            index++;
        }
        if (index == result.length()) {
            return "0";
        }
        return result.substring(index, result.length());
    }

    public static class strComparator implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            String a = (String) o1 + o2;
            String b = (String) o2 + o1;
            return -(a.compareTo(b));
        }
    }

    public static void main(String[] args) {
        int[] a = {1,20,23,4,8};
        System.out.println(largestNumber(a));
    }
}
