import java.util.*;

public class Inversions {

  private static long getNumberOfInversions(int[] a, int[] b, int left, int right) {
      long numberOfInversions = 0;
      if (right <= left + 1) {
          return numberOfInversions;
      }
      int ave = (left + right) / 2;
      numberOfInversions += getNumberOfInversions(a, b, left, ave);
      numberOfInversions += getNumberOfInversions(a, b, ave, right);
      //write your code here
      int index=ave;
      for(int i=left;i<ave;i++)
      {
          while(index<right&&a[i]>a[index])
              index++;
          numberOfInversions+=(index-ave);
      }
      int index1 = left;
      int index2=  ave;
      while(index1+index2-ave<right)
      {
          if(index2==right||a[index1]<=a[index2])
          {
              b[index1+index2-ave]=a[index1];
              index1++;
          }
          else
          {
              b[index1+index2-ave]=a[index2];
              index2++;
          }
      }
      for(int i=left;i<right;i++)
        a[i]=b[i];
      return numberOfInversions;
  }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        System.out.println(getNumberOfInversions(a, b, 0, a.length));
    }
}
