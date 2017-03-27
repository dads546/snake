package game.sxl.view;

import game.sxl.entity.Food;
import game.sxl.entity.Ground;
import game.sxl.entity.Snake;

import java.awt.Graphics;

import javax.swing.JPanel;
/**
 * 操作界面
 * @author songxilong
 *
 */
public class GamePanel extends JPanel {
	private Snake snake;
	private Food food;
	private Ground ground;
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		//System.out.println("repainting");
		// TODO Auto-generated method stub
		if(snake!= null&&food!= null&&ground!= null){
			snake.drawMe(g);
			food.drawMe(g);
			ground.drawMe(g);
		}
	}
	public void display(Snake snake,Food food,Ground ground) {
		//System.out.println("面板正在显示。。。。。");
		this.snake = snake;
		this.food = food;
		this.ground = ground;
		repaint();
	}

}
