
//No.2477 - 좌표
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main43_1 {
	public static int K, ans;
	public static Point[] pList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		K = Integer.parseInt(br.readLine());
		pList = new Point[6];
		Point now = new Point(0, 0);

		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());

			switch (dir) {
			case 1:
				pList[i] = new Point(now.x + len, now.y);
				break;

			case 2:
				pList[i] = new Point(now.x - len, now.y);
				break;

			case 3:
				pList[i] = new Point(now.x, now.y - len);
				break;

			case 4:
				pList[i] = new Point(now.x, now.y + len);
				break;
			}
			now = pList[i];
		}

		solve();
		System.out.println(ans);

	}

	public static void solve() {
		int minX = Integer.MAX_VALUE;
		int minY = Integer.MAX_VALUE;
		int maxX = Integer.MIN_VALUE;
		int maxY = Integer.MIN_VALUE;
		int midX = 0, midY = 0;

		for (int i = 0; i < 6; i++) {
			if (maxX < pList[i].x) {
				maxX = pList[i].x;
			}
			if (minX > pList[i].x) {
				minX = pList[i].x;
			}
			if (maxY < pList[i].y) {
				maxY = pList[i].y;
			}
			if (minY > pList[i].y) {
				minY = pList[i].y;
			}
		}

		for (int i = 0; i < 6; i++) {
			if (pList[i].x > minX && pList[i].x < maxX) {
				midX = pList[i].x;
			}
			if (pList[i].y > minY && pList[i].y < maxY) {
				midY = pList[i].y;
			}
		}

		int lenX = 0, lenY = 0;

		for (int i = 0; i < 6; i++) {
			if (pList[i].x == midX && pList[i].y != midY) {
				lenY = Math.max(pList[i].y, midY) - Math.min(pList[i].y, midY);
			}
			if (pList[i].y == midY && pList[i].x != midX) {
				lenX = Math.max(pList[i].x, midX) - Math.min(pList[i].x, midX);
			}
		}

		int big = (maxX - minX) * (maxY - minY);
		int small = lenX * lenY;

		ans = (big - small) * K;
	}
}