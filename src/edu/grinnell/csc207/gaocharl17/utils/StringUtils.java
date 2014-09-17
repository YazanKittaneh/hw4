package edu.grinnell.csc207.gaocharl17.utils;

import java.math.BigInteger;
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
	} //splirAt(String input, char sep);

	public static String[] splitCSV(String input) {

		char sep = ',';
		// define output array
		ArrayList<String> output = new ArrayList<String>(0);

		stringIterator: while (true) {
			if (input.charAt(0) != '"') {// no quotation mark in the current
											// element to scan
				int splitIndex = input.indexOf(sep);
				if (splitIndex == -1) {
					output.add(input);
					break stringIterator;
				}
				output.add(input.substring(0, splitIndex));
				input = input.substring((splitIndex + 1), input.length());
			} else { // there is a quote
				int i = 1;
				scanner: while (true) {
					if (input.charAt(i) == '"' && i + 1 == input.length()) {
						// if dual-char scanner reaches the end of the string,
						// then extract
						output.add(input.substring(1, i));
						break stringIterator;
					}
					if (input.charAt(i) == '"' && input.charAt(i + 1) == '"') {
						input = input.substring(0, i)
								+ input.substring(i + 1, input.length());
					}
					if (input.charAt(i) == '"' && input.charAt(i + 1) == sep) {
						// if dual-char scanner reaches ", signifying the end of
						// the element, extract
						int splitIndex = i + 1;
						output.add(input.substring(1, (splitIndex - 1)));
						input = input.substring((splitIndex + 1),
								input.length());
						break scanner;
					} else
						i++;
				}
			}
		} //splitCSV(String input)

		String[] arrayOutput = new String[output.size()];
		arrayOutput = output.toArray(arrayOutput);
		return arrayOutput;
	}

	public static BigInteger calculatorEval0(String input) { // "1 + 2 + 12
		BigInteger result;
		char oper;
		int sepIndex = input.indexOf(" ");
		
		if(sepIndex > 0)
		{
			result = new BigInteger(input.substring(0, sepIndex));
			input = input.substring((sepIndex + 1), input.length()); // set													// input="2 + 12"
		}else{
			result = new BigInteger((input.substring(0,input.length())));
			return result;
		}

		stringIterator: while (true) {
			oper = input.charAt(0); // set oper="+"
			switch (oper) {
			case '+': {
				input = input.substring(2, input.length());
				sepIndex = input.indexOf(" ");
				if (sepIndex == -1) {
					BigInteger modifier = new BigInteger(input.substring(0,
							input.length()));
					result = result.add(modifier);
					break stringIterator;
				} else {
					result = result.add(new BigInteger(input.substring(0,
							sepIndex)));
					input = input.substring((sepIndex + 1), input.length());
				}
				break;
			}
			case '-': {
				input = input.substring(2, input.length());
				sepIndex = input.indexOf(" ");
				if (sepIndex == -1) {
					result = result.subtract(new BigInteger(input.substring(0,
							input.length())));
					break stringIterator;
				} else {
					result = result.subtract(new BigInteger(input.substring(0,
							sepIndex)));
					input = input.substring((sepIndex + 1), input.length());
				}
				break;
			}
			case '/': {
				input = input.substring(2, input.length());
				sepIndex = input.indexOf(" ");
				if (sepIndex == -1) {
					result = result.divide(new BigInteger(input.substring(0,
							input.length())));
					break stringIterator;
				} else {
					result = result.divide(new BigInteger(input.substring(0,
							sepIndex)));
					input = input.substring((sepIndex + 1), input.length());
				}
				break;
			}
			case '*': {
				input = input.substring(2, input.length());
				sepIndex = input.indexOf(" ");
				if (sepIndex == -1) {
					result = result.multiply(new BigInteger(input.substring(0,
							input.length())));
					break stringIterator;
				} else {
					result = result.multiply(new BigInteger(input.substring(0,
							sepIndex)));
					input = input.substring((sepIndex + 1), input.length());
				}
				break;
			}
			case '^': {
				input = input.substring(2, input.length());
				sepIndex = input.indexOf(" ");
				if (sepIndex == -1) {
					result = result.pow(new BigInteger(input.substring(0,
							input.length())).intValue());
					break stringIterator;
				} else {
					result = result.pow(new BigInteger(input.substring(0,
							sepIndex)).intValue());
					input = input.substring((sepIndex + 1), input.length());
				}
				break;
			}
			default:
				break;
			}
		}
		
		return result;
	} //calculatorEval0(String input)
	
	
	public static Fraction calculatorEval1(String input) { // "1 + 2 + 12
		Fraction result;
		char oper;
		int sepIndex = input.indexOf(" ");
		
		if(sepIndex > 0)
		{
			result = new Fraction(input.substring(0, sepIndex));
			input = input.substring((sepIndex + 1), input.length()); // set													// input="2 + 12"
		}else{
			result = new Fraction((input.substring(0,input.length())));
			return result;
		}

		stringIterator: while (true) {
			oper = input.charAt(0); // set oper="+"
			switch (oper) {
			case '+': {
				input = input.substring(2, input.length());
				sepIndex = input.indexOf(" ");
				if (sepIndex == -1) {
					Fraction modifier = new Fraction(input.substring(0,
							input.length()));
					result = result.add(modifier);
					break stringIterator;
				} else {
					result = result.add(new Fraction(input.substring(0,
							sepIndex)));
					input = input.substring((sepIndex + 1), input.length());
				}
				break;
			}
			case '-': {
				input = input.substring(2, input.length());
				sepIndex = input.indexOf(" ");
				if (sepIndex == -1) {
					result = result.subtract(new Fraction(input.substring(0,
							input.length())));
					break stringIterator;
				} else {
					result = result.subtract(new Fraction(input.substring(0,
							sepIndex)));
					input = input.substring((sepIndex + 1), input.length());
				}
				break;
			}
			case '/': {
				input = input.substring(2, input.length());
				sepIndex = input.indexOf(" ");
				if (sepIndex == -1) {
					result = result.divide(new Fraction(input.substring(0,
							input.length())));
					break stringIterator;
				} else {
					result = result.divide(new Fraction(input.substring(0,
							sepIndex)));
					input = input.substring((sepIndex + 1), input.length());
				}
				break;
			}
			case '*': {
				input = input.substring(2, input.length());
				sepIndex = input.indexOf(" ");
				if (sepIndex == -1) {
					result = result.multiply(new Fraction(input.substring(0,
							input.length())));
					break stringIterator;
				} else {
					result = result.multiply(new Fraction(input.substring(0,
							sepIndex)));
					input = input.substring((sepIndex + 1), input.length());
				}
				break;
			}
			case '^': {
				input = input.substring(2, input.length());
				sepIndex = input.indexOf(" ");
				if (sepIndex == -1) { //casting doubles as ints because I can
					result = result.pow((int) new Fraction( input.substring(0,
							input.length())).doubleValue());
					break stringIterator;
				} else {
					result = result.pow((int) new Fraction(input.substring(0,
							sepIndex)).doubleValue());
					input = input.substring((sepIndex + 1), input.length());
				}
				break;
			}
			default:
				break;
			}
		}
		
		return result;
	} //calculatorEval0(String input)
	
	
}
