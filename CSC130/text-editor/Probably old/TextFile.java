import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Stack;

public class TextFile {

	private File originalFile;
	private File newFile;
	
	private boolean isNew;
	
	private Stack<Buffer> currentFile = new Stack<Buffer>();
	private ArrayList<Integer> linesAltered = new ArrayList<Integer>();
	
	public TextFile() {
		
	}
	
	public void openFile(String path) {
		
		originalFile = new File(path);
	
	}
	
	public void openFile(String path, String name) {
		
		if (!name.contains(".txt")) {
			name.concat(".txt");
		}
		
		if (!path.endsWith("//")) {
			path.concat("//");
		}
		
		originalFile = new File(path + name);
		newFile = createTmpFile(originalFile);
		
		
	
	}
	
	public void openFile(File file) {
		
		originalFile = file;
		newFile = createTmpFile(originalFile);
		
	}
	
	public void newFile(String name, String path) {
		if (!name.contains(".txt")) {
			name.concat(".txt");
		}
		
		if (!path.endsWith("//")) {
			path.concat("//");
		}
		
		isNew = true;
		newFile = new File(path + name);
		
	}
	
	public void newFile(String fullPath) {
		
		isNew = true;
		newFile = new File(fullPath);
		
	}
	
	private File createTmpFile(File originalFIle) {
		BufferedReader reader = null;
		FileWriter writer = null;
		String line = null;
		
		File newFile = new File(originalFile.getPath() + originalFile.getName() + "tmp");
		
		try {
			writer = new FileWriter(newFile);
			
		} catch (IOException e2) {
			e2.printStackTrace();
			
		}
		
		try {
			reader = new BufferedReader(new FileReader(originalFile));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		}
		
		try {
			while((line = reader.readLine()) != null) {
				writer.write(line);;          
			}
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		return newFile;
	}
	
	public void importLines(File file, int lineBegin, int lineEnd) {
		BufferedReader reader = null;
		String line = null;
		
		try {
			reader = new BufferedReader(new FileReader(file));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		}
		
		try {
			while((line = reader.readLine()) != null) {
				fillBuffer(line);          
			}
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	private void fillBuffer(String line) {
		Buffer tmp = new Buffer();
		char[] characters = line.toCharArray();
		
		for (char character : characters) {
			tmp.insert(character);
		}
		
		currentFile.push(tmp);
	}
	
}
