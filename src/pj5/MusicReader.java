package pj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class creates a MusicReader object which takes in a csv file as a String Name
 * and creates Song Objects
 * 
 * @author zuri
 * @version 11/30/2016
 */
public class MusicReader
{

    private Scanner     scanner;
    private LList<Song> songs;


    /**
     * This constrcuts a MusicReader object and an empty LinkedList<Song>
     * @param fileNameIn the name of the file that is being read as a String
     * @throws FileNotFoundException if the file is not found in the source foulder
     */
    public MusicReader(String fileNameIn) throws FileNotFoundException
    {
        File file = new File(fileNameIn);
        scanner = new Scanner(file);
        songs = new LList<Song>();
    }


    /**
     * Gets a list of Songs from the csv File
     * @return a LinkedList<Song> from the csv File 
     */
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
