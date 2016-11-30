package pj5;

/**
 * This is a test class for Song
 * @author usmana
 * @version 11/15/2016
 */
public class SongTest extends student.TestCase
{
    private Song song;


    /**
     * Creates a Song Object to be tested
     */
    public void setUp()
    {
        song = new Song("title", "artist", 1985, "genre");
    }


    /**
     * tests to see if the correct Artist is returned 
     */
    public void testgetArtist()
    {
        assertEquals("artist", song.getArtist());
    }


    /**
     * tests to see if the correct Genre is returned 
     */
    public void testgetGenre()
    {
        assertEquals("genre", song.getGenre());
    }


    /**
     * tests to see if the correct Title is returned 
     */
    public void testgetTitle()
    {
        assertEquals("title", song.getTitle());
    }


    /**
     * tests to see if the correct Year is returned 
     */
    public void testgetYear()
    {
        assertEquals(1985, song.getYear());
    }


    /**
     * tests to see if the correct String representation of Song is returned 
     */
    public void testtoString()
    {
        assertEquals("\nSong Title: " + song.getTitle() + "\n" + "Song Artist: "
            + song.getArtist() + "\n" + "Song Genre: " + song.getGenre() + "\n"
            + "Song Year: " + song.getYear() + "\n", song.toString());
    }

}

