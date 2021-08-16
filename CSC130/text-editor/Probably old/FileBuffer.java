import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class FileBuffer {

	private Stack<LineBuffer> bufferAbove;
	private Stack<LineBuffer> bufferBelow;
	
	public FileBuffer() {
		bufferAbove = new Stack<LineBuffer>();
		bufferBelow = new Stack<LineBuffer>();
		
	}
	
	public void addLine(LineBuffer line) {
		bufferAbove.push(line);
	
	}
	
	public LineBuffer up(int k) {
		while(!bufferAbove.isEmpty() && --k >= 0) {				
			bufferBelow.push(bufferAbove.pop());
			
		}
		
		return bufferAbove.peek();
			
	}
		
	public LineBuffer down(int k) {
		while(!bufferBelow.isEmpty() && --k >= 0) {
			bufferAbove.push(bufferBelow.pop());
		}
		
		return bufferBelow.peek();
	}
		
	public int size() {
		return bufferAbove.size() + bufferBelow.size();
	
	}
	
	public void save(String name) {
		File file = new File(name);
		FileWriter writer;
		
		try {
			writer = new FileWriter(file);
			writer.write(toString());
			
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}
	
	public void open(String name) {
		Scanner reader;
		File file;
		
		try {
			file = new File(name);
			reader = new Scanner(file);
			
			while(reader.hasNextLine()) {
				bufferAbove.add(new LineBuffer(reader.nextLine()));
			}
			
			reader.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		}
	}
	
	public String toString() {
		Stack<LineBuffer> temp = new Stack<LineBuffer>();
		Stack<LineBuffer> temp2 = bufferAbove;
		Stack<LineBuffer> temp3 = bufferBelow;
		
		while (!bufferAbove.isEmpty()) {
			temp.push(temp2.pop());
		}
		
		while (!bufferBelow.isEmpty()) {
			temp.push(temp3.pop());
		}
		
		String out = "";
		
		while (!temp.isEmpty()) {
			out += temp.pop() + "\n";
		}
		
		return out;
	}
	
}
