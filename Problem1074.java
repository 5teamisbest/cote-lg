import java.io.*;
import java.util.StringTokenizer;

/**
 * ▣ 문제: 백준: 1074 - Z
 * ▣ 알고리즘:
 * ▣ 시간 복잡도:
 * * [풀이 전략]
 * 1.
 * 2.
 */
public class Problem1074 {

    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, N);

        solve(size, r, c);

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void solve(int size, int r, int c) {
        if (size == 1) {
            return;
        }

        int half = size / 2;

        if (r < half && c < half) {
            solve(half, r, c);
        }
        else if (r < half && c >= half) {
            count += half * half;
            solve(half, r, c - half);
        }
        else if (r >= half && c < half) {
            count += 2 * half * half;
            solve(half, r - half, c);
        }
        else {
            count += 3 * half * half;
            solve(half, r - half, c - half);
        }
    }
}
