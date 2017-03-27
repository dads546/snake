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
 * 控制器控制实体类及视图类
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
	 * 判断蛇是否碰到身体，食物，障碍
	 */
	@Override
	public void snakeMoved(Snake snake) {
		int x,y;
		//System.out.println("判断蛇的移动是否合法");
		if(food.isEatenBySnake(snake)){
			snake.eatFood(food);
			//产生新食物
			//判断产生的食物是否在蛇身上getPoint()返回的点已经不再障碍物上再进行蛇身上的判断
			do{
				 x = new Random().nextInt(Global.WIDTH);
				 y = new Random().nextInt(Global.HEIRTH);
			}while(snake.isOnSnake(ground.getPoint()));
			food.addFood(new Point(x,y));
		}
		if(ground.isB(snake)){
			//提示框的弹出
			JOptionPane.showMessageDialog(null, "GameOver");
			//System.exit(0);
		}
		gamePanel.display(snake, food, ground);
		
	}
	/**
	 * 开始游戏
	 */
	public void startGame() {
		snake.start();
		food.addFood(ground.getPoint());
	}
	/**
	 * 设置食物的位置
	 */
//	public Point getPoint(){
//		int x = new Random().nextInt(Global.WIDTH);
//		int y = new Random().nextInt(Global.HEIRTH);
//		return new Point(x,y);
//	}
}
