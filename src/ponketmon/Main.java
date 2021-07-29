package ponketmon;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int nums[] = {3,3,3,2,2,2};
		System.out.println(solution(nums));
	}
	
    private static int solution(int[] nums) {
        
        int countArr[] = new int[200001];
        int N = nums.length/2;
        int pocket = 0;
        
        for(int i=0; i<nums.length;i++) {
        	if(countArr[nums[i]] == 0) {
        		countArr[nums[i]]++;
        		pocket++;
        	}        	
        }
        
        if(N >= pocket) {
        	return pocket;
        }
        
        return N;        
    }

}
