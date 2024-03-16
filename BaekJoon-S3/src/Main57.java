
//No.1063
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main57 {
	public static char[] king, stone;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		king = st.nextToken().toCharArray();
		stone = st.nextToken().toCharArray();
		int N = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			char[] tmp = move(s, king);
			if (!range(tmp)) {
				continue;
			} else {
				if (tmp[0] == stone[0] && tmp[1] == stone[1]) {
					char[] tmp2 = move(s, stone);
					{
						if (!range(tmp2)) {
							continue;
						} else {
							king = tmp;
							stone = tmp2;
						}
					}
				} else {
					king = tmp;
				}
			}
		}
		sb.append(king).append('\n').append(stone);
		System.out.println(sb);
	}

	public static boolean range(char[] arr) {
		if (arr[0] < 'A' || arr[0] > 'H' || arr[1] < '1' || arr[1] > '8') {
			return false;
		}
		return true;
	}

	public static char[] move(String s, char[] arr) {
		char[] tmp = arr.clone();
		switch (s) {

		case "R":
			tmp[0]++;
			break;

		case "L":
			tmp[0]--;
			break;

		case "B":
			tmp[1]--;
			break;

		case "T":
			tmp[1]++;
			break;

		case "RT":
			tmp[0]++;
			tmp[1]++;
			break;

		case "LT":
			tmp[0]--;
			tmp[1]++;
			break;

		case "RB":
			tmp[0]++;
			tmp[1]--;
			break;

		case "LB":
			tmp[0]--;
			tmp[1]--;
			break;
		}
		return tmp;
	}
}