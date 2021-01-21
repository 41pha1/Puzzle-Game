package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import input.Mouse;

public class Frame extends JFrame
{
	private static final long serialVersionUID = -1;
	public static BufferedImage screen;
	public static int width, height;

	public Frame(int w, int h)
	{
		screen = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		this.setSize(w, h);
		width = w;
		height = h;
		this.addMouseListener(new Mouse());
		this.addMouseMotionListener(new Mouse());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setUndecorated(true);
		this.setTitle("Puzzle Game");
		this.setVisible(true);
	}

	@Override
	public void paint(Graphics display)
	{
		Graphics2D g = screen.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(new Color(30, 30, 30));
		width = this.getWidth();
		height = this.getHeight();
		g.fillRect(0, 0, width, height);
		Main.sim.update();
		Main.sim.show(g);
		display.drawImage(screen, 0, 0, null);
	}
}
