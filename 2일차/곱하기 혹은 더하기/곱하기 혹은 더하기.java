import java.io.*;
import java.util.*;

public class Main{
  public static void main(String[] args)throws Exception{
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    
    int[] arr = new int[s.length()];
    for(int i =0;i<s.length();i++){
      arr[i] = s.charAt(i)-'0';
    }
    Arrays.sort(arr);
    int result  = arr[0];
    for(int i=1;i<s.length();i++){
      if(arr[i]<=1||result<=1){
        result+=arr[i];
      }
      else{
        result*=arr[i];
      }
    }
    System.out.println(result);
  }
}
