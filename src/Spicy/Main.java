package Spicy;

import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] sc = {1, 2, 3, 9, 10, 12};
		
		System.out.println(solution(sc, 7));
	}
	
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<scoville.length;i++) {
        	pq.add(scoville[i]);
        }
        
        int sum = 0;
        
        while(K > sum && !pq.isEmpty()) {
        	sum = 0;
        	int n1 = pq.peek();
        	pq.remove();
        	
        	if(pq.isEmpty()) break;
        	
        	sum += n1 + pq.peek() * 2;
        	pq.remove();
        	
        	pq.add(sum);
        	answer++;
        }
        
        if(sum >= K) {
        	return answer;
        }
        
        return -1;
    }

}
