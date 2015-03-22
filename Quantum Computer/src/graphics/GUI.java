package graphics;


import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;

import core.Qubit;
import core.Register;
import core.State;
import algorithm.Grover;

public class GUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final Dimension DEFAULT_SIZE = new Dimension(600, 210);
	public static final int MODIFIER_MINIMUM = 0;
	public static final int MODIFIER_MAXIMUM = 15;
	public static final int RESOLUTION_MINIMUM = 0;
	public static final int RESOLUTION_MAXIMUM = 15;
	private JFrame frame;


	// components - 14 total
	private JTextArea qubitsArea;
	private JTextArea searchIndexArea;
	private JButton startButton;
	private SimpleGraph plot; // TODO update to pre-built package if need be

	private JLabel qubitsLabel;
	private JLabel searchIndexLabel;


	// component locations
	private Point qubitsAreaLocation;
	private Point searchIndexAreaLocation;
	private Point startButtonLocation;
	private Point plotLocation;

	private Point qubitsLabelLocation;
	private Point searchIndexLabelLocation;


	public GUI() {
		super();
		setSize(DEFAULT_SIZE);
		initialise();
	}


	public void reset() {
		//TODO
	}

	public JFrame getFrame() {
		return frame;
	}


	public void setFrame(JFrame frame) {
		this.frame = frame;
	}


	private void initialise() {
		initComponents();
		try {
			UIManager.setLookAndFeel(new MetalLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}


	protected void exit() {
		onExit();
		System.exit(0);
	}

	private void onExit() {
		// Do nothing for now
	}


	private void initComponents() {
		setLayout(null);
		buildComponents();
		calculateComponentLocations();
		updateComponentLocations();
		addComponents();
	}

	private void addComponents() {
		add(qubitsArea);
		add(searchIndexArea);
		add(startButton);
		add(plot);
		add(qubitsLabel);
		add(searchIndexLabel);
	}

	private void updateComponentLocations() {
		qubitsArea.setLocation(qubitsAreaLocation);
		searchIndexArea.setLocation(searchIndexAreaLocation);
		startButton.setLocation(startButtonLocation);
		plot.setLocation(plotLocation);
		qubitsLabel.setLocation(qubitsLabelLocation);
		searchIndexLabel.setLocation(searchIndexLabelLocation);

	}

	private void calculateComponentLocations() {
		qubitsAreaLocation = new Point(150, 50); //
		searchIndexAreaLocation = new Point(150, 10); //
		startButtonLocation = new Point(50, 120); //
		plotLocation = new Point(240, 10);
		qubitsLabelLocation = new Point(10, 50); //
		searchIndexLabelLocation = new Point(30, 10);
	}

	private void buildComponents() {
		qubitsArea = new JTextArea();
		qubitsArea.setSize(50, 30);
		qubitsArea.setText("6");

		searchIndexArea = new JTextArea();
		searchIndexArea.setSize(50, 30);
		searchIndexArea.setText("4");


		startButton = new JButton("Start");
		startButton.setSize(100, 30); //
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				start();
			}
		});



		int graphMin = 0;
		int graphMax = 1;
		int numberOfPoints = 64;
		plot = new SimpleGraph(numberOfPoints, graphMin, graphMax);
		plot.setSize(330, 145); //IRRELEVANT, WILL BE RESET ON START()

		qubitsLabel = new JLabel("Number of Qubits");
		qubitsLabel.setSize(200, 30);

		searchIndexLabel = new JLabel("Search Index:");
		searchIndexLabel.setSize(200, 20);

	}




	protected void start() {
		boolean valid = checkArgumentValidity();

		if (valid) {
			if (frame != null) {
				frame.setTitle("Running");
			}
			int numberOfQubits = Integer.parseInt(qubitsArea.getText());
			int searchIndex = Integer.parseInt(searchIndexArea.getText());

			Qubit[] qubits = new Qubit[numberOfQubits];
			for(int i = 0; i < numberOfQubits; i++){
				qubits[i] = new Qubit(new State(0));
			}

			Register testR = new Register(qubits);
			Grover g = new Grover(testR, searchIndex);
			testR = g.act();
			//			System.out.println(testR);
			//			System.out.println(testR.getProb(searchIndex));
			//double[] values = g.getValues();
			//plot.setValues(values);
			double[] values = g.getValues();
			plot.setValues(values);
			repaint();
			plot.repaint();
			
			if (frame != null) {
				frame.setTitle("");
			}

		} else {
			System.out.println("invalid");
		}
	}


	/**
	 * Returns true if the limit is less than 2^n, where n is the number of qubits.
	 * @return
	 */
	private boolean checkArgumentValidity() {
		int numberOfQubits = Integer.parseInt(qubitsArea.getText());
		int searchIndex = Integer.parseInt(searchIndexArea.getText());

		int limit = (int) Math.pow(2,numberOfQubits);
		if (searchIndex > limit) {
			return false;
		}
		return true;
	}


	public static void main(String[] args) {
		JFrame frame= new JFrame();

		GUI panel = new GUI();
		Dimension size = GUI.DEFAULT_SIZE;

		frame.setSize(size);
		frame.add(panel);
		frame.setLocationRelativeTo(null);
		panel.setFrame(frame);
		frame.setVisible(true);
	}		

}