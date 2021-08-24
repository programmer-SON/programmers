class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for(int i=yellow; i>=(yellow/i); i--){
           if(yellow % i != 0) continue;
            
            int c = i;
            int r = yellow/i;
            if(c*2 + r*2 + 4 == brown){
                answer[0] = c + 2;
                answer[1] = r + 2;
                break;
            }
        }
        
        return answer;
    }
}

/*
Reference : https://velog.io/@so-soon/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%B9%B4%ED%8E%AB
*/