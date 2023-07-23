class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for(int[] x : queries){
            int temp = arr[x[0]];
            arr[x[0]]=arr[x[1]];
            arr[x[1]]=temp;
        }
        return arr;
    }
}