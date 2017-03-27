package game.sxl.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.PrintWriter;
import java.util.Random;

import game.sxl.util.Global;

/**
 * 障碍物类
 * @author songxilong
 *
 */
public class Ground {
	int[][] gArray = new int[Global.HEIRTH][Global.WIDTH];
	public Ground(){
		for(int x = 0;x<Global.WIDTH;x++){
			gArray[x][0] = 1;
			gArray[0][x] = 1;
			gArray[Global.HEIRTH-1][x] = 1;
			gArray[x][Global.WIDTH-1] = 1;
		}
	}
	/**
	 * 画出自己
	 */
	public void drawMe(Graphics g) {
		g.setColor(Color.black);
		for(int x = 0;x<Global.WIDTH;x++){
			for(int y = 0;y<Global.HEIRTH;y++)
				if(gArray[x][y]==1)
					g.fill3DRect(x * Global.CELL_SIEZ, y * Global.CELL_SIEZ,
							Global.CELL_SIEZ, Global.CELL_SIEZ, true);
		}
	}
		public Point getPoint(){
			int x,y;
			do{
				 x = new Random().nextInt(Global.WIDTH);
				 y = new Random().nextInt(Global.HEIRTH);
				 System.out.println("x:"+x+"----------y:"+y+"----gA:"+gArray[x][y]);
			}while(gArray[x][y]==1);
			return new Point(x,y);
		}
	/**
	 * 碰撞方法实现
	 */
	public boolean isB(Snake snake) {
		Point head = snake.getHead();
		for(int x = 0;x<Global.WIDTH;x++){
			for(int y = 0;y<Global.HEIRTH;y++)
				if(gArray[x][y]==1&&x==head.x&&y==head.y)
					return true;			
		}
		return false;
	}
}
