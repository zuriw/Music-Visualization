package pj5;

/**
 * Test class for the student class
 * 
 * @author usmana
 * @version 11/28/2016
 */
public class StudentTest extends student.TestCase
{
    private Student student;
    private Song    song;


    /**
     * Creates an instance of a Student and Song Object used in testing
     */
    public void setUp()
    {
        student = new Student("Computer Science", "reading", "NorthEast");
        song = new Song("SongTitle", "SongArtist", 2016, "SongGenre");
    }


    /**
     * tests to see if the student's major is returned
     */
    public void testgetMajor()
    {
        assertEquals("Computer Science", student.getMajor());
    }


    /**
     * tests to see if the student's hobby is returned
     */
    public void testgetHobby()
    {
        assertEquals("reading", student.getHobby());
    }


    /**
     * tests to see if the student's region is returned
     */
    public void testgetRegion()
    {
        assertEquals("NorthEast", student.getRegion());
    }


    /**
     * tests to see if the SongsHeard for the student is returned
     */
    public void testgetSongsHeard()
    {
        student.addHeard(song);
        assertEquals("{" + song.toString() + "}", student.getSongsHeard()
            .toString());
    }


    /**
     * tests to see if the SongsLiked for the student is returned
     */
    public void testgetSongsLike()
    {
        student.addLike(song);
        assertEquals("{" + song.toString() + "}", student.getSongsLike()
            .toString());
    }


    /**
     * tests to see if a song is heard by a student if it is then it is added to
     * the Heard list
     */
    public void testaddHeard()
    {
        student.addHeard(song);
        assertEquals(1, student.getSongsHeard().getLength());

    }


    /**
     * tests to see if a song is liked by a student if it is then it is added to
     * the Like list
     */
    public void testaddLike()
    {
        student.addLike(song);
        assertEquals(1, student.getSongsLike().getLength());
    }


    /**
     * tests to see if the toString() method returns in the following format
     * "Major: Major" "Region: Region" "Hobby: Hobby"
     */
    public void testtoString()
    {
        assertEquals("Major: " + student.getMajor() + "\n" + "Region: "
            + student.getRegion() + "\n" + "Hobby: " + student.getHobby()
            + "\n", student.toString());
    }

}
