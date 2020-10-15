package ����Ž��;

import java.util.HashSet;
import java.util.Set;

/*
 * ���α׷��ӽ� - �ڵ��׽�Ʈ ����� Kit
 * ����Ž�� - �Ҽ�ã��
 * https://programmers.co.kr/learn/courses/30/lessons/42839
 */
class �Ҽ�ã�� {

	// ����ó�� �� �� ����. ex) �� �� ���ڰ� 0�� ���, ������ �� ����, �Ҽ��� 2�̻� ��..

	// HashSet�� �ߺ��� ������� �����Ƿ� �ߺ����ڸ� �ڵ����� ó������.
	static Set<Integer> combinationList = new HashSet<>();

	public static void main(String[] args) {

		String numbers = "17";

		int result = solution(numbers);

		System.out.println(result);
	}

	public static int solution(String numbers) {

		int answer = 0;

		int[] num = new int[numbers.length()];
		boolean[] visited = new boolean[num.length];

		// String numbers�� substring���� ���ڸ��� ����
		// int�� ����ȯ�Ͽ� int �迭�� ����
		for (int i = 0; i < numbers.length(); i++) {
			num[i] = Integer.parseInt(numbers.substring(i, i + 1));
		}

		for (int i = 0; i < num.length; i++) {
			visited[i] = true;
			comb(num, visited, String.valueOf(num[i]));
			visited[i] = false;
		}

		answer = combinationList.size();

		return answer;
	}

	// ����
	static void comb(int[] num, boolean[] visited, String str) {

		// �ش� ���ڰ� �Ҽ��� ��� combinationList�� �߰�
		if (isPrimeNumber(Integer.parseInt(str))) {
			combinationList.add(Integer.parseInt(str));
		}

		// �湮ó������ ���� ���ڰ� �ִ��� Ȯ���Ͽ�
		// �ش� ���ڸ� str + str �������� �̾� �ٿ� comb�� ���ȣ��
		// ��� ���ڸ� �� �湮�Ͽ� ������ �Ϸ�ɶ����� �ݺ�
		for (int i = 0; i < num.length; i++) {
			if (visited[i] == false) {
				visited[i] = true;
				comb(num, visited, str + String.valueOf(num[i]));
				visited[i] = false;
			}
		}

		return;
	}

	// �Ҽ� �Ǻ��ϱ� boolean
	public static boolean isPrimeNumber(int N) {
		// �Ҽ��� 2���� �����Ѵ�.
		// �ش� ���ڰ� 2���� ������ �Ҽ��� �ƴϹǷ� return false;
		if (N <= 1) {
			return false;
		}

		// �ش� ���ڰ� �Ҽ����� Ȯ���ϱ� ����
		// 2���� N-1 ���� ������ Ȯ��
		// �Ҽ��� �ƴ� ��� �ٷ� return true;
		for (int i = 2; i < N; i++) {
			// ���� �������ٴ� ���� ����� �����Ѵٴ� ��.
			if (N % i == 0) {
				return false;
			}
		}

		return true;
	}

}
