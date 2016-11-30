/**
 * 
 */
package pj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author zuriw,usmana
 * @version 11/30/2016
 */
public class SurveyReader
{
    private Scanner        scanner;
    private LList<Student> students;


    /**
     * This constrcuts a SurveyReader object and an empty LinkedList<Student>
     * @param fileNameIn the name of the file that is being read as a String
     * @throws FileNotFoundException if the file is not found in the source foulder
     */
    public SurveyReader(String fileNameIn) throws FileNotFoundException
    {
        File file = new File(fileNameIn);
        scanner = new Scanner(file);
        students = new LList<Student>();
    }

    /**
     * Gets a list of Students from the csv File
     * @return a LinkedList<Student> from the csv File
     * @param songsIn LinkedList<Song> from MusicReader
     */
    public LList<Student> getStudents(LList<Song> songsIn)
    {
        scanner.nextLine();

        while (scanner.hasNextLine())
        {
            String line = scanner.nextLine();
            String[] phrases = line.split(",");
            if (phrases.length > 4)
            {

                //String ID = phrases[0];
                //String date = phrases[1];
                String major = phrases[2];
                String region = phrases[3];
                String hobby = phrases[4];
                if (!major.equals("") && !hobby.equals("") && !region.equals(
                    "")) // student
                         // is
                         // valid
                {
                    Student student = new Student(major, hobby, region);
                    students.add(student);
                    int index = 5;
                    int songIndex = 1;
                    while (index < phrases.length)
                    {
                        if (index % 2 == 0) // even
                        {
                            if (phrases[index].equals("Yes"))
                            {
                                student.addLike(songsIn.getEntry(songIndex)); // song
                                // 1
                            }
                            songIndex++;
                        }
                        else
                        {
                            if (phrases[index].equals("Yes"))
                            {
                                student.addHeard(songsIn.getEntry(songIndex)); // song
                            }

                        }

                        index++;
                    }
                }
            }
        }

        return students;
    }
}
