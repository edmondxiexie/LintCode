import java.util.ArrayList;
import java.util.Collections;

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
}
