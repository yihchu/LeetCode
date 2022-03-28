package In.House.Q1816;


public class Solution {

    public String truncateSentence(String s, int k) {
        String[] array = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < k; ++i) {
            builder.append(array[i]);
            builder.append(" ");
        }
        return builder.toString().trim();
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.truncateSentence("Hello how are you Contestant", 4)); // Hello how are you
        System.out.println(slt.truncateSentence("What is the solution to this problem", 4)); // What is the solution
        System.out.println(slt.truncateSentence("chopper is not a tanuki", 5)); // chopper is not a tanuki
    }

}

