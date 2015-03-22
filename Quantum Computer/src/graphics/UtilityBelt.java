package graphics;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilityBelt {
	
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
	
	public static String getDateAndTimeString() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		Date date = new Date();
		return dateFormat.format(date); //2014/08/06 15:59:48
	}
}
