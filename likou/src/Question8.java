package src;

import java.util.HashMap;
import java.util.Map;

/**
 * 力扣第八题 字符串转整数
 */
public class Question8 {
    public static void main(String[] args) {

    }

    public int myAtoi(String s) {
        s = s.trim();
        int sign = 1;
        if (s.equals("")) return 0;

        if (s.charAt(0) == '-') {
            sign = -sign;
            s = s.substring(1);
        }
        if (s.charAt(0) == '+') {
            s = s.substring(1);
        }

        char[] charArray = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (char c : charArray) {
            if (Character.isDigit(c)){
                if (
                        sb.length() > 0 &&
                                (
                                        Integer.parseInt(sb.toString()) * sign > 214748364 ||
                                                (
                                                        Integer.parseInt(sb.toString()) * sign == 214748364
                                                                && Integer.valueOf(String.valueOf(c)) > 7
                                                )
                                )
                ) {
                    break;
                }

                //判断是否 小于 最小32位整数
                if (
                        sb.length() > 0 &&
                                (
                                        Integer.parseInt(sb.toString()) * sign < -214748364 ||
                                                (
                                                        Integer.parseInt(sb.toString()) * sign == -214748364
                                                                && Integer.valueOf(String.valueOf(c))  < -8)
                                )
                ) {
                    break;
                }
            }
        }

        return sb.length() > 0 ? Integer.parseInt(sb.toString()) * sign : 0;
    }
}
