import java.util.ArrayList;
import java.lang.*;

public class Sandbox{

        public static void main(String[] args) {
                Contract c = new Contract(10);
                //Contract c = new Contract();
                //for (int i = 0; i < 1000000; i++) {
                        //c.execute();
                //}

                long start, end;
                ArrayList<Long> execTimes = new ArrayList<Long>();
                for (int i = 0; i < 1000; i++) {
                        start = System.nanoTime();
                        c.execute();
                        end = System.nanoTime();
                        execTimes.add(end-start);
                }

                for (Long t : execTimes)
                        System.out.println(t);
        }
}
