/**
[프로그래머스] 탐욕법 > 체육복
*/
import java.util.*;

public int solution(int n, int[] lost, int[] reserve) {
  int answer = 0;
  int[] students = new int[n];
  for(int reserveNum : reserve){
    students[reserveNum-1]++;
  }
  for(int lostNum : lost){
    students[lostNum-1]--;
  }

  for (int i = 0; i < n; i++) {
    if (students[i] < 0) {
      if (i == 0) {
        if (students[i + 1] == 1) {
          students[i]++;
          students[i + 1]--;
        }
      } else if (i == (n - 1)) {
        if (students[i - 1] == 1) {
          students[i]++;
          students[i - 1]--;
        }
      } else {
        if (students[i - 1] == 1) {
          students[i]++;
          students[i - 1]--;
        } else if (students[i + 1] == 1) {
          students[i]++;
          students[i + 1]--;
        }
      }
    }
  }
  answer = (int) Arrays.stream(students).filter(x -> x >= 0).count();
  return answer;
}
