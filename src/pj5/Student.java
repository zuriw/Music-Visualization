/**
 * 
 */
package pj5;

/**
 * @author zuriw
 * @version 2016.11.23
 */
public class Student
{

    private String major;
    private String hobby;
    private String region;
    private LList<Song> songsHeard;
    private LList<Song> songsLike;

    public Student(String majorIn, String hobbyIn, String regionIn)
    {
        major = majorIn;
        hobby = hobbyIn;
        region = regionIn;
        songsHeard = new LList<Song>();
        songsLike = new LList<Song>();
    }


    public String getMajor()
    {
        return major;
    }


    public String getHobby()
    {
        return hobby;
    }


    public String getRegion()
    {
        return region;
    }
    
    public LList getSongsHeard()
    {
        return songsHeard;
    }
    
    public LList getSongsLike()
    {
        return songsLike;
    }
    
    public void addHeard(Song songIn)
    {
        songsHeard.add(songIn);
    }
    
    public void addLike(Song songIn)
    {
        songsLike.add(songIn);
    }
    
    /**
     * 
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
