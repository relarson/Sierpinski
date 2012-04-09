/**
 * 
 */
package sierpinski_tirangle;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

/**
 * @author Ross
 *
 */
public class Triangle extends JComponent {

	public int ax, bx, cx, ay, by, cy;
	public Color fillColor;
	public boolean isPrimary;
	
	public Triangle (int ax, int ay, int bx, int by, int cx, int cy, boolean isPrimary) {
		this.ax = ax;
		this.bx = bx;
		this.cx = cx;
		this.ay = ay;
		this.by = by;
		this.cy = cy;
		this.isPrimary = isPrimary;
	}
	
	public void init(Color fillColor) {
		this.fillColor = fillColor;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// set the color
		g.setColor(fillColor);
		g.fillPolygon(new int[] {ax, bx, cx}, new int[] {ay, by, cy}, 3);
	}
	
}
