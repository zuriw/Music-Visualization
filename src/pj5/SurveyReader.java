/**
 * 
 */
package pj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author zuriw
 */
public class SurveyReader
{
    private Scanner        scanner;
    private LList<Student> students;


    public SurveyReader(String fileNameIn) throws FileNotFoundException
    {
        File file = new File(fileNameIn);
        scanner = new Scanner(file);
        students = new LList<Student>();
    }


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
