
//No.1676
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main15 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		count += N / 5 + N / 25 + N / 125;
		System.out.println(count);
	}
}