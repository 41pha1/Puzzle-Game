package game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;
import java.util.ArrayList;

import inOut.PuzzleLoader;
import input.Mouse;
import main.Frame;

public class Simulation
{
	public Puzzle puzzle;
	public Trace trace;
	public boolean tracing;
	public String[] puzzles = new String[] { "puzzle0", "puzzle1", "puzzle2", "puzzle3", "puzzle4", "puzzle5",
			"puzzle6", "puzzle7", "puzzle8", "puzzle9", "puzzle10", "puzzle11", "puzzle12", "puzzle13", "puzzle14",
			"puzzle15", "puzzle16", "puzzle17", "puzzle18", "puzzle19", "puzzle20", "puzzle21", "puzzle22",
			"puzzle100" };
	public int currentPuzzle = 0;
	public int animLength = 60;
	public int fadeOutAnim;

	public Simulation()
	{
		try
		{
			puzzle = PuzzleLoader.loadPuzzle(puzzles[currentPuzzle++]);
		} catch (ClassNotFoundException | IOException e)
		{
			e.printStackTrace();
		}
	}

	public void show(Graphics2D g)
	{
		puzzle.display(g);
		if (tracing)
			trace.show(g, puzzle, false);
	}

	public void update()
	{
		puzzle.center();
		if (!puzzle.solved && fadeOutAnim == 0)
		{
			if (Mouse.left)
			{
				if (!tracing)
				{
					ArrayList<Tile> startTiles = puzzle.find(puzzle.START);
					for (Tile start : startTiles)
					{
						if (puzzle.overTile(Mouse.x, Mouse.y, start))
							startTracing(start);
					}

					ArrayList<Tile> linkedStartTiles = puzzle.find(puzzle.LINKED_START);
					for (Tile linkedStart : linkedStartTiles)
					{
						if (puzzle.overTile(Mouse.x, Mouse.y, linkedStart))
							startTracing(linkedStart, linkedStart.v(), linkedStart.h());
					}
				} else
				{
					trace.update(puzzle);
				}

			} else
			{
				tracing = false;
			}
		} else
		{
			if (fadeOutAnim > animLength / 2)
			{
				fadeOutAnim--;
				float s = (fadeOutAnim / (float) animLength);
				float zoom = (int) (1 / Math.pow(s, 10));
				float wth = (puzzle.height - 1) / (puzzle.width - 1);
				puzzle.x1 -= zoom;
				puzzle.y1 -= 3 * zoom * wth;
				puzzle.w += 2 * zoom;
				puzzle.h = (int) (puzzle.w * wth);
				puzzle.stroke = (int) (puzzle.stroke + zoom / 10f);
				int red = (int) (trace.strokeColor.getRed() * s + 255 * (1 - s));
				int green = (int) (trace.strokeColor.getGreen() * s + 255 * (1 - s));
				int blue = (int) (trace.strokeColor.getBlue() * s + 255 * (1 - s));
				trace.sc = new Color(red, green, blue);
			} else
			{
				if (fadeOutAnim == animLength / 2)
					loadNextPuzzle();

				float s = 1 - (fadeOutAnim / (float) animLength * 2);
				int dx = (Frame.width / 2) - puzzle.x1;
				int dy = (Frame.height / 2) - puzzle.y1;
				puzzle.x1 = (int) ((Frame.width / 2) - (dx * s));
				puzzle.y1 = (int) ((Frame.height / 2) - (dy * s));
				puzzle.w = (int) (puzzle.w * s);
				puzzle.h = (int) (puzzle.h * s);
				puzzle.stroke = (int) (puzzle.stroke * s);
				fadeOutAnim--;
			}

		}
	}

	public void loadNextPuzzle()
	{
		try
		{
			if (currentPuzzle < puzzles.length)
			{
				puzzle = PuzzleLoader.loadPuzzle(puzzles[currentPuzzle++]);
				puzzle.center();
			} else
			{
				System.out.println("All Done!");
				System.exit(0);
			}
		} catch (ClassNotFoundException | IOException e)
		{
			System.out.println("Couldnt find next puzzle");
		}
		tracing = false;
	}

	public void startTracing(Tile start)
	{
		trace = new Trace(start);
		tracing = true;
	}

	public void startTracing(Tile start, boolean v, boolean h)
	{
		trace = new Trace(start, v, h);
		tracing = true;
	}
}
