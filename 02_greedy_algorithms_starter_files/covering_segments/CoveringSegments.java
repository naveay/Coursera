import java.util.*;

public class CoveringSegments {

    private static int[] optimalPoints(Segment[] segments) {
        List<Integer> list=new ArrayList<>();
        Arrays.sort(segments, new Comparator<Segment>(){
            public int compare(Segment a, Segment b)
            {
                return (a.end!=b.end)?a.end-b.end: a.start-b.start;
            }
        });
        Segment pre=null;
        for(Segment i: segments)
        {
            if(pre==null||pre.end<i.start)
            {
                pre=i;
                list.add(pre.end);
            }
        }
        int[] points = new int[list.size()];
        for(int i=0;i<list.size();i++)
            points[i]=list.get(i);
        return points;
    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
