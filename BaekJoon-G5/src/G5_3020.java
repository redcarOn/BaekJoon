
// No.3020(개똥벌레) - 56
// 누적합
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_3020 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[] up = new int[H + 1];
		int[] down = new int[H + 1];

		for (int i = 0; i < N / 2; i++) {
			up[Integer.parseInt(br.readLine())]++;
			down[Integer.parseInt(br.readLine())]++;
		}

		for (int i = 1; i <= H; i++) {
			up[i] += up[i - 1];
			down[i] += down[i - 1];
		}

		int min = Integer.MAX_VALUE;
		int count = 0;

		for (int i = 1; i <= H; i++) {
			int upCount = up[H] - up[i - 1];
			int downCount = down[H] - down[H - i];
			int total = upCount + downCount;

			if (total < min) {
				min = total;
				count = 1;
			} else if (total == min) {
				count++;
			}
		}

		System.out.println(min + " " + count);
		br.close();
	}
}
