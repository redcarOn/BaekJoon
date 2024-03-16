
//NO.2961(도영이가 만든 맛있는 음식) - 비트마스킹
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main57_1 {
	public static int[] sour;
	public static int[] bit;
	public static int N;
	public static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		sour = new int[N];
		bit = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			sour[i] = Integer.parseInt(st.nextToken());
			bit[i] = Integer.parseInt(st.nextToken());
		}

		bitSolve();

		System.out.println(min);
	}

	public static void bitSolve() {
		for (int i = 1; i < 1 << N; i++) {
			int S = 1, B = 0;
			for (int j = 0; j < N; j++) {
				if ((i & 1 << j) > 0) {
					S *= sour[j];
					B += bit[j];
				}
			}
			min = Math.min(min, Math.abs(S - B));
		}
	}
}