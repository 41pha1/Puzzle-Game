package game;

import java.awt.Graphics2D;
import java.io.Serializable;

import main.Frame;

public class LinkedStartTile extends StartTile implements Serializable
{
	private static final long serialVersionUID = 1L;
	public boolean h, v;

	public LinkedStartTile(int x, int y, Puzzle puzzle)
	{
		super(x, y, puzzle);
	}

	@Override
	public void show(Graphics2D g)
	{
		super.show(g);
		g.setColor(puzzle.tc);
		int dx = h ? mirrorX(calcDX()) : calcDX();
		int dy = v ? mirrorY(calcDY()) : calcDY();
		int radius = (int) (puzzle.stroke * size);
		g.fillOval(dx - radius, dy - radius, radius * 2, radius * 2);
	}

	public static int mirrorX(int x)
	{
		return Frame.width - x;
	}

	public static int mirrorY(int y)
	{
		return Frame.height - y;
	}

	@Override
	public boolean v()
	{
		return v;
	}

	@Override
	public boolean h()
	{
		return h;
	}

	@Override
	public int type()
	{
		return puzzle.LINKED_START;
	}
}
