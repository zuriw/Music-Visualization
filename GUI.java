package pj5;

import java.awt.Color;
import java.io.FileNotFoundException;
import CS2114.Button;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;
import CS2114.WindowSide;

/**
 * This class creates a User Interface that will display Each Song by its
 * respective categories. It will also sort these Songs by the Sorting Buttons
 * provided.
 * 
 * @author usmana,zuri
 * @version 11/30/2016
 */
public class GUI
{
    private Button           buttonExit;
    private Button           buttonHobbies;
    private Button           buttonMajor;
    private Button           buttonRegion;
    private Button           buttonPrevious;
    private Button           buttonNext;
    private Button           buttonSortArtist;
    private Button           buttonSortSongTitle;
    private Button           buttonSortYear;
    private Button           buttonSortGenre;
    private Window           mainWindow;
    private LList<Song>      allSongs;
    private LList<Student>   allStudents;
    private int              firstSongIndex;
    private final static int disBetweenSongX = 70;
    private final static int disBetweenSongY = 70;
    private final static int pertBarHeight   = 5;
    private final static int blackBarHeight  = pertBarHeight * 4;
    private final static int blackBarWidth   = 2;
    private int              representNum;


    /**
     * Constructor of GUI
     * @param songsIn LinkedList of Songs
     * @param studentsIn LinkedList of Students
     */
    public GUI(LList<Song> songsIn, LList<Student> studentsIn)
    {
        mainWindow = new Window("Project 5");
        buttonExit = new Button("Quit");
        buttonHobbies = new Button("Represent Hobby");
        buttonMajor = new Button("Represent Major");
        buttonRegion = new Button("Represent Region");
        buttonPrevious = new Button("Prev");
        buttonNext = new Button("Next");
        buttonSortArtist = new Button("Sort by Artist Name");
        buttonSortSongTitle = new Button("Sort by Song Title");
        buttonSortYear = new Button("Sort by Release Year");
        buttonSortGenre = new Button("Sort by Genre");

        buttonExit.onClick(this, "clickedExit");
        buttonHobbies.onClick(this, "clickedHobbies");
        buttonMajor.onClick(this, "clickedMajor");
        buttonRegion.onClick(this, "clickedRegion");
        buttonPrevious.onClick(this, "clickedPrevious");
        buttonNext.onClick(this, "clickedNext");
        buttonSortArtist.onClick(this, "clickedSortByArtist");
        buttonSortSongTitle.onClick(this, "clickedSortBySongTitle");
        buttonSortYear.onClick(this, "clickedSortByYear");
        buttonSortGenre.onClick(this, "clickedSortByGenre");

        mainWindow.addButton(buttonPrevious, WindowSide.NORTH);
        mainWindow.addButton(buttonSortArtist, WindowSide.NORTH);
        mainWindow.addButton(buttonSortSongTitle, WindowSide.NORTH);
        mainWindow.addButton(buttonSortYear, WindowSide.NORTH);
        mainWindow.addButton(buttonSortGenre, WindowSide.NORTH);
        mainWindow.addButton(buttonNext, WindowSide.NORTH);
        mainWindow.addButton(buttonHobbies, WindowSide.SOUTH);
        mainWindow.addButton(buttonMajor, WindowSide.SOUTH);
        mainWindow.addButton(buttonRegion, WindowSide.SOUTH);
        mainWindow.addButton(buttonExit, WindowSide.SOUTH);

        allSongs = songsIn;
        allStudents = studentsIn;

        representNum = 1;
        getPercentage();
        firstSongIndex = 1;
        createNineCharts();

        // representNum = 1 Hobby
        // representNum = 2 Major
        // representNum = 3 Region

    }


    /**
     * creates the charts to be displayed in the Window
     */
    public void createNineCharts()
    {
        int titlex = 30;
        int titley = 15;
        for (int i = firstSongIndex; i < firstSongIndex + 9 && i <= allSongs
            .getLength(); i++)
        {
            String title = allSongs.getEntry(i).getTitle();
            String artist = allSongs.getEntry(i).getArtist();

            TextShape songTitleShape = new TextShape(titlex, titley, title,
                Color.BLACK);
            TextShape songArtistShape = new TextShape(titlex, titley
                + songTitleShape.getHeight(), artist, Color.BLACK);
            Shape blackBar = new Shape(titlex + (songTitleShape.getWidth() / 2),
                songArtistShape.getY() + 5 + songArtistShape.getHeight(),
                blackBarWidth, blackBarHeight, Color.BLACK);
            int pinkHeardWidth = 0;
            int greenHeardWidth = 0;
            int blueHeardWidth = 0;
            int orangeHeardWidth = 0;
            switch (representNum)
            {
                case 1:
                    pinkHeardWidth = allSongs.getEntry(i).getPertsportsHeard()
                        / 10;
                    greenHeardWidth = allSongs.getEntry(i).getPertreadingHeard()
                        / 10;
                    blueHeardWidth = allSongs.getEntry(i).getPertartHeard()
                        / 10;
                    orangeHeardWidth = allSongs.getEntry(i).getPertmusicHeard()
                        / 10;
                case 2:
                    pinkHeardWidth = allSongs.getEntry(i).getPertCsHeard() / 10;
                    greenHeardWidth = allSongs.getEntry(i).getPertCmdaHeard()
                        / 10;
                    blueHeardWidth = allSongs.getEntry(i).getPertOtherEngHeard()
                        / 10;
                    orangeHeardWidth = allSongs.getEntry(i).getPertOtherHeard()
                        / 10;
                case 3:
                    pinkHeardWidth = allSongs.getEntry(i).getPertNeHeard() / 10;
                    greenHeardWidth = allSongs.getEntry(i).getPertSeHeard()
                        / 10;
                    blueHeardWidth = allSongs.getEntry(i).getPertUsHeard() / 10;
                    orangeHeardWidth = allSongs.getEntry(i)
                        .getPertOutsideUsHeard() / 10;
            }

            Shape pinkHeardBar = new Shape(blackBar.getX() - pinkHeardWidth,
                blackBar.getY(), pinkHeardWidth, pertBarHeight, Color.PINK);
            Shape greenHeardBar = new Shape(blackBar.getX() - greenHeardWidth,
                blackBar.getY() + pertBarHeight, greenHeardWidth, pertBarHeight,
                Color.GREEN);
            Shape blueHeardBar = new Shape(blackBar.getX() - blueHeardWidth,
                blackBar.getY() + (pertBarHeight * 2), blueHeardWidth,
                pertBarHeight, Color.BLUE);
            Shape orangeHeardBar = new Shape(blackBar.getX() - orangeHeardWidth,
                blackBar.getY() + (pertBarHeight * 3), orangeHeardWidth,
                pertBarHeight, Color.ORANGE);

            if ((i % 3) == 0)
            {
                titlex = 30;
                titley += disBetweenSongY + songTitleShape.getHeight();
            }
            else
            {
                titlex += disBetweenSongX + songTitleShape.getWidth();
            }

            mainWindow.addShape(songTitleShape);
            mainWindow.addShape(songArtistShape);
            mainWindow.addShape(blackBar);
            mainWindow.addShape(pinkHeardBar);
            mainWindow.addShape(greenHeardBar);
            mainWindow.addShape(blueHeardBar);
            mainWindow.addShape(orangeHeardBar);
        }

        firstSongIndex += 9;
    }


    /**
     * gets the percentages of each Student
     */
    public void getPercentage()
    {
        LList<Student> sportsStudents = new LList<Student>();
        LList<Student> readingStudents = new LList<Student>();
        LList<Student> artStudents = new LList<Student>();
        LList<Student> musicStudents = new LList<Student>();

        LList<Student> csStudents = new LList<Student>();
        LList<Student> cmdaStudents = new LList<Student>();
        LList<Student> otherEngStudents = new LList<Student>();
        LList<Student> otherStudents = new LList<Student>();

        LList<Student> neStudents = new LList<Student>();
        LList<Student> seStudents = new LList<Student>();
        LList<Student> usStudents = new LList<Student>();
        LList<Student> outsideUsStudents = new LList<Student>();

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

            if (allStudents.getEntry(i).getMajor().equals("Math or CMDA"))
            {
                cmdaStudents.add(allStudents.getEntry(i));
            }
            else if (allStudents.getEntry(i).getMajor().equals(
                "Computer Science"))
            {
                csStudents.add(allStudents.getEntry(i));
            }
            else if (allStudents.getEntry(i).getMajor().equals(
                "Other Engineering"))
            {
                otherEngStudents.add(allStudents.getEntry(i));
            }
            else if (allStudents.getEntry(i).getMajor().equals("Other"))
            {
                otherStudents.add(allStudents.getEntry(i));
            }

            if (allStudents.getEntry(i).getRegion().equals("Northeast"))
            {
                neStudents.add(allStudents.getEntry(i));
            }
            else if (allStudents.getEntry(i).getRegion().equals("Southeast"))
            {
                seStudents.add(allStudents.getEntry(i));
            }
            else if (allStudents.getEntry(i).getRegion().equals(
                "United States (other than Southeast or Northwest)"))
            {
                usStudents.add(allStudents.getEntry(i));
            }
            else if (allStudents.getEntry(i).getRegion().equals(
                "Outside of United States"))
            {
                outsideUsStudents.add(allStudents.getEntry(i));
            }

        }

        for (int i = 1; i <= allSongs.getLength(); i++)
        {
            // get hobby percentages
            int sportsHeardNum = 0;
            int sportsLikeNum = 0;

            for (int x = 1; x <= sportsStudents.getLength(); x++)
            {
                if (sportsStudents.getEntry(x).getSongsHeard().contains(allSongs
                    .getEntry(i)))
                {
                    sportsHeardNum++;
                }
                if (sportsStudents.getEntry(x).getSongsLike().contains(allSongs
                    .getEntry(i)))
                {
                    sportsLikeNum++;
                }
            }

            int readingHeardNum = 0;
            int readingLikeNum = 0;

            for (int x = 1; x <= readingStudents.getLength(); x++)
            {
                if (readingStudents.getEntry(x).getSongsHeard().contains(
                    allSongs.getEntry(i)))
                {
                    readingHeardNum++;
                }
                if (readingStudents.getEntry(x).getSongsLike().contains(allSongs
                    .getEntry(i)))
                {
                    readingLikeNum++;
                }
            }

            int artHeardNum = 0;
            int artLikeNum = 0;

            for (int x = 1; x <= artStudents.getLength(); x++)
            {
                if (artStudents.getEntry(x).getSongsHeard().contains(allSongs
                    .getEntry(i)))
                {
                    artHeardNum++;
                }
                if (artStudents.getEntry(x).getSongsLike().contains(allSongs
                    .getEntry(i)))
                {
                    artLikeNum++;
                }
            }

            int musicHeardNum = 0;
            int musicLikeNum = 0;

            for (int x = 1; x <= musicStudents.getLength(); x++)
            {
                if (musicStudents.getEntry(x).getSongsHeard().contains(allSongs
                    .getEntry(i)))
                {
                    musicHeardNum++;
                }
                if (musicStudents.getEntry(x).getSongsLike().contains(allSongs
                    .getEntry(i)))
                {
                    musicLikeNum++;
                }
            }

            // get Major percentages

            int csHeardNum = 0;
            int csLikeNum = 0;

            for (int x = 1; x <= csStudents.getLength(); x++)
            {
                if (csStudents.getEntry(x).getSongsHeard().contains(allSongs
                    .getEntry(i)))
                {
                    csHeardNum++;
                }
                if (csStudents.getEntry(x).getSongsLike().contains(allSongs
                    .getEntry(i)))
                {
                    csLikeNum++;
                }
            }

            int cmdaHeardNum = 0;
            int cmdaLikeNum = 0;

            for (int x = 1; x <= cmdaStudents.getLength(); x++)
            {
                if (cmdaStudents.getEntry(x).getSongsHeard().contains(allSongs
                    .getEntry(i)))
                {
                    cmdaHeardNum++;
                }
                if (cmdaStudents.getEntry(x).getSongsLike().contains(allSongs
                    .getEntry(i)))
                {
                    cmdaLikeNum++;
                }
            }

            int otherEngHeardNum = 0;
            int otherEngLikeNum = 0;

            for (int x = 1; x <= otherEngStudents.getLength(); x++)
            {
                if (otherEngStudents.getEntry(x).getSongsHeard().contains(
                    allSongs.getEntry(i)))
                {
                    otherEngHeardNum++;
                }
                if (otherEngStudents.getEntry(x).getSongsLike().contains(
                    allSongs.getEntry(i)))
                {
                    otherEngLikeNum++;
                }
            }

            int otherHeardNum = 0;
            int otherLikeNum = 0;

            for (int x = 1; x <= otherStudents.getLength(); x++)
            {
                if (otherStudents.getEntry(x).getSongsHeard().contains(allSongs
                    .getEntry(i)))
                {
                    otherHeardNum++;
                }
                if (otherStudents.getEntry(x).getSongsLike().contains(allSongs
                    .getEntry(i)))
                {
                    otherLikeNum++;
                }
            }

            // get Region percentages

            int neHeardNum = 0;
            int neLikeNum = 0;

            for (int x = 1; x <= neStudents.getLength(); x++)
            {
                if (neStudents.getEntry(x).getSongsHeard().contains(allSongs
                    .getEntry(i)))
                {
                    neHeardNum++;
                }
                if (neStudents.getEntry(x).getSongsLike().contains(allSongs
                    .getEntry(i)))
                {
                    neLikeNum++;
                }
            }

            int seHeardNum = 0;
            int seLikeNum = 0;

            for (int x = 1; x <= seStudents.getLength(); x++)
            {
                if (seStudents.getEntry(x).getSongsHeard().contains(allSongs
                    .getEntry(i)))
                {
                    seHeardNum++;
                }
                if (seStudents.getEntry(x).getSongsLike().contains(allSongs
                    .getEntry(i)))
                {
                    seLikeNum++;
                }
            }

            int usHeardNum = 0;
            int usLikeNum = 0;

            for (int x = 1; x <= usStudents.getLength(); x++)
            {
                if (usStudents.getEntry(x).getSongsHeard().contains(allSongs
                    .getEntry(i)))
                {
                    usHeardNum++;
                }
                if (usStudents.getEntry(x).getSongsLike().contains(allSongs
                    .getEntry(i)))
                {
                    usLikeNum++;
                }
            }

            int outsideUsHeardNum = 0;
            int outsideUsLikeNum = 0;

            for (int x = 1; x <= outsideUsStudents.getLength(); x++)
            {
                if (outsideUsStudents.getEntry(x).getSongsHeard().contains(
                    allSongs.getEntry(i)))
                {
                    outsideUsHeardNum++;
                }
                if (outsideUsStudents.getEntry(x).getSongsLike().contains(
                    allSongs.getEntry(i)))
                {
                    outsideUsLikeNum++;
                }
            }

            // calculation for Hobby percentages
            allSongs.getEntry(i).setPertsportsHeard((sportsHeardNum * 100)
                / sportsStudents.getLength());
            allSongs.getEntry(i).setPertsportsLike((sportsLikeNum * 100)
                / sportsStudents.getLength());

            allSongs.getEntry(i).setPertreadingHeard((readingHeardNum * 100)
                / readingStudents.getLength());
            allSongs.getEntry(i).setPertreadingLike((readingLikeNum * 100)
                / readingStudents.getLength());

            allSongs.getEntry(i).setPertartHeard((artHeardNum * 100)
                / artStudents.getLength());
            allSongs.getEntry(i).setPertartLike((artLikeNum * 100) / artStudents
                .getLength());

            allSongs.getEntry(i).setPertmusicHeard((musicHeardNum * 100)
                / musicStudents.getLength());
            allSongs.getEntry(i).setPertmusicLike((musicLikeNum * 100)
                / musicStudents.getLength());

            // calculation for Major percentages
            allSongs.getEntry(i).setPertCsHeard((csHeardNum * 100) / csStudents
                .getLength());
            allSongs.getEntry(i).setPertCsLike((csLikeNum * 100) / csStudents
                .getLength());

            allSongs.getEntry(i).setPertCmdaHeard((cmdaHeardNum * 100)
                / cmdaStudents.getLength());
            allSongs.getEntry(i).setPertCmdaLike((cmdaLikeNum * 100)
                / cmdaStudents.getLength());

            allSongs.getEntry(i).setPertOtherEngHeard((otherEngHeardNum * 100)
                / otherEngStudents.getLength());
            allSongs.getEntry(i).setPertOtherEngLike((otherEngLikeNum * 100)
                / otherEngStudents.getLength());

            allSongs.getEntry(i).setPertOtherHeard((otherHeardNum * 100)
                / otherStudents.getLength());
            allSongs.getEntry(i).setPertOtherLike((otherLikeNum * 100)
                / otherStudents.getLength());

            // calculation for Region percentages
            allSongs.getEntry(i).setPertNeHeard((neHeardNum * 100) / neStudents
                .getLength());
            allSongs.getEntry(i).setPertNeLike((neLikeNum * 100) / neStudents
                .getLength());

            allSongs.getEntry(i).setPertSeHeard((seHeardNum * 100) / seStudents
                .getLength());
            allSongs.getEntry(i).setPertSeLike((seLikeNum * 100) / seStudents
                .getLength());

            allSongs.getEntry(i).setPertUsHeard((usHeardNum * 100) / usStudents
                .getLength());
            allSongs.getEntry(i).setPertUsLike((usLikeNum * 100) / usStudents
                .getLength());

            allSongs.getEntry(i).setPertOutsideUsHeard((outsideUsHeardNum * 100)
                / outsideUsStudents.getLength());
            allSongs.getEntry(i).setPertOutsideUsLike((outsideUsLikeNum * 100)
                / outsideUsStudents.getLength());
        }
    }


    /**
     * Exits the program
     * @param button
     */
    public void clickedExit(Button button)
    {
        System.exit(0);
    }

}
