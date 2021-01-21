package main;

import java.io.FileNotFoundException;
import java.io.IOException;

import game.Simulation;
import inOut.PuzzleCreator;

public class Main
{
	public static int FPS = 60;
	public static Frame f;
	public static Simulation sim;

	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		PuzzleCreator.generate();
		int mpf = 1000 / FPS;
		sim = new Simulation();
		f = new Frame(1920, 1080);

		long lf = System.currentTimeMillis();

		while (true)
		{
			if (System.currentTimeMillis() - lf > mpf)
			{
				lf = System.currentTimeMillis();
				f.repaint();
			}
		}
	}
}
