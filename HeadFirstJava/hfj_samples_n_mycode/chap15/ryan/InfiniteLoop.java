package chap15.ryan;

public class InfiniteLoop {
    static long SLICE = 40;
    public static void main(String[] args) {
        new Thread(new Runnable() {
                public void run() {
                    System.out.println("second thread");
                    for (int x = 0; x < 360 * 10; x++) {
                        double percent = Math.sin((double)x/180*Math.PI) * 0.5 + 0.5;
                        long runtime = (long)(percent * SLICE);
                        long startTime = System.currentTimeMillis();
                        while (System.currentTimeMillis() - startTime < runtime) {
                            System.out.println("second thread: " + x);
                        }
                        try {
                            Thread.sleep(SLICE - runtime);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        for (int i = 0; ; i++) {
            System.out.println("main thread: " + i);
        }
    }
}
