import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * ▣ 문제: 백준: 2096 - 내려가기
 * ▣ 알고리즘:
 * ▣ 시간 복잡도:
 * * [풀이 전략]
 * 1.
 * 2.
 */
public class Problem2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        final int N = Integer.parseInt(br.readLine());
        final int dpLen = 3;

        int[] maxDP = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] minDP = Arrays.copyOf(maxDP, maxDP.length);


        int[] map, nextMax, nextMin;
        for(int i = 1; i < N; i++) {
            map = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            nextMax = new int[dpLen];
            nextMin = new int[dpLen];

            nextMax[0] = map[0] + Math.max(maxDP[0], maxDP[1]);
            nextMax[1] = map[1] + Math.max(maxDP[0], Math.max(maxDP[1], maxDP[2]));
            nextMax[2] = map[2] + Math.max(maxDP[1], maxDP[2]);

            nextMin[0] = map[0] + Math.min(minDP[0], minDP[1]);
            nextMin[1] = map[1] + Math.min(minDP[0], Math.min(minDP[1], minDP[2]));
            nextMin[2] = map[2] + Math.min(minDP[1], minDP[2]);

            maxDP = nextMax;
            minDP = nextMin;
        }


        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++) {
            max = Math.max(max, maxDP[i]);
            min = Math.min(min, minDP[i]);
        }

        bw.write(max + " " + min + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
