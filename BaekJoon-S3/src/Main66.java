
//No.6986
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main66 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		double[] arr = new double[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Double.parseDouble(br.readLine());
		}
		Arrays.sort(arr);

		sb.append(avgd(arr, K)).append('\n').append(avga(arr, K));
		System.out.println(sb);
	}

	public static String avgd(double[] arr, int K) {
		double sum = 0;
		double avg = 0;
		String result = "";

		for (int i = K; i < arr.length - K; i++) {
			sum += arr[i];
		}

		avg = sum / (arr.length - K * 2);
		result = String.format("%.2f", avg);
		return result;
	}

	public static String avga(double[] arr, int K) {
		double sum = 0;
		double avg = 0;
		String result = "";

		for (int i = 0; i < K; i++) {
			arr[i] = arr[K];
		}
		for (int i = arr.length - 1; i >= arr.length - K; i--) {
			arr[i] = arr[arr.length - K - 1];
		}
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}

		avg = sum / arr.length;
		result = String.format("%.2f", avg);
		return result;
	}
}