package puzzleEditor;

import game.EmptyTile;
import game.FinishTile;
import game.LinkedStartTile;
import game.Puzzle;
import game.StartTile;

public class PuzzleEditor
{
	public Puzzle editing;

	public PuzzleEditor(Puzzle puzzle)
	{
		editing = puzzle;
	}

	public void setStart(int x, int y)
	{
		editing.tiles[x][y] = new StartTile(x, y, editing);
	}

	public void setLinkedStart(int x, int y, boolean h, boolean v)
	{
		LinkedStartTile lst = new LinkedStartTile(x, y, editing);
		lst.v = v;
		lst.h = h;
		editing.tiles[x][y] = lst;
	}

	public void setFinish(int x, int y)
	{
		editing.tiles[x][y] = new FinishTile(x, y, editing);
	}

	public void setEssential(int x, int y)
	{
		editing.tiles[x][y].essential = true;
		editing.essentialTiles.add(editing.tiles[x][y]);
	}

	public void setEmpty(int x, int y)
	{
		editing.tiles[x][y] = new EmptyTile(x, y, editing);
	}

	public void disconnectRight(int x, int y, boolean fully)
	{
		editing.tiles[x][y].conRight = false;
		editing.tiles[x][y].discFul = fully;
	}

	public void disconnectDown(int x, int y, boolean fully)
	{
		editing.tiles[x][y].conDown = false;
		editing.tiles[x][y].discFul = fully;
	}

	public void setSpecial(int x, int y, int id)
	{
		editing.tiles[x][y].special = id;
	}

	public void setEssentialConnection(int x, int y, boolean dir)
	{
		if (dir)
			editing.tiles[x][y].rightEss = true;
		else
			editing.tiles[x][y].downEss = true;
	}
}
