package game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serializable;

public class Tile implements Serializable
{
	private static final long serialVersionUID = 1L;
	public Puzzle puzzle;
	public int x, y;
	public boolean essential;
	public boolean conRight;
	public boolean conDown;
	public boolean discFul;
	public boolean downEss;
	public boolean rightEss;
	public int special = -1;

	public Tile(int x, int y, Puzzle puzzle)
	{
		this.x = x;
		this.y = y;
		this.puzzle = puzzle;
		conRight = true;
		conDown = true;
	}

	public void show(Graphics2D g)
	{
		if (occupied())
		{
			int dx = calcDX();
			int dy = calcDY();

			if (x < puzzle.width - 1 && y < puzzle.height - 1)
				switch (special)
				{
				case 0:
					int sx = calcDX(x + 1) - dx;
					int sy = calcDY(y + 1) - dy;
					int s = Math.min(sx, sy);
					g.setColor(Color.WHITE);
					g.fillOval(dx + s / 4, dy + s / 4, s / 2, s / 2);
					break;
				case 1:
					sx = calcDX(x + 1) - dx;
					sy = calcDY(y + 1) - dy;
					s = Math.min(sx, sy);
					g.setColor(Color.BLACK);
					g.fillOval(dx + s / 4, dy + s / 4, s / 2, s / 2);
					break;
				}

			g.setColor(puzzle.tc);
			if (puzzle.occupied(x + 1, y))
			{
				if (conRight)
				{
					drawConnection(g, dx, dy, calcDX(x + 1), dy, true);
					if (rightEss)
					{
						g.setColor(Color.BLACK);
						g.fillOval(calcDX(x + 0.5f) - (puzzle.stroke / 4), dy - (puzzle.stroke / 4), puzzle.stroke / 2,
								puzzle.stroke / 2);
					}
				} else if (!discFul)
				{
					drawConnection(g, dx, dy, calcDX(x + 0.3f), dy, false);
					drawConnection(g, calcDX(x + 0.6f), dy, calcDX(x + 1), dy, false);
				}
			}
			g.setColor(puzzle.tc);
			if (puzzle.occupied(x, y + 1))
			{
				if (conDown)
				{
					drawConnection(g, dx, dy, dx, calcDY(y + 1), true);
					if (downEss)
					{
						g.setColor(Color.BLACK);
						g.fillOval(dx - (puzzle.stroke / 4), calcDY(y + 0.5f) - (puzzle.stroke / 4), puzzle.stroke / 2,
								puzzle.stroke / 2);
					}
				} else if (!discFul)
				{
					drawConnection(g, dx, dy, dx, calcDY(y + 0.3f), false);
					drawConnection(g, dx, calcDY(y + 0.6f), dx, calcDY(y + 1), false);
				}
			}

			if (essential)
			{
				g.setColor(Color.BLACK);
				g.fillOval(dx - (puzzle.stroke / 4), dy - (puzzle.stroke / 4), puzzle.stroke / 2, puzzle.stroke / 2);
			}
		}
	}

	public int calcDY()
	{
		return calcDY(y);
	}

	public int calcDX()
	{
		return calcDX(x);
	}

	public boolean v()
	{
		return false;
	}

	public boolean h()
	{
		return false;
	}

	public int calcDX(float x)
	{
		float px = x / (puzzle.width - 1);
		int dx = (int) (puzzle.x1 + puzzle.w * px);
		return dx;
	}

	public int calcDY(float y)
	{
		float py = y / (puzzle.height - 1);
		int dy = (int) (puzzle.y1 + puzzle.h * py);
		return dy;
	}

	public void drawConnection(Graphics2D g, int x1, int y1, int x2, int y2, boolean round)
	{
		if (round)
			g.setStroke(new BasicStroke(puzzle.stroke, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		else
			g.setStroke(new BasicStroke(puzzle.stroke));
		g.drawLine(x1, y1, x2, y2);
	}

	public int type()
	{
		return puzzle.TILE;
	}

	public boolean occupied()
	{
		return true;
	}

	public boolean isValid()
	{
		return true;
	}
}
