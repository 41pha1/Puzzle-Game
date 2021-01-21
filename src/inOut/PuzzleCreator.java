package inOut;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import game.Puzzle;
import puzzleEditor.PuzzleEditor;

public class PuzzleCreator
{
	public static void generate() throws FileNotFoundException, IOException
	{
		savePuzzle(puzzle0(), "puzzle0");
		savePuzzle(puzzle1(), "puzzle1");
		savePuzzle(puzzle2(), "puzzle2");
		savePuzzle(puzzle3(), "puzzle3");
		savePuzzle(puzzle4(), "puzzle4");
		savePuzzle(puzzle5(), "puzzle5");
		savePuzzle(puzzle6(), "puzzle6");
		savePuzzle(puzzle7(), "puzzle7");
		savePuzzle(puzzle8(), "puzzle8");
		savePuzzle(puzzle9(), "puzzle9");
		savePuzzle(puzzle10(), "puzzle10");
		savePuzzle(puzzle11(), "puzzle11");
		savePuzzle(puzzle12(), "puzzle12");
		savePuzzle(puzzle13(), "puzzle13");
		savePuzzle(puzzle14(), "puzzle14");
		savePuzzle(puzzle15(), "puzzle15");
		savePuzzle(puzzle16(), "puzzle16");
		savePuzzle(puzzle17(), "puzzle17");
		savePuzzle(puzzle18(), "puzzle18");
		savePuzzle(puzzle19(), "puzzle19");
		savePuzzle(puzzle20(), "puzzle20");
		savePuzzle(puzzle21(), "puzzle21");
		savePuzzle(puzzle22(), "puzzle22");
		savePuzzle(puzzle99(), "puzzle99");
		savePuzzle(puzzle100(), "puzzle100");
	}

	public static Puzzle puzzle0()
	{
		Puzzle puzzle = new Puzzle(3, 3);
		PuzzleEditor editor = new PuzzleEditor(puzzle);
		editor.setStart(0, 1);
		editor.setEmpty(0, 0);
		editor.setEmpty(1, 0);
		editor.setEmpty(2, 0);
		editor.setEmpty(0, 2);
		editor.setEmpty(1, 2);
		editor.setEmpty(2, 2);
		editor.setFinish(2, 1);
		return puzzle;
	}

	public static Puzzle puzzle1()
	{
		Puzzle puzzle = new Puzzle(3, 3);
		PuzzleEditor editor = new PuzzleEditor(puzzle);
		editor.setStart(0, 0);
		editor.setEmpty(1, 0);
		editor.setEmpty(2, 0);
		editor.setEmpty(1, 1);
		editor.setEmpty(2, 1);
		editor.setFinish(2, 2);
		return puzzle;
	}

	public static Puzzle puzzle2()
	{
		Puzzle puzzle = new Puzzle(5, 5);
		PuzzleEditor editor = new PuzzleEditor(puzzle);
		editor.setStart(0, 4);
		editor.setFinish(4, 0);
		editor.disconnectDown(1, 0, true);
		editor.disconnectDown(2, 0, true);
		editor.disconnectDown(3, 0, true);
		editor.disconnectDown(4, 0, true);
		editor.disconnectDown(4, 0, true);
		editor.disconnectDown(0, 1, true);
		editor.disconnectDown(1, 2, true);
		editor.disconnectDown(3, 2, true);
		editor.disconnectDown(0, 3, true);
		editor.disconnectDown(4, 3, true);
		editor.disconnectRight(1, 1, true);
		editor.disconnectRight(3, 1, true);
		editor.disconnectRight(3, 2, true);
		editor.disconnectRight(0, 3, true);
		editor.disconnectRight(1, 4, true);
		return puzzle;
	}

	public static Puzzle puzzle3()
	{
		Puzzle puzzle = new Puzzle(7, 7);
		PuzzleEditor editor = new PuzzleEditor(puzzle);
		editor.setStart(4, 4);
		editor.setFinish(2, 0);
		editor.disconnectDown(1, 0, true);
		editor.disconnectDown(2, 1, true);
		editor.disconnectDown(3, 1, true);
		editor.disconnectDown(4, 1, true);
		editor.disconnectDown(5, 1, true);
		editor.disconnectDown(3, 2, true);
		editor.disconnectDown(5, 2, true);
		editor.disconnectDown(0, 3, true);
		editor.disconnectDown(3, 3, true);
		editor.disconnectDown(4, 3, true);
		editor.disconnectDown(0, 4, true);
		editor.disconnectDown(2, 4, true);
		editor.disconnectDown(6, 4, true);
		editor.disconnectDown(1, 5, true);
		editor.disconnectDown(3, 5, true);
		editor.disconnectDown(4, 5, true);
		editor.disconnectDown(5, 5, true);
		editor.disconnectRight(2, 0, true);
		editor.disconnectRight(4, 0, true);
		editor.disconnectRight(0, 1, true);
		editor.disconnectRight(1, 1, true);
		editor.disconnectRight(3, 1, true);
		editor.disconnectRight(5, 1, true);
		editor.disconnectRight(0, 2, true);
		editor.disconnectRight(2, 2, true);
		editor.disconnectRight(0, 3, true);
		editor.disconnectRight(1, 3, true);
		editor.disconnectRight(3, 3, true);
		editor.disconnectRight(5, 3, true);
		editor.disconnectRight(1, 4, true);
		editor.disconnectRight(5, 4, true);
		editor.disconnectRight(0, 5, true);
		editor.disconnectRight(1, 5, true);
		editor.disconnectRight(2, 5, true);
		editor.disconnectRight(4, 5, true);
		return puzzle;
	}

	public static Puzzle puzzle4()
	{
		Puzzle puzzle = new Puzzle(7, 7);
		PuzzleEditor editor = new PuzzleEditor(puzzle);
		editor.setStart(0, 6);
		editor.setStart(6, 6);
		editor.setFinish(3, 0);
		editor.disconnectDown(4, 0, false);
		editor.disconnectDown(5, 0, false);
		editor.disconnectDown(2, 1, false);
		editor.disconnectDown(3, 1, false);
		editor.disconnectDown(6, 1, false);
		editor.disconnectDown(1, 2, false);
		editor.disconnectDown(4, 2, false);
		editor.disconnectDown(5, 2, false);
		editor.disconnectDown(2, 3, false);
		editor.disconnectDown(3, 3, false);
		editor.disconnectDown(6, 3, false);
		editor.disconnectDown(1, 4, false);
		editor.disconnectDown(4, 4, false);
		editor.disconnectDown(5, 4, false);
		editor.disconnectRight(0, 0, false);
		editor.disconnectRight(2, 0, false);
		editor.disconnectRight(3, 0, false);
		editor.disconnectRight(0, 1, false);
		editor.disconnectRight(3, 1, false);
		editor.disconnectRight(0, 2, false);
		editor.disconnectRight(2, 2, false);
		editor.disconnectRight(4, 2, false);
		editor.disconnectRight(1, 3, false);
		editor.disconnectRight(3, 3, false);
		editor.disconnectRight(3, 4, false);
		editor.disconnectRight(4, 4, false);
		editor.disconnectRight(1, 5, false);
		editor.disconnectRight(4, 5, false);
		editor.disconnectRight(2, 6, false);
		editor.disconnectRight(4, 6, false);
		return puzzle;
	}

	public static Puzzle puzzle5()
	{
		Puzzle puzzle = new Puzzle(7, 7);
		PuzzleEditor editor = new PuzzleEditor(puzzle);
		editor.setStart(0, 6);
		editor.setFinish(6, 6);
		editor.disconnectDown(3, 0, false);
		editor.disconnectDown(5, 0, false);
		editor.disconnectDown(2, 1, false);
		editor.disconnectDown(6, 1, false);
		editor.disconnectDown(0, 2, false);
		editor.disconnectDown(4, 2, false);
		editor.disconnectDown(5, 2, false);
		editor.disconnectDown(2, 3, false);
		editor.disconnectDown(3, 3, false);
		editor.disconnectDown(6, 3, false);
		editor.disconnectDown(1, 4, false);
		editor.disconnectDown(4, 4, false);
		editor.disconnectDown(5, 4, false);
		editor.disconnectRight(3, 0, false);
		editor.disconnectRight(1, 1, false);
		editor.disconnectRight(2, 1, false);
		editor.disconnectRight(4, 1, false);
		editor.disconnectRight(2, 2, false);
		editor.disconnectRight(4, 2, false);
		editor.disconnectRight(1, 3, false);
		editor.disconnectRight(3, 3, false);
		editor.disconnectRight(3, 4, false);
		editor.disconnectRight(4, 4, false);
		editor.disconnectRight(1, 5, false);
		editor.disconnectRight(4, 5, false);
		editor.disconnectRight(2, 6, false);
		editor.disconnectRight(4, 6, false);
		return puzzle;
	}

	public static Puzzle puzzle6()
	{
		Puzzle puzzle = new Puzzle(11, 11);
		PuzzleEditor editor = new PuzzleEditor(puzzle);
		editor.setStart(0, 10);
		editor.setFinish(10, 0);
		editor.disconnectDown(2, 0, true);
		editor.disconnectDown(7, 0, true);
		editor.disconnectDown(8, 0, true);
		editor.disconnectDown(1, 1, true);
		editor.disconnectDown(2, 1, true);
		editor.disconnectDown(5, 1, true);
		editor.disconnectDown(6, 1, true);
		editor.disconnectDown(9, 1, true);
		editor.disconnectDown(0, 2, true);
		editor.disconnectDown(1, 2, true);
		editor.disconnectDown(3, 2, true);
		editor.disconnectDown(4, 2, true);
		editor.disconnectDown(7, 2, true);
		editor.disconnectDown(8, 2, true);
		editor.disconnectDown(9, 2, true);
		editor.disconnectDown(1, 3, true);
		editor.disconnectDown(3, 3, true);
		editor.disconnectDown(4, 3, true);
		editor.disconnectDown(7, 3, true);
		editor.disconnectDown(9, 3, true);
		editor.disconnectDown(0, 4, true);
		editor.disconnectDown(1, 4, true);
		editor.disconnectDown(4, 4, true);
		editor.disconnectDown(5, 4, true);
		editor.disconnectDown(7, 4, true);
		editor.disconnectDown(8, 4, true);
		editor.disconnectDown(2, 5, true);
		editor.disconnectDown(5, 5, true);
		editor.disconnectDown(10, 5, true);
		editor.disconnectDown(4, 6, true);
		editor.disconnectDown(7, 6, true);
		editor.disconnectDown(9, 6, true);
		editor.disconnectDown(2, 7, true);
		editor.disconnectDown(3, 7, true);
		editor.disconnectDown(5, 7, true);
		editor.disconnectDown(10, 7, true);
		editor.disconnectDown(0, 8, true);
		editor.disconnectDown(4, 8, true);
		editor.disconnectDown(8, 8, true);
		editor.disconnectDown(9, 8, true);
		editor.disconnectDown(1, 9, true);
		editor.disconnectDown(6, 9, true);
		editor.disconnectDown(7, 9, true);
		editor.disconnectDown(9, 9, true);
		editor.disconnectRight(1, 0, true);
		editor.disconnectRight(3, 0, true);
		editor.disconnectRight(6, 0, true);
		editor.disconnectRight(0, 1, true);
		editor.disconnectRight(3, 1, true);
		editor.disconnectRight(8, 1, true);
		editor.disconnectRight(2, 2, true);
		editor.disconnectRight(5, 2, true);
		editor.disconnectRight(6, 2, true);
		editor.disconnectRight(7, 2, true);
		editor.disconnectRight(9, 2, true);
		editor.disconnectRight(4, 3, true);
		editor.disconnectRight(5, 3, true);
		editor.disconnectRight(8, 3, true);
		editor.disconnectRight(1, 4, true);
		editor.disconnectRight(2, 4, true);
		editor.disconnectRight(4, 4, true);
		editor.disconnectRight(5, 4, true);
		editor.disconnectRight(6, 4, true);
		editor.disconnectRight(9, 4, true);
		editor.disconnectRight(0, 5, true);
		editor.disconnectRight(2, 5, true);
		editor.disconnectRight(3, 5, true);
		editor.disconnectRight(5, 5, true);
		editor.disconnectRight(6, 5, true);
		editor.disconnectRight(8, 5, true);
		editor.disconnectRight(0, 6, true);
		editor.disconnectRight(1, 6, true);
		editor.disconnectRight(2, 6, true);
		editor.disconnectRight(5, 6, true);
		editor.disconnectRight(7, 6, true);
		editor.disconnectRight(8, 6, true);
		editor.disconnectRight(9, 6, true);
		editor.disconnectRight(2, 7, true);
		editor.disconnectRight(3, 7, true);
		editor.disconnectRight(7, 7, true);
		editor.disconnectRight(8, 7, true);
		editor.disconnectRight(1, 8, true);
		editor.disconnectRight(4, 8, true);
		editor.disconnectRight(5, 8, true);
		editor.disconnectRight(6, 8, true);
		editor.disconnectRight(7, 8, true);
		editor.disconnectRight(9, 8, true);
		editor.disconnectRight(1, 9, true);
		editor.disconnectRight(2, 9, true);
		editor.disconnectRight(4, 9, true);
		editor.disconnectRight(6, 9, true);
		editor.disconnectRight(2, 10, true);
		editor.disconnectRight(5, 10, true);
		editor.disconnectRight(8, 10, true);
		return puzzle;
	}

	public static Puzzle puzzle7()
	{
		Puzzle puzzle = new Puzzle(3, 3);
		PuzzleEditor editor = new PuzzleEditor(puzzle);
		editor.setStart(0, 2);
		editor.setFinish(2, 0);
		editor.setEssential(0, 0);
		editor.setEssential(2, 2);
		return puzzle;
	}

	public static Puzzle puzzle8()
	{
		Puzzle puzzle = new Puzzle(4, 4);
		PuzzleEditor editor = new PuzzleEditor(puzzle);
		editor.setStart(0, 3);
		editor.setFinish(3, 0);
		editor.setEmpty(0, 0);
		editor.setEssential(1, 0);
		editor.setEssential(2, 1);
		editor.setEssential(0, 2);
		editor.setEssential(3, 3);
		editor.disconnectDown(2, 2, true);
		editor.disconnectRight(2, 1, true);
		return puzzle;
	}

	public static Puzzle puzzle9()
	{
		Puzzle puzzle = new Puzzle(4, 4);
		PuzzleEditor editor = new PuzzleEditor(puzzle);
		editor.setStart(0, 3);
		editor.setFinish(3, 0);
		editor.setEmpty(0, 0);
		editor.setEssential(1, 0);
		editor.setEssential(2, 1);
		editor.setEssential(0, 2);
		editor.setEssential(3, 3);
		editor.setEssential(1, 2);
		editor.disconnectDown(2, 2, true);
		editor.disconnectRight(2, 1, true);
		editor.disconnectRight(1, 1, true);
		editor.disconnectRight(0, 3, true);
		return puzzle;
	}

	public static Puzzle puzzle10()
	{
		Puzzle puzzle = new Puzzle(4, 4);
		PuzzleEditor editor = new PuzzleEditor(puzzle);
		editor.setStart(1, 1);
		editor.setStart(2, 2);
		editor.setFinish(0, 1);
		editor.setEmpty(0, 0);
		editor.setEssential(1, 0);
		editor.setEssential(2, 1);
		editor.setEssential(0, 2);
		editor.setEssential(3, 3);
		editor.setEssential(3, 1);
		editor.setEssential(1, 2);
		editor.disconnectDown(2, 2, true);
		editor.disconnectRight(2, 1, true);
		return puzzle;
	}

	public static Puzzle puzzle11()
	{
		Puzzle puzzle = new Puzzle(4, 4);
		PuzzleEditor editor = new PuzzleEditor(puzzle);
		editor.setStart(2, 0);
		editor.setStart(3, 0);
		editor.setStart(3, 2);
		editor.setFinish(0, 1);
		editor.setEmpty(0, 0);
		editor.setEssential(1, 0);
		editor.setEssential(2, 1);
		editor.setEssential(0, 2);
		editor.setEssential(3, 3);
		editor.setEssential(3, 1);
		editor.setEssential(1, 2);
		editor.disconnectDown(2, 2, true);
		editor.disconnectRight(2, 1, true);
		return puzzle;
	}

	public static Puzzle puzzle12()
	{
		Puzzle puzzle = new Puzzle(2, 3);
		PuzzleEditor editor = new PuzzleEditor(puzzle);
		editor.setStart(0, 1);
		editor.setFinish(1, 1);
		editor.setSpecial(0, 0, 0);
		editor.setSpecial(0, 1, 1);
		return puzzle;
	}

	public static Puzzle puzzle13()
	{
		Puzzle puzzle = new Puzzle(2, 3);
		PuzzleEditor editor = new PuzzleEditor(puzzle);
		editor.setStart(0, 2);
		editor.setFinish(1, 0);
		editor.setSpecial(0, 0, 0);
		editor.setSpecial(0, 1, 1);
		return puzzle;
	}

	public static Puzzle puzzle14()
	{
		Puzzle puzzle = new Puzzle(2, 4);
		PuzzleEditor editor = new PuzzleEditor(puzzle);
		editor.setStart(0, 3);
		editor.setFinish(1, 0);
		editor.setSpecial(0, 0, 0);
		editor.setSpecial(0, 1, 0);
		editor.setSpecial(0, 2, 1);
		return puzzle;
	}

	public static Puzzle puzzle15()
	{
		Puzzle puzzle = new Puzzle(3, 3);
		PuzzleEditor editor = new PuzzleEditor(puzzle);
		editor.setStart(0, 2);
		editor.setFinish(2, 0);
		editor.setSpecial(0, 0, 0);
		editor.setSpecial(1, 0, 0);
		editor.setSpecial(0, 1, 0);
		editor.setSpecial(1, 1, 1);
		return puzzle;
	}

	public static Puzzle puzzle16()
	{
		Puzzle puzzle = new Puzzle(4, 4);
		PuzzleEditor editor = new PuzzleEditor(puzzle);
		editor.setStart(0, 3);
		editor.setFinish(3, 0);
		editor.setSpecial(0, 0, 0);
		editor.setSpecial(1, 0, 0);
		editor.setSpecial(2, 0, 0);
		editor.setSpecial(0, 1, 0);
		editor.setSpecial(1, 1, 1);
		editor.setSpecial(2, 1, 0);
		editor.setSpecial(0, 2, 1);
		editor.setSpecial(1, 2, 1);
		editor.setSpecial(2, 2, 1);
		return puzzle;
	}

	public static Puzzle puzzle17()
	{
		Puzzle puzzle = new Puzzle(4, 4);
		PuzzleEditor editor = new PuzzleEditor(puzzle);
		editor.setStart(0, 3);
		editor.setFinish(0, 2);
		editor.setSpecial(0, 0, 0);
		editor.setSpecial(1, 0, 0);
		editor.setSpecial(2, 0, 0);
		editor.setSpecial(0, 1, 0);
		editor.setSpecial(1, 1, 1);
		editor.setSpecial(2, 1, 0);
		editor.setSpecial(0, 2, 1);
		editor.setSpecial(1, 2, 1);
		editor.setSpecial(2, 2, 1);
		return puzzle;
	}

	public static Puzzle puzzle18()
	{
		Puzzle puzzle = new Puzzle(5, 5);
		PuzzleEditor editor = new PuzzleEditor(puzzle);
		editor.setStart(0, 4);
		editor.setFinish(1, 0);
		editor.setSpecial(0, 0, 0);
		editor.setSpecial(2, 0, 1);
		editor.setSpecial(3, 0, 0);
		editor.setSpecial(0, 1, 0);
		editor.setSpecial(1, 1, 0);
		editor.setSpecial(2, 1, 0);
		editor.setSpecial(3, 1, 0);
		editor.setSpecial(0, 2, 0);
		editor.setSpecial(1, 2, 1);
		editor.setSpecial(2, 2, 0);
		editor.setSpecial(3, 2, 0);
		editor.setSpecial(0, 3, 1);
		editor.setSpecial(1, 3, 1);
		editor.setSpecial(2, 3, 1);
		editor.setSpecial(3, 3, 0);
		return puzzle;
	}

	public static Puzzle puzzle19()
	{
		Puzzle puzzle = new Puzzle(5, 5);
		PuzzleEditor editor = new PuzzleEditor(puzzle);
		editor.setStart(0, 4);
		editor.setFinish(4, 2);
		editor.setSpecial(0, 0, 0);
		editor.setSpecial(1, 0, 0);
		editor.setSpecial(2, 0, 1);
		editor.setSpecial(3, 0, 0);
		editor.setSpecial(1, 1, 0);
		editor.setSpecial(2, 1, 0);
		editor.setSpecial(3, 1, 0);
		editor.setSpecial(0, 2, 0);
		editor.setSpecial(1, 2, 1);
		editor.setSpecial(2, 2, 0);
		editor.setSpecial(3, 2, 0);
		editor.setSpecial(0, 3, 1);
		editor.setSpecial(1, 3, 1);
		editor.setSpecial(2, 3, 1);
		editor.setSpecial(3, 3, 0);
		return puzzle;
	}

	public static Puzzle puzzle20()
	{
		Puzzle puzzle = new Puzzle(5, 5);
		PuzzleEditor editor = new PuzzleEditor(puzzle);
		editor.setStart(0, 4);
		editor.setFinish(3, 4);
		editor.setSpecial(1, 0, 0);
		editor.setSpecial(2, 0, 1);
		editor.setSpecial(3, 0, 0);
		editor.setSpecial(3, 1, 0);
		editor.setSpecial(0, 2, 0);
		editor.setSpecial(1, 2, 1);
		editor.setSpecial(2, 2, 0);
		editor.setSpecial(0, 3, 1);
		editor.setSpecial(1, 3, 1);
		editor.setSpecial(2, 3, 1);
		editor.setSpecial(3, 3, 0);
		return puzzle;
	}

	public static Puzzle puzzle21()
	{
		Puzzle puzzle = new Puzzle(8, 8);
		PuzzleEditor editor = new PuzzleEditor(puzzle);
		editor.setStart(0, 7);
		editor.setStart(4, 2);
		editor.setStart(2, 5);
		editor.setStart(6, 4);
		editor.setFinish(0, 0);
		editor.setFinish(7, 0);
		editor.setFinish(7, 7);
		editor.setSpecial(0, 0, 1);
		editor.setSpecial(1, 0, 0);
		editor.setSpecial(0, 1, 0);
		editor.setSpecial(3, 1, 1);
		editor.setSpecial(4, 1, 1);
		editor.setSpecial(3, 2, 0);
		editor.setSpecial(4, 2, 0);
		editor.setSpecial(5, 0, 1);
		editor.setSpecial(6, 0, 0);
		editor.setSpecial(5, 0, 1);
		editor.setSpecial(2, 4, 1);
		editor.setSpecial(2, 5, 0);
		editor.setSpecial(6, 5, 1);
		editor.setSpecial(6, 6, 1);
		editor.setSpecial(5, 6, 0);
		editor.setEssentialConnection(6, 0, true);
		editor.setEssentialConnection(6, 4, true);
		editor.setEssentialConnection(5, 7, true);
		editor.setEssentialConnection(1, 5, true);
		editor.setEssentialConnection(0, 7, true);
		editor.setEssentialConnection(7, 3, false);
		editor.setEssentialConnection(0, 6, false);
		editor.setEssentialConnection(7, 0, false);
		return puzzle;
	}

	public static Puzzle puzzle22()
	{
		Puzzle puzzle = new Puzzle(8, 8);
		PuzzleEditor editor = new PuzzleEditor(puzzle);
		editor.setLinkedStart(0, 7, true, false);
		editor.setFinish(7, 0);
		return puzzle;
	}

	public static Puzzle puzzle99()
	{
		Puzzle puzzle = new Puzzle(6, 6);
		PuzzleEditor editor = new PuzzleEditor(puzzle);
		editor.setStart(0, 0);
		editor.disconnectDown(0, 0, false);
		editor.disconnectDown(5, 0, false);
		editor.disconnectDown(2, 0, false);
		editor.disconnectDown(1, 1, false);
		editor.disconnectDown(2, 1, false);
		editor.disconnectDown(3, 1, false);
		editor.disconnectDown(3, 2, false);
		editor.disconnectDown(1, 3, false);
		editor.disconnectDown(4, 3, false);
		editor.disconnectDown(2, 3, false);
		editor.disconnectDown(3, 3, false);
		editor.disconnectDown(4, 3, false);
		editor.disconnectDown(5, 3, false);
		editor.disconnectDown(5, 4, false);
		editor.disconnectRight(1, 0, false);
		editor.disconnectRight(0, 1, false);
		editor.disconnectRight(3, 1, false);
		editor.disconnectRight(4, 1, false);
		editor.disconnectRight(2, 2, false);
		editor.disconnectRight(0, 3, false);
		editor.disconnectRight(1, 3, false);
		editor.disconnectRight(0, 4, false);
		editor.disconnectRight(1, 4, false);
		editor.disconnectRight(3, 4, false);
		editor.disconnectRight(2, 5, false);
		editor.setFinish(5, 5);
		return puzzle;
	}

	public static Puzzle puzzle100()
	{
		Puzzle puzzle = new Puzzle(5, 5);
		PuzzleEditor editor = new PuzzleEditor(puzzle);
		editor.setStart(1, 2);
		editor.setFinish(3, 2);
		editor.setEmpty(2, 2);
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 5; j++)
			{
				editor.setEssential(i, j);
			}
		}
		return puzzle;
	}

	public static void savePuzzle(Puzzle puzzle, String name) throws FileNotFoundException, IOException
	{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(name + ".pzl"));
		oos.writeObject(puzzle);
		oos.close();
		System.out.println("Succesfully saved puzzle " + name + "!");
	}
}
