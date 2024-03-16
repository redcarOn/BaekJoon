
//No.20922(겹치는 건 싫어) - 투 포인터
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main65 {
	public static int N, K;
	public static int[] arr;
	public static int[] num;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		num = new int[100001];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(check());
	}

	public static int check() {
		int start = 0;
		int end = 0;
		int max = 0;

		while (end < N) {
			if (num[arr[end]] < K) {
				num[arr[end]]++;
				end++;
			} else {
				max = Math.max(max, end - start);
				num[arr[start]]--;
				start++;
			}

			if (end == N) {
				max = Math.max(max, end - start);
				break;
			}
		}
		return max;
	}
}