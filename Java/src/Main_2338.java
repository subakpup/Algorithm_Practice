import java.io.*;
import java.math.BigInteger;

public class Main_2338 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		BigInteger a = new BigInteger(br.readLine());
		BigInteger b = new BigInteger(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		sb.append(a.add(b)).append('\n').append(a.subtract(b)).append('\n').append(a.multiply(b));
		
		System.out.println(sb.toString());
	}

}
