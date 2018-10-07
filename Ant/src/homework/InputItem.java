package homework;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author gbk
 */
public class InputItem extends JPanel {

	JTextField antName;
	JTextField antPosition;
	JComboBox antDirect;
	JComboBox antColor;
	String[] directions = {"左", "右"};
	String[] colors = {"红色", "绿色", "蓝色", "黄色", "粉色"};
	
	public InputItem(String name, String position) {

		antName = new JTextField(name);
		antName.setColumns(10);
		antPosition = new JTextField(position);
		antPosition.setColumns(10);
		antDirect = new JComboBox(directions);
		antColor = new JComboBox(colors);
		add(new JLabel("蚂蚁名字: "));
		add(antName);
		add(new JLabel("蚂蚁初始位置: "));
		add(antPosition);
		add(new JLabel("蚂蚁初始方向"));
		add(antDirect);
		add(new JLabel("蚂蚁颜色"));
		add(antColor);
	}
	
	public Ant getAnt() {
		Color[] Colors = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.PINK};
		String name = this.antName.getText();
		int position = Integer.parseInt(this.antPosition.getText());
		int direct = this.antDirect.getSelectedIndex() == 0 ? -1 : 1;
		Color color = Colors[this.antColor.getSelectedIndex()];
		return new Ant(name, position, direct, color);
	}
}
