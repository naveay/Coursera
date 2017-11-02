import java.util.*;

public class LCM {
  private static long lcm_naive(int a, int b) {
    int min=Math.min(a,b);
    int max=Math.max(a,b);
    while(min!=0)
    {
      int tmp=max;
      max=min;
      min=tmp%min;
    }
    return (long) a * b/max;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(lcm_naive(a, b));
  }
}
