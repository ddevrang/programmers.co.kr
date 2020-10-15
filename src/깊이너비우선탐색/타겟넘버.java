package ���̳ʺ�켱Ž��;

/*
 * ���α׷��ӽ� - �ڵ��׽�Ʈ ����� Kit
 * ����Ž�� - Ÿ�ٳѹ�
 * https://programmers.co.kr/learn/courses/30/lessons/43165
 */

class Ÿ�ٳѹ� {
	
	static int answer = 0;
	
	public static void main(String[] args) {

		int[] numbers = { 1, 1, 1, 1, 1 };
		int target = 3;

		int result = solution(numbers, target);

		System.out.println(result);
	}

	public static int solution(int[] numbers, int target) {

		// DFS �Լ��� ��ͷ� �ݺ��Ͽ� Ÿ�� �ѹ��� ����� ���� ã�´�.
		DFS(numbers, target, 0);

		return answer;
	}

	// depth�� node�� depth�� �ǹ�
	public static void DFS(int[] numbers, int target, int depth) {

		// Node�� leaf���� �����ߴ��� �Ǵ�
		if (depth == numbers.length) {
			// numbers �迭 ���� �հ踦 �����ϱ� ���� ����
			int sum = 0;
			// numbers �迭 �� �ջ�
			for(int num : numbers) {
				sum += num;
			}
			
			// �ջ��� ���� Ÿ�ٳѹ��� ��ġ�ϸ� ���� ���� ���� answer�� ++;
			if (sum == target) answer++;
		// ���� �߰� ��忡 �ִ� ���
		} else {
			// ���ʳ��� �����Ͽ� ����� ���ϰ� �� ���� numbers[depth]�� ����
			// Node�� depth�� + 1 �Ͽ� ���ȣ��
			numbers[depth] *= 1;
			DFS(numbers, target, depth + 1);
			// ������ ���� �����Ͽ� ������ ���ϰ� �� ���� numbers[depth]�� ����
			// Node�� depth�� + 1 �Ͽ� ���ȣ��
			numbers[depth] *= -1;
			DFS(numbers, target, depth + 1);
		}

	}
}
