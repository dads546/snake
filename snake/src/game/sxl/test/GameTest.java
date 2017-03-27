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
		//ʵ��Ĵ���
		Snake snake = new Snake();
		Food food = new Food();
		Ground ground = new Ground();
		
		//��ͼ���ڴ���
		GamePanel gamePanel = new GamePanel();
		
		//�������Ĵ���
		Controller controller = new Controller(snake, food, ground, gamePanel);
		//Ϊsnake��Ӽ���������
		snake.addSnakeListener(controller);
		//Ϊ������Ӽ���ʱ�������
		gamePanel.addKeyListener(controller);
		JFrame gameFrame = new JFrame("SankeGame");
		gameFrame.setSize(Global.WIDTH*Global.CELL_SIEZ+50, Global.HEIRTH*Global.CELL_SIEZ+100);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setLocationRelativeTo(null);
		//������ý���
		gamePanel.setFocusable(true);
		gameFrame.add(gamePanel);
		
		//������Ϸ
		controller.startGame();
		
		//��ʾ
		gameFrame.setVisible(true);
		
	}
}
