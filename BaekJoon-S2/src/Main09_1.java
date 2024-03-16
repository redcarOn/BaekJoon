
//No.1406 - ListIterator
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main09_1 {
	public static LinkedList<Character> list;
	public static ListIterator<Character> iter;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str = br.readLine();
		int M = Integer.parseInt(br.readLine());

		list = new LinkedList<>();

		for (int i = 0; i < str.length(); i++) {
			list.add(str.charAt(i));
		}

		iter = list.listIterator();
		while (iter.hasNext()) {
			iter.next();
		}

		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			edit(s);
		}

		for (Character c : list) {
			sb.append(c);
		}

		System.out.println(sb);
	}

	public static void edit(String s) {
		char c = s.charAt(0);

		switch (c) {
		case 'L':
			if (iter.hasPrevious()) {
				iter.previous();
			}
			break;

		case 'D':
			if (iter.hasNext()) {
				iter.next();
			}
			break;

		case 'B':
			if (iter.hasPrevious()) {
				iter.previous();
				iter.remove();
			}
			break;

		case 'P':
			char x = s.charAt(2);
			iter.add(x);
			break;

		default:
			break;
		}
	}
}