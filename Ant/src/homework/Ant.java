package homework;

import java.awt.Color;

/**
 * @author gbk1
 */

public class Ant {

	private String antName;
	private int position;
	private int velocity = 5;
	private int direct;
	private Color color;

	public Ant(String antName, int position, int direct, Color color) {
		this.antName = antName;
		this.position = position;
		this.direct = direct;
		this.color = color;
	}

	public String getAntName() {
		return antName;
	}

	public void setAntName(String antName) {
		this.antName = antName;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getVelocity() {
		return velocity;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	public int getDirect() {
		return direct;
	}

	public void setDirect(int direct) {
		this.direct = direct;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * 判断是否与其他蚂蚁碰头
	 */
	public boolean isCollision(Ant other) {
		if (this.position == other.position) {
			return true;
		} 
		return false;
	}

	/**
	 * 蚂蚁爬行1秒 
	 */
	public void creeping() {
		this.position += this.velocity * this.direct;
	}

	/**
	 *  改变爬行方向
	 */
	public void changeDirect() {
		this.direct *= -1;
	}
}
