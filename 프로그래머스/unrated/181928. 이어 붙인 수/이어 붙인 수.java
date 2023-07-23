class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        String a =""; 
        String b = "";
        for(int x : num_list){
            if(x%2==0){
                a +=Integer.toString(x);
            }else{
                b += Integer.toString(x);
            }
        }
            answer =Integer.parseInt(a)+Integer.parseInt(b); 
            return answer;       
    }
}