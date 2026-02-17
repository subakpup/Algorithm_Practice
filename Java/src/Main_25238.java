import java.util.*;
import java.io.*;

public class Main_25238 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		double a = Double.parseDouble(st.nextToken());
		double b = Double.parseDouble(st.nextToken());

		double defense = a - (a * b / 100);

		System.out.print(defense < 100 ? 1 : 0);
	}

}
