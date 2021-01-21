package inOut;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import game.Puzzle;

public class PuzzleLoader
{
	public static Puzzle loadPuzzle(String name) throws FileNotFoundException, IOException, ClassNotFoundException
	{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(name + ".pzl"));
		Puzzle puzzle = (Puzzle) ois.readObject();
		ois.close();
		return puzzle;
	}
}
