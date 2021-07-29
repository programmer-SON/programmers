package OpenChat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Main {


	public static void main(String[] args) {
		String[] strArr = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		String[] ans = solution(strArr);
		
		for(String s : ans) {
			System.out.println(s);
		}
	}
	
    public static String[] solution(String[] record) {
        String[] answer;
        ArrayList<String> list = new ArrayList<>();
    	HashMap<String, String> map = new HashMap<>();
        
        String come = "´ÔÀÌ µé¾î¿Ô½À´Ï´Ù.";
        String leave = "´ÔÀÌ ³ª°¬½À´Ï´Ù.";
        
        for(int i=0; i<record.length; i++) {
        	String[] str = record[i].split(" ");
        	       	
        	if(str[0].equals("Enter")) {
        		map.put(str[1],str[2]);
        		list.add(str[1] + come);
        	}else if(str[0].equals("Change")) {
        		map.put(str[1], str[2]);
        	}else {
        		list.add(str[1] + leave);
        	}
        }
        
        answer = new String[list.size()];
        
        int idx = 0;
        
        for(String str : list) {
        	//System.out.println(str);
        	int i = str.indexOf("´Ô");
        	String nick = str.substring(0,i);
        	answer[idx++] = str.replace(nick, map.get(nick));
        }
        
        return answer;  
        
    }
    
    
}
