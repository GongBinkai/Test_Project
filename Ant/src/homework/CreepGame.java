package homework;

/**
 * @author gbk
 */
public class CreepGame implements Runnable {

	/**
	 *  在这次爬行中的所有蚂蚁的实时状态
	 */
		private Ant[] ants;

		/**
		 *  当前游戏进行的时间
		 */
		private int time;

		/**
		 *  在这次爬行中的杆
		 */
		private Stick stick;
		

	/**
	 * 构造函数
	 */
	public CreepGame(Ant[] ants, Stick stick) {
		this.ants = ants;
		this.time = 0;
		this.stick = stick;
	}
	
	/**
	 * 获得游戏时间
	 */
	public int getTime() {
		return this.time;
	}

	/**
	 * 判断游戏是否已经结束
	 */
	public boolean isEnd() {
		for(int i = 0; i < this.ants.length; i++) {
			if(!stick.isOut(this.ants[i])) return false;

		}
		return true;
	}
	
	/**
	 * 每秒执行的函数，判断蚂蚁是否相遇，若相遇则改变蚂蚁方向
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
				 * System.out.println(this.time + "s蚂蚁" + i + "的位置: " + this.ants.get(i).getPosition());
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
				DisplayPanel.getInstance().setMessage("花费" + time + "s");
				DisplayPanel.getInstance().repaint();
				break;
			}
		}
	}
	
}