package lotto;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] lottos = {44, 1, 0, 0, 31, 25};
		int[] win = {31, 10, 45, 1, 6, 19};
		int[] ans = solution(lottos, win);
		
		for(int x : ans) {
			System.out.print(x + " ");
		}
	}
	
    public static int[] solution(int[] lottos, int[] win_nums) {
                
        int eqCnt = 0;
        int zeroCnt = 0;
        
        for(int i=0; i<6;i++) {
        	for(int j=0; j<6;j++) {
	        	if(lottos[i] == win_nums[j]) {
	        		eqCnt++;
	        	}	        	
        	}
        	if(lottos[i] == 0) {
        		zeroCnt++;
        	}
        }
        
        int[] ranks = new int[2];
        
        int maxCnt = eqCnt + zeroCnt;
        int minCnt = eqCnt;
        
        ranks[0] = CalRank(maxCnt);
        ranks[1] = CalRank(minCnt);
        
        return ranks;
    }
    
    public static int CalRank(int key) {
    	
    	int rank = 0;
    	switch (key) {
		case 6:
			rank = 1;
			break;
		case 5:
			rank=2;
			break;
		case 4:
			rank=3;
			break;
		case 3:
			rank=4;
			break;
		case 2:
			rank=5;
			break;
		default:
			rank=6;
			break;
		}
    	
    	return rank;
    }



}
