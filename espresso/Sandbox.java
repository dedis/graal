import java.util.ArrayList;
import java.lang.*;

public class Sandbox{

        public static void main(String[] args) {
                int argCount = args.length;

                if (argCount == 0) {
                        System.out.println("Missing arguments");
                        System.exit(0);
                }

                String opt = args[0];
                Contract c;

                if (opt.equals("-fp")) {
                        c = new Contract(10);
                } else {
                        c = new Contract();
                }
                      
                if (argCount < 2) {
                        for (int i = 0; i < 1000000; i++) {
                                c.execute();
                        }
                }

                long start, end;
                ArrayList<Long> execTimes = new ArrayList<Long>();
                for (int i = 0; i < 1000000; i++) {
                        start = System.nanoTime();
                        c.execute();
                        end = System.nanoTime();
                        execTimes.add(end-start);
                }

                for (Long t : execTimes)
                        System.out.println(t);
        }
}
