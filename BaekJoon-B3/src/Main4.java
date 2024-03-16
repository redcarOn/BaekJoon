
//No.10818
import java.util.Scanner;

public class Main4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N, min, max;
		N = sc.nextInt();
		int arr[] = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		min = arr[0];
		max = arr[0];
		for (int i = 1; i < N; i++) {
			if (min > arr[i])
				min = arr[i];
			if (max < arr[i])
				max = arr[i];
		}
		System.out.println(min + " " + max);
		sc.close();
	}
}


/*Scanner sc = new Scanner(System.in);
int N;
N = sc.nextInt();
int arr[] = new int[N];
for (int i = 0; i < N; i++) {
	arr[i] = sc.nextInt();
}
Arrays.sort(arr);
System.out.println(arr[0] + " " + arr[N - 1]);
sc.close();*/