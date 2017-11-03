import java.util.*;

public class FibonacciPartialSum {
    private static long getFibonacciPartialSumNaive(long from, long to) {
        return (10+help(to)- (from-1<0?0:help(from-1)))%10;
    }
    private static long help(long n) {
        if(n==0)
            return 0;
        long pre=0;
        long cur=1;
        int count=0;
        long tmp=n-1;
        long sum=1;
        do
        {
            cur+=pre;
            pre=cur-pre;
            cur=cur%10;
            pre=pre%10;
            sum+=cur;
            count++;
            tmp--;
            if(tmp==0)
              return sum%10;
        }while(cur!=1||pre!=0);
        sum--;
        sum=((n/count)%10)*(sum%10);
        n=n%count;

        pre=0;
        cur=1;
        if(n==0)
          return sum%10;
        n-=1;
        sum+=1;
        while(n>0)
        {
            cur+=pre;
            pre=cur-pre;
            cur=cur%10;
            pre=pre%10;
            sum+=cur;
            n--;
        }
        return sum % 10;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSumNaive(from, to));
    }
}
