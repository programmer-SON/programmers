package Rank;

public class Solution {
    boolean graph[][];
    public int solution(int n, int[][] results) {
        int answer = 0;
        graph = new boolean[n+1][n+1];
        
        for(int i=0; i<results.length;i++){
            graph[results[i][0]][results[i][1]] = true;
        }
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                for(int k=1; k<=n; k++){
                    if(graph[j][i] && graph[i][k]){
                        graph[j][k] = true;
                    }
                }
            }
        }
        
        for(int i=1; i<=n; i++){
            int count = 0;
            for(int j=1; j<=n; j++){
                if(graph[i][j] || graph[j][i]) count++;
            }
            if(count == n-1) answer++;
        }
        
        return answer;
    }
}
