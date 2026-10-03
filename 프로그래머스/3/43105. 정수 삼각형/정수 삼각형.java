class Solution {
    public int solution(int[][] triangle) {
        int[] dp = new int[triangle[0].length];
        
        dp[0] = triangle[0][0];
        
        for (int i = 1; i < triangle.length; i++) {
            int[] dpTemp = new int[triangle[i].length];
            for (int j = 0; j < dpTemp.length; j++) {
                if (j == 0) {
                    dpTemp[j] = triangle[i][j] + dp[j];
                }
                else if (j == dpTemp.length - 1) {
                    dpTemp[j] = triangle[i][j] + dp[dp.length - 1];
                }
                else {
                    dpTemp[j] = triangle[i][j] + Math.max(dp[j - 1], dp[j]);
                }
            }
            dp = dpTemp;
        }
        
        int answer = 0;
        for (int num : dp) {
            answer = Math.max(answer, num);
        }
        
        return answer;
    }
}