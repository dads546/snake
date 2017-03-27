package game.sxl.controller;

import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JOptionPane;

import game.sxl.entity.Food;
import game.sxl.entity.Ground;
import game.sxl.entity.Snake;
import game.sxl.listener.SnakeListener;
import game.sxl.util.Global;
import game.sxl.view.GamePanel;

/**
 * ����������ʵ���༰��ͼ��
 * @author songxilong
 *
 */
public class Controller extends KeyAdapter implements SnakeListener{
	private Snake snake;
	private Food food;
	private Ground ground;
	private GamePanel gamePanel;
	public Controller(Snake snake,Food food,Ground ground,GamePanel gamePanel){
		this.snake = snake;
		this.food = food;
		this.ground = ground;
		this.gamePanel = gamePanel;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int keycode = e.getKeyCode();
		switch (keycode) {
		case KeyEvent.VK_UP:
			snake.changeDirection(Snake.UP);
			break;
		case KeyEvent.VK_DOWN:
			snake.changeDirection(Snake.DOWN);
			break;
		case KeyEvent.VK_LEFT:
			snake.changeDirection(Snake.LEFT);
			break;
		case KeyEvent.VK_RIGHT:
			snake.changeDirection(Snake.RIGHT);
			break;
		default:
			break;
		}
	}
	/**
	 * �ж����Ƿ��������壬ʳ��ϰ�
	 */
	@Override
	public void snakeMoved(Snake snake) {
		int x,y;
		//System.out.println("�ж��ߵ��ƶ��Ƿ�Ϸ�");
		if(food.isEatenBySnake(snake)){
			snake.eatFood(food);
			//������ʳ��
			//�жϲ�����ʳ���Ƿ���������getPoint()���صĵ��Ѿ������ϰ������ٽ��������ϵ��ж�
			do{
				 x = new Random().nextInt(Global.WIDTH);
				 y = new Random().nextInt(Global.HEIRTH);
			}while(snake.isOnSnake(ground.getPoint()));
			food.addFood(new Point(x,y));
		}
		if(ground.isB(snake)){
			//��ʾ��ĵ���
			JOptionPane.showMessageDialog(null, "GameOver");
			//System.exit(0);
		}
		gamePanel.display(snake, food, ground);
		
	}
	/**
	 * ��ʼ��Ϸ
	 */
	public void startGame() {
		snake.start();
		food.addFood(ground.getPoint());
	}
	/**
	 * ����ʳ���λ��
	 */
//	public Point getPoint(){
//		int x = new Random().nextInt(Global.WIDTH);
//		int y = new Random().nextInt(Global.HEIRTH);
//		return new Point(x,y);
//	}
}
