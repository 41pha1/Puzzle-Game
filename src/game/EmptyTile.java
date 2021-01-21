package game;

import java.io.Serializable;

public class EmptyTile extends Tile implements Serializable
{
	private static final long serialVersionUID = 1L;

	public EmptyTile(int x, int y, Puzzle puzzle)
	{
		super(x, y, puzzle);
	}

	@Override
	public boolean occupied()
	{
		return false;
	}

	@Override
	public int type()
	{
		return puzzle.EMPTY;
	}
}
