package PredictFightChart;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(8, 4, 7));
	}
    public static int solution(int n, int a, int b) {
        int answer = 1;
        
        for(int i=0; i<n/2;i++) {
        	if(a > b) {
        		if(a%2 == 0) {
        			if(a-1 == b) return answer;
        		}
        	}else if(a < b) {
        		if(b%2 == 0) {
        			if(b-1 == a) return answer;
        		}
        	}
        	
        	a = a % 2 == 0 ? a/2 : a/2+1;
        	b = b % 2 == 0 ? b/2 : b/2+1;
        	
        	answer++;
        }

        return answer;
    }

}
