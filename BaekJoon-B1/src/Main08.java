
//No.2309
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main08 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[9];
		int sum = 0;
		int spy1 = 0, spy2 = 0;

		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		Arrays.sort(arr);
		sum -= 100;
		for (int i = 0; i < 8; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (arr[i] + arr[j] == sum) {
					spy1 = i;
					spy2 = j;
					break;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			if (i == spy1 || i == spy2) {
				continue;
			}
			sb.append(arr[i] + "\n");
		}
		System.out.print(sb);
	}
}