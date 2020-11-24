/**
 [백준] Stack > 단어뒤집기
*/
import java.io.*;
import java.util.*;
public class Main{
  public static void main(String[] args) {
  
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {
        
      int cnt = Integer.parseInt(br.readLine());
      Stack<Character> st = new Stack<>();
      while (cnt-- > 0) {
        String content = br.readLine() + "\n";
        for (char ch : content.toCharArray()) {
          if(ch ==' ' || ch =='\n'){
            while (!st.isEmpty()) {
              bw.write(st.pop());
            }
            bw.write(ch);
          }else{
            st.push(ch);
          }
        }
        bw.flush();
      }
    } catch (IOException e) {
      System.out.println(e);
    }
  }
}
