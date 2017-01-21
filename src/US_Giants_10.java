import java.util.List;
import java.util.Stack;

/**
 * Created by Edmond on 11/10/16.
 */
public class US_Giants_10 {
    /**
     * @param height: A list of integer
     * @return The area of largest rectangle in the histogram
     */
    public static int largestRectangleArea(int[] height) {
        int max = 0;
        int len = height.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= len; i++) {
            int curHeight;
            if (i < len) {
                curHeight = height[i];
            } else {
                curHeight = 0;
            }
            while (!stack.isEmpty() && curHeight < height[stack.peek()]) {
                int topIndex = stack.pop();
                int w = stack.isEmpty()? i : i - stack.peek() - 1;
                int h = height[topIndex];
                int area = w * h;
                System.out.println(area);
                max = Math.max(max, area);
            }
            stack.push(i);
        }
        return max;
    }

    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
//    public int[] medianII(int[] nums) {
//        List<Integer> result;
//        if (nums.size() == 0) {
//            return result;
//        }
//
//        int median = nums[0];
//        priority_queue<int> maxHeap, minHeap;
//
//        result.push_back(median);
//        for (int i = 1; i < nums.size(); i++) {
//            if (nums[i] < median) {
//                maxHeap.push(nums[i]);
//            } else {
//                minHeap.push(-nums[i]);
//            }
//
//            if (maxHeap.size() > minHeap.size()) {
//                minHeap.push(-median);
//                median = maxHeap.top();
//                maxHeap.pop();
//            } else if (maxHeap.size() + 1 < minHeap.size()) {
//                maxHeap.push(median);
//                median = -minHeap.top();
//                minHeap.pop();
//            }
//
//            result.push_back(median);
//        }
//
//        return result;
//    }

    public static void main(String[] args) {
        int[] nums = {5,4,1,2};
        largestRectangleArea(nums);
    }



}
