package sierpinski_tirangle;

import javax.swing.JApplet;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JMenuBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import net.miginfocom.swing.MigLayout;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class SierpinskiTriangle extends JApplet {
	private JComboBox colorBox;
	private JPanel triPanel;
	private JLabel titleLabel;
	private JPanel menuPanel;
	private JComboBox levelsBox;
	private ArrayList<Triangle> triangles = new ArrayList<Triangle>();
	private Color primary = Color.BLACK;
	private Color secondary = Color.WHITE;
	private int levels = 1;
	private HashMap<String, Color[]> colorSchemes = new HashMap<String, Color[]>();
	private HashMap<String, Integer> depths = new HashMap<String, Integer>();

	/**
	 * Create the applet.
	 */
	public SierpinskiTriangle() {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		
		// load up color Schemes
		colorSchemes.put("Black / White", new Color[] {Color.BLACK, Color.WHITE});
		colorSchemes.put("Blue / Orange", new Color[] {Color.BLUE, Color.ORANGE});
		colorSchemes.put("Red / Green", new Color[] {Color.RED, Color.GREEN});
		colorSchemes.put("Purple / Yellow", new Color[] {new Color(126, 30, 156), Color.YELLOW});
		
		// load up depths
		depths.put("One Level", 1);
		depths.put("Two Levels", 2);
		depths.put("Three Levels", 3);
		depths.put("Four Levels", 4);
		depths.put("Five Levels", 5);
		depths.put("Six Levels", 6);
		depths.put("Seven Levels", 7);
		
		
		getContentPane().setPreferredSize(new Dimension(650, 500));
		
		triPanel = new JPanel();
		triPanel.setBackground(Color.LIGHT_GRAY);
		Triangle triangle = new Triangle(250, 0, 500, 433, 0, 433, true);
		triangle.setBounds(0, 5, 500, 433);
		triangle.fillColor = Color.WHITE;
		triangle.setPreferredSize(new Dimension(500, 433));
		triangle.init(Color.WHITE);
		triPanel.setLayout(null);
		triangles.add(triangle);
		triPanel.add(triangle);
		//triPanel.getRootPane().repaint();
		getContentPane().add(triPanel, BorderLayout.CENTER);
		
		titleLabel = new JLabel("Ross Larson's Sierpinski Triangle");
		titleLabel.setBackground(Color.LIGHT_GRAY);
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(titleLabel, BorderLayout.NORTH);
		
		menuPanel = new JPanel();
		menuPanel.setBackground(Color.LIGHT_GRAY);
		menuPanel.setPreferredSize(new Dimension(140, 550));
		menuPanel.setMaximumSize(new Dimension(20, 1000));
		getContentPane().add(menuPanel, BorderLayout.WEST);
		menuPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		colorBox = new JComboBox();
		colorBox.setMaximumSize(new Dimension(40, 20));
		colorBox.setModel(new DefaultComboBoxModel(new String[] {"Color Options", "Black / White", "Blue / Orange", "Red / Green", "Purple / Yellow"}));
		colorBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					String colors = "";
					if (!((String) e.getItem()).equals("Color Options")) {
						colors = e.getItem().toString();
					}
					else {
						colors = "Black / White";
					}
					primary = colorSchemes.get(colors)[0];
					secondary = colorSchemes.get(colors)[1];
					redraw();
				}
			}
		});
		menuPanel.add(colorBox);
		
		levelsBox = new JComboBox();
		levelsBox.setModel(new DefaultComboBoxModel(new String[] {"Level Depth", "One Level", "Two Levels", "Three Levels", "Four Levels", "Five Levels", "Six Levels", "Seven Levels"}));
		levelsBox.setMaximumSize(new Dimension(40, 20));
		levelsBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					String depth = "";
					if (!((String) e.getItem()).equals("Level Depth")) {
						depth = e.getItem().toString();
					}
					else {
						depth = "One Level";
					}
					levels = depths.get(depth);
					redraw();
				}
			}
		});
		menuPanel.add(levelsBox);

	}
	
	private void redraw() {
		System.out.println("redraw()");
		for (int i = 1 ; i <= levels ; i ++) {
			Triangle triangle = new Triangle(250, 0, 500, 215, 0, 215, true);
			triangle.setPreferredSize(new Dimension(500, 215));
			triangle.init(Color.BLUE);
			triangles.add(triangle);
			triPanel.add(triangle);
			triPanel.getRootPane().revalidate();
			triPanel.getRootPane().repaint();
		}
		
	}

}
