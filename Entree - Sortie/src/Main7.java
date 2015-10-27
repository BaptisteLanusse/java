import java.io.StringReader;
import java.io.StringWriter;
import java.io.IOException;

public class Main7 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringWriter sw = new StringWriter();
		StringReader sr;
		
		try {
			sw.write("Coucou les Zéros");
			
			System.out.println(sw);
			
			sw.close();
			
			sr = new StringReader(sw.toString());
			
			int i;
			
			String str = "";
			while((i = sr.read()) != -1) {
				str += (char) i;
			}
			
			System.out.println(str);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
