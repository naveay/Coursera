import java.util.Scanner;

public class PlacingParentheses {
    private static long getMaximValue(String exp) {
        String[]number=exp.split("[+\\-*]");
        String[]op=exp.split("[0-9]+",0);
        long[][] dp_min=new long[number.length][number.length];
        long[][] dp_max=new long[number.length][number.length];
        for(int i=0;i<number.length;i++)
        {
        	dp_min[i][i]=Long.parseLong(number[i]);
        	dp_max[i][i]=dp_min[i][i];
        }
        for(int len=1;len<number.length;len++)
        {
        	for(int start=0;start+len<number.length;start++)
        	{
        		long min=Long.MAX_VALUE;
        		long max=Long.MIN_VALUE;
        		for(int i=start;i<start+len;i++)
        		{
        			min=Math.min(eval(dp_min[start][i],dp_min[i+1][start+len],op[i+1]),min);
        			min=Math.min(eval(dp_max[start][i],dp_max[i+1][start+len],op[i+1]),min);
        			min=Math.min(eval(dp_max[start][i],dp_min[i+1][start+len],op[i+1]),min);
        			min=Math.min(eval(dp_min[start][i],dp_max[i+1][start+len],op[i+1]),min);

        			max=Math.max(eval(dp_min[start][i],dp_min[i+1][start+len],op[i+1]),max);
        			max=Math.max(eval(dp_max[start][i],dp_max[i+1][start+len],op[i+1]),max);
        			max=Math.max(eval(dp_max[start][i],dp_min[i+1][start+len],op[i+1]),max);
        			max=Math.max(eval(dp_min[start][i],dp_max[i+1][start+len],op[i+1]),max);
        		}
        		dp_min[start][start+len]=min;
        		dp_max[start][start+len]=max;
        	}
        }
        return dp_max[0][number.length-1];
      }

      private static long eval(long a, long b, String op) {
          if (op.equals("+")) {
              return a + b;
          } else if (op.equals("-")) {
              return a - b;
          } else if (op.equals("*")) {
              return a * b;
          } else {
              assert false;
              return 0;
          }
      }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}
