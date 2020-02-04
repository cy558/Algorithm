/**
* 프로그래머스 알고리즘
* 02_완주하지 못한 선수[Java]
*/

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer ="";
        Map<String,Integer> passName = new HashMap<>();
        for (String name : completion){
            if (passName.containsKey(name)) passName.put(name, passName.get(name)+1);
            else passName.put(name,1);
        }
        for (String participantName : participant){
            if(passName.containsKey(participantName) && passName.get(participantName) > 0){
                passName.put(participantName, passName.get(participantName)-1 );
            }else{
                answer = participantName;
                break;
            }
        }
        return answer;
    }
}
