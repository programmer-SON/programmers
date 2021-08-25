class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        int dp1[][] = new int[m+1][n+1];
        int dp2[][] = new int[m+1][n+1];
        
        dp1[1][1] = dp2[1][1] = 1;
        
        for(int i=1; i<=m;i++){
            for(int j=1; j<=n;j++){
                if(cityMap[i-1][j-1] == 0){
                    dp2[i][j] = dp1[i][j] += (dp1[i][j-1] + dp2[i-1][j]) % MOD;
                    
                }else if(cityMap[i-1][j-1] == 1){
                   dp1[i][j] = dp2[i][j] = 0; 
                }else{
                    dp1[i][j] = dp1[i][j-1];
                    dp2[i][j] = dp2[i-1][j];
                }
            }
        }
        
        return dp1[m][n] % MOD;
    }
}