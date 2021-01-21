package game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serializable;

public class FinishTile extends Tile implements Serializable
{
	private static final long serialVersionUID = 1L;
	public static float finishLength = 0.2f;

	public FinishTile(int x, int y, Puzzle puzzle)
	{
		super(x, y, puzzle);
	}

	@Override
	public void show(Graphics2D g)
	{
		super.show(g);
		g.setColor(puzzle.tc);
		int dx = calcDX();
		int dy = calcDY();
		if (!puzzle.occupied(x + 1, y))
			drawFinish(g, dx, dy, calcDX(x + finishLength), dy);
		else if (!puzzle.occupied(x - 1, y))
			drawFinish(g, dx, dy, calcDX(x - finishLength), dy);
		else if (!puzzle.occupied(x, y + 1))
			drawFinish(g, dx, dy, dx, calcDY(y + finishLength));
		else if (!puzzle.occupied(x, y - 1))
			drawFinish(g, dx, dy, dx, calcDY(y - finishLength));
		else
			System.err.println("finish tile is not placed at a border");
	}

	public void drawFinish(Graphics2D g, int x1, int y1, int x2, int y2)
	{
		drawConnection(g, x1, y1, x2, y2, true);
		g.setColor(Color.WHITE);
		g.fillOval(x2 - puzzle.stroke / 8, y2 - puzzle.stroke / 8, puzzle.stroke / 4, puzzle.stroke / 4);
	}

	@Override
	public int type()
	{
		return puzzle.FINISH;
	}
}
