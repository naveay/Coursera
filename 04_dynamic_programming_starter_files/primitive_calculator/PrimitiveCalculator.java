import java.util.*;

    public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        int[]dp=new int[n+1];
        dp[1]=1;
        for(int i=2;i<=n;i++)
        {
            int next= Math.min((i)%2==0?dp[i/2]:n,
            i%3==0?dp[i/3]:n);
            dp[i]=Math.min(next,dp[i-1])+1;
        }
        while (n >= 1) {
            sequence.add(n);
            if (n % 3 == 0&&dp[n/3]+1==dp[n]) {
                n /= 3;
            } else if (n % 2 == 0&&dp[n/2]+1==dp[n]) {
                n /= 2;
            } else {
                n -= 1;
            }
        }
        Collections.reverse(sequence);
        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}
