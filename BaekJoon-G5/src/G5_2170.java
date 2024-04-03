
// No.2170(선 긋기) - 44
// 정렬 + 스위핑
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class G5_2170 {
	static int N;
	static List<Line> lines;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		lines = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			lines.add(new Line(x, y));
		}

		Collections.sort(lines, (o1, o2) -> o1.start - o2.start);

		System.out.println(draw());
	}

	static int draw() {
		int ans = 0;
		int start = Integer.MIN_VALUE;
		int end = Integer.MIN_VALUE;

		for (Line num : lines) {
			int nowStart = num.start;
			int nowEnd = num.end;

			if (end < nowStart) {
				ans += end - start;
				start = nowStart;
				end = nowEnd;
			} else {
				end = Math.max(end, nowEnd);
			}
		}
		ans += end - start;

		return ans;
	}

	static class Line {
		int start;
		int end;

		Line(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
}