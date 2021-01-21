package game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import input.Mouse;
import main.Main;

public class Trace
{
	public ArrayList<Tile> tracedTiles;
	public float strokeFac = 1.5f;
	public int stroke;
	public boolean dir;
	public boolean nextTileValid;
	public boolean solved;
	public boolean linked;
	public boolean v, h;
	public final Color strokeColor = new Color(255, 140, 0);
	public Color sc = strokeColor;

	public Trace(Tile start)
	{
		tracedTiles = new ArrayList<Tile>();
		tracedTiles.add(start);
	}

	public Trace(Tile start, boolean v, boolean h)
	{
		tracedTiles = new ArrayList<Tile>();
		tracedTiles.add(start);
		this.v = v;
		this.h = h;
		linked = true;
	}

	public void show(Graphics2D g, Puzzle puzzle, boolean mirror)
	{
		g.setColor(sc);
		stroke = (int) (puzzle.stroke * strokeFac);
		g.setStroke(new BasicStroke(stroke, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		int dx = tracedTiles.get(0).calcDX();
		int dy = tracedTiles.get(0).calcDY();
		if (h && mirror)
			dx = LinkedStartTile.mirrorX(dx);
		if (v && mirror)
			dy = LinkedStartTile.mirrorY(dy);

		g.fillOval(dx - stroke, dy - stroke, stroke * 2, stroke * 2);

		if (tracedTiles.size() > 1)
		{
			int lx = dx;
			int ly = dy;
			for (int i = 1; i < tracedTiles.size(); i++)
			{
				int tx = tracedTiles.get(i).calcDX();
				int ty = tracedTiles.get(i).calcDY();
				if (h && mirror)
					tx = LinkedStartTile.mirrorX(tx);
				if (v && mirror)
					ty = LinkedStartTile.mirrorY(ty);
				g.drawLine(lx, ly, tx, ty);
				lx = tx;
				ly = ty;
			}
		}

		dx = lastTile().calcDX();
		dy = lastTile().calcDY();
		if (h && mirror)
			dx = LinkedStartTile.mirrorX(dx);
		if (v && mirror)
			dy = LinkedStartTile.mirrorY(dy);

		if (solved)
			showSolved(g, puzzle);

		if (nextTileValid)
		{
			int mx = Mouse.x;
			int my = Mouse.y;
			if (h && mirror)
				mx = LinkedStartTile.mirrorX(mx);
			if (v && mirror)
				my = LinkedStartTile.mirrorY(my);
			if (dir)
				g.drawLine(dx, dy, mx, dy);
			else
				g.drawLine(dx, dy, dx, my);
		}
		if (linked && !mirror)
			show(g, puzzle, true);
	}

	public void showSolved(Graphics2D g, Puzzle puzzle)
	{
		float finishLength = FinishTile.finishLength;
		Tile finish = lastTile();
		int dx = finish.calcDX();
		int dy = finish.calcDY();
		int x = finish.x;
		int y = finish.y;
		if (!puzzle.occupied(x + 1, y))
			g.drawLine(dx, dy, finish.calcDX(x + finishLength), dy);
		else if (!puzzle.occupied(x - 1, y))
			g.drawLine(dx, dy, finish.calcDX(x - finishLength), dy);
		else if (!puzzle.occupied(x, y + 1))
			g.drawLine(dx, dy, dx, finish.calcDY(y + finishLength));
		else if (!puzzle.occupied(x, y - 1))
			g.drawLine(dx, dy, dx, finish.calcDY(y - finishLength));
	}

	public Tile lastTile()
	{
		return tracedTiles.get(tracedTiles.size() - 1);
	}

	public void addTile(Puzzle puzzle, int x, int y)
	{
		if (!puzzle.inBounds(x, y))
			return;
		if (!puzzle.tiles[x][y].occupied())
			return;
		Tile toAdd = puzzle.tiles[x][y];
		if (tracedTiles.contains(toAdd))
			return;
		tracedTiles.add(puzzle.tiles[x][y]);
	}

	public boolean traceable(Puzzle puzzle, int x, int y)
	{
		return puzzle.occupied(x, y) && !tracedTiles.contains(puzzle.tiles[x][y]);
	}

	public boolean connecting(int x1, int y1, int x2, int y2)
	{
		for (int i = 1; i < tracedTiles.size(); i++)
		{
			Tile t1 = tracedTiles.get(i - 1);
			Tile t2 = tracedTiles.get(i);
			if (t1.x == x1 && t1.y == y1 && t2.x == x2 && t2.y == y2)
				return true;
			if (t1.x == x2 && t1.y == y2 && t2.x == x1 && t2.y == y1)
				return true;

		}
		return false;
	}

	public boolean connecting(Tile t1, Tile t2)
	{
		return connecting(t1.x, t1.y, t2.x, t2.y);
	}

	public boolean solved(Puzzle puzzle)
	{
		for (int x = 0; x < puzzle.width; x++)
		{
			for (int y = 0; y < puzzle.height; y++)
			{
				if (puzzle.tiles[x][y].downEss && !connecting(x, y, x, y + 1))
					return false;
				if (puzzle.tiles[x][y].rightEss && !connecting(x, y, x + 1, y))
					return false;
				if (puzzle.tiles[x][y].special == 0)
				{
					if (puzzle.occupied(x + 1, y) && puzzle.tiles[x + 1][y].special == 1)
					{
						if (!connecting(x + 1, y, x + 1, y + 1))
							return false;
					}
					if (puzzle.occupied(x - 1, y) && puzzle.tiles[x - 1][y].special == 1)
					{
						if (!connecting(x, y, x, y + 1))
							return false;
					}
					if (puzzle.occupied(x, y + 1) && puzzle.tiles[x][y + 1].special == 1)
					{
						if (!connecting(x, y + 1, x + 1, y + 1))
							return false;
					}
					if (puzzle.occupied(x, y - 1) && puzzle.tiles[x][y - 1].special == 1)
					{
						if (!connecting(x, y, x + 1, y))
							return false;
					}
				}
			}
		}
		for (Tile t : puzzle.essentialTiles)
		{
			if (t.occupied() && !tracedTiles.contains(t))
				return false;
		}
		if (lastTile().type() == puzzle.FINISH)
			return true;
		return false;
	}

	public boolean isNextTileValid(Puzzle puzzle, Tile lastTile, boolean dir)
	{
		boolean ntv = false;
		int mx = Mouse.x;
		int my = Mouse.y;
		int x = lastTile.x;
		int y = lastTile.y;
		if (dir)
		{
			if (mx > lastTile.calcDX() && lastTile.conRight)
				ntv = traceable(puzzle, x + 1, y);
			if (mx < lastTile.calcDX() && x > 0 && puzzle.tiles[x - 1][y].conRight)
				ntv = traceable(puzzle, x - 1, y);
		} else
		{
			if (my > lastTile.calcDY() && lastTile.conDown)
				ntv = traceable(puzzle, x, y + 1);
			if (my < lastTile.calcDY() && y > 0 && puzzle.tiles[x][y - 1].conDown)
				ntv = traceable(puzzle, x, y - 1);
		}
		return ntv;
	}

	public boolean canGoLeft(Puzzle puzzle, Tile lastTile)
	{
		if (puzzle.occupied(lastTile.x - 1, lastTile.y))
		{
			Tile nextTile = puzzle.tiles[lastTile.x - 1][lastTile.y];
			if (!tracedTiles.contains(nextTile))
				return true;
			if (connecting(lastTile, nextTile))
				return true;
		}
		return false;
	}

	public boolean canGoRight(Puzzle puzzle, Tile lastTile)
	{
		if (puzzle.occupied(lastTile.x + 1, lastTile.y))
		{
			Tile nextTile = puzzle.tiles[lastTile.x + 1][lastTile.y];
			if (!tracedTiles.contains(nextTile))
				return true;
			if (connecting(lastTile, nextTile))
				return true;
		}
		return false;
	}

	public boolean canGoUp(Puzzle puzzle, Tile lastTile)
	{
		if (puzzle.occupied(lastTile.x, lastTile.y - 1))
		{
			Tile nextTile = puzzle.tiles[lastTile.x][lastTile.y - 1];
			if (!tracedTiles.contains(nextTile))
				return true;
			if (connecting(lastTile, nextTile))
				return true;
		}
		return false;
	}

	public boolean canGoDown(Puzzle puzzle, Tile lastTile)
	{
		if (puzzle.occupied(lastTile.x, lastTile.y + 1))
		{
			Tile nextTile = puzzle.tiles[lastTile.x][lastTile.y + 1];
			if (!tracedTiles.contains(nextTile))
				return true;
			if (connecting(lastTile, nextTile))
				return true;
		}
		return false;
	}

	public boolean canGoHorizontal(Puzzle puzzle, Tile lastTile)
	{
		return canGoDown(puzzle, lastTile) || canGoUp(puzzle, lastTile);
	}

	public boolean canGoVertical(Puzzle puzzle, Tile lastTile)
	{
		return canGoRight(puzzle, lastTile) || canGoLeft(puzzle, lastTile);
	}

	public int distance(int x1, int x2)
	{
		return Math.abs(x1 - x2);
	}

	public void update(Puzzle puzzle)
	{
		int mx = Mouse.x;
		int my = Mouse.y;
		Tile lastTile = lastTile();
		int xt = puzzle.calcScale() / 3;
		int yt = puzzle.calcScale() / 3;
		int dx = mx - lastTile().calcDX();
		int dy = my - lastTile().calcDY();

		switch ((Math.abs(dx) > Math.abs(dy)) ? (dx > 0 ? 0 : 1) : (dy > 0 ? 2 : 3))
		{
		case 0:
			if (canGoRight(puzzle, lastTile))
				dir = true;
			break;
		case 1:
			if (canGoLeft(puzzle, lastTile))
				dir = true;
			break;
		case 2:
			if (canGoDown(puzzle, lastTile))
				dir = false;
			break;
		case 3:
			if (canGoUp(puzzle, lastTile))
				dir = false;
			break;
		}

		Tile tblt = null;
		if (tracedTiles.size() > 1)
		{
			tblt = tracedTiles.get(tracedTiles.size() - 2);
		}

		int x = lastTile.x;
		int y = lastTile.y;
		if (dir)
		{
			if (tracedTiles.size() > 1 && distance(mx, lastTile.calcDX()) > xt
					&& ((mx > lastTile.calcDX() && mx < tblt.calcDX())
							|| (mx < lastTile.calcDX() && mx > tblt.calcDX())))
				tracedTiles.remove(lastTile);
			if (distance(mx, lastTile.calcDX(x + 1)) < xt && lastTile.conRight)
				addTile(puzzle, x + 1, y);
			if (distance(mx, lastTile.calcDX(x - 1)) < xt && x > 0 && puzzle.occupied(x - 1, y)
					&& puzzle.tiles[x - 1][y].conRight)
				addTile(puzzle, x - 1, y);
		} else
		{
			if (tracedTiles.size() > 1 && distance(my, lastTile.calcDY()) > yt
					&& ((my > lastTile.calcDY() && my < tblt.calcDY())
							|| (my < lastTile.calcDY() && my > tblt.calcDY())))
				tracedTiles.remove(lastTile);
			if (distance(my, lastTile.calcDY(y + 1)) < yt && lastTile.conDown)
				addTile(puzzle, x, y + 1);
			if (distance(my, lastTile.calcDY(y - 1)) < yt && puzzle.occupied(x, y - 1)
					&& puzzle.tiles[x][y - 1].conDown)
				addTile(puzzle, x, y - 1);
		}
		nextTileValid = isNextTileValid(puzzle, lastTile, dir);
		puzzle.solved = solved(puzzle);
		solved = puzzle.solved;
		if (solved)
			Main.sim.fadeOutAnim = Main.sim.animLength;
	}
}
