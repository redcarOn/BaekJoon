
//No.10826 (BigInteger)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main16 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		BigInteger bef2 = new BigInteger("0");
		BigInteger bef = new BigInteger("1");
		BigInteger ans = new BigInteger("1");
		if (n == 0) {
			System.out.println(0);
			return;
		} else if (n == 1 || n == 2) {
			System.out.print(1);
			return;
		}
		for (int i = 3; i <= n; i++) {
			bef2 = bef;
			bef = ans;
			ans = ans.add(bef2);
		}
		System.out.println(ans.toString());
	}
}