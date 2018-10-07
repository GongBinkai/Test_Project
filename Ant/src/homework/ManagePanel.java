package homework;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import javax.swing.JPanel;
/**
 * @author gbk
 */
public class ManagePanel extends JPanel {

	private static ManagePanel instance;
	
	private ManagePanel() {

		JButton addBtn = new JButton("�������");
		JButton startBtn = new JButton("�Ը�������ʼ��ʼ");
		JButton startBtn2 = new JButton("�����ⷽ��ʼ");
		add(addBtn);
		add(startBtn);
		add(startBtn2);
		addBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				if(e.getSource() == addBtn) {
					InputPanel.getInstance(3);
					InputPanel.addItem();
				}
			}
		});
		startBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				if(e.getSource() == startBtn) {
					InputPanel.getInstance(3);
					Ant[] ants = InputPanel.getAllAnts();
					CreepGame cg = new CreepGame(ants, new Stick(300));
					Thread t = new Thread(cg);
					t.start();
				}
			}
		});
		startBtn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				InputPanel.getInstance(3);

				Ant[] ants = InputPanel.getAllAnts();
				CreepGame cg = new CreepGame(ants, new Stick(300));
				PlayRoom pr = new PlayRoom(cg);
				Thread t = new Thread(pr);
				t.start();
			}
		});
	}
	
	public static ManagePanel getInstance() {
		if(instance == null) {
			instance = new ManagePanel();
		}
		return instance;
	}
}
