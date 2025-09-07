import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        ArrayList<String> list = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            list.add(br.readLine());
        }
        Object [] arr = new Object [m+1];
        for (int i = 1; i <= m; i++) {
            arr[i] = br.readLine();
        }
        
        for (int i = 1; i <= m; i++) {
            Object anw = arr[i].getClass().getSimpleName();
            if(anw.equals("String")) {
                System.out.println(list.indexOf(arr[i])+1);
            }
            else {
                System.out.println(list.get(i));
            }
            
        }

    }
}