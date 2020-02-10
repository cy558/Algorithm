import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        ArrayList<Integer> answerList = new ArrayList();
        int[] s1 = {1,2,3,4,5};
        int[] s2 = {2,1,2,3,2,4,2,5};
        int[] s3 = {3,3,1,1,2,2,4,4,5,5};
        
        int s1c =  sCount(answers, s1);
        int s2c =  sCount(answers, s2);
        int s3c =  sCount(answers, s3);
        int max = Math.max(s1c, s2c);
        max = Math.max(max, s3c);
        
        if(max==s1c) answerList.add(1);
        if(max==s2c) answerList.add(2);
        if(max==s3c) answerList.add(3);
        
        answer = new int[answerList.size()];
        int size =0;
        for(int temp : answerList){
            answer[size++] = (int)temp;
        }
        return answer;
    }
    
    int sCount (int[] answers, int[] s){
        int count =0;
        for(int i=0; i<answers.length; i++){
            if(answers[i]== s[i%s.length]){
                count++;
            }
        }
        return count;
    }
}
