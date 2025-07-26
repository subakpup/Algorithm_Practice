/*
 * Main_3273_두수의합_함지수
 *  - n개의 서로 다른 양의 정수로 이루어진 수열
 *  - 자연수 x
 *  - ai + aj = x를 만족하는 쌍의 개수 출력
 *  
 * 아이디어
 *  - 투 포인터 알고리즘 사용
 *  - 배열을 정렬하고 왼쪽 끝, 오른쪽 끝 인덱스를 줄여가며 합의 쌍을 찾는 방식 이용
 */

import java.util.*;
import java.io.*;

public class Main_3273 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int x = Integer.parseInt(br.readLine());
        
        Arrays.sort(arr);
        int l = 0, r = n-1, cnt = 0;
        
        while (l<r) {
            int cur = arr[l] + arr[r];
            if (cur < x) {
                ++l;
            } else if (cur > x) {
                --r;
            } else {
                ++cnt;
                ++l;
            }
        }
        System.out.println(cnt);
    }

}
