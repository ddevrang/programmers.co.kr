package �ؽ�;

import java.util.Arrays;

/*
 * ���α׷��ӽ� - �ڵ��׽�Ʈ ����� Kit
 * �ؽ� - �����������Ѽ���
 * https://programmers.co.kr/learn/courses/30/lessons/42576
 */

class �����������Ѽ��� {

	public static void main(String[] args) {

		String[] participant = { "leo", "kiki", "eden" };
		String[] completion = { "eden", "kiki" };

		String result = solution(participant, completion);
		System.out.println(result);
	}

	public static String solution(String[] participant, String[] completion) {
		// String answer = "";
		int i;

		Arrays.sort(participant);
		Arrays.sort(completion);

		for (i = 0; i < completion.length; i++) {
			if (!participant[i].equals(completion[i])) {
				return participant[i];
			}
		}

		return participant[i];
	}
}