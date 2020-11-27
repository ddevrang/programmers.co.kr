package �׷���;

/*
 * ���α׷��ӽ� - �ڵ��׽�Ʈ ����� Kit
 * �׷��� - ����
 * https://programmers.co.kr/learn/courses/30/lessons/49191
 */

class ���� {

	public static void main(String[] args) {

		int n = 5;
		int[][] results = { { 4, 3 }, { 4, 2 }, { 3, 2 }, { 1, 2 }, { 2, 5 } };

		int result = solution(n, results);

		System.out.println(result);
	}

	public static int solution(int n, int[][] results) {

		int answer = 0;
		// ���� ����� ���� �迭
		int[][] matches = new int[n + 1][n + 1];

		// ��� ����� ���� ��, �и� ����
		for (int[] match : results) {
			matches[match[0]][match[1]] = 1; // ��
			matches[match[1]][match[0]] = -1; // ��
		}

		// match ����
		// 1. Ư�� ������ �ٸ� ������ �̱� ���
		// ���� �̱� ����, ��밡 �̱� �������� Ư�� ������ �̱� �� �ִٰ� ����
		// 2. Ư�� ������ �ٸ� �������� �� ���
		// ���� �� ��뿡�Դ�, ���� �̱� ������ �� �̱� �� �ִٰ� ����
		for (int player = 1; player <= n; player++) {
			for (int enemy = 1; enemy <= n; enemy++) {
				if (matches[player][enemy] == 1) { // ���� �̱� ����
					for (int i = 1; i <= n; i++) {
						if (matches[enemy][i] == 1) { // ��밡 �̱� �������� ���� �̱� �� �ִ�.
							matches[player][i] = 1;
							matches[i][player] = -1;
						}
					}
				} else if (matches[player][enemy] == -1) { // ���� �� ����
					for (int i = 1; i <= n; i++) {
						if (matches[player][i] == 1) { // ���� �̱� ��븦 �� �̱��.
							matches[enemy][i] = 1;
							matches[i][enemy] = -1;
						}
					}
				}
			}
		}

		// ��ũ�� Ȯ������ �� �ִ� ������ ���� ����
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
