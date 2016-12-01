package pj5;
import student.TestCase;

import java.io.FileNotFoundException;

/**
 * This is a test class for MusicReader
 * @author zuriw,usmana
 * @version 11/30/2016
 *
 */
public class MusicReaderTest extends TestCase
{

    private MusicReader reader;
    /**
     * creates an MusicReader object for testing
     */
    public void setUp() throws FileNotFoundException
    {
        reader = new MusicReader("SongListTest1.csv");
    }
    
    /**
     * tests to see if the MusicReader can retrieve the songs from the File
     */
    public void testGetSongs()
    {
        
        LList<Song> songs = reader.getSongs();
       /* for (int i = 1; i <= songs.getLength(); i++)
        {
            System.out.println(songs.getEntry(i).toString());
        }*/
        assertEquals(5, songs.getLength());
    }
}

