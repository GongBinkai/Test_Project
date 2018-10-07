package homework;

import java.awt.Color;

import java.awt.Graphics;

import javax.swing.JPanel;
/**
 * @author gbk
 */

public class DisplayPanel extends JPanel implements Runnable {

	private static DisplayPanel instance = new DisplayPanel();
	private static Ant[] ants;
	private static int num;
	private int xi;
	private String message = "";
	private int maxnum = 100;
	
	private DisplayPanel() {
		xi = 0;
		num = 0;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public static DisplayPanel getInstance() {
		return instance;
	}
	
	@Override
	public void paint(Graphics g) {

		super.paint(g);
		for(int i = 0; i < num; i++) {
			g.setColor(DisplayPanel.ants[i].getColor());
			g.drawString(DisplayPanel.ants[i].getAntName(), DisplayPanel.ants[i].getPosition(), 460);		
			g.fillOval(DisplayPanel.ants[i].getPosition(), 480, 20, 20);
		}
		g.setColor(Color.BLACK);
		g.fillRect(0, 500, 320, 10);
		g.drawString(message, 400, 250);
	}

	@Override
	public void run() {

		for(int i = 0; i <= maxnum; i++) {
			xi = xi + 1;
			instance.repaint();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}
	
	public static void setAnts(Ant[] ants) {
		DisplayPanel.ants = ants;
		num = ants.length;
	}
}
