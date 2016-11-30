package pj5;

import java.util.Comparator;

/**
 * Comparator class that compares two Song Objects by their Years
 * 
 * @author usmana
 * @version 11/30/2016
 */
public class CompareYear implements Comparator<Song>
{

    /**
     * Compares two Song Objects by their Year and returns a negative positive
     * or equal int
     * 
     * @param song1
     *            Song Object 1
     * @param song2
     *            the other Song Object being compared to
     * @return int negative if year is less else positive if greater and 0 if
     *         equal
     */
    @Override
    public int compare(Song song1, Song song2)
    {
        return song1.getYear() - song2.getYear();
    }

}
