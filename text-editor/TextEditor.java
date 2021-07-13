import java.util.Scanner;


public class TextEditor {

  public static void main(String[] arga) {
	  
	  	FileBuffer textEditor = new FileBuffer();
	    LineBuffer line = new LineBuffer();
	    
		Scanner cmd = new Scanner(System.in);
		
		String command = cmd.nextLine();
		
		char query;
		boolean negative;
		
		System.out.println("Stack-Based Simple Text Editor \n| !H Help | !New | !S Save | !O Open | !E Exit | \n\n Type !N or !N to begin");

		boolean openTextEditor = false;
		
		while(!openTextEditor) {
			
			query = command.isEmpty() ? '\0' : command.charAt(0);
			
			switch(query) {
			case '!':
				char commandArg = command.isEmpty() ? '\0' : command.charAt(0);
				
				switch(commandArg) {
				case 'H':
					System.out.println("This is a simple text editor.\n\n"
							+ "\t- Type any character and press enter to add it to the stream.\n"
							+ "\t- '•' cursor.\n"
							+ "\nCommands:"
							+ "\n\n\t+C\tAdd a special character (C) to the stream."
							+ "\n\t-\tRemove a character from the stream."
							+ "\n\t?\tGet information about the stream (i.e., the size)."
							+ "\n\t<#\tMove the cursor left by (#) number of places."
							+ "\n\t>#\tMove the cursor right by (#) number of places.\n\n"
							+ "\n\t^#\t Move lines (-#) down, (#) up"
							+ "\n\t%\t Next line"
					);
					
					break;
					
				case 'S':
					System.out.println("Enter name of File: ");
					textEditor.save(cmd.nextLine());
					
					openTextEditor = true;
					break;
					
				case 'O':
					System.out.println("Enter name of File: ");
					textEditor.open(cmd.nextLine());
					
					openTextEditor = true;
					break;
					
				case 'E':
					System.out.println("Goodbye!");
					
					cmd.close();
					return;
					
				case 'N':
					openTextEditor = true;
					break;
					
				default:
					System.out.println("Invalid Command!");
				}
				
			case '\0':
				break;
				
			}
		}
		
		textEditor.addLine(new LineBuffer("File:"));
		
		while(openTextEditor) {
			System.out.println("\t" + line.getText());
			System.out.print(" > ");
			
			query = command.isEmpty() ? '\0' : command.charAt(0);
			negative = false;
			
			switch(query) {
			case '!':
				char commandArg = command.isEmpty() ? '\0' : command.charAt(0);
				
				switch(commandArg) {
				case 'H':
					System.out.println("This is a simple text editor.\n\n"
							+ "\t- Type any character and press enter to add it to the stream.\n"
							+ "\t- '•' cursor.\n"
							+ "\nCommands:"
							+ "\n\n\t+C\tAdd a special character (C) to the stream."
							+ "\n\t-\tRemove a character from the stream."
							+ "\n\t?\tGet information about the stream (i.e., the size)."
							+ "\n\t<#\tMove the cursor left by (#) number of places."
							+ "\n\t>#\tMove the cursor right by (#) number of places.\n\n"
							+ "\n\t^#\t Move lines (-#) down, (#) up"
							+ "\n\t%\t Next line"
					);
					
					break;
					
				case 'S':
					System.out.println("Enter name of File: ");
					textEditor.save(cmd.nextLine());
					
					break;
					
				case 'O':
					System.out.println("Enter name of File: ");
					textEditor.open(cmd.nextLine());
					
					break;
					
				case 'E':
					System.out.println("Goodbye!");
					
					cmd.close();
					return;
					
				default:
					System.out.println("Invalid Command!");
				}
				
				
			case '-':
				line.delete();
				
				break;
				
			case '?':
				System.out.println("Number of characters: " + line.size());
				
				break;
				
			case '<':
				negative = true;
				
			case '>':
				int cursorArg = Integer.parseInt(command.substring(1, command.length()));
				
				if(negative) {
					line.left(cursorArg);
					
				} else {
					line.right(cursorArg);
				}
				
				break;
				
			case '&':
				int lineArg = Integer.parseInt(command.substring(1, command.length()));
				
				if(lineArg < 0) {
					textEditor.addLine(line);
					line = textEditor.up(lineArg);
					
				} else {
					textEditor.addLine(line);
					line = textEditor.down(lineArg);
				}
				
				break;
				
			case '%':
				textEditor.addLine(line);
				line = new LineBuffer();
				
				break;
				
			case '\0':
				break;
				
			case '+':
				query = command.charAt(1);
				
			default:
				line.insert(query);
				
				break;
				
			}	
		}
		
	}
}