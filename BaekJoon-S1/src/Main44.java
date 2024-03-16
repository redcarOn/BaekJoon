
//No.2531(회전 초밥) - 브루트포스 + 투포인터★
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main44 {
	public static int N, d, k, c;
	public static int[] arr;
	public static int[] sushi;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new int[N];
		sushi = new int[d + 1];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		System.out.println(check());
	}

	public static int check() {
		int cnt = 0;

		for (int i = 0; i < k; i++) {

			if (sushi[arr[i]] == 0) {
				cnt++;
			}
			sushi[arr[i]]++;
		}
		int max = sushi[c] == 0 ? cnt + 1 : cnt;

		for (int i = 1; i < N; i++) {
			sushi[arr[i - 1]]--;
			if (sushi[arr[i - 1]] == 0) {
				cnt--;
			}

			if (sushi[arr[(i + k - 1) % N]] == 0) {
				cnt++;
			}
			sushi[arr[(i + k - 1) % N]]++;

			if (max <= cnt) {
				if (sushi[c] == 0) {
					max = cnt + 1;
				} else {
					max = cnt;
				}
			}
		}
		return max;
	}
}