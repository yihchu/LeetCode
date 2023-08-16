package In.House.MultiThread.Q1117;


public class H2OV2 {

    private int count = 1;

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        synchronized (this) {
            while (count % 3 != 0) {
                this.wait();
            }
            releaseOxygen.run();
            ++ count;
            this.notifyAll();
        }
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        synchronized (this) {
            while (count % 3 == 0) {
                this.wait();
            }
            releaseHydrogen.run();
            ++ count;
            this.notifyAll();
        }
    }

    public static void test(String str) {
        H2OV2 h2o = new H2OV2();
        for (int i = 0; i < str.length(); ++i) {
            char c = str.charAt(i);
            new Thread(() -> {
                try {
                    if (c == 'O') {
                        h2o.oxygen(() -> System.out.print("O"));
                    } else {
                        h2o.hydrogen(() -> System.out.print("H"));
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i ++) {
            test("OHOOHOHHHHOHHOHHHH");
//            test("HHHHOO"); // OHOHHH
//            test("HHHHHHHHHHHHOOOOOO"); // OHH OHH HOH OOH HOH HHH
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println();
        }
    }

}
