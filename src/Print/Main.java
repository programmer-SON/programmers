package Print;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int prior[] = {1, 1, 9, 1, 1, 1};
		int num = solution(prior,0);
		System.out.println(num);
	}
	
    public static int solution(int[] priorities, int location) {
        int answer = 1;
    	PriorityQueue pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int p : priorities){
            pq.add(p);
            
        }

        while(!pq.isEmpty()){
            for(int i=0; i<priorities.length; i++){
                if(priorities[i] == (int)pq.peek()) {
                    if(i == location){
                        return answer;
                    }
                    pq.poll();
                    answer++;
                }
            }
        }
/*        int answer = 1;
        int idx = 0;
        //ArrayList<Pair> list = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Pair> st = new Stack<>();
        
        for(int p : priorities) {
        	list.add(p);
        }
        
        
        Collections.sort(list,Collections.reverseOrder());
        
        for(int p : list) {
        	System.out.print(p + " ");
        }
        System.out.println();
        
        for(int n : list) {
        	for(int i=0; i<priorities.length;i++) {
        		if(n == priorities[i]) {
        			if(i == location) {
        				return answer;
        			}
        			answer++;
        		}
        	}
        }*/
        
        
        /*while(location != st.peek().idx) {
        	st.pop();
        	answer++;
        }*/
        
        /*for(Pair p : list) {
        	System.out.println(p.prior + " " + p.idx);
        }*/
        
        return answer;
    }

}

class Pair implements Comparable<Pair>{
	int prior,idx;
	
	Pair(int prior, int idx){
		this.prior = prior;
		this.idx = idx;
	}
	
	@Override
	public int compareTo(Pair p) {
		if(this.prior > p.prior) {
			return -1;
		}else if(this.prior == p.prior) {
			if(this.idx > p.idx) {
				return -1;
			}
		}		
		return 1;
	}
}