import java.util.Scanner;
import java.util.*;
public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        PriorityQueue<Integer> queue=new PriorityQueue<Integer>((a,b)->((double)values[b]/weights[b]>(double)values[a]/weights[a]?1:-1));
        for(int i=0;i<values.length;i++)
            queue.add(i);
        while(capacity>0&&queue.size()>0)
        {
            int next=queue.poll();
            if(weights[next]<=capacity)
            {
                value+=values[next];
                capacity-=weights[next];
            }
            else
            {
                value+=((double)values[next]*capacity)/weights[next];
                capacity=0;
            }
        }
        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
}
