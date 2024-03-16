//No. 2480
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[3];
		int sum = 0;
		for (int i = 0; i < 3; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		if (arr[0] == arr[1] && arr[1] == arr[2])
			sum = 10000 + arr[0] * 1000;
		else if (arr[0] == arr[1] && arr[1] != arr[2])
			sum = 1000 + arr[0] * 100;
		else if (arr[1] == arr[2] && arr[1] != arr[0])
			sum = 1000 + arr[1] * 100;
		else
			sum = arr[2] * 100;
		System.out.println(sum);
		sc.close();
	}
}
