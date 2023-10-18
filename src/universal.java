public class universal {
   protected universal() {}
   
   public static void sleep(long num) {
      try {
         Thread.sleep(num);
      }
      catch (Exception e) {
         System.out.println(e.getMessage());
      }
   }
   
   public static void gc() {
      Runtime.getRuntime().gc();
   }
   public static void print(String input) {
      System.out.println(input);
   }
   public static void print(int input) {
      print("" + input);
   }
   public static void print(double input) {
      print("" + input);
   }
   public static void print(boolean input) {
      print("" + input);
   }
}