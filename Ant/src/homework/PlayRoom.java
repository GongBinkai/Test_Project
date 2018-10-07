package homework;
/**
 * @author gbk
 */
public class PlayRoom implements Runnable {

	private CreepGame cg;
	private int minTime = 10000;
	private int maxTime = 0;
	private int num = 2;
	public PlayRoom(CreepGame cg) {

		this.cg = cg;
	}

	@Override
	public void run() {

		
		InputPanel.getInstance(3);
		Ant[] ants = InputPanel.getAllAnts();
		int length = ants.length;
		int arrs[] = new int[length];
		Thread t = null;
		
		
		for(int i = 0; i < (int)Math.pow(num, length); i++) {
			InputPanel.getInstance(3);
			ants = InputPanel.getAllAnts();
			String str = Integer.toBinaryString(i);
			char chs[] = str.toCharArray();
			int l = str.length();
			int directions[] = new int[length];
			for(int j = 0; j < length; j++) {
				if((j + l) >= length) {
					directions[j] = chs[j + l - length] == '0' ? -1 : 1;
				} else {
					directions[j] = -1;
				}
			}
			
			for(int j = 0; j < length; j++) {
				ants[j].setDirect(directions[j]);
			}
			
			cg = new CreepGame(ants, new Stick(300));
			t = new Thread(cg);
			t.start();
			try {
				t.join();
				Thread.sleep(100);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			if(minTime > cg.getTime()) {
				minTime = cg.getTime();
			}
			if(maxTime < cg.getTime()) {
				maxTime = cg.getTime();
			}
		}
		System.out.println("最小运行时间: " + minTime);
		System.out.println("最长运行时间: " + maxTime);
	}

}
