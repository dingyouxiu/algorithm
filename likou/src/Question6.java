package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 力扣第六题 Z字形转换
 */
public class Question6 {
    public static void main(String[] args) {

    }

    public String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }

        StringBuffer result = new StringBuffer();

        List<StringBuffer> strList = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            strList.add(new StringBuffer());
        }


        int flag = 1; // 1＋ -1－
        int clo = 0;
        for (char c : s.toCharArray()) {
            if (clo == 0) flag = 1;
            if (clo == numRows -1) flag = -1;
            strList.get(clo).append(c);
            clo = flag == 1 ? ++clo : --clo;
        }

        for (StringBuffer stringBuffer : strList) {
            result.append(stringBuffer);
        }

        return result.toString();
    }
}
