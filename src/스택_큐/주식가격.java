package ����_ť;

import java.util.Arrays;

/*
 * ���α׷��ӽ� - �ڵ��׽�Ʈ ����� Kit
 * ����/ť - �ֽİ���
 * https://programmers.co.kr/learn/courses/30/parts/12081
 */

class �ֽİ��� {

	public static void main(String[] args) {

		int[] prices = { 1, 2, 3, 2, 3 };

		int[] result = solution(prices);

		System.out.println(Arrays.toString(result));
	}

	public static int[] solution(int[] prices) {

		int[] answer = new int[prices.length];

		int keep_price_second = 0; // ������ ������ ��

		// ���� for���� ���� ������ �������� ���� �ð��� ���
		for (int i = 0; i < prices.length; i++) {
			// �ʱ�ȭ
			keep_price_second = 0;

			// j�� i���� Ŀ���ϱ� ������ ���۰��� i+1
			for (int j = i + 1; j < prices.length; j++) {
				// ������ �����Ǿ����� ++
				// ������ ������� 1�ʰ��� ������ �������� ���� ������ �Ǵ��ϹǷ� ++ ��.
				keep_price_second++;

				// ������ �������� break
				if (prices[i] > prices[j]) {
					break;
				}
			}

			// ������ ������ �ʸ� �迭�� ����
			answer[i] = keep_price_second;
		}

		return answer;
	}
}
