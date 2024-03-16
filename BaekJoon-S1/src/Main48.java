
//No.1713(후보 추천하기) - 클래스+정렬
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main48 {
	public static class Student {
		int idx;
		int cnt;
		int time;
		boolean check;

		public Student(int idx, int cnt, int time, boolean check) {
			this.idx = idx;
			this.cnt = cnt;
			this.time = time;
			this.check = check;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());
		Student[] arr = new Student[101];
		ArrayList<Student> list = new ArrayList<>();

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < P; i++) {
			int num = Integer.parseInt(st.nextToken());

			if (arr[num] == null) {
				arr[num] = new Student(num, 0, 0, false);
			}

			if (arr[num].check) {
				arr[num].cnt++;
			} else {
				if (list.size() == N) {
					Collections.sort(list, new Comparator<Student>() {
						@Override
						public int compare(Student o1, Student o2) {
							if (o1.cnt == o2.cnt) {
								return o1.time - o2.time;
							}
							return o1.cnt - o2.cnt;
						}
					});
					list.get(0).check = false;
					list.remove(0);
				}
				arr[num].cnt = 1;
				arr[num].time = i;
				arr[num].check = true;
				list.add(arr[num]);
			}
		}

		Collections.sort(list, (o1, o2) -> o1.idx - o2.idx);
		for (Student mem : list) {
			sb.append(mem.idx).append(" ");
		}

		System.out.println(sb);
	}
}