
import java.util.*;

/**
 * Created by Edmond on 10/25/16.
 */
public class US_Giants_2 {

    // 172. Remove Element
    public int removeElement(int[] A, int elem) {
        int left = 0;
        int right = A.length - 1;
        while (left < right) {
            while (left < A.length && A[left] != elem) {
                left++;
            }
            while (right >= 0 && A[right] == elem) {
                right--;
            }
            if (left < right) {
                int tmp = A[left];
                A[left] = A[right];
                A[right] = tmp;

                left++;
                right--;
            }
        }
        return right + 1;
    }

    // 138. Subarray Sum
    public static ArrayList<Integer> subarraySum(int[] nums) {
        int len = nums.length;
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum = sum + nums[i];
            if (map.containsKey(sum)) {
                result.add(map.get(sum) + 1);
                result.add(i);
                return result;
            }
            map.put(sum, i);
        }
        return result;
    }

    // 100. Remove Duplicates from Sorted Array
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int slow = 0;
        int fast = 1;

        while (fast < nums.length) {
            while (fast < nums.length && nums[fast] == nums[slow]) {
                fast++;
            }
            if (fast == nums.length) {
                break;
            }
            slow++;
            nums[slow] = nums[fast];
            fast++;
        }
        return slow + 1;
    }

    // 64. Merge Sorted Array
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        int len = m + n;
        int indexA = m - 1;
        int indexB = n - 1;
        for (int i = len - 1; i >= 0; i--) {
            if (indexA >= 0 && (indexB < 0 || A[indexA] > B[indexB])) {
                A[i] = A[indexA];
                indexA--;
            } else {
                A[i] = B[indexB];
                indexB--;
            }
        }
    }

    // 50. Product of Array Exclude Itself
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        int len = A.size();
        ArrayList<Long> result = new ArrayList<>();
        Long[] forward = new Long[len];
        Long[] backward = new Long[len];
        forward[0] = (long)A.get(0);
        for (int i = 1; i < len; i++) {
            forward[i] = forward[i - 1] * (long)A.get(i);
        }
        backward[len - 1] = (long)A.get(len - 1);
        for (int i = len - 2; i >= 0; i--) {
            backward[i] = backward[i + 1] * (long)A.get(i);
        }

        for (int i = 0; i < len; i++) {
            long forPro;
            long backPro;
            if (i - 1 >= 0) {
                forPro = forward[i - 1];
            } else {
                forPro = 1;
            }
            if (i + 1 < len) {
                backPro = backward[i + 1];
            } else {
                backPro = 1;
            }
            result.add(forPro * backPro);
        }
        return result;
    }

    // 189. First Missing Positive
    public int firstMissingPositive(int[] A) {
        // put the element to its right position
        // ex. [1, 2, 3, 4, 5]

        if (A == null || A.length == 0) {
            return 1;
        }

        for (int i = 0; i < A.length; i++) {
            while (A[i] > 0 && A[i] - 1 < A.length && A[i] != i + 1 && A[i] != A[A[i] - 1]) {
                int tmp =  A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i] = tmp;
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }
        return A.length + 1;
    }

    // 59. 3Sum Closest
    private int min;
    private int sum;

    public int threeSumClosest(int[] numbers, int target) {
        min = Integer.MAX_VALUE;
        int[] record = new int[numbers.length];
        int stepsLeft = 3;
        solveThreeSumClosest(numbers, record, target, stepsLeft, 0);
        return sum;
    }

    private void solveThreeSumClosest(int[] numbers, int[] record,
                                      int target, int stepsLeft,
                                      int curSum) {
        if (stepsLeft == 0) {
            int dif = Math.abs(curSum - target);
            if (dif < min) {
                min = dif;
                sum = curSum;
            }
            return;
        }
        for (int i = 0; i < numbers.length; i++) {
            if (record[i] == 1) {
                continue;
            }
            int curNum = numbers[i];
            record[i] = 1;
            solveThreeSumClosest(numbers, record, target, stepsLeft - 1, curSum + curNum);
            record[i] = 0;
        }
    }

    // 57. 3Sum
    public static ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        Set<ArrayList<Integer>> result = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        int[] record = new int[numbers.length];
        solveThreeSum(numbers, record, 0, list, result);
        return new ArrayList<>(result);
    }

    private static void solveThreeSum(int[] numbers, int[] record,
                               int curSum, List<Integer> list,
                               Set<ArrayList<Integer>> result) {
        if (list.size() == 3) {
            if (curSum == 0) {
                ArrayList<Integer> temp = new ArrayList<>(list);
                Collections.sort(temp);
                result.add(temp);
            }
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (record[i] == 1) {
                continue;
            }
            int curNum = numbers[i];
            record[i] = 1;
            list.add(numbers[i]);
            solveThreeSum(numbers, record, curSum + curNum, list, result);
            list.remove(list.size() - 1);
            record[i] = 0;
        }
    }

    // 56. Two Sum
    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        for (int i = 0; i < numbers.length - 1; i++) {
            int sum = numbers[i];
            result[0] = i + 1;
            for (int j = i + 1; j < numbers.length; j++) {
                if (sum + numbers[j] == target) {
                    result[1] = j + 1;
                    return result;
                }
            }
        }
        return result;
    }

    // 31. Partition Array
    public static int partitionArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[left] < k) {
                left++;
            }
            while (left < right && nums[right] >= k) {
                right--;
            }

            if (left >= right) {
                if (nums[right] < k) {
                    return right + 1;
                } else {
                    return right;
                }
            }
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
        return right + 1;
    }

    public static void main(String[] args) {
        int[] nums = {-2,-3,5,-1,-4,5,-11,7,1,2,3,4,-7,-1,-2,-3,-4,-5};
//        System.out.println(removeDuplicates(nums));
        System.out.println(threeSum(nums));
        int[] a = {110,159,48,56,24,192,126,109,102,103,183,194,110,155,110,28,159,183,147,77,58,35,136,175,148,182,140,47,168,76,97,178,190,134,152,197,100,105,104,27,69,99,94,154,138,97,103,171,145,73,94,124,105,188,173,176,184,157,160,161,27,198,20,88,129,28,104,163,31,181,40,60,180,158,54,191,118,152,119,189,134,43,147,23,158,195,148,146,176,78,20,166,24,46,140,178,54,143,86,138,124,195,84,71,24,55,90,188,171,68,111,68,183,195,77,43,142,42,151,141,104,105,62,153,199,159,55,120,169,146,45,64,109,58,136,101,154,74,192,102,84,196,60,111,97,57,194,40,142,41,147,151,141,118,166,185,80,185,80,36,52,100,121,117,37,75,177,85,123,160,100,116,158,129,148,24,137,49,56,128};
        System.out.println(partitionArray(a, 110));
    }
}
