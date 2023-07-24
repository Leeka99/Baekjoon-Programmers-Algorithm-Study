class Solution {
    public String solution(String my_string, int[][] queries) {
       char[] arr =my_string.toCharArray();
        
        for(int[]x : queries){
        int left = x[0];
        int right = x[1];
            
        while(left<right){
            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }
        return new String(arr);
    }
}