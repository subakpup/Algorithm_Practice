import java.io.*;

public class Main_5622 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cnt = 0;
		
		while (true) {
			int value = br.read();
			
			if (value == '\n') break;
			
			if (value < 68) cnt += 3;
			else if (value < 71) cnt += 4;
			else if (value < 74) cnt += 5;
			else if (value < 77) cnt += 6;
			else if (value < 80) cnt += 7;
			else if (value < 84) cnt += 8;
			else if (value < 87) cnt += 9;
			else cnt += 10;
		}
		
		System.out.println(cnt);
		
	}

}
