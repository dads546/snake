package game.sxl.test;

import javax.swing.JFrame;

import game.sxl.controller.Controller;
import game.sxl.entity.Food;
import game.sxl.entity.Ground;
import game.sxl.entity.Snake;
import game.sxl.util.Global;
import game.sxl.view.GamePanel;

public class GameTest {
	public static void main(String[] args) {
		//实体的创建
		Snake snake = new Snake();
		Food food = new Food();
		Ground ground = new Ground();
		
		//视图窗口创建
		GamePanel gamePanel = new GamePanel();
		
		//控制器的创建
		Controller controller = new Controller(snake, food, ground, gamePanel);
		//为snake添加监听控制器
		snake.addSnakeListener(controller);
		//为窗体添加键盘时间监听器
		gamePanel.addKeyListener(controller);
		JFrame gameFrame = new JFrame("SankeGame");
		gameFrame.setSize(Global.WIDTH*Global.CELL_SIEZ+50, Global.HEIRTH*Global.CELL_SIEZ+100);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setLocationRelativeTo(null);
		//让面板获得焦点
		gamePanel.setFocusable(true);
		gameFrame.add(gamePanel);
		
		//启动游戏
		controller.startGame();
		
		//显示
		gameFrame.setVisible(true);
		
	}
}
