
package pj5;

import java.util.Comparator;

/**
 * Comparator class that compares two Song Objects by their Artists
 * 
 * @author usmana
 * @version 11/30/2016
 */
public class CompareArtist implements Comparator<Song>
{

    /**
     * Compares two Song Objects by the Artists and returns less than /equal to
     * / greater than
     * 
     * @param song1
     *            Song Object 1
     * @param song2
     *            the other Song Object being compared to
     * @return int negative (less) 0 (equal to) positive (greater than) Ignores
     *         String case
     */
    @Override
    public int compare(Song song1, Song song2)
    {
        return song1.getArtist().compareToIgnoreCase(song2.getArtist());
    }

}
