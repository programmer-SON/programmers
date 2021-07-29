package Parentheses;

import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "}]()[{";
		System.out.println(solution(str));
	}
	
    public static int solution(String s) {
        int answer = 0;
        StringBuffer sb = null;
        
        for(int i=0; i<s.length();i++) {
        	sb = new StringBuffer();
        	for(int j=i; j<s.length();j++) {
        		sb.append(s.charAt(j));
        	}
        	
        	for(int j=0; j<i;j++) {
        		sb.append(s.charAt(j));
        	}
        	
        	answer += Cal(sb.toString());
        }

        return answer;
    }
    
    public static int Cal(String pare) {
    	Stack<Character> st = new Stack<>();
    	
    	for(int i=0; i<pare.length();i++ ) {
    		if(pare.charAt(i) == '{' || pare.charAt(i) == '(' || pare.charAt(i) == '[') {
    			st.push(pare.charAt(i));
    		}else {
    			if(st.isEmpty()) return 0;
    				
    			if(st.peek() == '{' && pare.charAt(i) == '}') {
    				st.pop();
    			}else if(st.peek() == '(' && pare.charAt(i) == ')' ) {
    				st.pop();
    			}else if(st.peek() == '[' && pare.charAt(i) == ']') {
    				st.pop();
    			}    			
    		}
    	}
    	
    	if(st.isEmpty()) {
    		return 1;
    	}
    	
    	return 0;
    }
}
