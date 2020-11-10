/** [프로그래머스] 완전탐색 > 카펫
# 공식을 찾는다!!
*/

import java.util.*;
class Solution {
  public int[] solution(int brown, int yellow) {
    int[] answer = {};
    int width = yellow;
    while (width >= 1) {
      for (int i = 1; i <= width; i++) {
        if(width * i > yellow) break;
        if (width * i == yellow) {
          if (2 * width + 2 * i + 4 == brown) {
            int[] bSize = {width + 2, i + 2};
            answer = bSize;
            break;
          }
        }
      }
      if (answer.length > 0) break;
      width--;
    }
    return answer;
  }
}
