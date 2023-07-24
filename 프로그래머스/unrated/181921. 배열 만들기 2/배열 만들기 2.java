import java.util.*;
class Solution {
    public int[] solution(int l, int r) {
        ArrayList<Integer> al = new ArrayList<>();
        for(int i =l; i<=r; i++){
            int tmp = i;
            boolean flag =true;
            while(tmp>0){
                int t = tmp%10;
                if(!(t==5||t==0)){
                    flag = false;
                    break;
                }
                tmp = tmp/10;
            }
            if(flag){
                al.add(i);
            }
        }     
            if(al.size()==0){
                return new int[]{-1};
            }
            int[] answer = new int[al.size()];
        
            for(int i = 0; i<al.size(); i++){
                    answer[i] = al.get(i);
                     
             }
            
           return answer;
    }
}