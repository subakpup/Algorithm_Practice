import java.util.*;
import java.io.*;

public class Main_25206 {
	static double cnt = 0.0;
	static double answer = 0.0;
	static HashMap<String, Double> grades = new HashMap<>();

	private static void init() {
		grades.put("A+", 4.5);
		grades.put("A0", 4.0);
		grades.put("B+", 3.5);
		grades.put("B0", 3.0);
		grades.put("C+", 2.5);
		grades.put("C0", 2.0);
		grades.put("D+", 1.5);
		grades.put("D0", 1.0);
		grades.put("F", 0.0);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		init();

		for (int i = 0; i < 20; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			String title = st.nextToken();
			double credit = Double.parseDouble(st.nextToken());
			String grade = st.nextToken();

			switch (grade) {
			case "P": continue;
			default: {
				answer += credit * grades.get(grade);
				cnt += credit;
			}
			}
			
		}
		
		System.out.println(answer / cnt);
	}

}
