package In.House.Q319;

public class Solution {

    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.bulbSwitch(3)); // 1
        System.out.println(slt.bulbSwitch(0)); // 0
        System.out.println(slt.bulbSwitch(1)); // 1
    }

}


