package 스택_큐;

import java.util.Arrays;

/*
 * 프로그래머스 - 코딩테스트 고득점 Kit
 * 스택/큐 - 기능개발
 * https://programmers.co.kr/learn/courses/30/lessons/42586
 */

class 기능개발 {

	public static void main(String[] args) {

		int[] progresses = { 93, 30, 55 };
//		int[] progresses = { 95, 90, 99, 99, 80, 99 };

		int[] speeds = { 1, 30, 5 };
//		int[] speeds = { 1, 1, 1, 1, 1, 1 };

		int[] result = solution(progresses, speeds);

		System.out.println(Arrays.toString(result));
	}

	public static int[] solution(int[] progresses, int[] speeds) {

		// 각 작업을 끝내는데 걸리는 일자
		int[] Working_days = new int[progresses.length];

		// 배포할 총 일 수
		int distribute_day = 0;
		// 뒤에 있는 기능을 앞에 있는 기능과 함께 배포할지 확인하기 위한 변수
		int max = 0;

		for (int i = 0; i < progresses.length; i++) {
			// 각 작업을 끝내는데 걸리는 일자를 구함
			// 나누어 떨어지지 않는 경우 작업이 완료되지 않은 것이므로, 작업일자 +1을 해준다.
			if ((100 - progresses[i]) % speeds[i] == 0) {
				Working_days[i] = (100 - progresses[i]) / speeds[i];
			} else {
				Working_days[i] = ((100 - progresses[i]) / speeds[i]) + 1;
			}

			// 뒤에 있는 기능을 앞에 있는 기능과 함께 배포할지 확인
			// 기존 max값보다 크면 함께 배포할 수 없으므로 배포할 횟수를 ++
			// 그리고 그 값을 새로운 max값으로 저장
			if (Working_days[i] > max) {
				distribute_day++;
				max = Working_days[i];
			}
		}

		// 배포할 총 일 수를 size로 return할 배열을 만듬.
		int[] answer = new int[distribute_day];
		int answer_index = 0;

		// 동시에 배포할 갯수
		int distribute_count = 1;

		for (int i = 0; i < Working_days.length; i++) {

			// 앞, 뒤에 기능을 비교하여 뒤의 개발도 끝난 상태라면 동시에 배포하기 위함
			for (int j = i + 1; j < Working_days.length; j++) {

				// 뒤의 기능 개발이 안 끝난경우 break
				if (Working_days[i] < Working_days[j])
					break;

				// 동시에 배포하는 갯수 ++
				distribute_count++;
				// 동시에 배포할 대상은 건너 뜀.
				i++;
			}

			// 동시에 배포하는 갯수를 return 할 배열에 입력
			answer[answer_index] = distribute_count;
			// 배열 index++
			answer_index++;
			// distribute_count 값 초기화
			distribute_count = 1;

		}

		return answer;
	}
}
