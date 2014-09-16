package edu.grinnell.csc207.gaocharl17.utils;

import java.util.ArrayList;

public class StringUtils {

	public static String[] splitAt(String input, char sep) {
		ArrayList<String> output = new ArrayList<String>(0);
		stringIterator: while (true) {
			int sepIndex = input.indexOf(sep);
			if (sepIndex == -1) {
				output.add(input);
				break stringIterator;
			}
			output.add(input.substring(0, sepIndex));
			input = input.substring((sepIndex + 1), input.length());
		}

		// thanks to
		// http://stackoverflow.com/questions/5374311/convert-arrayliststring-to-string
		String[] arrayOutput = new String[output.size()];
		arrayOutput = output.toArray(arrayOutput);
		return arrayOutput;
	}

	public static String[] splitCSV(String input) {
		char sep = ',';
		// define output array
		ArrayList<String> output = new ArrayList<String>(0);

		stringIterator: while (true) {
			if (input.charAt(0) != '"') {// no quotation mark in the current
											// element to scan
				System.out.println("noquote");
				int splitIndex = input.indexOf(sep);
				if (splitIndex == -1) {
					System.out.println("breaking");
					output.add(input);
					break stringIterator;
				}
				output.add(input.substring(0, splitIndex));
				input = input.substring((splitIndex + 1), input.length());
			} else { //there is a quote
				System.out.println("quote");
				int i = 1;
				scanner : while (true)
				{
					if(input.charAt(i) == '"' && i+1 == input.length())
					{
						// if dual-char scanner reaches the end of the string, then extract
						output.add(input.substring(1,i));
						break stringIterator;
					}
					if (input.charAt(i) == '"'  && input.charAt(i + 1) == '"' )
					{
						input = input.substring(0,i) + input.substring(i+1, input.length());	
					}
					if (input.charAt(i) == '"'  && input.charAt(i + 1) == sep)
					{
						// if dual-char scanner reaches ", signifying the end of the element, extract
						int splitIndex = i+1;
						output.add(input.substring(1, (splitIndex - 1)));
						input = input.substring((splitIndex + 1), input.length());
						break scanner;
					}else i++;
				}
			}
		}
		
		

		System.out.println("return now");
		String[] arrayOutput = new String[output.size()];
		arrayOutput = output.toArray(arrayOutput);
		return arrayOutput;
	}
}
