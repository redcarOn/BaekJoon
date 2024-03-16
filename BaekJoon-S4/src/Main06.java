
//No.11047
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main06 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		System.out.println(coin(arr, K));
	}

	public static int coin(int[] arr, int K) {
		int count = 0;
		int i = arr.length - 1;
		while (K >= 0) {
			if (i < 0) {
				break;
			}
			if (K / arr[i] == 0) {
				i--;
			} else {
				int quo = K / arr[i];
				K -= (quo * arr[i]);
				count += quo;
			}
		}
		return count;
	}
}

/*public static int coin(int[] arr, int K) {
	int count=0;
	for (int i=arr.length-1;i>=0;i--) {
		if (arr[i]<=K) {
			count += K/arr[i];
			K %= arr[i];
		}
	}
	return count;
}*/