package 해시;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Solution {

	public static void main(String[] args) {

//		String[] genres = { "classic", "pop", "classic", "classic", "pop", "dance", "k-pop",
//				"k-pop", "k-pop" };
//		int[] plays = { 500, 600, 150, 800, 2500, 1000, 2000, 3000, 500 };
		
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = { 500, 600, 150, 800, 2500 };

		int[] result = solution(genres, plays);
		System.out.println(Arrays.toString(result));
	}

	public static int[] solution(String[] genres, int[] plays) {

		// key(장르이름) + value(총조회수 + 노래 조회수, 인덱스 정보)
		Map<String, GenresInfo> map = new HashMap<>();

		for (int i = 0; i < genres.length; i++) {

			// 아직 추가되지 않은 장르는 새로 만들어서 추가해줌
			if (!map.containsKey(genres[i])) {

				// 새로운 GenresInfo 객체
				map.put(genres[i], new GenresInfo(plays[i], new ArrayList<SongInfo>()));

				// 현재 순서의 노래 정보 추가
				map.get(genres[i]).getSongInfoList().add(new SongInfo(plays[i], i));

				// 이미 존재하는 장르의 경우
			} else {

				// 총 조회수 증가시킴
				GenresInfo temp = map.get(genres[i]);
				temp.setTotalPlays(temp.getTotalPlays() + plays[i]);

				// 노래 정보 추가
				temp.getSongInfoList().add(new SongInfo(plays[i], i));

			}
		}

		// 노래 정보 정렬 기준
		class SongInfoListSort implements Comparator<SongInfo> {

			@Override
			public int compare(SongInfo o1, SongInfo o2) {

				// 조회수 기준 내림차순 정렬, 같은 경우 인덱스 기준 오름차순 정렬
				if (o1.getPlays() < o2.getPlays()
						|| (o1.getPlays() == o2.getPlays() && o1.getIndex() > o2.getIndex())) {
					return 1;
				}

				return -1;
			}
		}

		// 장르 정보를 배열로 바꾸면서 동시에 각 장르가 가진 노래 리스트를 조회수로 정렬
		GenresInfo[] genresInfoList = new GenresInfo[map.size()];
		int k = 0;
		for (Entry<String, GenresInfo> e : map.entrySet()) {

			genresInfoList[k++] = e.getValue();

			// 각 장르안의 노래 리스트 정렬
			e.getValue().getSongInfoList().sort(new SongInfoListSort());
		}

		Arrays.sort(genresInfoList);
		
		// 마지막 작업, 각 장르안의 리스트의 노래 정보에서 최대 2개까지만 인덱스 정보를 가져옴
		List<Integer> result = new ArrayList<>();
		for (GenresInfo g : genresInfoList) {

			List<SongInfo> list = g.getSongInfoList();
			int size = list.size();

			// 1개일 경우
			if (size == 1) {
				result.add(list.get(0).getIndex());

				// 2개일 경우
			} else {
				for (int i = 0; i < 2; i++) {
					result.add(list.get(i).getIndex());
				}
			}
		}

		int resultSize = result.size();
		int[] answer = new int[resultSize];
		for (int i = 0; i < resultSize; i++) {
			answer[i] = result.get(i);
		}

		return answer;
	}
}

/* 장르별 정보 */
class GenresInfo implements Comparable<GenresInfo> {

	private int totalPlays; // 총 조회수
	private List<SongInfo> songInfoList; // 장르에 속한 노래 정보 리스트

	public GenresInfo(int totalPlays, List<SongInfo> songInfo) {
		this.totalPlays = totalPlays;
		this.songInfoList = songInfo;
	}

	// 정렬기준
	@Override
	public int compareTo(GenresInfo o) {

		// 총 조회수 내림차순
		if (totalPlays < o.totalPlays) {
			return 1;
		}
		return -1;
	}

	public int getTotalPlays() {
		return totalPlays;
	}

	public void setTotalPlays(int totalPlays) {
		this.totalPlays = totalPlays;
	}

	public List<SongInfo> getSongInfoList() {
		return songInfoList;
	}

	public void setSongInfoList(List<SongInfo> songInfoList) {
		this.songInfoList = songInfoList;
	}
}

/* 개별 노래 정보 */
class SongInfo {

	private int plays; // 조회수
	private int index; // 인덱스

	public SongInfo(int plays, int index) {
		this.plays = plays;
		this.index = index;
	}

	public int getPlays() {
		return plays;
	}

	public int getIndex() {
		return index;
	}
}