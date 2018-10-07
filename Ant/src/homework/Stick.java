package homework;
/**
 * @author gbk
 */
public class Stick {

	/**
	 * 长度
	 */
	private int length;
	
	/**
	 * 构造函数
	 */
	public Stick(int length) {
		this.length = length;
	}
	
	/**
	 * 判断蚂蚁是否超出范围
	 */
	public boolean isOut(Ant ant) {
		if(ant.getPosition() >= this.length || ant.getPosition() <= 0) {
			return true;
		} else {
			return false;
			
		}
	}

}