package homework;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

/**
 * @author gbk
 */
public class InputPanel extends JPanel {

	private static InputPanel instance = null;
	private static ArrayList<InputItem> items;
	private static int num;
	
	private InputPanel(int num) {

		InputPanel.num = num;
		items = new ArrayList();
		for(int i = 0; i < num; i++) {
			InputItem item = new InputItem((i + 1) + "", (i + 1) * 20 + "");
			items.add(item);
			add(item);
		}
	}
	
	public static InputPanel getInstance(int num) {
		if(instance == null) {
			instance = new InputPanel(num);
		}
		return instance;
	}
	
	public static void addItem() {
		num++;
		InputItem item = new InputItem(num + "", num * 20 + "");	
		items.add(item);
		instance.add(item);
		instance.setVisible(true);
	}
	
	public static Ant[] getAllAnts() {
		Iterator<InputItem> i = items.iterator();
		Ant[] ants = new Ant[num];
		int j = 0;
		while(i.hasNext()) {
			ants[j++] = i.next().getAnt();
		}
		return ants;
	}
}
