package 완전탐색;

import java.util.HashSet;
import java.util.Set;

/*
 * 프로그래머스 - 코딩테스트 고득점 Kit
 * 완전탐색 - 소수찾기
 * https://programmers.co.kr/learn/courses/30/lessons/42839
 */
class 소수찾기 {

	// 예외처리 할 것 생각. ex) 맨 앞 숫자가 0인 경우, 동일한 값 제거, 소수는 2이상 등..

	// HashSet은 중복을 허용하지 않으므로 중복숫자를 자동으로 처리가능.
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

		// String numbers를 substring으로 한자리씩 끊고
		// int로 형변환하여 int 배열에 저장
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

	// 조합
	static void comb(int[] num, boolean[] visited, String str) {

		// 해당 숫자가 소수인 경우 combinationList에 추가
		if (isPrimeNumber(Integer.parseInt(str))) {
			combinationList.add(Integer.parseInt(str));
		}

		// 방문처리되지 않은 숫자가 있는지 확인하여
		// 해당 숫자를 str + str 형식으로 이어 붙여 comb를 재귀호출
		// 모든 숫자를 다 방문하여 조합이 완료될때까지 반복
		for (int i = 0; i < num.length; i++) {
			if (visited[i] == false) {
				visited[i] = true;
				comb(num, visited, str + String.valueOf(num[i]));
				visited[i] = false;
			}
		}

		return;
	}

	// 소수 판별하기 boolean
	public static boolean isPrimeNumber(int N) {
		// 소수는 2부터 시작한다.
		// 해당 숫자가 2보다 작으면 소수가 아니므로 return false;
		if (N <= 1) {
			return false;
		}

		// 해당 숫자가 소수인지 확인하기 위해
		// 2부터 N-1 까지 나눠서 확인
		// 소수가 아닐 경우 바로 return true;
		for (int i = 2; i < N; i++) {
			// 나눠 떨어진다는 것은 약수가 존재한다는 것.
			if (N % i == 0) {
				return false;
			}
		}

		return true;
	}

}
