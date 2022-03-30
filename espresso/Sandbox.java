import java.lang.*;

public class Sandbox{

        private static final int WARMUP_COUNT = 1000000;
        private static final int RUN_COUNT = 1000000;

        public static void main(String[] args) {
                int argCount = args.length;
                if (argCount != 1) {
                        System.out.println("Missing arguments");
                        System.exit(0);
                }

                String wup = args[0];
                Contract c = new Contract(10);

                // Warmup on if -y
                if (wup.equals("-y")) {
                        for (int i = 0; i < WARMUP_COUNT; i++) {
                                c.execute();
                        }
                }

                long start, end;
                Long[] execTimes = new Long[RUN_COUNT];
                for (int i = 0; i < RUN_COUNT; i++) {
                        start = System.nanoTime();
                        c.execute();
                        end = System.nanoTime();
                        execTimes[i] = end-start;
                }
                long sum = 0;
                for (Long t : execTimes)
                        sum += t;
                double avg = sum / execTimes.length;
                System.out.println(avg);
        }
}
