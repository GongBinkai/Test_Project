package homework;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

/**
 * @author gbk
 */
public class MainFrame extends JFrame {

	public void init() {
		JSplitPane upDown = new JSplitPane(JSplitPane.VERTICAL_SPLIT, InputPanel.getInstance(3), DisplayPanel.getInstance());
		upDown.setDividerLocation(400);
		JSplitPane leftRight = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, upDown, ManagePanel.getInstance());
		leftRight.setDividerLocation(750);
		this.add(leftRight);
	}
	
	public MainFrame() {
		this.setSize(1000, 1000);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		init();
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		MainFrame mf = new MainFrame();
	}
	
}
