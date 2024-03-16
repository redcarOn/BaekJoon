
//N0.3052
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int arr[] = new int[10];
		int num = 0;
		for (int i = 0; i < 10; i++) {
			int n = Integer.parseInt(br.readLine());
			arr[i] = n % 42;
		}
		for (int i = 0; i < 10; i++) {
			int count = 0;
			for (int j = i + 1; j < 10; j++) {
				if (arr[i] == arr[j])
					count++;
			}
			if (count == 0) {
				num++;
			}
		}
		bw.write(String.valueOf(num));
		bw.flush();
		bw.close();
	}
}