
//No.4779
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main63 {
	public static StringBuilder s;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input = null;

		while ((input = br.readLine()) != null && !input.isEmpty()) {
			int n = Integer.parseInt(input);
			int len = (int) Math.pow(3, n);
			s = new StringBuilder();
			s.append("-".repeat(len));
			func(0, len);
			sb.append(s).append('\n');
		}
		System.out.println(sb);
	}

	public static void func(int start, int size) {
		if (size == 1) {
			return;
		}

		int nSize = size / 3;

		for (int i = start + nSize; i < start + nSize * 2; i++) {
			s.setCharAt(i, ' ');
		}
		func(start, nSize);
		func(start + nSize * 2, nSize);
	}
}