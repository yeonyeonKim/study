import java.util.*;
import java.io.*;

public class Main{
  public static void main(String[] args) throws Exception{
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int result = 0;
    int min = 10001;

    for (int i=0;i<N;i++){
      StringTokenizer st2 = new StringTokenizer(br.readLine());
      for(int j=0;j<M;j++){
        min = Math.min(min,st2.nextToken());
      }
      result = Math.max(min,result);
    }
    
    System.out.println(result);
  }
}
