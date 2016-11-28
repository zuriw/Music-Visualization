package pj5;

import java.util.Comparator;

/**
 * @author zuriw
 *
 */
public class CompareYear implements Comparator<Song>
{
    
        /**
         * @param uno
         * @param dos
         * @return
         */
        public int compare(Song uno, Song dos) 
        {
            return uno.getYear() - dos.getYear();
        }
    
    
}
