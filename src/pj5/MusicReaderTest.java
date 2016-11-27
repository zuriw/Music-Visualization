/**
 * 
 */
package pj5;
import student.TestCase;

import java.io.FileNotFoundException;

/**
 * @author zuriw
 *
 */
public class MusicReaderTest extends TestCase
{

    private MusicReader reader;
    public void setUp() throws FileNotFoundException
    {
        reader = new MusicReader("SongListTest1.csv");
    }
    
    public void testGetSongs()
    {
        
        LList songs = reader.getSongs();
        for (int i = 1; i <= songs.getLength(); i++)
        {
            System.out.println(songs.getEntry(i).toString());
        }
    }
}
