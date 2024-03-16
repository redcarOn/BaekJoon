
//No.1138(한 줄로 서기) - 간편화
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main61_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		ArrayList<Integer> seq = new ArrayList<>();

		for (int i = N; i >= 0; i--) {
			seq.add(arr[i], i);
		}

		for (int i = 1; i <= N; i++) {
			sb.append(seq.get(i)).append(' ');
		}

		System.out.println(sb);
	}
}