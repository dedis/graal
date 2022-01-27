public class Contract {
        
        private int num;

        public Contract() {}

        public Contract(int num) {
                this.num = num;
        }

        public static long fib(int n) {
                if (n <= 1) return n;
                else return fib(n-1) + fib(n-2);
        }

        public void execute() {

                //System.out.println("Hello world!");

                float x = 2.4f;
                float y = 3.2f;
                float w = 3.5f;
                float z = 0.9f;

                float xx = x + y;
                float yy = x * y;
                float ww = w - z;
                float zz = w * z;
                int i = (int) x;

                fib(num);
        }
}
