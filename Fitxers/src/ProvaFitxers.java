import java.io.File;

public class ProvaFitxers {
	public static void main(String[] args) {
		try {
			File file = new File("exemple1.txt");
			boolean exist= file.exists();
			if (exist){
				System.out.println("És un arxiu: " + file.isFile());
				System.out.println("Té permsos de lectura: " + file.canRead());
				System.out.println("Té permisos d'escriptura: " + file.canWrite());
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}