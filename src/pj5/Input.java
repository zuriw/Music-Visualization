package pj5;

import java.io.FileNotFoundException;
import java.util.Comparator;

/**
 * This class executes the program based on the Input provided
 * 
 * @author zuriw
 * @version 11/30/2016
 */
public class Input
{
    @SuppressWarnings("unused")
    public static void main(String[] args)
    {

        SurveyReader surveyReader = null;
        MusicReader musicReader = null;


        try
        {
            surveyReader = new SurveyReader("MusicSurveyData.csv");
            musicReader = new MusicReader("SongList.csv");

        }
        catch (FileNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        LList<Song> songs = musicReader.getSongs();
        LList<Student> allStudents = surveyReader.getStudents(songs);
        GUI gui = new GUI(songs, allStudents);

    }
}
