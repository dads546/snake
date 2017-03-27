package game.sxl.entity;

import game.sxl.util.Global;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

/**
 * 食物类
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
	 * @param snake  蛇类
	 * 判断蛇头坐标与食物是否匹配即可
	 * 把去掉的尾巴加回去
	 * 食物被蛇吃掉
	 */
	public boolean isEatenBySnake(Snake snake) {
		Point head = snake.getHead();
		if(head.equals(this))
			return true;
		return false;
	}
	/**
	 * 添加食物
	 * @param point
	 */
	public void addFood(Point point) {
		this.x = point.x;
		this.y = point.y;
		//System.out.println(x+"++++++++++"+y);
	}
}
