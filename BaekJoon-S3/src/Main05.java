
//No.2579★
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main05 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[301];

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int[] score = new int[301];
		score[1] = arr[1];
		score[2] = arr[2] + score[1];
		for (int i = 3; i <= N; i++) {
			score[i] = arr[i] + Math.max(arr[i - 1] + score[i - 3], score[i - 2]);
		}
		System.out.println(score[N]);
	}
}