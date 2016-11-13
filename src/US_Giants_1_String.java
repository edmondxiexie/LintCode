/**
 * Created by Edmond on 11/12/16.
 */
public class US_Giants_1_String {
    /**
     * 54. String to Integer II.
     *  1. 判断字符串是否为空
        2. 取消掉字符串中的所有空格，用String.trim()
        3. 判断第一位是否为'+'或者'-'
        4. 循环每一位
        4.1 判断是否有小数点'.'出现
        4.2 判断是否每一位都属于[0 ~ 9]
        4.3 当长度超过14时候，跳出循环，避免超长字符串的事儿
        4.4 更新，记录当前的数字是多少
        5. 如果前面是negative，加符号
        6. 判断是否超过INT_MAX或者INT_MIN
     * @param str: A string
     * @return An integer
     */
    public int atoi(String str) {
        if (str.length() == 0) {
            return 0;
        }
        long result = 0;
        int maxLength = (int)Math.log10(Integer.MAX_VALUE) + 1;

        str = str.trim();
        int sign = 1;
        if (str.charAt(0) == '+' || str.charAt(0) == '-') {
            char signChar = str.charAt(0);
            if (signChar == '-') {
                sign = -1;
            }
            str = str.substring(1);
        }

        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            if (i > maxLength) {
                break;
            }
            if (cur < '0' || cur > '9') {
                break;
            }
            result = result * 10 + (cur - '0');
        }

        result = result * sign;
        if (result > (long)Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (result < (long)Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int)result;
    }
}
