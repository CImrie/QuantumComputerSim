package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class SimpleGraph extends JComponent {
	public static final Dimension DEFAULT_SIZE = new Dimension(300,300);
	private double[] values;
	private double minimum;
	private double maximum;
	private double range;
	private int numberOfPoints;
	private boolean dynamicScaling;


	/**
	 * Constructs a SimpleGraph for a number of points. Dynamic scaling is used so all points are displayed on the graph.
	 * @param numberOfPoints Number of points in the graph.
	 */
	public SimpleGraph(int numberOfPoints) {
		super();
		this.numberOfPoints = numberOfPoints;
		dynamicScaling = true;
		values = new double[numberOfPoints];
		setSize(DEFAULT_SIZE);
	}

	/**
	 * Constructs a SimpleGraph for a specified y range.
	 * @param numberOfPoints Number of points in the graph.
	 * @param minimum Minimum displayed y value
	 * @param maximum Maximum displayed y value
	 */
	public SimpleGraph(int numberOfPoints, int minimum, int maximum) {
		super();
		this.numberOfPoints = numberOfPoints;
		dynamicScaling = false;
		values = new double[numberOfPoints];
		this.minimum = minimum;
		this.maximum = maximum;
		range = Math.abs(maximum - minimum);
		setSize(DEFAULT_SIZE);
	}


	/**
	 * Called using dynamic scaling usually. Updates the Minimum and Maximum y values so all points are displayed.
	 * @param values
	 */
	public void updateValues(double[] values) {
		this.values = values;
		recalculateBoundaries();
	}

	/**
	 * Updates the Minimum and Maximum y values so all points are displayed.
	 * @param values
	 */
	private void recalculateBoundaries() {
		if (dynamicScaling) {
			minimum = UtilityBelt.getMinimum(values);
			maximum = UtilityBelt.getMaximum(values);
			range = Math.abs(maximum - minimum);
		}
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		double width = getWidth();
		double height = getHeight();

		g.drawLine(0, 0, (int)width,(int)height);
		
		//draw border
		g.setColor(Color.black);
		g.fillRect(0, 0, (int)width, (int)height);
		g.setColor(Color.white);
		g.fillRect(1,1,(int)width-2,(int)height-2);
		g.setColor(Color.black);

		int x = 0;
		double prop = (values[0] - minimum) / (double)range;
		int y = (int)(height - (prop * height));
		int previousX = x;
		int previousY = y;
		

		//draw lines
		for (int i = 2; i < numberOfPoints; i++) {
			x = (int)(i * width / numberOfPoints);
			prop = (values[i] - minimum) / (double)range;
			//System.out.println(values[i]);
			y = (int)(height - (prop * height));
			g.drawLine(previousX, previousY, x, y);
			previousX = x;
			previousY = y;
		}
	}

	/**
	 * Adds a single point to the graph.
	 * @param point
	 */
	public void addPoint(int point) {
		double[] newValues = new double[numberOfPoints];

		for (int i = 1; i < numberOfPoints; i++) {
			newValues[i-1] = values[i];
		}

		
		newValues[numberOfPoints-1] = point;
		values = newValues;
		recalculateBoundaries();


	}

	public static void main(String[] args) {
		
		int min = 0;
		int max = 100000;
		int range = max - min;
		double[] values = new double[range];
		
		for (int i = min; i < max; i++) {
			values[i] = 2 * Math.asin(1 / Math.sqrt(i));
		}
		
		final JFrame frame= new JFrame();
		JPanel panel = new JPanel();
		Dimension size = new Dimension(600,600);
		frame.setSize(size);
		panel.setSize(size);
		//frame.add(panel);
		final SimpleGraph graph = new SimpleGraph(range);
		panel.add(graph);
		//frame.add(graph);
		

		graph.setValues(values);
		
		frame.setVisible(true);
	}
	
	/**
	 * Sets graph values.
	 * @param values
	 */
	public void setValues(double[] values) {
		this.values = values;
		this.numberOfPoints = values.length;
		recalculateBoundaries();
		//System.out.println("setting values");
	}

	/**
	 * Sets whether or not graph adjusts range to draw all points.
	 * @param dynamicScaling
	 */
	public void setDynamicScaling(boolean dynamicScaling) {
		this.dynamicScaling = dynamicScaling;
	}

	/**
	 * Sets minimum and maximum displayed y values.
	 * @param minimum Minimum displayed y value.
	 * @param maximum Maximum displayed y value.
	 */
	public void setBoundaries(int minimum, int maximum) {
		this.minimum = minimum;
		this.maximum = maximum;
	}

	/**
	 * Sets the number of points in the graph.
	 * @param nextNumber
	 */
	public void setNumberOfPoints(int nextNumber) {
		double[] nextValues = new double[nextNumber];
		
		for (int i = 0; i < numberOfPoints && i < nextNumber; i++) {
			nextValues[i] = values[i];
		}
		values = nextValues;
		numberOfPoints = nextNumber;
	}
}
