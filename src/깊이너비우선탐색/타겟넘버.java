package 깊이너비우선탐색;

/*
 * 프로그래머스 - 코딩테스트 고득점 Kit
 * 완전탐색 - 타겟넘버
 * https://programmers.co.kr/learn/courses/30/lessons/43165
 */

class 타겟넘버 {
	
	static int answer = 0;
	
	public static void main(String[] args) {

		int[] numbers = { 1, 1, 1, 1, 1 };
		int target = 3;

		int result = solution(numbers, target);

		System.out.println(result);
	}

	public static int solution(int[] numbers, int target) {

		// DFS 함수를 재귀로 반복하여 타겟 넘버를 만드는 수를 찾는다.
		DFS(numbers, target, 0);

		return answer;
	}

	// depth는 node의 depth를 의미
	public static void DFS(int[] numbers, int target, int depth) {

		// Node의 leaf까지 도달했는지 판단
		if (depth == numbers.length) {
			// numbers 배열 값의 합계를 저장하기 위한 변수
			int sum = 0;
			// numbers 배열 값 합산
			for(int num : numbers) {
				sum += num;
			}
			
			// 합산한 값이 타겟넘버와 일치하면 최종 리턴 값인 answer를 ++;
			if (sum == target) answer++;
		// 아직 중간 노드에 있는 경우
		} else {
			// 왼쪽노드라 가정하여 양수를 곱하고 그 값을 numbers[depth]에 저장
			// Node의 depth를 + 1 하여 재귀호출
			numbers[depth] *= 1;
			DFS(numbers, target, depth + 1);
			// 오른쪽 노드라 가정하여 음수를 곱하고 그 값을 numbers[depth]에 저장
			// Node의 depth를 + 1 하여 재귀호출
			numbers[depth] *= -1;
			DFS(numbers, target, depth + 1);
		}

	}
}
