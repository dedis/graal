public class HelloWorld{
        
        private static float foo() {
                float x = 2.4f;
                float y = 3.2f;
                return x + y;
        }

        public static void main(String[] args) {
                float x = 2.4f;
                float y = 3.2f;
                float w = 3.5f;
                float z = 0.9f;
                float xx = x + y;
                float yy = x * y;
                float ww = w - z;
                float zz = w * z;
                System.out.println(xx + " " + yy + " " + ww + " " + zz);
                float aa = foo();
                System.out.println(aa);
        }
}
