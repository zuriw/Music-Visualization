package pj5;

import student.TestCase;

/**
 * This class tests all of the compare classes. It creates two 
 * song objects to test the classes.
 * 
 * @author jchu247
 * @version 11/30/2016
 */
public class CompareTest extends TestCase
{
    private Song song1; 
    private Song song2; 
    private Song song3;
    private CompareArtist art;
    private CompareGenre genre;
    private CompareTitle title; 
    private CompareYear year;
    
    /**
     * runs before every test
     */
    public void setUp()
    {
        song1 = new Song("a", "a", 0, "a");
        song2 = new Song("a", "a", 0, "a");
        song3 = new Song("b", "b", 1, "b");
        art = new CompareArtist();
        genre = new CompareGenre();
        title = new CompareTitle();
        year = new CompareYear();
    }
    
    /**
     * tests CompareArtist class
     */
    public void testCompareArtist()
    {
        assertEquals(0, art.compare(song1, song2));
        assertEquals(-1, art.compare(song1, song3));
        assertEquals(1, art.compare(song3, song1));
    }
    
    /**
     * tests CompareGenre class
     */
    public void testCompareGenre()
    {
        assertEquals(0, genre.compare(song1, song2));
        assertEquals(-1, genre.compare(song1, song3));
        assertEquals(1, genre.compare(song3, song1));
    }
    
    /**
     * tests CompareTitle class
     */
    public void testCompareTitle()
    {
        assertEquals(0, title.compare(song1, song2));
        assertEquals(-1, title.compare(song1, song3));
        assertEquals(1, title.compare(song3, song1));
    }
    
    /**
     * tests CompareYear class
     */
    public void testCompareYear()
    {
        assertEquals(0, year.compare(song1, song2));
        assertEquals(-1, year.compare(song1, song3));
        assertEquals(1, year.compare(song3, song1));
    }
}
