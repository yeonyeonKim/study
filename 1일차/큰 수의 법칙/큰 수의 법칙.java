import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws Exception
    {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());

      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      int K = Integer.parseInt(st.nextToken());
      int[] arr = new int[N];
      
      StringTokenizer st2 = new StringTokenizer(br.readLine());
      for(int i = 0; i<N;i++){
        arr[i] = Integer.parseInt(st2.nextToken());
      }
      
      Array.sort(arr);

      int first = arr[N-1];
      int second = arr[N-2];

      int result = (M/(K+1))*(first*K+second)+(M%(K+1))*first;

      System.out.println(result);
    }
}
