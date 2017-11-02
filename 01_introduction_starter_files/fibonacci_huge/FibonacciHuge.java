import java.util.*;

public class FibonacciHuge {
    private static long getFibonacciHugeNaive(long n, long m) {
        long pre=0;
        long cur=1;
        int count=0;
        long tmp=n-1;
        do
        {
            cur+=pre;
            pre=cur-pre;
            cur=cur%m;
            pre=pre%m;
            count++;
            tmp--;
            if(tmp==0)
              return cur;
        }while(cur!=1||pre!=0);
        n=n%count;

        pre=0;
        cur=1;
        if(n==0)
          return 0;
        n-=1;
        while(n>0)
        {
            cur+=pre;
            pre=cur-pre;
            cur=cur%m;
            pre=pre%m;
            n--;
        }
        return cur;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHugeNaive(n, m));
    }
}
