package 해시;

import java.util.*;

/*
 * 프로그래머스 - 코딩테스트 고득점 Kit
 * 해시 - 위장
 * https://programmers.co.kr/learn/courses/30/lessons/425798
 */

class 위장 {

	public static void main(String[] args) {

		String[][] clothes = { { "yellow_hat", "headgear" }, { "blue_sunglasses", "eyewear" },
				{ "green_turban", "headgear" } };

		int result = solution(clothes);
		System.out.println(result);
	}

	public static int solution(String[][] clothes) {
		int answer = 1;

		HashMap<String, Integer> map = new HashMap<>();

		for (int i = 0; i < clothes.length; i++) {
			if (map.containsKey(clothes[i][1])) {
				map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
			} else
				map.put(clothes[i][1], 1);
		}

		for (String keys : map.keySet()) {
			answer *= (map.get(keys) + 1);
		}

		answer -= 1;

		return answer;
	}
}