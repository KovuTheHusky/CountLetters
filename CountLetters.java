import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class CountLetters
{
	private static int[] letters = new int[26];
	private static int maximum = 20;

	public static void main(String[] args)
	{
		try
		{
			Scanner s = new Scanner(new File(JOptionPane.showInputDialog("What file would you like to read?", "CountLetters.java")));
			while (s.hasNext())
				getLettersFrom(s.next().toUpperCase());
			drawHistogram();
		}
		catch (Exception ex)
		{
			System.out.println(ex.getMessage());
			System.exit(0);
		}
	}

	private static void getLettersFrom(String str)
	{
		for (int i = 0; i < str.length(); ++i)
		{
			char c = str.charAt(i);
			if (c >= 'A' && c <= 'Z')
			{
				if (++letters[(int)c - 65] > maximum)
					maximum = letters[(int)c - 65];
			}
		}
	}

	private static void drawHistogram()
	{
		System.out.println();
		for (int i = 20; i > 0; --i)
		{
			int val = (int)((double)maximum / 20 * i);
			String temp = val + "";
			while (temp.length() < (maximum + "").length())
				temp = " " + temp;
			System.out.print(temp + " ");
			for (int j = 0; j < letters.length; ++j)
			{
				if (letters[j] >= val)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
		System.out.println();
		String spacer = "";
		while ((maximum + "").length() >= spacer.length())
			spacer += " ";
		System.out.print(spacer);
		for (int i = 65; i < 91; ++i)
			System.out.print((char)i + " ");
		System.out.println();
	}
}