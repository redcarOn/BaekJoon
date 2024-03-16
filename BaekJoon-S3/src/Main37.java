
//No.11478
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main37 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		Set<String> hSet = new HashSet<>();
		int idx = 1;
		int length = s.length();

		while (length > 0) {
			for (int i = 0; i < length; i++) {
				String part = s.substring(i, i + idx);
				hSet.add(part);
			}
			length--;
			idx++;
		}
		System.out.println(hSet.size());
	}
}

/*for (int i = 1; i <= size; i++) {
    for (int j = 0; j <= size - i; j++) {
        String substring = input.substring(j, j + i);
        results.add(substring);
    }
}*/