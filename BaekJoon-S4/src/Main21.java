
//No.1026
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main21 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] arrA = new int[N];
		int[] arrB = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arrA[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arrA);

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arrB[i] = Integer.parseInt(st.nextToken());
		}

		int S = 0;
		int maxindex = 0;
		for (int i = 0; i < N; i++) {
			int max = -1;

			for (int j = 0; j < N; j++) {
				if (max < arrB[j]) {
					max = arrB[j];
					maxindex = j;
				}
			}
			arrB[maxindex] = -1;
			S += arrA[i] * max;
		}
		System.out.print(S);
	}
}