import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int[] a = new int[n];
		StringTokenizer st1 = new StringTokenizer(br.readLine());

		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.parseInt(st1.nextToken());
		}

		int x = Integer.parseInt(br.readLine());

		// 시간초과
//		for (int i = 0; i < a.length - 1; i++) {
//			for (int j = i + 1; j < a.length; j++) {
//				if (a[i] != 0 && a[j] != 0 && a[i] + a[j] == x) {
//					a[i] = 0;
//					a[j] = 0;
//					num1.add(a[i]);
//					num2.add(a[j]);
//				}
//			}
//		}
		boolean[] exist = new boolean[1000001];
		int cnt = 0;

		for (int i = 0; i < n; i++) {
			exist[a[i]] = true;
		}

		for (int i = 0; i < a.length; i++) {
			int sub = x - a[i];
			if (0 <= sub && sub <= 1000000) {
				cnt += exist[sub] ? 1 : 0;
			}
		}

		bw.write(cnt / 2 + "");
		bw.flush();
	}
}