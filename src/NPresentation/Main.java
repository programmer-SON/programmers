package NPresentation;

public class Main {

	static int answer;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int solution(int N, int number) {
        answer = Integer.MAX_VALUE;
        DFS(0,0,number,N);
                
        return answer == Integer.MAX_VALUE ? -1 : answer;    
    }
    
    public static void DFS(int count, int prev,int target,int n) {
    	if(count > 8) {
    		answer = -1;
    		return;
    	}
    	
    	if(prev == target) {
    		answer = Math.min(answer,count);
    		return;
    	}
    	
    	int temp = n;
    	
    	for(int i=0; i<8-count;i++) {
    		int newCount = count+i+1;
    		
    		DFS(newCount, prev + temp,target ,n);
    		DFS(newCount, prev - temp,target ,n);
    		DFS(newCount, prev / temp,target ,n);
    		DFS(newCount, prev * temp,target ,n);
    	
    		temp = temp * 10 + n;
    	}
    	
    }

}
