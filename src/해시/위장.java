package �ؽ�;

import java.util.*;

/*
 * ���α׷��ӽ� - �ڵ��׽�Ʈ ����� Kit
 * �ؽ� - ����
 * https://programmers.co.kr/learn/courses/30/lessons/425798
 */

class ���� {

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