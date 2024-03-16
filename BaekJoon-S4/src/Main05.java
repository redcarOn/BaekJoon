
//No.1065
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main05 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.println(ArtSeq(N));
	}

	public static int ArtSeq(int N) {
		int count = 0;
		if (N < 100) {
			return N;
		} else {
			count = 99;
			int tmp = 100;
			while (tmp <= N) {
				if ((tmp / 100 + tmp % 10) == 2 * ((tmp / 10) % 10)) {
					count++;
					tmp++;
				} else {
					tmp++;
				}
			}
		}
		return count;
	}
}