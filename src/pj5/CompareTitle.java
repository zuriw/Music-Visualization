/**
 * 
 */
package pj5;

import java.util.Comparator;

/**
 * @author zuriw
 *
 */
public class CompareTitle implements Comparator<Song>
{

    @Override
    public int compare(Song song1, Song song2)
    {
        return song1.getTitle().compareToIgnoreCase(song2.getTitle());
    }
}
