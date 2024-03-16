
//No.10810
import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N, M, i, j, k;
		N = sc.nextInt();
		M = sc.nextInt();
		int arr[] = new int[N];

		for (int a = 0; a < M; a++) {
			i = sc.nextInt();
			j = sc.nextInt();
			k = sc.nextInt();

			for (int b = i - 1; b < j; b++) {
				arr[b] = k;
			}
		}
		for (int a = 0; a < N; a++) {
			System.out.print(arr[a] + " ");

		}
		sc.close();
	}
}