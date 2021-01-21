package game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serializable;
import java.util.ArrayList;

import main.Frame;

public class Puzzle implements Serializable
{
	private static final long serialVersionUID = 1L;
	public Tile[][] tiles;
	public int width, height;
	public int stroke;
	public int x1, y1, w, h;
	public int tileSens = 30;
	public boolean solved;
	public final Color backgroundColor = new Color(30, 30, 30);
	public final Color tileColor = new Color(80, 80, 80);
	public Color bgc = backgroundColor;
	public Color tc = tileColor;
	public ArrayList<Tile> essentialTiles;
	public int TILE = 0, EMPTY = -1, START = 1, FINISH = 2, LINKED_START = 3;

	public Puzzle(int w, int h)
	{
		essentialTiles = new ArrayList<Tile>();
		tiles = new Tile[w][h];
		this.width = w;
		this.height = h;
		for (int x = 0; x < width; x++)
		{
			for (int y = 0; y < height; y++)
			{
				tiles[x][y] = new Tile(x, y, this);
			}
		}
	}

	public boolean occupied(int x, int y)
	{
		if (!inBounds(x, y))
			return false;
		return tiles[x][y].occupied();
	}

	public boolean inBounds(int x, int y)
	{
		return !(x < 0 || x >= width || y < 0 || y >= height);
	}

	public ArrayList<Tile> find(int type)
	{
		ArrayList<Tile> foundTiles = new ArrayList<Tile>();
		for (int x = 0; x < width; x++)
		{
			for (int y = 0; y < height; y++)
			{
				if (tiles[x][y].type() == type)
					foundTiles.add(tiles[x][y]);
			}
		}
		return foundTiles;
	}

	public boolean overTile(int x, int y, Tile t)
	{
		if (!t.isValid())
			return false;

		int sx = t.calcDX();
		int sy = t.calcDY();
		float d = (float) Math.sqrt(Math.pow(sx - x, 2) + Math.pow(sy - y, 2));
		return d < tileSens;
	}

	public int calcScale()
	{
		float xr = Frame.width / (float) width;
		float yr = Frame.height / (float) height;
		return (int) (Math.min(xr, yr) * 0.8f);
	}

	public void center()
	{
		int mw = Frame.width / 2;
		int mh = Frame.height / 2;
		int s = calcScale();
		stroke = s / 8;
		w = (width - 1) * s;
		h = (height - 1) * s;
		x1 = mw - w / 2;
		y1 = mh - h / 2;
	}

	public void display(Graphics2D g)
	{
		g.setColor(bgc);
		g.fillRect(x1, y1, w, h);
		for (int x = 0; x < width; x++)
		{
			for (int y = 0; y < height; y++)
			{
				tiles[x][y].show(g);
			}
		}
	}
}
