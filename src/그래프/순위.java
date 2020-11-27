package 그래프;

/*
 * 프로그래머스 - 코딩테스트 고득점 Kit
 * 그래프 - 순위
 * https://programmers.co.kr/learn/courses/30/lessons/49191
 */

class 순위 {

	public static void main(String[] args) {

		int n = 5;
		int[][] results = { { 4, 3 }, { 4, 2 }, { 3, 2 }, { 1, 2 }, { 2, 5 } };

		int result = solution(n, results);

		System.out.println(result);
	}

	public static int solution(int n, int[][] results) {

		int answer = 0;
		// 승패 기록을 위한 배열
		int[][] matches = new int[n + 1][n + 1];

		// 경기 결과에 대한 승, 패를 저장
		for (int[] match : results) {
			matches[match[0]][match[1]] = 1; // 승
			matches[match[1]][match[0]] = -1; // 패
		}

		// match 저장
		// 1. 특정 선수가 다른 선수를 이긴 경우
		// 내가 이긴 상대면, 상대가 이긴 선수들을 특정 선수도 이길 수 있다고 저장
		// 2. 특정 선수가 다른 선수에게 진 경우
		// 내가 진 상대에게는, 내가 이긴 선수를 다 이길 수 있다고 저장
		for (int player = 1; player <= n; player++) {
			for (int enemy = 1; enemy <= n; enemy++) {
				if (matches[player][enemy] == 1) { // 내가 이긴 상대면
					for (int i = 1; i <= n; i++) {
						if (matches[enemy][i] == 1) { // 상대가 이긴 선수들을 나도 이길 수 있다.
							matches[player][i] = 1;
							matches[i][player] = -1;
						}
					}
				} else if (matches[player][enemy] == -1) { // 내가 진 상대는
					for (int i = 1; i <= n; i++) {
						if (matches[player][i] == 1) { // 내가 이긴 상대를 다 이긴다.
							matches[enemy][i] = 1;
							matches[i][enemy] = -1;
						}
					}
				}
			}
		}

		// 랭크를 확정지을 수 있는 선수의 수를 구함
		for (int y = 1; y <= n; y++) {
			int cnt = 0;
			for (int x = 1; x <= n; x++) {
				if (matches[y][x] != 0) {
					cnt++;
				}
			}
			if (cnt == n - 1) {
				answer++;
			}
		}

		return answer;
	}
}
