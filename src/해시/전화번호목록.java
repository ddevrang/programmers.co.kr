package �ؽ�;

import java.util.Arrays;

/*
 * ���α׷��ӽ� - �ڵ��׽�Ʈ ����� Kit
 * �ؽ� - ��ȭ��ȣ���
 * https://programmers.co.kr/learn/courses/30/lessons/42577
 */

class ��ȭ��ȣ��� {

	public static void main(String[] args) {

		String[] phone_book = { "119", "97674223", "1195524421" };

		boolean result = solution(phone_book);
		System.out.println(result);
	}

	public static boolean solution(String[] phone_book) {
		boolean answer = true;
		int i, j;

		Arrays.sort(phone_book);

		for (i = 0; i < phone_book.length; i++) {

			for (j = i + 1; j < phone_book.length; j++) {
				if (phone_book[j].contains(phone_book[i])) {
					return false;
				}
			}

		}

		return answer;
	}
}