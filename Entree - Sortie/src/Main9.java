import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;

public class Main9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		FileChannel fc = null;
		
		try {
			
			fis = new FileInputStream(new File("dictionnaire.txt"));
			bis = new BufferedInputStream(fis);
			
			long time = System.currentTimeMillis();
			
			while(bis.read() != -1);
			
			System.out.println("Temps d'exécution avec un buffer conventionnel : " + (System.currentTimeMillis() - time));

			fis = new FileInputStream(new File("dictionnaire.txt"));
			
			fc = fis.getChannel();
			
			int size = (int)fc.size();
			
			ByteBuffer bBuff = ByteBuffer.allocate(size);
			
			time = System.currentTimeMillis();
			
			fc.read(bBuff);
			
			bBuff.flip();
			
			System.out.println("Temps d'exécution avec un nouveau buffer : " + (System.currentTimeMillis() - time));
			
			byte[] tabByte = bBuff.array();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fis != null)fis.close();
				if(bis != null)bis.close();
				if(fc != null)fc.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
