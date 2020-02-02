/*
프로그래머스 알고리즘
01_문자열 압축
*/


import java.util.ArrayList;
import java.util.List;
class Solution {
  public int solution(String s) {
    int answer = 0;
    if (s.length() == 1)
      return 1;
      
    List<String> rsList = new ArrayList<>();
    // 문자열을 여러 크기로 자른다.
    for (int i = 1; i <= s.length() / 2; i++) {
      List<String> list = new ArrayList<>();
      String cutStr = s.substring(0, i);
      list.add(cutStr);
      for (int j = 1; i * (j + 1) <= s.length(); j++) {
        String cutStr2 = s.substring(i * j, i * (j + 1));
        list.add(cutStr2);
        // 자르고 남은 문자열 추가
        if (i * (j + 2) >= s.length() && s.length() % i > 0) {
          list.add(s.substring(i * (j + 1), s.length()));
        }
      }
      // 배열에서 중복을 찾아 문자의 개수와 반복되는 값으로 표현 한 후 String 리턴
      String rs = findDuplicateValue(list);
      rsList.add(rs);
    }
    // 최종 압축한 문자열 리스트
    int minSize = rsList.get(0).length();
    int minInd = 0;
    for (int i = 1; i < rsList.size(); i++) {
      if (rsList.get(i).length() < minSize) {
        minSize = rsList.get(i).length();
        minInd = i;
      }
    }
      
    String ansStr = rsList.get(minInd);
    answer = ansStr.length();
    return answer;
  }
  // 배열에서 중복을 찾아 문자의 개수와 반복되는 값으로 표현 한 후 String 리턴
  private String findDuplicateValue(List<String> list) {
    int dup = 1;
    Integer dupStart = null;
    for (int i = 0; i < list.size(); i++) {
      dup = 1;
      dupStart = null;
      String str1 = list.get(i);
      for (int j = i + 1; j < list.size(); j++) {
        String str2 = list.get(j);
        if (str1.equals(str2)) {
          if (dup == 1) {
            dupStart = i;
          }
          dup++;
          list.set(j, "");
          if (dup == 1) {
            break;
          }
        } else {
          break;
        }
      }
      if (dup > 1 && dupStart != null && !"".equals(list.get(i))) {
        String rsult = String.valueOf(dup) + str1;
        list.set(i, rsult);
      }
    }
    String rs = "";
    for (String item : list) {
      rs += item;
    }
    return rs;
  }
}
