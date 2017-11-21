import java.util.*;

class EditDistance {
  public static int EditDistance(String s, String t) {
    int[][]dp=new int[s.length()+1][t.length()+1];
    for(int m=0;m<s.length();m++)
        dp[m+1][0]=m+1;
    for(int n=0;n<t.length();n++)
        dp[0][n+1]=n+1;
    for(int m=0;m<s.length();m++)
    {
        for(int n=0;n<t.length();n++)
        {
            dp[m+1][n+1]=Math.min(Math.min(dp[m][n+1],dp[m+1][n])+1,dp[m][n]+(s.charAt(m)==t.charAt(n)?0:1));
        }
    }
    return dp[s.length()][t.length()];
  }
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
  }

}
