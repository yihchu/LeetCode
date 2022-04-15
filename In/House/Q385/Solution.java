package In.House.Q385;

import java.util.Deque;
import java.util.LinkedList;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {

    public NestedInteger deserialize(String s) {
        char[] chars = s.toCharArray();
        if (chars[0] != '[') {
            return new NestedIntegerImpl(Integer.parseInt(s));
//            return new NestedInteger(Integer.parseInt(s));
        }
        Deque<NestedInteger> stack = new LinkedList<>();
        int num = 0, len = s.length();
        boolean isNeg = false;
        for (int i = 0; i < len; ++i) {
            char c = chars[i];
            if (c == '-') {
                isNeg = true;
            } else if (c >= '0' && c <= '9') {
                num *= 10;
                num += (c - '0');
            } else if (c == '[') {
                stack.push(new NestedIntegerImpl());
//            stack.push(new NestedInteger());
            } else if (c == ',' || c == ']') {
                if (chars[i - 1] >= '0' && chars[i - 1] <= '9') {
                    num = isNeg ? 0 - num : num;
                    stack.peek().add(new NestedIntegerImpl(num));
//                    stack.peek().add(new NestedInteger(num));
                }
                num = 0;
                isNeg = false;
                if (c == ']' && stack.size() > 1) {
                    NestedInteger ni = stack.pop();
                    stack.peek().add(ni);
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        slt.deserialize("[123,[456,[789]]]");
    }
}
