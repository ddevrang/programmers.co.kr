package ���̳ʺ�켱Ž��;

/*
 * ���α׷��ӽ� - �ڵ��׽�Ʈ ����� Kit
 * ����Ž�� - ��Ʈ��ũ
 * https://programmers.co.kr/learn/courses/30/lessons/43162
 */

class ��Ʈ��ũ {

	public static void main(String[] args) {

		int n = 3;
		int[][] computers = { {1, 1, 0}, {1, 1, 0}, {0, 0, 1} };

		int result = solution(n, computers);

		System.out.println(result);
	}

	public static int solution(int n, int[][] computers) {

		int answer = 0;
		// �湮 ����
        boolean[] visited = new boolean[computers.length];
        
        // ��� �湮���� ���� �ʱ�ȭ
        for(int i = 0; i < computers.length; i++){
            visited[i] = false;
        }
        
        // �湮 ������ ������  answer++ �ϰ�, DFS ����
        for(int i = 0; i < computers.length; i++){
            if(visited[i] == false){
                answer++;
                DFS(computers, visited, i);
            }            
        }

		return answer;
	}
	
	// depth�� node�� depth�� �ǹ�
    public static void DFS(int[][] computers, boolean[] visited, int depth){
    	// �湮ó��
        visited[depth] = true;
        
        for(int i = 0; i < computers.length; i++){
        	// �ش� depth�� ���������� ������ �湮ó������ ���� ��� DFS ���ȣ���Ͽ� �湮ó��
            if(computers[depth][i] == 1 && visited[i] == false){
            	DFS(computers, visited, i);
            }
        }
    }
}
