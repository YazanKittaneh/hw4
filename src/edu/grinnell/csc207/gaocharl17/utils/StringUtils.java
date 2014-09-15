package edu.grinnell.csc207.gaocharl17.utils;

import java.util.ArrayList;

public class StringUtils {
	public static String[] splitAt(String input, char sep)
	{
		ArrayList<String> output = new ArrayList<String>(0);
		stringIterator : while(true)
		{
			int sepIndex = input.indexOf(sep);
			if(sepIndex == -1)
			{
				output.add(input);
				break stringIterator;
			}
			output.add(input.substring(0,sepIndex));
			input = input.substring((sepIndex + 1),input.length());
		}
		
		//thanks to http://stackoverflow.com/questions/5374311/convert-arrayliststring-to-string
		String[] arrayOutput = new String[output.size()];
		arrayOutput = output.toArray(arrayOutput);
		return arrayOutput;
	}
}
