package JoyStick;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
    public static int solution(String name) {
        int answer = 0;
        
        for(char c : name.toCharArray()) {
        	if( c < 78) answer += c %65;
        	else answer += 91 - c;
        }
        
        int mini = name.length() - 1;
        
        for(int i=0; i<name.length();i++) {
        	
        	int idx = i;
        	if(name.charAt(idx) == 'A') {
        		while(idx < name.length() && name.charAt(idx) == 'A') {
        			idx++;
        		}
        		
        		int cnt = (i-1)*2 + name.length() - idx;
        		mini = Math.min(cnt, mini);
        	}
        }
        
        return answer + mini;
    }
}
