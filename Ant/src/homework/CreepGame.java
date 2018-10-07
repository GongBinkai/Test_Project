package homework;

/**
 * @author gbk
 */
public class CreepGame implements Runnable {

	/**
	 *  ����������е��������ϵ�ʵʱ״̬
	 */
		private Ant[] ants;

		/**
		 *  ��ǰ��Ϸ���е�ʱ��
		 */
		private int time;

		/**
		 *  ����������еĸ�
		 */
		private Stick stick;
		

	/**
	 * ���캯��
	 */
	public CreepGame(Ant[] ants, Stick stick) {
		this.ants = ants;
		this.time = 0;
		this.stick = stick;
	}
	
	/**
	 * �����Ϸʱ��
	 */
	public int getTime() {
		return this.time;
	}

	/**
	 * �ж���Ϸ�Ƿ��Ѿ�����
	 */
	public boolean isEnd() {
		for(int i = 0; i < this.ants.length; i++) {
			if(!stick.isOut(this.ants[i])) return false;

		}
		return true;
	}
	
	/**
	 * ÿ��ִ�еĺ������ж������Ƿ���������������ı����Ϸ���
	 */
	public void update() {
		for(int i = 0; i < this.ants.length - 1; i++) {
			for(int j = i; j < this.ants.length; j++) {
				if(this.ants[i].isCollision(this.ants[j])) {
					this.ants[i].changeDirect();
					this.ants[j].changeDirect();
				}
			}
		}
	}

	@Override
	public void run() {
		this.time = 1;
		for(;;this.time++) {
			for(int i = 0; i < this.ants.length; i++) {		
				/**
				 * System.out.println(this.time + "s����" + i + "��λ��: " + this.ants.get(i).getPosition());
				 */
				if(!this.stick.isOut(this.ants[i])) {
					this.ants[i].creeping();	
				}						
			}
			this.update();	
			DisplayPanel.setAnts(ants);
			DisplayPanel.getInstance().repaint();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(this.isEnd()) {
				DisplayPanel.getInstance().setMessage("����" + time + "s");
				DisplayPanel.getInstance().repaint();
				break;
			}
		}
	}
	
}