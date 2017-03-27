package game.sxl.entity;

import game.sxl.util.Global;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

/**
 * ʳ����
 * @author songxilong
 *
 */
public class Food extends Point{
	public void	drawMe(Graphics g) {
		g.setColor(Color.RED);
		g.draw3DRect(x*Global.CELL_SIEZ, y*Global.CELL_SIEZ, Global.CELL_SIEZ, Global.CELL_SIEZ, true);
		g.fillOval(x*Global.CELL_SIEZ, y*Global.CELL_SIEZ,15,15);
		//System.out.println(x*Global.CELL_SIEZ+"-----"+y*Global.CELL_SIEZ);
	}
	/**
	 * @param snake  ����
	 * �ж���ͷ������ʳ���Ƿ�ƥ�伴��
	 * ��ȥ����β�ͼӻ�ȥ
	 * ʳ�ﱻ�߳Ե�
	 */
	public boolean isEatenBySnake(Snake snake) {
		Point head = snake.getHead();
		if(head.equals(this))
			return true;
		return false;
	}
	/**
	 * ���ʳ��
	 * @param point
	 */
	public void addFood(Point point) {
		this.x = point.x;
		this.y = point.y;
		//System.out.println(x+"++++++++++"+y);
	}
}
