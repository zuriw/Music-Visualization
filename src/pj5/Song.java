/**
 * 
 */
package pj5;

/**
 * @author zuriw
 */
public class Song
{
    private String title;
    private String artist;
    private int    year;
    private String genre;


    /**
     * 
     * @param Title
     * @param Year
     * @param Genre
     * @param Artist
     */
    public Song(String title, String artist, int year, String genre)
    {
        this.title = title;
        
       
        this.artist = artist;
        this.year = year;
        this.genre = genre;
    }


    /**
     * @return
     */
    public String getTitle()
    {
        return title;
    }


    /**
     * @return
     */
    public String getArtist()
    {
        return artist;
    }

    /**
     * 
     * @return
     */
    public int getYear()
    {
        return year;
    }

    /**
     * 
     * @return
     */
    public String getGenre()
    {
        return genre;
    }

    /**
     *@return
     */
    public String toString()
    {
           StringBuilder s = new StringBuilder();
           s.append("\nSong Title: " + this.getTitle() + "\n");          
           s.append("Song Artist: " + this.getArtist() + "\n");           
           s.append("Song Genre: " +this.getGenre() + "\n");
           s.append("Song Year: " +this.getYear() + "\n");
           return s.toString();
    }
}
