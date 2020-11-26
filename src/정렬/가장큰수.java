package 정렬;

import java.util.Arrays;
import java.util.Comparator;

/*
 * 프로그래머스 - 코딩테스트 고득점 Kit
 * 정렬 - 가장큰수
 * https://programmers.co.kr/learn/courses/30/lessons/42746
 */

class 가장큰수 {

	public static void main(String[] args) {

		int[] numbers = { 3, 30, 34, 5, 9 };

		String result = solution(numbers);
		System.out.println(result);
	}

	public static String solution(int[] numbers) {
		String answer = "";

		String[] strArray = new String[numbers.length];

		for (int i = 0; i < numbers.length; i++) {
			strArray[i] = String.valueOf(numbers[i]);
		}

		Arrays.sort(strArray, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {

				return ((o2 + o1).compareTo(o1 + o2));
			}
		});

		if (strArray[0].equals("0")) {
			return "0";
		}

		for (String str : strArray) {
			answer += str;
		}

		return answer;
	}
}