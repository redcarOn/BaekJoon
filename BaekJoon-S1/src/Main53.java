
//No.15954(인형들) - 브루트포스
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main53 {
	public static int N;
	public static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		arr = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		double min = Double.MAX_VALUE;

		for (int i = K; i <= N; i++) {
			for (int j = 0; j <= N - i; j++) {
				min = Math.min(min, func(j, i));
			}
		}

		System.out.println(String.format("%.11f", min));
	}

	public static double func(int start, int K) {
		double sum = 0;
		double avg = 0;
		double v = 0;

		for (int i = 0; i < K; i++) {
			sum += arr[start + i];
		}

		avg = sum / K;

		for (int i = 0; i < K; i++) {
			v += Math.pow(arr[start + i] - avg, 2);
		}

		return Math.sqrt(v / K);
	}
}