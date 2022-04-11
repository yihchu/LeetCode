package In.House.Q345;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

    public String reverseVowels(String s) {
        Set<Character> vowels = Arrays.stream(
                new Character[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'}).collect(Collectors.toSet());
        char[] arr = s.toCharArray();
        int len = s.length();
        int l = 0, r = len - 1;
        while (true) {
            while (l <= r) {
                if (vowels.contains(arr[l])) {
                    break;
                }
                ++l;
            }
            while (r >= l) {
                if (vowels.contains(arr[r])) {
                    break;
                }
                --r;
            }
            if (l >= r) {
                return new String(arr);
            }
            char tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
            ++l;
            --r;
        }
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.reverseVowels("hello")); // holle
        System.out.println(slt.reverseVowels("leetcode")); // leotcede
    }

}

