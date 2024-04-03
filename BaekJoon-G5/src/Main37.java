
//No.1092(배) - 정렬 + 그리디 알고리즘 - 리스트에 삭제
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main37 {
	public static void main(String[] arg) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		List<Integer> crane = new ArrayList<>();

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			crane.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(crane, Collections.reverseOrder());

		int M = Integer.parseInt(br.readLine());
		List<Integer> box = new ArrayList<>();

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			box.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(box, Collections.reverseOrder());

		if (crane.get(0) < box.get(0)) {
			System.out.println(-1);
			return;
		}

		int cnt = 0;

		while (!box.isEmpty()) {
			int idx = 0;
			for (int i = 0; i < crane.size(); i++) {
				if (idx == box.size()) {
					break;
				}

				if (crane.get(i) >= box.get(idx)) {
					box.remove(idx);
				} else {
					idx++;
					i--;
				}
			}
			cnt++;
		}

		System.out.println(cnt);
	}
}

// crane이 box무게를 옮기지 못하면 다음 박스로 이동해서 for문 다시 돌기