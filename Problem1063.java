import java.io.*;
import java.util.StringTokenizer;

/**
 * ▣ 문제: 백준: 1063 - 킹
 * ▣ 알고리즘:
 * ▣ 시간 복잡도:
 * * [풀이 전략]
 * 1.
 * 2.
 */
public class Problem1063 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 0: y, 1: x
        int[] kingPoint = getPoint(st.nextToken());
        int[] dollPoint = getPoint(st.nextToken());
        int moveCount = Integer.parseInt(st.nextToken());

        String command;
        int crtY, crtX;
        int dollY, dollX;
        for(int i = 0; i < moveCount; i++) {
            command = br.readLine();
            crtY = kingPoint[0];
            crtX = kingPoint[1];
            dollY = dollPoint[0];
            dollX = dollPoint[1];
            switch(command) {
                case "R" : crtX++; dollX++; break;
                case "L" : crtX--; dollX--; break;
                case "B" : crtY++; dollY++; break;
                case "T" : crtY--; dollY--; break;
                case "RT" : crtX++; crtY--; dollX++; dollY--; break;
                case "LT" : crtX--; crtY--; dollX--; dollY--;break;
                case "RB" : crtX++; crtY++; dollX++; dollY++;break;
                case "LB" : crtX--; crtY++; dollX--; dollY++;break;
            }
            if(isOver(crtY, crtX)) continue;
            if(dollPoint[0] == crtY && dollPoint[1] == crtX) {
                if(isOver(crtY, crtX)) continue;
                dollPoint[0] = dollY;
                dollPoint[1] = dollX;
            }
            kingPoint[0] = crtY;
            kingPoint[1] = crtX;
        }
        bw.write((char)('A'+kingPoint[1])+""+kingPoint[0] + "\n");
        bw.write((char)('A'+dollPoint[1])+""+dollPoint[0] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int[] getPoint(String str) {
        int x = str.charAt(0) - 'A';
        int y = str.charAt(1) - '1';
        return new int[]{y, x};
    }

    private static boolean isOver(int y, int x) {
        if(y < 0 || x < 0) return true;
        return y >= 8 || x >= 8;
    }
}
