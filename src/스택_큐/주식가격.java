package 스택_큐;

import java.util.Arrays;

/*
 * 프로그래머스 - 코딩테스트 고득점 Kit
 * 스택/큐 - 주식가격
 * https://programmers.co.kr/learn/courses/30/parts/12081
 */

class 주식가격 {

	public static void main(String[] args) {

		int[] prices = { 1, 2, 3, 2, 3 };

		int[] result = solution(prices);

		System.out.println(Arrays.toString(result));
	}

	public static int[] solution(int[] prices) {

		int[] answer = new int[prices.length];

		int keep_price_second = 0; // 가격이 유지된 초

		// 이중 for문을 돌려 가격이 떨어지지 않은 시간을 계산
		for (int i = 0; i < prices.length; i++) {
			// 초기화
			keep_price_second = 0;

			// j는 i보다 커야하기 때문에 시작값은 i+1
			for (int j = i + 1; j < prices.length; j++) {
				// 가격이 유지되었으면 ++
				// 가격이 떨어졌어도 1초간은 가격이 떨어지지 않은 것으로 판단하므로 ++ 임.
				keep_price_second++;

				// 가격이 떨어지면 break
				if (prices[i] > prices[j]) {
					break;
				}
			}

			// 가격이 유지된 초를 배열에 저장
			answer[i] = keep_price_second;
		}

		return answer;
	}
}
