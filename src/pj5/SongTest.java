package pj5;

/**
 * @author usmana
 * @version 11/15/2016
 */
public class SongTest extends student.TestCase
{
    private Song song;


    /**
     *
     */
    public void setUp()
    {
        song = new Song("title", "artist", 1985, "genre");
    }


    /**
     * 
     */
    public void testgetArtist()
    {
        assertEquals("artist", song.getArtist());
    }


    /**
     * 
     */
    public void testgetGenre()
    {
        assertEquals("genre", song.getGenre());
    }


    /**
     * 
     */
    public void testgetTitle()
    {
        assertEquals("title", song.getTitle());
    }


    /**
     * 
     */
    public void testgetYear()
    {
        assertEquals(1985, song.getYear());
    }


    /**
     * 
     */
    public void testtoString()
    {
        assertEquals("\nSong Title: " + song.getTitle() + "\n" + "Song Artist: "
            + song.getArtist() + "\n" + "Song Genre: " + song.getGenre() + "\n"
            + "Song Year: " + song.getYear() + "\n", song.toString());
    }

}
