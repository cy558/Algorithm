/** [프로그래머스] 완전탐색 > 소수찾기 */

import java.util.*;

class Solution {
 public int solution(String numbers) {
    int answer = 0;
    // 1. string 을 한글자씩 int[] 로 만든다
    int[] num = Arrays.stream(numbers.split("")).mapToInt(Integer::valueOf).toArray();

    // 2. 모든 조합의 배열을 구한다
    Set<Integer> allComb = new HashSet<>();
    for (int r = 1; r <= num.length; r++) {
      getAllComb(num, 0, num.length, r, allComb);
    }

    // 3. 소수의 개수를 구한다.
    for (int number : allComb) {
      if (isPrime(number)) {
        answer++;
      }
    }
    return answer;
  }

  private void getAllComb(int[] arr, int depth, int n, int r, Set<Integer> allComb) {
    if (depth == r) {
      LinkedList<String> numberstr = new LinkedList<>();
      for (int i = 0; i < r; i++) {
        numberstr.add(String.valueOf(arr[i]));
      }
      allComb.add(Integer.valueOf(String.join("", numberstr)));
      return;
    }
    for (int i = depth; i < n; i++) {
      swap(arr, depth, i);
      getAllComb(arr, depth + 1, n, r, allComb);
      swap(arr, depth, i);
    }
  }

  private void swap(int[] arr, int n1, int n2) {
    int temp = arr[n1];
    arr[n1] = arr[n2];
    arr[n2] = temp;
  }

  private boolean isPrime(int num) {
    boolean result = true;
    if (num < 2) {
      return false;
    }
    int end = (int) Math.sqrt(num);
    for (int i = 2; i <= end; i++) {
      if (num % i == 0) {
        result = false;
        break;
      } else {
        result = true;
      }
    }
    return result;
  }

}

