package semitest;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {1,3,2,4,2};
		int[] ans = solution(nums);
		
		for(int i=0; i<ans.length;i++) {
			System.out.print(ans[i] + " ");
		}
	}
	
    public static int[] solution(int[] answers) {
        int[] answer = {};
        
        int mathAbOne[] = {1,2,3,4,5};
        int mathAbTwo[] = {2,1,2,3,2,4,2,5};
        int mathAbThree[] = {3,3,1,1,2,2,4,4,5,5};
        
        int oneCnt =0, twoCnt = 0 , thrCnt=0;
        
        for(int i=0,j=0,k=0,l=0; i<answers.length;i++,j++,k++,l++) {
        	
        	if(j == mathAbOne.length) {
        		j=0;
        	}
        	if(k == mathAbTwo.length) {
        		k=0;
        	}
        	if(l == mathAbThree.length) {
        		l=0;
        	}
        	
        	
        	if(answers[i] == mathAbOne[j]) {
        		oneCnt++;
        	}
        	
        	if(answers[i] == mathAbTwo[k]) {
        		twoCnt++;
        	}
        	
        	if(answers[i] == mathAbThree[l]) {
        		thrCnt++;
        	}
        }
        
        int maxCnt = Math.max(oneCnt, Math.max(twoCnt, thrCnt));
        List<Integer> list = new ArrayList<>();
        
        if(maxCnt == oneCnt) list.add(1);
        if(maxCnt == twoCnt) list.add(2);
        if(maxCnt == thrCnt) list.add(3);
        
        list.stream().mapToInt(i->i.intValue());
        
        return list.stream().mapToInt(i->i.intValue()).toArray();
        
        
/*        if(oneCnt == twoCnt && twoCnt == thrCnt) {
        	answer = new int[3];
        	answer[0] = 1;
        	answer[1] = 2;
        	answer[2] = 3;
        }else if(oneCnt > thrCnt && oneCnt == twoCnt ) {
        	answer = new int[2];
        	answer[0] = 1;
        	answer[1] = 2;
        }else if(oneCnt > twoCnt && oneCnt == thrCnt ) {
        	answer = new int[2];
        	answer[0] = 1;
        	answer[1] = 3;
        }else if(twoCnt > oneCnt && twoCnt == thrCnt ) {
        	answer = new int[2];
        	answer[0] = 2;
        	answer[1] = 3;
        }else {
        	answer = new int[1];
        	
        	if(oneCnt > twoCnt) {
        		if(oneCnt > thrCnt) {
        			answer[0] = 1;
        		}else {
        			answer[0] = 3;
        		}
        	}else {
        		if(twoCnt > thrCnt) {
        			answer[0] = 2;
        		}else {
        			answer[0] = 3;
        		}
        	}      	
        	
        }        
        
        return answer;*/
    }
}
