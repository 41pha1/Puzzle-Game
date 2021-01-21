package game;

import java.io.Serializable;

public class InvalidTile extends Tile implements Serializable
{
	private static final long serialVersionUID = 1L;

	public InvalidTile()
	{
		super(0, 0, null);
	}

	@Override
	public boolean isValid()
	{
		return false;
	}
}
