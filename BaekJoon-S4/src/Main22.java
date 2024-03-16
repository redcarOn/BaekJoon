
//No.2003
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main22 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0;
		int end = 0;
		int sum = 0;
		int count = 0;

		while (start < N) {
			if (sum < M) {
				if (end == N) {
					break;
				} else {
					sum += arr[end];
					end++;
				}
			} else if (sum == M) {
				if (end == N) {
					count++;
					sum -= arr[start];
					start++;
				} else {
					count++;
					sum += arr[end];
					end++;
				}
			} else {
				sum -= arr[start];
				start++;
			}
		}
		System.out.println(count);
	}
}
/*	while (start < N) {
		if (sum >= M || end == N) {
			sum -= arr[start++];
		} else  {
    	sum += arr[end++];
		}
        if (sum == M) {
    	arr++;
    }
}*/