import java.util.Scanner;

public class Fibonacci {
  private static long calc_fib(int n) {
    if(n==0)
      return 0;
    long pre=0;
    long cur=1;
    n-=1;
    while(n>0)
    {
      cur+=pre;
      pre=cur-pre;
      n--;
    }
    return cur;
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calc_fib(n));
  }
}
