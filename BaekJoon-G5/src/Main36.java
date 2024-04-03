
//No.2166(다각형의 면적) - 기하학 + 다각형의 넓이 - 신발끈 공식
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main36 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		long[][] point = new long[N + 1][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			point[i][0] = Long.parseLong(st.nextToken());
			point[i][1] = Long.parseLong(st.nextToken());
		}
		point[N] = point[0].clone();

		long a = 0L;
		long b = 0L;

		for (int i = 0; i < N; i++) {
			a += point[i][0] * point[i + 1][1];
			b += point[i][1] * point[i + 1][0];
		}

		String ans = String.format("%.1f", Math.abs(a - b) / 2.0);

		System.out.println(ans);
	}
}
