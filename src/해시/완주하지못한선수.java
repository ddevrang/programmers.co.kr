package 해시;

import java.util.Arrays;

/*
 * 프로그래머스 - 코딩테스트 고득점 Kit
 * 해시 - 완주하지못한선수
 * https://programmers.co.kr/learn/courses/30/lessons/42576
 */

class 완주하지못한선수 {

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