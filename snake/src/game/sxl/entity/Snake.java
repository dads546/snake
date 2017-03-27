package game.sxl.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.LinkedList;

import game.sxl.listener.SnakeListener;
import game.sxl.util.Global;

import javax.naming.InitialContext;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

/**
 * ����
 * 
 * @author songxilong
 * 
 */
public class Snake {
	private SnakeListener snakeListener;
	private LinkedList<Point> body = new LinkedList<Point>();
	public static final int UP = 1;
	public static final int DOWN = -1;
	public static final int LEFT = 2;
	public static final int RIGHT = -2;
	//private int dire;
	private int oldDirectiion,newDirection;
	private Point tail;//���β��
	public Snake() {
		init();
		this.oldDirectiion= this.newDirection= RIGHT;
	}

	private void init() {
		int x = Global.WIDTH / 2;
		int y = Global.HEIRTH / 2;
		for (int i = 0; i < 3; i++) {
			body.add(new Point(x - i, y));
		}
	}
	public Point getHead(){
		return body.getFirst();
	}

	/**
	 * �ƶ�����
	 */
	public void move() {
		//ȥβ��
		tail = body.removeLast();
		//���Դ�����
		Point p = body.getFirst();
		//��ô�ʱͷ���Ķ���x,y
		int x = body.getFirst().x;
		int y = body.getFirst().y;
		/**
		 * �����ͷ��
		 * Ҫȷ������
		 * �ڳ�ʼ��ʱָ������(��������)
		 * �����ڴ˶�������з���
		 * 
		 */
		if(this.oldDirectiion +this.newDirection != 0)
			this.oldDirectiion = this.newDirection;
		switch (oldDirectiion) {
		case UP:
			y--;
			if(y<0) y = Global.HEIRTH-1;
			break;
		case DOWN:
			y++;
			if(y == Global.HEIRTH) y = 0;
			break;
		case LEFT:
			x--;
			if(x<0) x = Global.WIDTH-1;
			break;
		case RIGHT:
			x++;
			if(x == Global.WIDTH) x = 0;
			break;
		default:
			break;
		}
		body.addFirst(new Point(x,y));
		//System.out.println(x+"--------------"+y);
	}

	/**
	 * @param food
	 *            ʳ���� ��ʳ��
	 */
	public void eatFood(Food food) {
		body.addLast(tail);
		System.out.println("snake is eatting");
	}

	/**
	 * �ı䷽��
	 */
	public void changeDirection(int direction) {
		this.newDirection = direction;
		System.out.println("snake is changing direc");
	}

	/**
	 * �����Լ�
	 */
	public void drawMe(Graphics g) {
		g.setColor(Color.BLUE);
		for (Point p : body) {
			g.fill3DRect(p.x * Global.CELL_SIEZ, p.y * Global.CELL_SIEZ,
					Global.CELL_SIEZ, Global.CELL_SIEZ, true);
		}
	}
    public boolean isOnSnake(Point point){
    	for(Point p:body){
    		if(p.equals(point))
    			return true;
    	}
    	return false;
    }
	public void addSnakeListener(SnakeListener snakeListener) {
		this.snakeListener = snakeListener;
	}

	public void start() {
		new SnakeDriver().start();
	}

	private class SnakeDriver extends Thread {
		@Override
		public void run() {
			while (true) {
				move();
				snakeListener.snakeMoved(Snake.this);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
