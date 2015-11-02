import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class Exercici1 {
	public static void main(String[] args) {

		FileInputStream inputStream = null;
		FileInputStream inputStream1 = null;
		FileInputStream inputStream2 = null;
		File outputStream = null;

		try {
			inputStream = new FileInputStream("proba1.txt");
			inputStream1 = new FileInputStream("proba2.txt");
			inputStream2 = new FileInputStream("proba3.txt");
			outputStream = new File("probesJuntes.txt");
			boolean exists = outputStream.exists();
			if (exists) {
				inputStream.close();
				inputStream1.close();
				inputStream2.close();
				throw new FileAlreadyExistsException("El fitxer ja existeix");				
			}
			FileOutputStream fitxerSortida = new FileOutputStream(outputStream);
			copiar(inputStream, fitxerSortida);
			copiar(inputStream1, fitxerSortida);
			copiar(inputStream2, fitxerSortida);
			fitxerSortida.close();
		}
		catch (FileAlreadyExistsException o) {
			System.out.println(o.toString());
		} catch (IOException e) {
			System.out.println(e.toString());
		}
	}


	public static void copiar(FileInputStream fileOriginal, FileOutputStream fileDesti) throws IOException {
		try {
			int c;
			while ((c = fileOriginal.read()) > -1) {
				fileDesti.write(c);
			}
		} catch (Exception e) {
			e.toString();
		} finally {
			if (fileOriginal != null) {
				fileOriginal.close();
			}
		}
	}
}