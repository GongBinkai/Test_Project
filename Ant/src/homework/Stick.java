package homework;
/**
 * @author gbk
 */
public class Stick {

	/**
	 * ����
	 */
	private int length;
	
	/**
	 * ���캯��
	 */
	public Stick(int length) {
		this.length = length;
	}
	
	/**
	 * �ж������Ƿ񳬳���Χ
	 */
	public boolean isOut(Ant ant) {
		if(ant.getPosition() >= this.length || ant.getPosition() <= 0) {
			return true;
		} else {
			return false;
			
		}
	}

}