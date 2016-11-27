/**
 * 
 */
package pj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author zuriw
 *
 */
public class MusicReader
{

    
    private Scanner scanner;
    private LList<Song> songs;
    
    public MusicReader(String fileNameIn) throws FileNotFoundException
    {
        File file = new File(fileNameIn);
        scanner = new Scanner(file);
        songs = new LList<Song>();
    }
    
    public LList<Song> getSongs()
    {
        scanner.nextLine();
        while (scanner.hasNextLine())
        {
            String line = scanner.nextLine();
            String[] phrases = line.split(",");
            String title = phrases[0];
            String artist = phrases[1];
            int year = Integer.parseInt(phrases[2]);
            String genre = phrases[3];
            Song song = new Song(title, artist, year, genre);
            songs.add(song);
        }
        
        return songs;
    }
}
