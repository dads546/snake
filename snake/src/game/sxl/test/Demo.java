package game.sxl.test;

import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

import game.sxl.view.GamePanel;

	public class Demo extends JPanel {

	 

	    public static void main(String[] args){
	    	Random random=new Random();
			int x =random.nextInt(20);
			System.out.println(x);
	    }

	}

