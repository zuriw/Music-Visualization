package pj5;

/**
 * This class creates a Student Object that consists of a major, hobby, and
 * region with their Songs heard and Songs liked *
 * 
 * @author zuriw,usmana
 * @version 2016.11.23
 */
public class Student
{

    private String      major;
    private String      hobby;
    private String      region;
    private LList<Song> songsHeard;
    private LList<Song> songsLike;


    /**
     * Constructor for the Student Object
     * 
     * @param majorIn
     *            of the Student
     * @param hobbyIn
     *            of the Student
     * @param regionIn
     *            of the Student
     */
    public Student(String majorIn, String hobbyIn, String regionIn)
    {
        major = majorIn;
        hobby = hobbyIn;
        region = regionIn;
        songsHeard = new LList<Song>();
        songsLike = new LList<Song>();
    }


    /**
     * gets the Major of the Student
     * 
     * @return Major of the Student
     */
    public String getMajor()
    {
        return major;
    }


    /**
     * gets the Hobby of the Student
     * 
     * @return Hobby of the Student
     */
    public String getHobby()
    {
        return hobby;
    }


    /**
     * gets the Region of the Student
     * 
     * @return Region of the Student
     */
    public String getRegion()
    {
        return region;
    }


    /**
     * gets the LinkedList of Songs Heard
     * 
     * @return the LList<Song> of Songs Heard
     */
    public LList<Song> getSongsHeard()
    {
        return songsHeard;
    }


    /**
     * gets the LinkedList of Songs Liked
     * 
     * @return the LList<Song> of Songs Liked
     */
    public LList<Song> getSongsLike()
    {
        return songsLike;
    }


    /**
     * adds to the List of Songs Heard
     * 
     * @param songIn
     *            Song to be inputed
     */
    public void addHeard(Song songIn)
    {
        songsHeard.add(songIn);
    }


    /**
     * adds to the List of Songs Liked
     * 
     * @param songIn
     *            Song to be inputed
     */
    public void addLike(Song songIn)
    {
        songsLike.add(songIn);
    }


    /**
     * Creates and returns a String representation of a Student *
     * 
     * @return the Song in a String format Studejt Major: Student Region:
     *         Student Hobby:
     */
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        s.append("Major: " + this.getMajor() + "\n");
        s.append("Region: " + this.getRegion() + "\n");
        s.append("Hobby: " + this.getHobby() + "\n");
        return s.toString();
    }

}
