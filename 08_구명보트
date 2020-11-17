/**
  [프로그래머스] 탐욕법 > 구명보트
  -최대,최소를 한번에 비교하기!!
*/
class Solution {
  public int solution(int[] people, int limit) {
  
    int answer = 0;
    Arrays.sort(people);
    int min = 0;
    for (int max = people.length - 1; min <= max; max--) {
      if (people[max] + people[min] <= limit) min++;
      answer++;
    }
    return answer;
  }
}
