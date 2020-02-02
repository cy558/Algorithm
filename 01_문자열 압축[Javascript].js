/*
프로그래머스
01_문자열 압축[Javascript]
*/

function solution(s) {
    let minSize = s.length;
    if(s.length == 1) return 1;
    
    for(let i=1; i<=Math.floor(s.length / 2); i++){
        let summList=[];
        summList.push(s.substring(0,i));
        for(let j = 1;  i * (j + 1) <= s.length; j++){
             summList.push(s.substring(i * j , i * (j + 1)));
            if (i * (j + 2) >= s.length && s.length% i > 0) {
                summList.push(s.substring(i * (j + 1), s.length));
            }
        }
     
         for (let i = 0; i < summList.length; i++) {
             let dup=1;
             let dupStartIdx=null;
             for (let j = i + 1; j < summList.length; j++) {
                  if(summList[i]==summList[j]){
                    if(dup==1){
                        dupStartIdx =i;
                    }
                    dup++;
                    summList[j]="";
                }else{
                    break;
                }
            }
             if (dup > 1 && ""!=summList[i]) {
                 summList[i]= dup + summList[i];
             }
         }
        minSize = Math.min(minSize, summList.join("").length)
    }
    return minSize;
}
