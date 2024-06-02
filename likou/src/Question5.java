package src;

import java.util.HashMap;
import java.util.Map;

/**
 * 力扣第五题 最长回文子串
 */
public class Question5 {
    public static void main(String[] args) {

    }

    public static String longestPalindrome(String s) {
        char[] charArray = s.toCharArray();
        if(charArray.length < 2) return s;
        String res = String.valueOf(charArray[0]);
        if (charArray.length == 0) return "";
        int left = 0, right = 0, maxLen = 0;
        for (int mid = 0; mid < charArray.length; mid++) {
            left = right = mid;
            // 向右扩散
            while (left > 0) {
                if (charArray[left - 1] == charArray[mid]) {
                    left--;
                    continue;
                }
                break;
            }

            // 向左扩散
            while (right < charArray.length - 1) {
                if (charArray[right + 1] == charArray[mid]){
                    right++;
                    continue;
                }
                break;
            }

            // 向两边扩展
            while (left - 1 >= 0 && right + 1 < charArray.length) {
                if (charArray[left - 1] == charArray[right + 1]){
                    left--;
                    right++;
                    continue;
                }
                break;
            }

            if (maxLen < right - left + 1) {
                if (right > left) res = s.substring(left, right + 1);
                maxLen = right - left + 1;
            }

        }

        return res;
    }
}
