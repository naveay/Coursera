import java.util.Scanner;

public class PointsAndSegments {


private static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
      Integer[] cnt = new Integer[points.length];
      //write your code here
      for(int i=0;i<points.length;i++)
        cnt[i]=i;
      Arrays.sort(starts);
      Arrays.sort(ends);
      Arrays.sort(cnt,new Comparator<Integer>() {
        public int compare(Integer a, Integer b)
        {
          return points[a]-points[b];
        }
      });
      int index1=0,index2=0;
      for(int i=0;i<points.length;i++)
      {
        while(index1<starts.length&&starts[index1]<=points[cnt[i]])
        {
          index1++;
        }
        while(index2<ends.length&&ends[index2]<points[cnt[i]])
        {
          index2++;
        }
        points[cnt[i]]=index1-index2;
      }
      return points;
  }

    private static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < starts.length; j++) {
                if (starts[j] <= points[i] && points[i] <= ends[j]) {
                    cnt[i]++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        //use fastCountSegments
        int[] cnt = naiveCountSegments(starts, ends, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }
    }
}
