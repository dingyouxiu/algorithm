package src;

import java.util.HashMap;
import java.util.Map;

/**
 * 力扣第七题 整数翻转
 */
public class Question7 {
    public static void main(String[] args) {
        System.out.println(reverse(1463847412));
    }

    public static int reverse(int x) {
        String s = String.valueOf(x);
        StringBuffer res = new StringBuffer();
        if (Character.isDigit(s.charAt(0))) {
            s = s;
        }else {
            res.append(s.charAt(0));
            s = s.substring(1);
        }

        for (int i = s.length() -1; i >= 0; i--) {

            if (
                    res.length() > 2 &&
                            (Integer.parseInt(res.toString()) > 214748364 || (Integer.parseInt(res.toString()) == 214748364 && Integer.valueOf(String.valueOf(s.charAt(i))) > 7))) {
                return 0;
            }
            //判断是否 小于 最小32位整数
            if (res.length() > 2 && (Integer.parseInt(res.toString()) < -214748364 || (Integer.parseInt(res.toString()) == -214748364 && Integer.valueOf(String.valueOf(s.charAt(i)))  < -8))) {
                return 0;
            }
            res.append(s.charAt(i));
        }

        return Integer.parseInt(res.toString());
    }
}
