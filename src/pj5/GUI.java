package pj5;

import java.awt.Color;
import java.io.FileNotFoundException;
import CS2114.Button;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;
import CS2114.WindowSide;

/**
 * This class executes the front end GUI of the program
 * 
 * @author zuriw, jchu247
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

    private CompareGenre     genreComparator;
    private CompareArtist    artistComparator;
    private CompareTitle     titleComparator;
    private CompareYear      yearComparator;
    
    private Shape legend1;
    private Shape legend2;
    private Shape legend3;
    private Shape legend4; 
    private Shape blackBar;
    private TextShape options1;
    private TextShape options2; 
    private TextShape options3;
    private TextShape options4;
    private TextShape TitleOfSong;
    private TextShape heard;
    private TextShape likes;
    private TextShape isLegend;

    /**
     * This is the GUI constructor that adds all the buttons and 
     * initially sets up the gui
     * @param songsIn the list of songs
     * @param studentsIn the list of students
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
        buttonSortSongTitle.onClick(this, "clickedSortByTitle");
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

        genreComparator = new CompareGenre();
        artistComparator = new CompareArtist();
        titleComparator = new CompareTitle();
        yearComparator = new CompareYear();

        // representNum = 1 Hobby
        // representNum = 2 Major
        // representNum = 3 Region
        representNum = 1;
        getPercentage();
        firstSongIndex = 1;
        createNineCharts();
    }

    /**
     * The createNineCharts method creates the nine charts 
     * based on hobby, major, or region. 
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
            int REDHeardWidth = 0;

            int pinkLikeWidth = 0;
            int greenLikeWidth = 0;
            int blueLikeWidth = 0;
            int REDLikeWidth = 0;
            switch (representNum)
            {
                case 1:
                    pinkHeardWidth = allSongs.getEntry(i).getPertsportsHeard()
                        / 10;
                    greenHeardWidth = allSongs.getEntry(i).getPertreadingHeard()
                        / 10;
                    blueHeardWidth = allSongs.getEntry(i).getPertartHeard()
                        / 10;
                    REDHeardWidth = allSongs.getEntry(i).getPertmusicHeard()
                        / 10;

                    pinkLikeWidth = allSongs.getEntry(i).getPertsportsLike()
                        / 10;
                    greenLikeWidth = allSongs.getEntry(i).getPertreadingLike()
                        / 10;
                    blueLikeWidth = allSongs.getEntry(i).getPertartLike() / 10;
                    REDLikeWidth = allSongs.getEntry(i).getPertmusicLike()
                        / 10;

//                    pinkHeardWidth = allSongs.getEntry(i).getPertsportsHeard();
//                    greenHeardWidth = allSongs.getEntry(i)
//                        .getPertreadingHeard();
//                    blueHeardWidth = allSongs.getEntry(i).getPertartHeard();
//                    REDHeardWidth = allSongs.getEntry(i).getPertmusicHeard();
//
//                    pinkLikeWidth = allSongs.getEntry(i).getPertsportsLike();
//                    greenLikeWidth = allSongs.getEntry(i).getPertreadingLike();
//                    blueLikeWidth = allSongs.getEntry(i).getPertartLike() / 10;
//                    REDLikeWidth = allSongs.getEntry(i).getPertmusicLike();
                    break;
                case 2:
                    pinkHeardWidth = allSongs.getEntry(i).getPertCsHeard() / 10;
                    greenHeardWidth = allSongs.getEntry(i).getPertCmdaHeard()
                        / 10;
                    blueHeardWidth = allSongs.getEntry(i).getPertOtherEngHeard()
                        / 10;
                    REDHeardWidth = allSongs.getEntry(i).getPertOtherHeard()
                        / 10;

                    pinkLikeWidth = allSongs.getEntry(i).getPertCsLike() / 10;
                    greenLikeWidth = allSongs.getEntry(i).getPertCmdaLike()
                        / 10;
                    blueLikeWidth = allSongs.getEntry(i).getPertOtherEngLike()
                        / 10;
                    REDLikeWidth = allSongs.getEntry(i).getPertOtherLike()
                        / 10;
                    break;
                case 3:
                    pinkHeardWidth = allSongs.getEntry(i).getPertNeLike() / 10;
                    greenHeardWidth = allSongs.getEntry(i).getPertSeLike() / 10;
                    blueHeardWidth = allSongs.getEntry(i).getPertUsLike() / 10;
                    REDHeardWidth = allSongs.getEntry(i)
                        .getPertOutsideUsLike() / 10;

                    pinkLikeWidth = allSongs.getEntry(i).getPertNeLike() / 10;
                    greenLikeWidth = allSongs.getEntry(i).getPertSeLike() / 10;
                    blueLikeWidth = allSongs.getEntry(i).getPertUsLike() / 10;
                    REDLikeWidth = allSongs.getEntry(i)
                        .getPertOutsideUsLike() / 10;
                    break;
            }

            Shape pinkHeardBar = new Shape(blackBar.getX() - pinkHeardWidth,
                blackBar.getY(), pinkHeardWidth, pertBarHeight, Color.PINK);
            Shape greenHeardBar = new Shape(blackBar.getX() - greenHeardWidth,
                blackBar.getY() + pertBarHeight, greenHeardWidth, pertBarHeight,
                Color.GREEN);
            Shape blueHeardBar = new Shape(blackBar.getX() - blueHeardWidth,
                blackBar.getY() + (pertBarHeight * 2), blueHeardWidth,
                pertBarHeight, Color.BLUE);
            Shape REDHeardBar = new Shape(blackBar.getX() - REDHeardWidth,
                blackBar.getY() + (pertBarHeight * 3), REDHeardWidth,
                pertBarHeight, Color.RED);

            Shape pinkLikeBar = new Shape(blackBar.getX() + blackBar.getWidth(),
                blackBar.getY(), pinkLikeWidth, pertBarHeight, Color.PINK);
            Shape greenLikeBar = new Shape(blackBar.getX() + blackBar
                .getWidth(), blackBar.getY() + pertBarHeight, greenLikeWidth,
                pertBarHeight, Color.GREEN);
            Shape blueLikeBar = new Shape(blackBar.getX() + blackBar.getWidth(),
                blackBar.getY() + (pertBarHeight * 2), blueLikeWidth,
                pertBarHeight, Color.BLUE);
            Shape REDLikeBar = new Shape(blackBar.getX() + blackBar
                .getWidth(), blackBar.getY() + (pertBarHeight * 3),
                REDLikeWidth, pertBarHeight, Color.RED);

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
            mainWindow.addShape(REDHeardBar);

            mainWindow.addShape(pinkLikeBar);
            mainWindow.addShape(greenLikeBar);
            mainWindow.addShape(blueLikeBar);
            mainWindow.addShape(REDLikeBar);
        }
        if (firstSongIndex - 9 < 1)
        {
            buttonPrevious.disable();
        }
        else
        {

            buttonPrevious.enable();
        }

        if (firstSongIndex + 9 > allSongs.getLength())
        {
            buttonNext.disable();
        }
        else
        {

            buttonNext.enable();
        }

        firstSongIndex += 9;

        legend1 = new Shape(600, 150, 5, 185, Color.BLACK);
        legend2 = new Shape(720, 150, 5, 185, Color.BLACK);
        legend3 = new Shape(600, 150, 120, 5, Color.BLACK);
        legend4 = new Shape(600, 330, 120, 5, Color.BLACK);
        blackBar = new Shape(665, 280, 10, 40, Color.BLACK);
        TitleOfSong = new TextShape(655, 260, "Song", Color.BLACK);
        heard = new TextShape(610, 290, "Heard", Color.BLACK);
        likes = new TextShape(680, 290, "Likes", Color.BLACK);
        mainWindow.addShape(legend1);
        mainWindow.addShape(legend2);
        mainWindow.addShape(legend3);
        mainWindow.addShape(legend4);
        mainWindow.addShape(blackBar);
        mainWindow.addShape(TitleOfSong);
        mainWindow.addShape(heard);
        mainWindow.addShape(likes);
        if (representNum == 1)
        {
            isLegend = new TextShape(610, 160, "Hobby Legend", Color.BLACK);
            options1 = new TextShape(610, 180, "Sports", Color.PINK);
            options2 = new TextShape(610, 200, "Reading", Color.GREEN);
            options3 = new TextShape(610, 220, "Art", Color.BLUE);
            options4 = new TextShape(610, 240, "Music", Color.RED);
        }
        else if (representNum == 2)
        {
            isLegend = new TextShape(610, 160, "Major Legend", Color.BLACK);
            options1 = new TextShape(610, 180, "Comp Sci", Color.PINK);
            options2 = new TextShape(610, 200, "MATH/CDMA", Color.GREEN);
            options3 = new TextShape(610, 220, "Other Eng", Color.BLUE);
            options4 = new TextShape(610, 240, "Other", Color.RED);
        }
        else if (representNum == 3)
        {
            isLegend = new TextShape(610, 160, "Region Legend", Color.BLACK);
            options1 = new TextShape(610, 180, "NE US", Color.PINK);
            options2 = new TextShape(610, 200, "SE US", Color.GREEN);
            options3 = new TextShape(610, 220, "Rest of US", Color.BLUE);
            options4 = new TextShape(610, 240, "Outside the US", Color.RED);
        }
        mainWindow.addShape(isLegend);
        mainWindow.addShape(options1);
        mainWindow.addShape(options2);
        mainWindow.addShape(options3);
        mainWindow.addShape(options4);
    }

    /**
     * The getPercentage method calculates the percentages 
     * for each chart. 
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
     * The clickedSortByGenre method is executed when the Sort by Genre 
     * button is clicked. It controls what that button does. 
     * @param button Sort by Genre button
     */
    public void clickedSortByGenre(Button button)
    {
        allSongs.insertSort(genreComparator);
        mainWindow.removeAllShapes();
        firstSongIndex = 1;
        createNineCharts();

    }

    /**
     * The clickedSortByTitle method is executed when the Sort by Title
     * button is clicked. It controls what that button does. 
     * @param button Sort by Title button
     */
    public void clickedSortByTitle(Button button)
    {
        allSongs.insertSort(titleComparator);
        mainWindow.removeAllShapes();
        firstSongIndex = 1;
        createNineCharts();

    }

    /**
     * The clickedSortByArtist method is executed when the Sort by artist 
     * button is clicked. It controls what that button does. 
     * @param button Sort by Artist button
     */
    public void clickedSortByArtist(Button button)
    {
        allSongs.insertSort(artistComparator);
        mainWindow.removeAllShapes();
        firstSongIndex = 1;
        createNineCharts();

    }

    /**
     * The clickedSortByYear method is executed when the Sort by Year
     * button is clicked. It controls what that button does. 
     * @param button Sort by Year button
     */
    public void clickedSortByYear(Button button)
    {
        allSongs.insertSort(yearComparator);
        mainWindow.removeAllShapes();
        firstSongIndex = 1;
        createNineCharts();

    }

    /**
     * The clickedExit method is executed when the Quit
     * button is clicked. It controls what that button does. 
     * @param button Quit button
     */
    public void clickedExit(Button button)
    {
        System.exit(0);
    }

    /**
     * The clickedNext method is executed when the Next
     * button is clicked. It controls what that button does. 
     * @param button Next button
     */
    public void clickedNext(Button button)
    {
        mainWindow.removeAllShapes();

        createNineCharts();
    }

    /**
     * The clickedPrevious method is executed when the Previous
     * button is clicked. It controls what that button does. 
     * @param button Previous button
     */
    public void clickedPrevious(Button button)
    {

        mainWindow.removeAllShapes();

        firstSongIndex -= 18;

        createNineCharts();

    }

    /**
     * The clickedMajor method is executed when Represent Major
     * button is clicked. It controls what that button does. 
     * @param button Represent Major button
     */
    public void clickedMajor(Button button)
    {
        representNum = 2;
        mainWindow.removeAllShapes();
        firstSongIndex = 1;
        createNineCharts();
    }

    /**
     * The clickedHobbies method is executed when Represent Hobby
     * button is clicked. It controls what that button does. 
     * @param button Represent Hobby button
     */
    public void clickedHobbies(Button button)
    {
        representNum = 1;
        mainWindow.removeAllShapes();
        firstSongIndex = 1;
        createNineCharts();
    }

    /**
     * The clickedRegion is executed when Represent Region
     * button is clicked. It controls what that button does. 
     * @param button Represent Region button
     */
    public void clickedRegion(Button button)
    {
        representNum = 3;
        mainWindow.removeAllShapes();
        firstSongIndex = 1;
        createNineCharts();
    }
    

}
