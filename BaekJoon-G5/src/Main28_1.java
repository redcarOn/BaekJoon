
//No.5539(이진 검색 트리) - DFS + 재귀
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main28_1 {
	public static StringBuilder sb;
	public static ArrayList<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		list = new ArrayList<>();
		String input = "";

		while ((input = br.readLine()) != null && !input.isEmpty()) {
			int num = Integer.parseInt(input);
			list.add(num);
		}

		postOrder(0, list.size() - 1);

		System.out.println(sb);
	}

	public static void postOrder(int start, int end) {
		if (start > end) {
			return;
		}

		int mid = start + 1;

		while (mid <= end && list.get(mid) < list.get(start)) {
			mid++;
		}

		postOrder(start + 1, mid - 1);
		postOrder(mid, end);
		sb.append(list.get(start)).append('\n');
	}
}