
//No.3273
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main23_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[100001];
		boolean[] check = new boolean[200001];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			check[arr[i]] = true;
		}

		int x = Integer.parseInt(br.readLine());
		int count = 0;

		for (int i = 0; i < n; i++) {
			if (x - arr[i] > 0 && check[x - arr[i]]) {
				count++;
			}
			check[arr[i]] = true;
		}

		System.out.println(count);
	}
}