package javanio.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListFiles {

	public static void main(String[] args) {
		Path path = Path.of("fichero");
		listarFicheros(path);

	}

	private static void listarFicheros(Path path) {
		try {
			Stream<Path> stream = Files.list(path);
			//ArrayList<Path> lista = (ArrayList<Path>) stream.collect(Collectors.toList());
			//List<Path> lista =  (ArrayList<Path>) stream.collect(Collectors.toList());
			/*for (Path path1: stream.collect(Collectors.toList())) {
				System.out.println(path1);
			}
			for (Path item: lista) {
				System.out.println(item);
			}*/
			stream.forEach(item-> {if (item.toFile().isDirectory()){
				listarFicheros(Path.of(item.toString()));}
			else {
				System.out.println(item);
			}
			});
		} catch (IOException e) {
			System.err.println("Error: no se ha podido crear el stream");
			System.err.println(e.getMessage());
		System.exit(-1);	
		}
	}

}
