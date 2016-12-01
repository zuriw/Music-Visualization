package pj5;

import java.io.FileNotFoundException;


/**
 * This class executes the program based on the Input provided
 * 
 * @author zuriw, jchu247
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
            surveyReader = new SurveyReader("MusicSurveyData2016F.csv");
            musicReader = new MusicReader("SongList2016F.csv");

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
