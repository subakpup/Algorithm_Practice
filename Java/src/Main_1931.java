import java.io.*;
import java.util.*;

public class Main_1931 {
	
	static class Time implements Comparable<Time> {
		int start, end;
		
		Time(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Time o) {
			if (this.end == o.end) return Integer.compare(this.start, o.start);
			return Integer.compare(this.end, o.end);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Time[] times = new Time[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			times[i] = new Time(s, e);
		}
		
		Arrays.sort(times);
		
		int answer = 0, nxtStart = 0;
		for (Time t : times) {
			if (t.start >= nxtStart) {
				answer++;
				nxtStart = t.end;
			}
		}
		System.out.println(answer);
	}

}
