package game;

import java.awt.Graphics2D;
import java.io.Serializable;

public class StartTile extends Tile implements Serializable
{
	private static final long serialVersionUID = 1L;
	float size = 1.5f;

	public StartTile(int x, int y, Puzzle puzzle)
	{
		super(x, y, puzzle);
	}

	@Override
	public int type()
	{
		return puzzle.START;
	}

	@Override
	public void show(Graphics2D g)
	{
		super.show(g);
		g.setColor(puzzle.tc);
		int dx = calcDX();
		int dy = calcDY();
		int radius = (int) (puzzle.stroke * size);
		g.fillOval(dx - radius, dy - radius, radius * 2, radius * 2);
	}
}
