import lombok.Getter;

import java.io.*;
import java.util.*;

import static java.util.Objects.isNull;

@Getter
public class YamlReader {

	private final File fileToRead;

	protected final ArrayList<String> newLines;


	public YamlReader(File file) throws IOException {

		if (!fileIsReadable(file))
			throw new RuntimeException("A fájl kiterjesztése nem megfelelő, emiatt nem feldolgozható.\n (yaml vagy yml a helyes kiterjesztés)");
		fileToRead = file;
		newLines = new ArrayList<>();
		fillNewLines();
	}


	private boolean fileIsReadable(File file){
		if (!file.exists())
			return false;
		String name = file.getName();
		String extension = name.substring(name.lastIndexOf(".") + 1);
		return "yaml".equals(extension) || "yml".equals(extension);
	}



	private void fillNewLines() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(fileToRead));

		String line = reader.readLine();
		addNewLineToList(line);

		while ((line = reader.readLine()) != null){
			addNewLineToList(line);
		}
	}

	private void addNewLineToList(String line){
		String value = getValue(line);
		newLines.add(isNull(value) ? line : changeValueIfItsReverse(line, value));
	}

	private String changeValueIfItsReverse(String line, String originValue){
		String reversedValue = reverseValueIfItsString(originValue);
		line = line.substring(0, line.lastIndexOf(originValue) - 1);
		return line + " " + reversedValue;
	}

	private String getValue(String line){
		if ("---".equals(line))
			return null;

		String[] keyValue = parseLine(line);
		if (!isNull(keyValue)){
			return keyValue[1];
		}else {
			return null;
		}
	}

	private String reverseValueIfItsString(String value){
		if (!itIsProperValue(value))
			return value;
		return new StringBuilder(value).reverse().toString();
	}

	private boolean itIsProperValue(String value){
		try {
			Integer.parseInt(value);
			return false;
		}catch (NumberFormatException e){
			try {
				Double.parseDouble(value);
				return false;
			}catch (NumberFormatException ex){
				return !"false".equals(value) && !"true".equals(value);
			}
		}
	}


	private String[] parseLine(String line){
		String[] keyValue = line.split(": ");
		if (keyValue.length == 1){
			if (keyValue[0].contains("\t"))
				keyValue = line.split("- ");
			else
				return null;
		}
		return keyValue;
	}

}
