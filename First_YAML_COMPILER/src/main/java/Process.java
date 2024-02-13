import lombok.Getter;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

@Getter
public class Process {

	public Process() throws IOException {
		System.out.println("Adja meg a beolvasni kívánt fájl elérési útvonalát.");
		String path = new Scanner(System.in).next();
		File file = new File(path);
		YamlReader reader = new YamlReader(file);
		YamlWriter writer = new YamlWriter(reader.getNewLines(), path);
		System.out.println("Elkészült egy új fájl\n" + writer.getNewFilePath() + "\nhelyen. " +
				"\nEbben a fájlban az eredeti string típusú értékek megfordítottjai szerepelnek.");
	}

}
