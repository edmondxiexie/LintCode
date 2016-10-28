
/**
 * Created by Edmond on 10/26/16.
 */
public class US_Giants_3 {

    /**
     * 141. Sqrt(x).
     * @param x: An integer
     * @return The sqrt of x
     */
    public int sqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        long start = 1;
        long end = x / 2;
        while (start < end) {
            long mid = start + (end - start) / 2;
            if (mid * mid == x) {
                return (int)mid;
            }
            if (mid * mid > x) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        if (start * start > x) {
            return (int)(start - 1);
        }
        return (int)start;
    }

    /**
     * 60. Search Insert Position.
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public int searchInsert(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int start = 0;
        int end = A.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            }
            if (A[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if (A[start] < target) {
            return start + 1;
        }
        return start;
    }

    /**
     * 28. Search a 2D Matrix.
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = 0;
        int col = cols - 1;
        while (row < rows || col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            }
            if (matrix[row][col] > target) {
                col--;
                if (col < 0) {
                    return false;
                }
            } else {
                row++;
                if (row >= rows) {
                    return false;
                }
            }
        }
        return false;
    }

    /**
     * 14. First Position of Target.
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }

        }
        if (nums[start] != target) {
            return -1;
        }
        return start;
    }

    /**
     * 183. Wood Cut.
     * @param L: Given n pieces of wood with length L[i]
     * @param k: An integer
     * @return The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        int end = 0;
        for (int l : L) {
            if (l > end) {
                end = l;
            }
        }
        int start = 0;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int pieces = 0;
            for (int l : L) {
                pieces += l / mid;
            }
            if (pieces < k) {
                end = mid;
            } else {
                start = mid;
            }
     }
     return start;
     }

     /**
     * 159. Find Minimum in Rotated Sorted Array.
     * @param nums: a rotated sorted array
     * @return the minimum number in the array
     */
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            if (nums[start] < nums[end]) {
                return nums[start];
            }
            int mid = start + (end - start) / 2;
            if (nums[start] > nums[mid]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return nums[start];
    }

    /**
     * 75. ind Peak Element.
     * @param A: An integers array.
     * @return return any of peek positions.
     */
    public int findPeak(int[] A) {
        int start = 0;
        int end = A.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
                return mid;
            }
            if (A[mid - 1] < A[mid + 1]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return start;
    }

    /**
     * 74. First Bad Version.
     * @param n: An integers.
     * @return An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        int start = 1;
        int end = n;
        while (start < end) {
            int mid = start + (end - start) / 2;
            // keep below code
//            if (SVNRepo.isBadVersion(mid) == false) {
//                start = mid + 1;
//            } else {
//                end = mid;
//            }
        }
        return start;
    }

    /**
     * 62. Search in Rotated Sorted Array.
     * @param A : an integer rotated sorted array
     * @param target :  an integer to be searched
     * @return : an integer
     */
    public int search(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            }
            if (A[start] == target) {
                return start;
            }
            if (A[end] == target) {
                return end;
            }
            if (A[start] < A[mid]) {
                if (A[start] <= target && target <= A[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (A[mid] <= target && target <= A[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 61. Search for a Range.
     * @param A : an integer sorted array
     * @param target :  an integer to be inserted
     * @return : a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        int[] result = {-1, -1};
        int start = 0;
        int end = A.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                result[0] = findLowerBound(A, target, 0, mid);
                result[1] = findUpperBound(A, target, mid, A.length - 1);
                return result;
            } else if (A[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }
        return result;
    }

    private int findLowerBound(int[] A, int target, int start, int end) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                 end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private int findUpperBound(int[] A, int target, int start, int end) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
}
