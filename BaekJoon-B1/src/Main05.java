
//No.1546
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main05 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		double[] arr = new double[N];
		int M = 0;
		for (int i = 0; i < N; i++) {
			int grade = Integer.parseInt(st.nextToken());
			arr[i] = grade;
			if (grade > M) {
				M = grade;
			}
		}

		double avg = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = arr[i] / M * 100;
			avg += arr[i];
		}
		System.out.println(avg / N);
	}
}