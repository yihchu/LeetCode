package In.House.Q401;

import java.util.*;

public class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        if (turnedOn == 0) {
            result.add("0:00");
            return result;
        }
        doReadBinaryWatch(result, "", 10, turnedOn);
        return result;
    }

    private void doReadBinaryWatch(List<String> result, String prefix, int pos, int turnedOn) {
        if (pos < turnedOn || (pos == 8 && prefix.startsWith("11"))) {
            return;
        }
        if (turnedOn == 1) {
            char[] chars = new char[pos];
            Arrays.fill(chars, '0');
            for (int i = 0; i < pos; ++i) {
                chars[i] = '1';
                String r = readFromBinary(prefix + new String(chars));
                if (Objects.nonNull(r)) {
                    result.add(r);
                }
                chars[i] = '0';
            }
            return;
        }
        int index = 0;
        String str = "";
        while (pos - index >= turnedOn) {
            doReadBinaryWatch(result, prefix + str + 1, pos - index - 1, turnedOn - 1);
            ++index;
            str += "0";
        }
    }

    private String readFromBinary(String str) {
        int start = 8;
        int hours = 0;
        for (int i = 0; i < 4; ++i) {
            hours += (str.charAt(i) == '1' ? start : 0);
            start /= 2;
        }
        if (hours > 11) {
            return null;
        }
        start = 32;
        int minutes = 0;
        for (int i = 4; i < 10; ++i) {
            minutes += (str.charAt(i) == '1' ? start : 0);
            start /= 2;
        }
        if (minutes > 59) {
            return null;
        }
        if (minutes == 0) {
            return hours + ":00";
        }
        return hours + ":" + (minutes < 10 ? "0" + minutes : minutes);
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(">>>>>>>>>>>>>>>>>>>>");
        System.out.println("--------------------");
        System.out.println(">>>>> turned = 0: ");
        slt.readBinaryWatch(0).stream().forEach(s -> System.out.print(s + " "));
        System.out.println();
        System.out.println("--------------------");
        System.out.println(">>>>> turned = 1: ");
        slt.readBinaryWatch(1).stream().forEach(s -> System.out.print(s + " "));
        System.out.println();
        System.out.println("--------------------");
        // ["0:03","0:05","0:06","0:09","0:10","0:12","0:17","0:18","0:20","0:24","0:33","0:34","0:36","0:40","0:48","1:01","1:02","1:04","1:08","1:16","1:32","2:01","2:02","2:04","2:08","2:16","2:32","3:00","4:01","4:02","4:04","4:08","4:16","4:32","5:00","6:00","8:01","8:02","8:04","8:08","8:16","8:32","9:00","10:00"]
        System.out.println(">>>>> turned = 2: ");
        slt.readBinaryWatch(2).stream().forEach(s -> System.out.print(s + " "));
        System.out.println();
        System.out.println("--------------------");
        System.out.println(">>>>> turned = 9: ");
        slt.readBinaryWatch(9).stream().forEach(s -> System.out.print(s + " "));
        System.out.println();
        System.out.println("--------------------");
        System.out.println("<<<<<<<<<<<<<<<<<<<<");
    }

}
