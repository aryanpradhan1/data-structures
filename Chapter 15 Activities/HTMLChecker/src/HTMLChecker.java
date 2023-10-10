import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
/**
 * Write a program that checks whether a sequence of HTML tags
 * is properly nested. For each opening tag, such as <p>, there
 * must be a closing tag </p>. A tag such as <p> may have other
 * tags inside, for example <p> <ul> <li> </li> </ul> <a> </a> </p>
 * <p>
 * The inner tags must be closed before the outer ones.
 * Your program should process a file containing tags.
 * For simplicity, assume that the tags are separated by
 * spaces, and that there is no text inside the tags.
*/
public class HTMLChecker
{
    public static void main(String[] args)
    {
        String filename = "src/TagSample1.html";

        Stack<String> tags = new Stack<>();
        String current;
        String test;
        
        try (Scanner in = new Scanner(new File(filename)))
        {
            // Your code goes here
            . . .
            String full = in.next();
            current = full.substring(1, full.length() - 1);
            tags.push(current);

            while(in.hasNext())
            {
                String tag = in.next();
                current = tag.substring(1, full.length() - 1);

                test = tags.pop();
                if(!current.equals("/" + test))
                {
                    tags.push(test);
                    tags.push(current);
                }
                
                if(tags.size()==0)
                {
                    System.out.println("The tags are correctly nested");
                }
                else{
                    System.out.println("The tags not nested properly");
                }

            }


        } catch (FileNotFoundException e)
        {
            System.out.println("Cannot open: " + filename);
        }

    }
}
