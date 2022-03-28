import java.lang.*;

public class Sandbox{

        //private static final int WARMUP_COUNT = 1000000;
        //private static final int RUN_COUNT = 1000000;
        private static final int WARMUP_COUNT = 10000;
        private static final int RUN_COUNT = 10;

        public static void main(String[] args) {
                System.out.println("Starting from scratch");
                int argCount = args.length;

                if (argCount != 1) {
                        System.out.println("Missing arguments");
                        System.exit(0);
                }

                //String opt = args[0];
                //String wup = args[1];
                String wup = args[0];
                //Contract c;
                Contract c = new Contract(10);

                //if (opt.equals("-fib")) {
                        //c = new Contract(10);
                //} else {
                        //c = new Contract();
                //}

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

                for (Long t : execTimes)
                        System.out.println(t);
        }
}
