
//No.14425
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main24 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Set<String> hSet = new HashSet<>();

		for (int i = 0; i < N; i++) {
			hSet.add(br.readLine());
		}

		int count = 0;

		for (int i = 0; i < M; i++) {
			if (hSet.contains(br.readLine())) {
				count++;
			}
		}
		System.out.println(count);
	}
}