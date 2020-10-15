package �ؽ�;
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

		// key(�帣�̸�) + value(����ȸ�� + �뷡 ��ȸ��, �ε��� ����)
		Map<String, GenresInfo> map = new HashMap<>();

		for (int i = 0; i < genres.length; i++) {

			// ���� �߰����� ���� �帣�� ���� ���� �߰�����
			if (!map.containsKey(genres[i])) {

				// ���ο� GenresInfo ��ü
				map.put(genres[i], new GenresInfo(plays[i], new ArrayList<SongInfo>()));

				// ���� ������ �뷡 ���� �߰�
				map.get(genres[i]).getSongInfoList().add(new SongInfo(plays[i], i));

				// �̹� �����ϴ� �帣�� ���
			} else {

				// �� ��ȸ�� ������Ŵ
				GenresInfo temp = map.get(genres[i]);
				temp.setTotalPlays(temp.getTotalPlays() + plays[i]);

				// �뷡 ���� �߰�
				temp.getSongInfoList().add(new SongInfo(plays[i], i));

			}
		}

		// �뷡 ���� ���� ����
		class SongInfoListSort implements Comparator<SongInfo> {

			@Override
			public int compare(SongInfo o1, SongInfo o2) {

				// ��ȸ�� ���� �������� ����, ���� ��� �ε��� ���� �������� ����
				if (o1.getPlays() < o2.getPlays()
						|| (o1.getPlays() == o2.getPlays() && o1.getIndex() > o2.getIndex())) {
					return 1;
				}

				return -1;
			}
		}

		// �帣 ������ �迭�� �ٲٸ鼭 ���ÿ� �� �帣�� ���� �뷡 ����Ʈ�� ��ȸ���� ����
		GenresInfo[] genresInfoList = new GenresInfo[map.size()];
		int k = 0;
		for (Entry<String, GenresInfo> e : map.entrySet()) {

			genresInfoList[k++] = e.getValue();

			// �� �帣���� �뷡 ����Ʈ ����
			e.getValue().getSongInfoList().sort(new SongInfoListSort());
		}

		Arrays.sort(genresInfoList);
		
		// ������ �۾�, �� �帣���� ����Ʈ�� �뷡 �������� �ִ� 2�������� �ε��� ������ ������
		List<Integer> result = new ArrayList<>();
		for (GenresInfo g : genresInfoList) {

			List<SongInfo> list = g.getSongInfoList();
			int size = list.size();

			// 1���� ���
			if (size == 1) {
				result.add(list.get(0).getIndex());

				// 2���� ���
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

/* �帣�� ���� */
class GenresInfo implements Comparable<GenresInfo> {

	private int totalPlays; // �� ��ȸ��
	private List<SongInfo> songInfoList; // �帣�� ���� �뷡 ���� ����Ʈ

	public GenresInfo(int totalPlays, List<SongInfo> songInfo) {
		this.totalPlays = totalPlays;
		this.songInfoList = songInfo;
	}

	// ���ı���
	@Override
	public int compareTo(GenresInfo o) {

		// �� ��ȸ�� ��������
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

/* ���� �뷡 ���� */
class SongInfo {

	private int plays; // ��ȸ��
	private int index; // �ε���

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