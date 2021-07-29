package JjakControl;

import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Character> st = new Stack<>();
		st.push('a');
		st.push('b');
		st.push('c');
		
		System.out.println(st.peek());

	}
    public static int solution(String s){
        
        Stack<Character> st = new Stack<>();
        
        for(int i=0; i<s.length();i++) {
        	if(st.isEmpty()) {
        		st.push(s.charAt(i));
        	}else if(st.peek() == s.charAt(i)) {
        		st.pop();
        	}else {
        		st.push(s.charAt(i));
        	}
        }
        
        if(st.isEmpty()) {
        	return 1;
        }
        return 0;
    }
}
