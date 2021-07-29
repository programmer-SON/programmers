package StickerTogether;

class Solution {
    public int solution(int sticker[]) {
        int answer = 36;
        int len = sticker.length;
        
        if(len == 1) return sticker[0];
        if(len == 2) return Math.max(sticker[0],sticker[1]);
        
        int[] dp = new int[len];
        
        //첫번째꺼 선택
        dp[0] = sticker[0];
        dp[1] = sticker[0];
        
        for(int i=2;i<len-1;i++) {
        	dp[i] = Math.max(dp[i-1], dp[i-2]+sticker[i]);
        }
        
        answer = dp[len-2];
        
        //선택안함
        dp[0] = 0;
        dp[1] = sticker[1];
        
        for(int i=2;i<len;i++) {
        	dp[i] = Math.max(dp[i-1], dp[i-2]+sticker[i]);
        }
               
        return Math.max(dp[len-1], answer);
    }
}


public class Main {

	public static void main(String[] args) {
		
	}
}
