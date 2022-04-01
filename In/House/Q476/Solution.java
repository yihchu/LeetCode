package In.House.Q476;

public class Solution {

    public int findComplement(int num) {
        int sum = 0, gap = 1073741824; // 1 << 30;
        boolean flag = false;
        for (int i = gap; i >= 1; i = i >> 1) {
            if ((num & i) > 0) {
                flag = true;
            } else if (flag) {
                sum += i;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.findComplement(5)); // 2
        System.out.println(slt.findComplement(1)); // 0
        System.out.println(slt.findComplement(Integer.MAX_VALUE)); // 0
        System.out.println(slt.findComplement(Integer.MAX_VALUE - 1)); // 1
    }

}

