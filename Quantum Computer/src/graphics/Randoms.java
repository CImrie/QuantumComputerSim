package graphics;

/**
 * Calling a function with no arguments assumes:
 * 		Minimum = 0
 * 		Maximum = 10
 */
public class Randoms {
	
	/**
	 * Returns a random integer between the two specified arguments.
	 * @param min The minimum value of the returned integer.
	 * @param max The maximum value of the returned integer.
	 * @return
	 */
	public static int randomInt(int min, int max) {
		int diff = (max - min);
		return (int) ((Math.random() * diff) + min);
	}
	

	/**
	 * Returns a random integer between 0 and 10.
	 * @return
	 */
	public static int randomInt() {
		return randomInt(0,10);
	}
	
	/**
	 * Returns a random double between the two specified arguments.
	 * @param min The minimum value of the returned double.
	 * @param max The maximum value of the returned double.
	 * @return
	 */
	public static double randomDouble(double min, double max) {
		double diff = (max - min);
		return (Math.random() * diff) + min;
	}
	
	/**
	 * Returns a random double between 0 and 10.
	 * @return
	 */
	public static double randomDouble() {
		return randomDouble(0,10.0);
	}

	

	/**
	 * Returns true if a value is between the given arguments.
	 * @param min The minimum required value of the given double.
	 * @param max The maximum required value of the given double.
	 * @param value
	 */
	public static void assertWithinRange(double min, double max, double value) {
		if (value < min | max > value) {
			System.out.println( ""+ (value < min));
			System.out.println("" +  (value > max));
			new Error("Outwith range");
		}
	}
	
	/**
	 * Returns true if a value is between the given arguments.
	 * @param min The minimum required value of the given integer.
	 * @param max The maximum required value of the given integer.
	 * @param value
	 */
	public static void assertWithinRange(int min, int max, int value) {
		if (value < min | value > max) {
			new Error("Outwith range").printStackTrace();
		}
	}
	
}
