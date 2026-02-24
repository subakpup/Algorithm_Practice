import java.io.*;
import java.util.*;

public class Main_2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] maxDp = new int[3];
        int[] minDp = new int[3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            int val = Integer.parseInt(st.nextToken());
            maxDp[i] = val;
            minDp[i] = val;
        }

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int[] curMax = new int[3];
            int[] curMin = new int[3];

            for (int j = 0; j < 3; j++) {
                int val = Integer.parseInt(st.nextToken());

                int maxPrev = maxDp[j];
                int minPrev = minDp[j];

                if (j > 0) {
                    maxPrev = Math.max(maxPrev, maxDp[j-1]);
                    minPrev = Math.min(minPrev, minDp[j-1]);
                }
                if (j < 2) {
                    maxPrev = Math.max(maxPrev, maxDp[j+1]);
                    minPrev = Math.min(minPrev, minDp[j+1]);
                }

                curMax[j] = val + maxPrev;
                curMin[j] = val + minPrev;
            }

            maxDp = curMax;
            minDp = curMin;
        }

        int maxAns = Math.max(maxDp[0], Math.max(maxDp[1], maxDp[2]));
        int minAns = Math.min(minDp[0], Math.min(minDp[1], minDp[2]));

        System.out.println(maxAns + " " + minAns);
    }
}
