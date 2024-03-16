
//No.2477 - 인덱스
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main43 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int K = Integer.parseInt(br.readLine());
		int wMaxIdx = -1, hMaxIdx = -1;
		int wMax = 0, hMax = 0;
		int[] dir = new int[6];
		int[] len = new int[6];

		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			dir[i] = Integer.parseInt(st.nextToken());
			len[i] = Integer.parseInt(st.nextToken());

			if (dir[i] == 1 || dir[i] == 2) {
				if (hMax < len[i]) {
					hMax = len[i];
					hMaxIdx = i;
				}
			} else {
				if (wMax < len[i]) {
					wMax = len[i];
					wMaxIdx = i;
				}
			}
		}

		int max = wMax * hMax;
		int min = len[(wMaxIdx + 3) % 6] * len[(hMaxIdx + 3) % 6];

		System.out.println((max - min) * K);
	}
}