import java.util.*;

class Solution {
 public String solution(String number, int k) {
  int[] numbers = Arrays.stream(number.split("")).mapToInt(Integer::valueOf).toArray();
  int n = numbers.length - k;

  StringBuilder ans = new StringBuilder();
  int max = 0;
  int idx = 0;
  while (ans.length() < n) {
    max = 0;
    for (int i = idx; (numbers.length - (i + 1) >= (n - ans.length() - 1)); i++) {
      if (max < numbers[i]) {
        max = numbers[i];
        idx = i+1;
      }
      if (max == 9) {
        break;
      }
    }
    ans.append(String.valueOf(max));
  }
  return ans.toString();
 }
}
