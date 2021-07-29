package ArrLineRotate;

import java.util.ArrayList;

public class Main {

	
	static int [][] arr, copyArr;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] re = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
		
		int temp[] = solution(6, 6, re);
		
		for(int i=0; i<temp.length;i++) {
			System.out.println(temp[i]);
		}
	}
	
    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();
        arr = new int[rows][columns];
        copyArr = new int[rows][columns];
        
        
        int num = 1;
        for(int i=0; i<rows;i++) {
        	for(int j=0; j<columns;j++) {
        		arr[i][j] = num;
        		copyArr[i][j] = num++;
        	}
        }
        
        for(int i=0; i<queries.length;i++) {
        	int x1,x2,y1,y2;
        	int minNum = Integer.MAX_VALUE;
        	
        	x1 = queries[i][0]-1;
        	y1 = queries[i][1]-1;
        	x2 = queries[i][2]-1;
        	y2 = queries[i][3]-1;
        	

            minNum = Math.min(minNum,Right(x1,y1,y2));
            minNum = Math.min(minNum,Down(x1,y2, x2));
            minNum = Math.min(minNum,Left(x2, y2, y1));
            minNum = Math.min(minNum,Up(x2,y1,x1));
            
            list.add(minNum);
            for(int x=0; x<rows;x++) {
            	for(int y=0; y<columns;y++) {
            		copyArr[x][y] = arr[x][y];
            	}
            }            
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
    
    //RIGHT
    public static int Right(int sr,int sc, int c) {
    	int mini = Integer.MAX_VALUE;
    	for(int j=sc+1; j<=c;j++) {
    		arr[sr][j] = copyArr[sr][j-1];
    		mini = Math.min(arr[sr][j],mini);
    	}
    	return mini;
    }
    
    public static int Down(int sr,int sc, int r) {
    	int mini = Integer.MAX_VALUE;
    	for(int i=sr+1; i<=r;i++) {
    		arr[i][sc] = copyArr[i-1][sc];
    		mini = Math.min(arr[i][sc],mini);
    	}
    	return mini;
    }
    
    public static int Left(int sr,int sc, int c) {
    	int mini = Integer.MAX_VALUE;
    	for(int j=sc-1; j>=c; j--) {
    		arr[sr][j] = copyArr[sr][j+1];
    		mini = Math.min(arr[sr][j],mini);
    	}
    	return mini;
    }
    
    public static int Up(int sr,int sc, int r) {
    	int mini = Integer.MAX_VALUE;
    	for(int i=sr-1; i>=r; i--) {
    		arr[i][sc] = copyArr[i+1][sc];
    		mini = Math.min(arr[i][sc], mini);
    	}
    	return mini;
    }
    
}
