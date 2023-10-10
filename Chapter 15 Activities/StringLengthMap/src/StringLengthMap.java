import java.util.*;

import javafx.scene.paint.Color;

import java.io.*;
/**
 * Read all words from a file and add them to a
 * map whose keys are word lengths and whose values
 * are comma-separated strings of words of the same length.
 * Then print out those strings, in increasing order by
 * the length of their entries.
 * Modify Worked Example 15.1.
 */
public class StringLengthMap
{
    public static void main(String[] args) throws FileNotFoundException
    {
        String filename = "src/test1.txt";

        try (Scanner in = new Scanner(new File(filename)))
        {

            Map<Integer, String> lengths = new TreeMap<>();
            

            while (in.hasNext())
            {
                String word = clean(in.next());
                Integer len = word.length();

                // Update the map here
                // Modify Worked Example 15.1
                if(lengths.containsKey(len))
                {
                    lengths.put(len, lengths.get(len)+", "+word);
                }
                else
                {
                    lengths.put(len, word);
                }
            }



            }

            // Print the strings, in increasing order of their length
            // Use this format: 1: i, a, i
            for(Integer key : lengths.keySet())
            {
                System.out.println(key + ": " + lengths.get(key));
            }

        } catch (FileNotFoundException e)
        {
            System.out.println("Cannot open: " + filename);
        }
    }

    public static String clean(String s)
    {
        String r = "";
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (Character.isLetter(c))
            {
                r = r + c;
            }
        }
        return r.toLowerCase();
    }


