import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        int[] coins={10,5,1};
        int num=0;
        for(int i: coins)
        {
          num+=m/i;
          m%=i;
        }
        return num;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}
