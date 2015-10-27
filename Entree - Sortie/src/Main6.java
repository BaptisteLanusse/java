import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;

public class Main6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CharArrayWriter caw = new CharArrayWriter();
		CharArrayReader car;
		
		try {
			caw.write("Coucou les Zéros");
			
			System.out.println(caw);
			
			caw.close();
			
			car = new CharArrayReader(caw.toCharArray());
			
			int i;
			
			String str = "";
			while((i = car.read()) != -1) {
				str += (char) i;
			}
			
			System.out.println(str);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
