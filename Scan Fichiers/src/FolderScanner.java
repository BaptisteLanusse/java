import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FolderScanner {
	private Path path = null;
	private String filter = "*";
	private long result = 0;

	public FolderScanner() {
	}

	public FolderScanner(Path p, String f) {
		path = p;
		filter = f;
	}

	public long sequentialScan() throws ScanException {
		if (path == null || path.equals("")) {
			throw new ScanException(
					"Chemin à scanner non valide (vide ou null) !");
		}

		System.out.println("Scan du dossier : " + path
				+ " à la recherche des fichiers portant l'extension "
				+ this.filter);

		try (DirectoryStream<Path> listing = Files.newDirectoryStream(path)) {
			for (Path nom : listing) {
				if (Files.isDirectory(nom.toAbsolutePath())) {
					FolderScanner f = new FolderScanner(nom.toAbsolutePath(),
							this.filter);
					result += f.sequentialScan();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (DirectoryStream<Path> listing = Files.newDirectoryStream(path,
				this.filter)) {
			for (Path nom : listing) {
				result++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;

	}

}
