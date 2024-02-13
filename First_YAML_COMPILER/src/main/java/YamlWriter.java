import lombok.Getter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

@Getter
public class YamlWriter {

	private final ArrayList<String> linesToWrite;

	private final String originalFilePath;

	private String newFilePath;

	private File outPut;

	public YamlWriter(ArrayList<String> linesToWrite, String path) throws IOException {
		this.linesToWrite = linesToWrite;
		originalFilePath = path;
		newFilePath = generateNewFilePath();
		createOutPut();
	}

	private String generateNewFilePath(){
		String path = originalFilePath.substring(0, originalFilePath.lastIndexOf("."));
		String extension = originalFilePath.substring(originalFilePath.lastIndexOf("."));
		path += "OutPut";
		return path + extension;
	}

	private void createOutPut() throws IOException {
		outPut = new File(newFilePath);
		BufferedWriter writer = new BufferedWriter(new FileWriter(outPut));

		for (String s : linesToWrite) {
			writer.append(s);
		}
	}
}
