package findDecimal;

class Solution {
   
	int store[];
	int arr[];
	boolean prime[];
	int answer = 0;
	
	public int solution(int[] nums) {
        int maxi = 0;
        int len = nums.length;
        
        arr = new int[len];
        store = new int[3];
               
        for(int i=0;i<len;i++) {
        	arr[i] = nums[i];
        	maxi += nums[i];
        }
        
        prime = new boolean[maxi+1];
        Eratos(maxi);
        
        DFS(0,0);
        return answer;
    }
	
	void Eratos(int maxiNum) {
		for(int i=2; i<=(int)Math.sqrt(maxiNum);i++) {
			if(prime[i]) continue;
			
			for(int j=i+i;j<=maxiNum;j+=i) {
				prime[j] = true;
			}
		}
	}
	
	void DFS(int count,int idx) {
		if(count == 3) {
			int sum = 0;
			
			for(int i=0; i<3;i++) {
				sum += store[i];
			}
			
			if(!prime[sum]) answer++;
			
			return;
		}
		
		
		for(int i=idx; i<arr.length;i++) {
			store[count] = arr[i];
			DFS(count+1,i+1);
		}
		
	}
		
}


public class Main{
	public static void main(String args[]) {
		Solution sol = new Solution();
		int arr[] = {1,2,7,6,4};
		System.out.println(sol.solution(arr));
	}
}