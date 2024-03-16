
//No.5397 - ListIterator
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main23_1 {
	public static LinkedList<Character> list;
	public static ListIterator<Character> iter;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			char[] str = br.readLine().toCharArray();
			list = new LinkedList<>();
			iter = list.listIterator();

			for (char c : str) {
				if (c == '-') {
					if (iter.hasPrevious()) {
						iter.previous();
						iter.remove();
					}

				} else if (c == '<') {
					if (iter.hasPrevious()) {
						iter.previous();
					}

				} else if (c == '>') {
					if (iter.hasNext()) {
						iter.next();
					}

				} else {
					iter.add(c);
				}
			}

			for (char c : list) {
				sb.append(c);
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}