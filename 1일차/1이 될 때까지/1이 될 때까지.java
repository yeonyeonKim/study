import java.io.*;
import java.util.*;

public class Main{
  public static void main(String[] args) throws Exception{
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    StringTokenier st = new StringTokenier(br.readLine());

    int N = Integer.paresInt(st.nextToken());
    int K = Integer.paresInt(st.nextToken());
    int result = 0;

    while(N>K){
      while(N%K!=0){
        N = N-1;
        result++;
      }
      N = N/K;
      result++;
    }

    while(N>1){
      N = N-1;
      result++;
    }
    System.out.println(result);
  }
}
