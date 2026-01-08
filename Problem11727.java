import java.io.*;

/**
 * ▣ 문제: 백준:11727번 2×n 타일링 2
 * ▣ 알고리즘: DP
 * ▣ 시간 복잡도: O(N)
 * * [풀이 전략]
 * 1. 파보나치 수열
 * 2. 성능향상을 위한 DP 활용
 */
public class Problem11727 {

    /**
     * 2 X 1 : 1
     * 2 X 2 : 3
     * 2 X 3 : 5
     *
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        dp[1] = 1;
        if(N >= 2) {
            dp[2] = 3;
        }

        for(int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 1] + (2* dp[i - 2]))%10007;
        }

        bw.write(dp[N] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
