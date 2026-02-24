import java.util.*;
import java.io.*;

public class Main_10814 {
	
	static class Member implements Comparable<Member> {
		int age;
		String name;
		
		Member (int age, String name) {
			this.age= age;
			this.name = name;
		}
		
		@Override
		public int compareTo(Member o) {
			return this.age - o.age;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Member[] members = new Member[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			members[i] = new Member(age, name);
		}
		
		Arrays.sort(members);
		
		StringBuilder sb = new StringBuilder();
		for (Member m : members) sb.append(m.age + " " + m.name + '\n');
		System.out.println(sb.toString());
	}
}
