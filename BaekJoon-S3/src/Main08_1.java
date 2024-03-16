
//No.2108 (수정)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main08_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[8001];
		int sum = 0;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int center = 0;
		int often = 0;

		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(br.readLine());
			sum += tmp;
			arr[tmp + 4000]++;
			if (max < tmp) {
				max = tmp;
			}
			if (min > tmp) {
				min = tmp;
			}
		}

		int cnt = 0;
		int oftenMax = 0;
		boolean check = false;

		for (int i = min + 4000; i <= max + 4000; i++) {
			if (arr[i] > 0) {
				if (cnt < (N + 1) / 2) {
					cnt += arr[i];
					center = i - 4000;
				}
				if (oftenMax < arr[i]) {
					oftenMax = arr[i];
					often = i - 4000;
					check = true;
				} else if (oftenMax == arr[i] && check == true) {
					often = i - 4000;
					check = false;
				}
			}
		}
		sb.append((int) Math.round((double) sum / N)).append('\n');
		sb.append(center).append('\n');
		sb.append(often).append('\n');
		sb.append(max - min);
		System.out.println(sb);
	}
}