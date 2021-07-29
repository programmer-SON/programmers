package PhoneNumberList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {"123","456","789"};
		System.out.println(solution(strs));
	}
	
    public static boolean solution(String[] phone_book) {
          
        //Arrays.sort(phone_book, (a,b) -> a.length() - b.length());
        
        /*for(int i=0; i<phone_book.length-1;i++) {
        	String tmp = phone_book[i];
        	int len = tmp.length();
        	int hashCode = tmp.hashCode();
        	
        	for(int j=i+1; j<phone_book.length;j++) {
        		if(phone_book[j].length() > len) {
        			if(phone_book[j].substring(0,len).hashCode() == hashCode) return false; 
        		}else {
        			if(tmp.substring(0,phone_book[j].length()).hashCode() == phone_book[j].hashCode()) return false; 
        		}
        	}
        }*/
    	
    	HashSet<String> hs = new HashSet<>();
    	for(String s : phone_book) {
    		hs.add(s);
    	}
    	
    	for(String pb : phone_book) {
    		for(int i=1; i<pb.length();i++) {
    			String tmp = pb.substring(0,i);
    			if(hs.contains(tmp)) {
    				return false;
    			}
    		}
    	}
        
        return true;        
    }

}
