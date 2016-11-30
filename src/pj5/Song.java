package pj5;

/**
 * This class creates a Song object which contains the Title Artist Year and
 * Genre compiled by their Hobbies Majors and
 * 
 * @author zuriw,usmana
 * @version 11/30/2016
 */
public class Song
{
    private String title;
    private String artist;
    private int    year;
    private String genre;

    // Hobbies
    private int    pertsportsHeard;
    private int    pertsportsLike;
    private int    pertreadingHeard;
    private int    pertreadingLike;
    private int    pertartHeard;
    private int    pertartLike;
    private int    pertmusicHeard;
    private int    pertmusicLike;

    // Majors
    private int    pertCsHeard;
    private int    pertCsLike;
    private int    pertCmdaHeard;
    private int    pertCmdaLike;
    private int    pertOtherEngHeard;
    private int    pertOtherEngLike;
    private int    pertOtherHeard;
    private int    pertOtherLike;

    // Regions
    private int    pertNeHeard;
    private int    pertNeLike;
    private int    pertSeHeard;
    private int    pertSeLike;
    private int    pertUsHeard;
    private int    pertUsLike;
    private int    pertOutsideUsHeard;
    private int    pertOutsideUsLike;


    /**
     * @param Title
     *            of the Song
     * @param Year
     *            of the Song
     * @param Genre
     *            of the Song
     * @param Artist
     *            of the Song
     */
    public Song(String title, String artist, int year, String genre)
    {
        this.title = title;

        this.artist = artist;
        this.year = year;
        this.genre = genre;
    }


    /**
     * gets the Title of the Song
     * 
     * @return the title of the Song
     */
    public String getTitle()
    {
        return title;
    }


    /**
     * gets the Artist of the Song
     * 
     * @return the Artist of the Song
     */
    public String getArtist()
    {
        return artist;
    }


    /**
     * gets the Year of the Song
     * 
     * @return the Year of the Song
     */
    public int getYear()
    {
        return year;
    }


    /**
     * gets the Genre of the Song
     * 
     * @return the Genre of the Song
     */
    public String getGenre()
    {
        return genre;
    }


    /**
     * Creates and returns a String representation of a Song
     * 
     * @return the Song in a String format Song Title: Song Artist: Song Genre:
     *         Song Year:
     */
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        s.append("\nSong Title: " + this.getTitle() + "\n");
        s.append("Song Artist: " + this.getArtist() + "\n");
        s.append("Song Genre: " + this.getGenre() + "\n");
        s.append("Song Year: " + this.getYear() + "\n");
        return s.toString();
    }


    /**
     * gets the percentage of sports Heard
     * 
     * @return the pertsportsHeard
     */
    public int getPertsportsHeard()
    {
        return pertsportsHeard;
    }


    /**
     * sets the percentage of sports Heard
     * 
     * @param pertsportsHeard
     *            the pertsportsHeard to set
     */
    public void setPertsportsHeard(int pertsportsHeard)
    {
        this.pertsportsHeard = pertsportsHeard;
    }


    /**
     * gets the percentage of sports Like
     * 
     * @return the pertsportsLike
     */
    public int getPertsportsLike()
    {
        return pertsportsLike;
    }


    /**
     * sets the percentage of sports Like
     * 
     * @param pertsportsLike
     *            the pertsportsLike to set
     */
    public void setPertsportsLike(int pertsportsLike)
    {
        this.pertsportsLike = pertsportsLike;
    }


    /**
     * gets the percentage of reading Heard
     * 
     * @return the pertreadingHeard
     */
    public int getPertreadingHeard()
    {
        return pertreadingHeard;
    }


    /**
     * sets the percentage of reading Heard
     * 
     * @param pertreadingHeard
     *            the pertreadingHeard to set
     */
    public void setPertreadingHeard(int pertreadingHeard)
    {
        this.pertreadingHeard = pertreadingHeard;
    }


    /**
     * sets the percentage of reading Like
     * 
     * @return the pertreadingLike
     */
    public int getPertreadingLike()
    {
        return pertreadingLike;
    }


    /**
     * sets the percentage of reading Like
     * 
     * @param pertreadingLike
     *            the pertreadingLike to set
     */
    public void setPertreadingLike(int pertreadingLike)
    {
        this.pertreadingLike = pertreadingLike;
    }


    /**
     * gets the percentage of art Heard
     * 
     * @return the pertartHeard
     */
    public int getPertartHeard()
    {
        return pertartHeard;
    }


    /**
     * sets the percentage of art Heard
     * 
     * @param pertartHeard
     *            the pertartHeard to set
     */
    public void setPertartHeard(int pertartHeard)
    {
        this.pertartHeard = pertartHeard;
    }


    /**
     * gets the percentage of art Like
     * 
     * @return the pertartLike
     */
    public int getPertartLike()
    {
        return pertartLike;
    }


    /**
     * sets the percentage of art Like
     * 
     * @param pertartLike
     *            the pertartLike to set
     */
    public void setPertartLike(int pertartLike)
    {
        this.pertartLike = pertartLike;
    }


    /**
     * gets the percentage of music Heard
     * 
     * @return the pertmusicHeard
     */
    public int getPertmusicHeard()
    {
        return pertmusicHeard;
    }


    /**
     * sets the percentage of music Heard
     * 
     * @param pertmusicHeard
     *            the pertmusicHeard to set
     */
    public void setPertmusicHeard(int pertmusicHeard)
    {
        this.pertmusicHeard = pertmusicHeard;
    }


    /**
     * gets the percentage of music Like
     * 
     * @return the pertmusicLike
     */
    public int getPertmusicLike()
    {
        return pertmusicLike;
    }


    /**
     * sets the percentage of music Like
     * 
     * @param pertmusicLike
     *            the pertmusicLike to set
     */
    public void setPertmusicLike(int pertmusicLike)
    {
        this.pertmusicLike = pertmusicLike;
    }


    /**
     * gets the percentage of CS Heard
     * 
     * @return the pertCsHeard
     */
    public int getPertCsHeard()
    {
        return pertCsHeard;
    }


    /**
     * sets the percentage of CS Heard
     * 
     * @param pertCsHeard
     *            the pertCsHeard to set
     */
    public void setPertCsHeard(int pertCsHeard)
    {
        this.pertCsHeard = pertCsHeard;
    }


    /**
     * gets the percentage of CS Like
     * 
     * @return the pertCsLike
     */
    public int getPertCsLike()
    {
        return pertCsLike;
    }


    /**
     * sets the percentage of CS Like
     * 
     * @param pertCsLike
     *            the pertCsLike to set
     */
    public void setPertCsLike(int pertCsLike)
    {
        this.pertCsLike = pertCsLike;
    }


    /**
     * gets the percentage of Cmda Heard
     * 
     * @return the pertCmdaHeard
     */
    public int getPertCmdaHeard()
    {
        return pertCmdaHeard;
    }


    /**
     * set the percentage of Cmda Heard
     * 
     * @param pertCmdaHeard
     *            the pertCmdaHeard to set
     */
    public void setPertCmdaHeard(int pertCmdaHeard)
    {
        this.pertCmdaHeard = pertCmdaHeard;
    }


    /**
     * get the percentage of Cmda Like
     * 
     * @return the pertCmdaLike
     */
    public int getPertCmdaLike()
    {
        return pertCmdaLike;
    }


    /**
     * sets the percentage of Cmda Like
     * 
     * @param pertCmdaLike
     *            the pertCmdaLike to set
     */
    public void setPertCmdaLike(int pertCmdaLike)
    {
        this.pertCmdaLike = pertCmdaLike;
    }


    /**
     * gets the percentage of OtherEng Heard
     * 
     * @return the pertOtherEngHeard
     */
    public int getPertOtherEngHeard()
    {
        return pertOtherEngHeard;
    }


    /**
     * sets the percentage of OtherEng Like
     * 
     * @param pertOtherEngHeard
     *            the pertOtherEngHeard to set
     */
    public void setPertOtherEngHeard(int pertOtherEngHeard)
    {
        this.pertOtherEngHeard = pertOtherEngHeard;
    }


    /**
     * gets the percentage of OtherEng Like
     * 
     * @return the pertOtherEngLike
     */
    public int getPertOtherEngLike()
    {
        return pertOtherEngLike;
    }


    /**
     * sets the percentage of OtherEng Like
     * 
     * @param pertOtherEngLike
     *            the pertOtherEngLike to set
     */
    public void setPertOtherEngLike(int pertOtherEngLike)
    {
        this.pertOtherEngLike = pertOtherEngLike;
    }


    /**
     * gets the percentage of Other Heard
     * 
     * @return the pertOtherHeard
     */
    public int getPertOtherHeard()
    {
        return pertOtherHeard;
    }


    /**
     * sets the percentage of Other Heard
     * 
     * @param pertOtherHeard
     *            the pertOtherHeard to set
     */
    public void setPertOtherHeard(int pertOtherHeard)
    {
        this.pertOtherHeard = pertOtherHeard;
    }


    /**
     * gets the percentage of Other Like
     * 
     * @return the pertOtherLike
     */
    public int getPertOtherLike()
    {
        return pertOtherLike;
    }


    /**
     * sets the percentage of Other Like
     * 
     * @param pertOtherLike
     *            the pertOtherLike to set
     */
    public void setPertOtherLike(int pertOtherLike)
    {
        this.pertOtherLike = pertOtherLike;
    }


    /**
     * gets the percentage of NE Heard
     * 
     * @return the pertNeHeard
     */
    public int getPertNeHeard()
    {
        return pertNeHeard;
    }


    /**
     * sets the percentage of NE Heard
     * 
     * @param pertNeHeard
     *            the pertNeHeard to set
     */
    public void setPertNeHeard(int pertNeHeard)
    {
        this.pertNeHeard = pertNeHeard;
    }


    /**
     * gets the percentage of NE Like
     * 
     * @return the pertNeLike
     */
    public int getPertNeLike()
    {
        return pertNeLike;
    }


    /**
     * sets the percentage of NE Like
     * 
     * @param pertNeLike
     *            the pertNeLike to set
     */
    public void setPertNeLike(int pertNeLike)
    {
        this.pertNeLike = pertNeLike;
    }


    /**
     * gets the percentage of SE Heard
     * 
     * @return the pertSeHeard
     */
    public int getPertSeHeard()
    {
        return pertSeHeard;
    }


    /**
     * sets the percentage of SE Heard
     * 
     * @param pertSeHeard
     *            the pertSeHeard to set
     */
    public void setPertSeHeard(int pertSeHeard)
    {
        this.pertSeHeard = pertSeHeard;
    }


    /**
     * gets the percentage of SE Like
     * 
     * @return the pertSeLike
     */
    public int getPertSeLike()
    {
        return pertSeLike;
    }


    /**
     * sets the percentage of SE Like
     * 
     * @param pertSeLike
     *            the pertSeLike to set
     */
    public void setPertSeLike(int pertSeLike)
    {
        this.pertSeLike = pertSeLike;
    }


    /**
     * gets the percentage of US Heard
     * 
     * @return the pertUsHeard
     */
    public int getPertUsHeard()
    {
        return pertUsHeard;
    }


    /**
     * sets the percentage of US Heard
     * 
     * @param pertUsHeard
     *            the pertUsHeard to set
     */
    public void setPertUsHeard(int pertUsHeard)
    {
        this.pertUsHeard = pertUsHeard;
    }


    /**
     * gets the percentage of US Like
     * 
     * @return the pertUsLike
     */
    public int getPertUsLike()
    {
        return pertUsLike;
    }


    /**
     * sets the percentage of US Like
     * 
     * @param pertUsLike
     *            the pertUsLike to set
     */
    public void setPertUsLike(int pertUsLike)
    {
        this.pertUsLike = pertUsLike;
    }


    /**
     * gets the percentage of OutsideUS Heard
     * 
     * @return the pertOutsideUsHeard
     */
    public int getPertOutsideUsHeard()
    {
        return pertOutsideUsHeard;
    }


    /**
     * sets the percentage of OutSideUS Heard
     * 
     * @param pertOutsideUsHeard
     *            the pertOutsideUsHeard to set
     */
    public void setPertOutsideUsHeard(int pertOutsideUsHeard)
    {
        this.pertOutsideUsHeard = pertOutsideUsHeard;
    }


    /**
     * gets the percentage of OutSideUS Like
     * 
     * @return the pertOutsideUsLike
     */
    public int getPertOutsideUsLike()
    {
        return pertOutsideUsLike;
    }


    /**
     * sets the percentage of OutsideUs Like
     * 
     * @param pertOutsideUsLike
     *            the pertOutsideUsLike to set
     */
    public void setPertOutsideUsLike(int pertOutsideUsLike)
    {
        this.pertOutsideUsLike = pertOutsideUsLike;
    }

}
