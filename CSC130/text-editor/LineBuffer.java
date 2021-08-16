import java.util.Stack;

public class LineBuffer {
    private Stack<Character> bufferLeft;
	private Stack<Character> bufferRight;
	
	private boolean reverse = true;
	
	public LineBuffer() {
		bufferLeft = new Stack<Character>();
		bufferRight = new Stack<Character>();

	}
	
	public LineBuffer(String text) {
		bufferLeft = new Stack<Character>();
		bufferRight = new Stack<Character>();
		
		char[] characters = text.toCharArray();
		
		for (char character : characters) {
			bufferLeft.push(character);
		}
	}
	
	public void insert(char c) {
		bufferLeft.push(c);
		
	}
	
	public char delete() {
		return bufferRight.isEmpty() ? '\0' : bufferRight.pop();
		
	}

	public void left(int k) {
		while(!bufferLeft.isEmpty() && --k >= 0) {
			bufferRight.push(bufferLeft.pop());
		}
		
	}
	
	public void right(int k) {
		while(!bufferRight.isEmpty() && --k >= 0) {
			bufferLeft.push(bufferRight.pop());
		}
		
	}
	
	public int size() {
		return bufferLeft.size() + bufferRight.size();
		
	}
	
	private String serializeBuffer(Stack<Character> bf) {
		int size = bf.size();
		
		StringBuilder out = new StringBuilder();
		
		if(reverse = !reverse) {
			for(int i = size - 1; i>=0; --i) {
				out.append(bf.get(i));
				
			}
			
		} else {
			for(int i = 0; i < size; ++i) {
				out.append(bf.get(i));
				
			}
		}
		
		return out.toString();
	}
	
	public String getText() {
		return serializeBuffer(bufferLeft) + "•" + serializeBuffer(bufferRight);
	}
	
	public String toString() {
		return serializeBuffer(bufferLeft) + serializeBuffer(bufferRight);
		
	}
	
}
