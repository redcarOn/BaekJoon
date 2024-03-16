
//No.1929
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main02 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		for (int i = M; i <= N; i++) {
			if (is_Prime(i)) {
				sb.append(i).append("\n");
			}
		}
		System.out.println(sb);	

	}

	public static boolean is_Prime(int num) {
		if (num == 1) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}

/*for (int i = 2; i <= n; i++){
    for (int j = 2; i * j<= n; j++){
        check[i * j]=true;
    }
}*/