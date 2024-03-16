
//No.2108
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main08 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);

		sb.append(avg(arr)).append('\n');
		sb.append(mid(arr)).append('\n');
		sb.append(mode(arr)).append('\n');
		sb.append(range(arr));
		System.out.println(sb);
	}

	public static int avg(int[] arr) {
		double sum = 0;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		sum = Math.round(sum / arr.length);
		return (int) sum;
	}

	public static int mid(int[] arr) {
		return arr[arr.length / 2];
	}

	public static int mode(int[] arr) {
		int[] tmp = new int[8001];
		int max = 0;
		int idx = 0;
		for (int i = 0; i < arr.length; i++) {
			tmp[arr[i] + 4000]++;
			if (max < tmp[arr[i] + 4000]) {
				max = tmp[arr[i] + 4000];
			}
		}

		List<Integer> aList = new ArrayList<>();

		for (int i = 0; i < tmp.length; i++) {
			if (max == tmp[i]) {
				aList.add(i);
			}
		}
		if (aList.size() == 1) {
			idx = aList.get(0);
		} else {
			idx = aList.get(1);
		}
		return idx - 4000;
	}

	public static int range(int[] arr) {
		return arr[arr.length - 1] - arr[0];
	}
}