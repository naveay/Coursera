import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
        //write you code here
        int[] dp=new int[W+1];
        for(int _w:w)
        {
            for(int i=W;i>=0;i--)
            {
                if(i>=_w)
                {
                    dp[i]=Math.max(dp[i],dp[i-_w]+_w);
                }
            }
        }
        return dp[W];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}
