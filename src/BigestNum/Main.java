package BigestNum;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int nums[] = {3, 30, 34, 5, 9};
		System.out.println(solution(nums));

	}
	
    public static String solution(int[] numbers) {
        String[] strs = new String[numbers.length];
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<numbers.length;i++) {
        	strs[i] = String.valueOf(numbers[i]);        	
        }
        
        //Arrays.sort(strs,Collections.reverseOrder());
        Arrays.sort(strs,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return (o2+o1).compareTo(o1+o2);
			}        	
        	
		});
                
        for(String s : strs) {
        	sb.append(s);
        }
        
        if(sb.toString().charAt(0) == '0') {
        	return "0";
        }
        
        return sb.toString();
    }   

}
