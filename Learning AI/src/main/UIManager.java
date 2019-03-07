package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import main.ai.Square;
import main.objects.Wall;

public class UIManager {
	
	private JFrame frame;
	private Graphics2D graphics;
	private BufferStrategy buff;
	
	public UIManager(Dimension size) {
		frame = new JFrame();
		frame.setSize(size);
		frame.setLocation(500, 0);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void setupBuff() {
		if(this.buff == null) { this.frame.createBufferStrategy(4); }
		this.buff = this.frame.getBufferStrategy();
		this.graphics = (Graphics2D) this.buff.getDrawGraphics();
	}
	
	public void disposeAndShow() {
		this.graphics.dispose();
		this.buff.show();
	}
	
	
	public void draw() {
		setupBuff();
		//---------------------------------------------------------------
		graphics.setColor(Color.white);
		graphics.fillRect(0, 0, 800, 600);
		graphics.setColor(Color.RED);
		Rectangle2D objective = new Rectangle2D.Double(Main.obj.getX(), Main.obj.getY(), Main.obj.getLength(), Main.obj.getLength());
		graphics.fill(objective);
		
		graphics.setColor(Color.BLUE);
		Wall[] walls = Main.walls;
		for(int i = 0; i < walls.length; i++) {
			if(walls[i] != null) {
				Rectangle2D rect = new Rectangle2D.Double(walls[i].getX(), walls[i].getY(), walls[i].getWidth(), walls[i].getHeight());
				graphics.fill(rect);
			}
		}
		
		Square[] squares = Main.pop.getSquares();
		for(int i = 0; i < squares.length; i++) {
			if(squares[i].isObjectiveComplete()) {
				graphics.setColor(Color.GREEN);
			} else if(squares[i].getHitWall()) {
				graphics.setColor(Color.RED);
			} else {
				graphics.setColor(Color.GRAY);
			}
			Rectangle2D rect = new Rectangle2D.Double(squares[i].getX(), squares[i].getY(), squares[i].getLength(), squares[i].getLength());
			graphics.fill(rect);
		}
		
		
		
		
		graphics.setColor(Color.BLACK);
		graphics.setFont(new Font("Cyrus", 0, 32));
		graphics.drawString("Gen: " + Main.gen + "", 650, 100);
		
		
		
		//--------------------------------------------------------------
		disposeAndShow();
	}
	
}
