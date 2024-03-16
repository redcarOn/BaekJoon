
//No.2217
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main19 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Integer[] arr = new Integer[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr, Collections.reverseOrder());

		int count = 0;
		int sum = 0;
		int max = 0;

		for (int i = 0; i < N; i++) {
			count++;
			sum += arr[i];

			if (arr[i] * count <= sum) {
				if (max < arr[i] * count) {
					max = arr[i] * count;
				}
			}
		}
		System.out.println(max);
	}
}

/*for(int i = 0; i < N; i++) {
	int temp = arr[i] * (N - i);
	if(temp > answer) {
		answer = temp;
	}
}*/