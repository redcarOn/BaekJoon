
//No.2096(내려가기) - 슬라이딩 윈도우
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main29_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] dpMax = new int[3];
		int[] dpMin = new int[3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int x1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int x3 = Integer.parseInt(st.nextToken());

			if (i == 0) {
				dpMax[0] = dpMin[0] = x1;
				dpMax[1] = dpMin[1] = x2;
				dpMax[2] = dpMin[2] = x3;
			} else {
				int beforeMax0 = dpMax[0];
				int beforeMax2 = dpMax[2];

				dpMax[0] = Math.max(dpMax[0], dpMax[1]) + x1;
				dpMax[2] = Math.max(dpMax[1], dpMax[2]) + x3;
				dpMax[1] = Math.max(dpMax[1], Math.max(beforeMax0, beforeMax2)) + x2;

				int beforeMin0 = dpMin[0];
				int beforeMin2 = dpMin[2];

				dpMin[0] = Math.min(dpMin[0], dpMin[1]) + x1;
				dpMin[2] = Math.min(dpMin[1], dpMin[2]) + x3;
				dpMin[1] = Math.min(dpMin[1], Math.min(beforeMin0, beforeMin2)) + x2;
			}
		}
		sb.append(Math.max(dpMax[0], Math.max(dpMax[1], dpMax[2]))).append(" ");
		sb.append(Math.min(dpMin[0], Math.min(dpMin[1], dpMin[2])));

		System.out.println(sb);
	}
}