package 깊이너비우선탐색;

/*
 * 프로그래머스 - 코딩테스트 고득점 Kit
 * 완전탐색 - 네트워크
 * https://programmers.co.kr/learn/courses/30/lessons/43162
 */

class 네트워크 {

	public static void main(String[] args) {

		int n = 3;
		int[][] computers = { {1, 1, 0}, {1, 1, 0}, {0, 0, 1} };

		int result = solution(n, computers);

		System.out.println(result);
	}

	public static int solution(int n, int[][] computers) {

		int answer = 0;
		// 방문 여부
        boolean[] visited = new boolean[computers.length];
        
        // 노드 방문여부 정보 초기화
        for(int i = 0; i < computers.length; i++){
            visited[i] = false;
        }
        
        // 방문 정보가 없으면  answer++ 하고, DFS 실행
        for(int i = 0; i < computers.length; i++){
            if(visited[i] == false){
                answer++;
                DFS(computers, visited, i);
            }            
        }

		return answer;
	}
	
	// depth는 node의 depth를 의미
    public static void DFS(int[][] computers, boolean[] visited, int depth){
    	// 방문처리
        visited[depth] = true;
        
        for(int i = 0; i < computers.length; i++){
        	// 해당 depth에 연결정보가 있으나 방문처리되지 않은 경우 DFS 재귀호출하여 방문처리
            if(computers[depth][i] == 1 && visited[i] == false){
            	DFS(computers, visited, i);
            }
        }
    }
}
