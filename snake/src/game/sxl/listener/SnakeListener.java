package game.sxl.listener;

import game.sxl.entity.Snake;

/**
 * �ߵļ�����
 * ��ͦ�ߵ��ƶ�
 * @author songxilong
 *
 */
public interface SnakeListener {
	/**
	 * �����ߵ��ƶ��Ƿ�Ϸ�
	 * @param snake
	 */
	public void snakeMoved(Snake snake);
}
