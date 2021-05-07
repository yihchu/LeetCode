import java.util.stream.IntStream;

public class LT1486 {

    public int xorOperation(int n, int start) {
        int result = 0;
        for (int i = 0; i < n; ++i) {
            result ^= (start + (i << 1));
        }
        return result;
//        return IntStream.range(0, n).map(i -> start + (i << 1)).reduce(0, (a, b) -> a ^ b);
    }

    public static void main(String[] args) {
        LT1486 lt1486 = new LT1486();
        System.out.println(lt1486.xorOperation(5, 0)); // [0, 2, 4, 6, 8]
        System.out.println(lt1486.xorOperation(4, 3)); // [3, 5, 7, 9]
        System.out.println(lt1486.xorOperation(1, 7)); // [7]
        System.out.println(lt1486.xorOperation(10, 5));// [0, 2, 4, 6, 8, 10, 20, 40, 80, 160]
    }

}
