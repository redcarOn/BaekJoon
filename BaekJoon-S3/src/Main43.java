
//No.9996
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main43 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		String pattern = br.readLine();
		String[] pArr = pattern.split("\\*");

		for (int i = 0; i < N; i++) {
			String file = br.readLine();
			if (file.length() < pattern.length() - 1) {
				sb.append("NE").append('\n');
				continue;
			}

			String front = file.substring(0, pArr[0].length());
			String back = file.substring(file.length() - pArr[1].length(), file.length());

			if (front.equals(pArr[0]) && back.equals(pArr[1])) {
				sb.append("DA").append('\n');
			} else {
				sb.append("NE").append('\n');
			}
		}
		System.out.println(sb);
	}
}