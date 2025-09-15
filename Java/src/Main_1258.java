import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String s = br.readLine();
			if (s.equals("0")) break;
			
			StringBuilder sb = new StringBuilder(s);
			
			String answer = "no";
			if (s.equals(sb.reverse().toString())) answer = "yes";
			System.out.println(answer);
		}
	}
}
