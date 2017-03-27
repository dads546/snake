package game.sxl.listener;

import game.sxl.entity.Snake;

/**
 * 蛇的监听器
 * 坚挺蛇的移动
 * @author songxilong
 *
 */
public interface SnakeListener {
	/**
	 * 监听蛇的移动是否合法
	 * @param snake
	 */
	public void snakeMoved(Snake snake);
}
