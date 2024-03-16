
//No. 4673
public class Main02 {
	public static void main(String[] args) {
		boolean[] arr = new boolean[10001];
		for (int i = 1; i < 10001; i++) {
			int dn = getSeq(i);
			if (dn < 10001) {
				arr[dn] = true;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < 10001; i++) {
			if (!arr[i]) {
				sb.append(i + "\n");
			}
		}
		System.out.print(sb);
	}

	public static int getSeq(int n) {
		int dn = n;
		while (n > 0) {
			dn += n % 10;
			n /= 10;
		}
		return dn;
	}
}