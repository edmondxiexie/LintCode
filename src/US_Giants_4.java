import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Edmond on 10/27/16.
 */
public class US_Giants_4 {

    /**
     * 181.  Flip Bits.
     * @param a, b: Two integer
     * @return An integer
     */
    public static int bitSwapRequired(int a, int b) {
        int tmp = a^b;
        int mask = 1;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += tmp & mask;
            tmp = tmp >> 1;
        }
        return count;
    }

    /**
     * 142. O(1) Check Power of 2.
     * @param n: An integer
     * @return True or false
     */
    public boolean checkPowerOf2(int n) {
        if (n == Integer.MIN_VALUE) {
            return false;
        }
        int count = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            count += n & mask;
            n = n >> 1;
        }
        return count == 1;
    }

    /**
     * 114. Unique Paths.
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    public static int uniquePaths(int m, int n) {
        int[][] grid = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i == 1 && j == 1) {
                    grid[i][j] = 1;
                    continue;
                }
                grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
            }
        }
        return grid[m][n];
    }

    /**
     * 2. Trailing Zeros.
     * param n: As desciption
     * return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) {
        long count = 0;
        while (n > 0) {
            count += n / 5;
            n = n / 5;
        }
        return count;
    }

    /**
     * 179. Update Bits。
     * @param n, m: Two integer
     * @param i, j: Two bit positions
     * @return An integer
     */
    public int updateBits(int n, int m, int i, int j) {
        int mask = -1;
        if (j - i + 1 == 32) {
            mask = -1;
        } else {
            mask = ~(mask << j - i + 1);
        }
        mask = ~(mask << i);
        n = n & mask;
        m = m << i;
        return n | m;
    }

    /**
     * 163. Unique Binary Search Trees.
     * @paramn n: An integer
     * @return An integer
     */
    public int numTrees(int n) {
        int[] numBST = new int[n + 1];
        numBST[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                numBST[i] += numBST[j] * numBST[i - j - 1];
            }
        }
        return numBST[n];
    }

    /**
     * 140. Fast Power.
     * @param a, b, n: 32bit integers
     * @return An integer
     */
    public int fastPower(int a, int b, int n) {
        if (b == 1) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return a % b;
        }
        int sub = n / 2;
        int carry = n % 2;
        long result = fastPower(a, b, sub);
        return (int)((result * result) % b * fastPower(a, b, carry) % b) % b;
    }

    /**
     * 180. Binary Representation.
     * @param n: Given a decimal number that is passed in as a string
     * @return A string
     */
    public String binaryRepresentation(String n) {
        String[] nums = n.split("\\.");
        int integer = Integer.parseInt(nums[0]);
        double fraction = Double.parseDouble("0." + nums[1]);
        String intPart = parseInteger(integer);
        String fracPart = parseFraction(fraction);
        if (fracPart.equals("ERROR")) {
            return "ERROR";
        }
        String result = "";
        if (intPart.length() == 0) {
            result += "0";
        }
        result += intPart;
        if (fracPart.length() != 0) {
            result += "." + fracPart;
        }
        return result;
    }

    private String parseInteger(int n) {
        String result = "";
        while (n >= 1) {
            result = n % 2 + result;
            n = n / 2;
        }
        return result;
    }

    private String parseFraction(double n) {
        String result = "";
        List<Integer> list = new ArrayList<>();
        while (n > 0) {
            if (list.contains((int)(n * 100000)) || result.length() > 32) {
                return "ERROR";
            }
            list.add((int)(n * 100000));
            n = n * 2;
            result += (int)(n / 1);
            n = n % 1;
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(uniquePaths(1, 3));
//        System.out.println(binaryRepresentation("1.0"));
    }
}
