package TargetNum;

public class Main {

	static int[] nums;
	static int answer;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {1, 1, 1, 1, 1};
		int tar = 3;
	
		System.out.println(solution(arr,tar));
	}
	
    public static int solution(int[] numbers, int target) {
        
        nums = numbers;
        answer = 0;      
        DFS(1,numbers[0] ,target);
        DFS(1,-numbers[0] ,target);
        
        return answer;
    }
    
    public static void DFS(int idx, int sum, int t) {
    	
    	if(idx == nums.length) {
    		if(sum == t) {
    			answer++;
    		}
    		/*if(CheckNum(t)) {
    			answer++;
    		}*/
    		return;
    	}
    	
    	DFS(idx+1,sum + nums[idx],t);
    	DFS(idx+1,sum - nums[idx],t);
    	
/*    	for(int i=idx; i<nums.length;i++) {
    		nums[i] *= -1;
    		DFS(i+1,t);    		
    		nums[i] *= -1;
    	}*/
    }
    
/*    public static boolean CheckNum(int t) {
    	int sum = 0;
    	
    	for(int i=0;i<nums.length;i++) {
    		sum += nums[i];
    		System.out.print(nums[i] + " ");
    	}
    	System.out.println();
    	
    	if(sum == t) return true;
    	return false;
    }*/
    
}
