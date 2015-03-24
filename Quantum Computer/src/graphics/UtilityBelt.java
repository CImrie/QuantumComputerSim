package graphics;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilityBelt {
	
	/**
	 * Returns the highest from an array of integers.
	 * @param values Highest integer from the given array.
	 * @return
	 */
	public static int getMaximum(int[] values) {
		int length = values.length;
		
		if (length == 0) {

			new Error("Supplied array of length 0").printStackTrace();
		}
		
		int maximum = values[0];
		
		for (int i = 0; i < length; i++) {
			if (values[i] >= maximum) {
				maximum = values[i];
			}
		}
		return maximum;
	}
	
	/**
	 * Returns the highest from an array of doubles.
	 * @param values Highest double from the given array.
	 * @return
	 */
	public static double getMaximum(double[] values) {
		int length = values.length;
		
		if (length == 0) {

			new Error("Supplied array of length 0").printStackTrace();
		}
		
		double maximum = values[0];
		
		for (int i = 0; i < length; i++) {
			if (values[i] >= maximum) {
				maximum = values[i];
			}
		}
		return maximum;
	}
	
	/**
	 * Returns the lowest from an array of integers.
	 * @param values Lowest integer from the given array.
	 * @return
	 */
	public static int getMinimum(int[] values) {
		int length = values.length;
		
		if (length == 0) {

			new Error("Supplied array of length 0").printStackTrace();
		}
		
		int minimum = values[0];
		
		for (int i = 0; i < length; i++) {
			if (values[i] <= minimum) {
				minimum= values[i];
			}
		}
		return minimum;
	}
	
	/**
	 * Returns the lowest from an array of doubles.
	 * @param values Lowest double from the given array.
	 * @return
	 */
	public static double getMinimum(double[] values) {
		int length = values.length;
		
		if (length == 0) {

			new Error("Supplied array of length 0").printStackTrace();
		}
		
		double minimum = values[0];
		
		for (int i = 0; i < length; i++) {
			if (values[i] <= minimum) {
				minimum= values[i];
			}
		}
		return minimum;
	}
	
	/**
	 * Generates a string based on the current time and date.
	 * @return
	 */
	public static String getDateAndTimeString() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		Date date = new Date();
		return dateFormat.format(date); //2014/08/06 15:59:48
	}
}
