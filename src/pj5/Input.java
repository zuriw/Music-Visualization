/**
 * 
 */
package pj5;

import java.io.FileNotFoundException;
import java.util.Comparator;

/**
 * @author zuriw
 */
public class Input
{

    @SuppressWarnings("unchecked")
    public static void main(String[] args)
    {
        LList<Student> sportsStudents = new LList<Student>();
        LList<Student> readingStudents = new LList<Student>();
        LList<Student> artStudents = new LList<Student>();
        LList<Student> musicStudents = new LList<Student>();
        SurveyReader surveyReader = null;
        MusicReader musicReader = null;
        CompareGenre genreComparator = new CompareGenre();
        CompareTitle titleComparator = new CompareTitle();
        CompareArtist artistComparator = new CompareArtist();
        CompareYear yearComparator = new CompareYear();
        GUIGlyph gui = new GUIGlyph();
        try
        {
            surveyReader = new SurveyReader("MusicSurveyData.csv");
            musicReader = new MusicReader("SongList.csv");

        }
        catch (FileNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        LList<Song> songs = musicReader.getSongs();
        LList<Student> allStudents = surveyReader.getStudents(songs);

        // add all sports students in list
        for (int i = 1; i <= allStudents.getLength(); i++)
        {
            
            if (allStudents.getEntry(i).getHobby().equals("sports"))
            {
                sportsStudents.add(allStudents.getEntry(i));
            }
            else if (allStudents.getEntry(i).getHobby().equals("reading"))
            {
                readingStudents.add(allStudents.getEntry(i));
            }
            else if (allStudents.getEntry(i).getHobby().equals("art"))
            {
                artStudents.add(allStudents.getEntry(i));
            }
            else if (allStudents.getEntry(i).getHobby().equals("music"))
            {
                musicStudents.add(allStudents.getEntry(i));
            }
        }

        for (int i = 1; i <= songs.getLength(); i++)
        {
            System.out.println(songs.getEntry(i).toString());

            int sportsHeardNum = 0;
            int sportsLikeNum = 0;

            for (int x = 1; x <= sportsStudents.getLength(); x++)
            {
                if (sportsStudents.getEntry(x).getSongsHeard().contains(songs
                    .getEntry(i)))
                {
                    sportsHeardNum++;
                }
                if (sportsStudents.getEntry(x).getSongsLike().contains(songs
                    .getEntry(i)))
                {
                    sportsLikeNum++;
                }
            }

            int readingHeardNum = 0;
            int readingLikeNum = 0;

            for (int x = 1; x <= readingStudents.getLength(); x++)
            {
                if (readingStudents.getEntry(x).getSongsHeard().contains(songs
                    .getEntry(i)))
                {
                    readingHeardNum++;
                }
                if (readingStudents.getEntry(x).getSongsLike().contains(songs
                    .getEntry(i)))
                {
                    readingLikeNum++;
                }
            }

            int artHeardNum = 0;
            int artLikeNum = 0;

            for (int x = 1; x <= artStudents.getLength(); x++)
            {
                if (artStudents.getEntry(x).getSongsHeard().contains(songs
                    .getEntry(i)))
                {
                    artHeardNum++;
                }
                if (artStudents.getEntry(x).getSongsLike().contains(songs
                    .getEntry(i)))
                {
                    artLikeNum++;
                }
            }

            int musicHeardNum = 0;
            int musicLikeNum = 0;

            for (int x = 1; x <= musicStudents.getLength(); x++)
            {
                if (musicStudents.getEntry(x).getSongsHeard().contains(songs
                    .getEntry(i)))
                {
                    musicHeardNum++;
                }
                if (musicStudents.getEntry(x).getSongsLike().contains(songs
                    .getEntry(i)))
                {
                    musicLikeNum++;
                }
            }
            int pertsportsHeard = (sportsHeardNum * 100) / sportsStudents.getLength();
            int pertsportsLike = (sportsLikeNum * 100) / sportsStudents.getLength();

            int pertreadingHeard = (readingHeardNum * 100) / readingStudents.getLength();
            int pertreadingLike =(readingLikeNum * 100)/ readingStudents.getLength();

            int pertartHeard = (artHeardNum * 100) / artStudents.getLength();
            int pertartLike = (artLikeNum * 100) / artStudents.getLength();

            int pertmusicHeard = (musicHeardNum * 100) / musicStudents.getLength();
            int pertmusicLike = (musicLikeNum * 100) / musicStudents.getLength();

            System.out.println("heard");
            System.out.println("reading" + pertreadingHeard + " art"
                + pertartHeard + " sports" + pertsportsHeard + " music"
                + pertmusicHeard);
            System.out.println("like");
            System.out.println("reading" + pertreadingLike + " art"
                + pertartLike + " sports" + pertsportsLike + " music"
                + pertmusicLike);
        }
        
        
//        songs.insertSort(genreComparator);
//        System.out.println(songs);
//        
//        songs.insertSort(titleComparator);
//        System.out.println(songs);
//        
//        songs.insertSort(artistComparator);
//        System.out.println(songs);
        
        songs.insertSort(yearComparator);
        System.out.println(songs);

    }
    
   

}
