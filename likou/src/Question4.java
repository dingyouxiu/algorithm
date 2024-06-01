package src;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.HashMap;
import java.util.Map;

/**
 * 力扣第四题 寻找两个正序数组的中位数.
 */
public class Question4 {
    public static void main(String[] args) {
        String s = "123";
        System.out.println(longestPalindrome1("ac"));
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

    public static String longestPalindrome1(String s) {

        if (s == null || s.length() == 0) {
            return "";
        }
        int strLen = s.length();
        int left = 0;
        int right = 0;
        int len = 1;
        int maxStart = 0;
        int maxLen = 0;

        for (int i = 0; i < strLen; i++) {
            left = i - 1;
            right = i + 1;
            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                len++;
                left--;
            }
            while (right < strLen && s.charAt(right) == s.charAt(i)) {
                len++;
                right++;
            }
            while (left >= 0 && right < strLen && s.charAt(right) == s.charAt(left)) {
                len = len + 2;
                left--;
                right++;
            }
            if (len > maxLen) {
                maxLen = len;
                maxStart = left;
            }
            len = 1;
        }
        return s.substring(maxStart + 1, maxStart + maxLen + 1);

    }

}