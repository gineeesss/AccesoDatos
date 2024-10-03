package javanio.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListFiles {

	public static void main(String[] args) {
		Path path = Path.of("ficheros");
		listarFicheros(path);

	}

	private static void listarFicheros(Path path) {
		try {
			Stream<Path> stream = Files.list(path);
			ArrayList<Path> lista = (ArrayList<Path>) stream.collect(Collectors.toList());
				} catch (IOException e) {
		
				}
	}

}
