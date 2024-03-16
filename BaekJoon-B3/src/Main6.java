
//No.10250
import java.util.Scanner;

public class Main6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int H, W, N, col;
		int arr[] = new int[T];
		for (int i = 0; i < T; i++) {
			H = sc.nextInt();
			W = sc.nextInt();
			N = sc.nextInt();
			if (N % H == 0) {
				col = H;
				W = N / H;
			} else {
				col = N % H;
				W = N / H + 1;
			}
			arr[i] = col * 100 + W;
		}
		for (int i = 0; i < T; i++) {
			System.out.println(arr[i]);
		}
		sc.close();
	}
}
