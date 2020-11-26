package 정렬;

import java.util.Arrays;

/*
 * 프로그래머스 - 코딩테스트 고득점 Kit
 * 정렬 - K번째수
 * https://programmers.co.kr/learn/courses/30/lessons/42748
 */

class K번째수 {

	public static void main(String[] args) {

		int[] array = { 1, 5, 2, 6, 3, 7, 4 };
		int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };

		int[] result = solution(array, commands);
		System.out.println(Arrays.toString(result));
	}

	public static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];

		for (int i = 0; i < commands.length; i++) {
			int[] tempArray = new int[commands[i][1] - commands[i][0] + 1];

//             int idx = 0;

//             for (int j = commands[i][0]-1; j < commands[i][1]; j++) {
//                 tempArray[idx] = array[j];
//                 idx++;
//             }

			tempArray = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);

			Arrays.sort(tempArray);

			answer[i] = tempArray[commands[i][2] - 1];
		}

		return answer;
	}
}