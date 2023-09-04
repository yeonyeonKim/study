import java.io.*;
import java.util.*;

public class Main{
  public static void main(String[] args)throws Exception{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.paresInt(st.nextToken());
    int[] arr = new int[N];
    int result = 0;
    int group_cnt = 0;
    for(int i = 0;i<N;i++){
      StringTokenizer st2 = new StringTokenizer(br.readLine());

      arr[i] = Integer.paresInt(st2.nextToken());
    }
    Arrays.sort(arr);
    
    for(int i=N-1;i>=0;i--){
      group_cnt++;
      if(group_cnt>=arr[i]){
        group_cnt = 0;
        result++;
      }
    }
    System.out.println(result);
  }
}
