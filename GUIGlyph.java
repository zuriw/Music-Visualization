package pj5;

import java.awt.Color;

import CS2114.Button;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;
import CS2114.WindowSide;

public class GUIGlyph 
{
    private Button buttonExit;
    private Button buttonHobbies;
    private Button buttonMajor;
    private Button buttonRegion;
    private Button buttonPrevious;
    private Button buttonNext;
    private Button buttonSortArtist;
    private Button buttonSortSongTitle;
    private Button buttonSortYear;
    private Button buttonSortGenre;
    private Window mainWindow;
    private TextShape songTitle1;
    private TextShape songTitle2;
    private TextShape songTitle3;
    private TextShape songTitle4;
    private TextShape songTitle5;
    private TextShape songTitle6;
    private TextShape songTitle7;
    private TextShape songTitle8;
    private TextShape songTitle9;
    private Shape blackBar1;
    private Shape blackBar2;
    private Shape blackBar3;
    private Shape blackBar4;
    private Shape blackBar5;
    private Shape blackBar6;
    private Shape blackBar7;
    private Shape blackBar8;
    private Shape blackBar9;
    private Shape blackBar10; 
    private Shape shapeHeard1;
    private Shape shapeHeard2;
    private Shape shapeHeard3;
    private Shape shapeHeard4;
    private Shape shapeHeard5;
    private Shape shapeHeard6;
    private Shape shapeHeard7;
    private Shape shapeHeard8;
    private Shape shapeHeard9;
    private Shape shapeLikes1;
    private Shape shapeLikes2;
    private Shape shapeLikes3;
    private Shape shapeLikes4;
    private Shape shapeLikes5;
    private Shape shapeLikes6;
    private Shape shapeLikes7;
    private Shape shapeLikes8;
    private Shape shapeLikes9;
    private Shape shapeSport1;
    private Shape shapeSport2;
    private Shape shapeSport3;
    private Shape shapeSport4;
    private Shape shapeSport5;
    private Shape shapeSport6;
    private Shape shapeSport7;
    private Shape shapeSport8;
    private Shape shapeSport9;
    private Shape shapeLegend1;
    private Shape shapeLegend2;
    private Shape shapeLegend3;
    private Shape shapeLegend4;
    private Shape shapeLegend5;
    private Shape shapeLegend6;
    private Shape shapeLegend7;
    private Shape shapeLegend8;
    private Shape shapeLegend9;
    private TextShape isLegend;
    private Shape legend;
    private Shape legend1;
    private Shape legend2;
    private Shape legend3;
    private TextShape options1;
    private TextShape options2;
    private TextShape options3;
    private TextShape options4;
    private TextShape TitleOfSong;
    private TextShape heard;
    private TextShape likes;
    private boolean hasBlackBars;
    private LList<Song> musicReader;
    private LList<Student> surveyReader;
    private int songTracker;
    
    public GUIGlyph(LList<Song> music, LList<Student> survey)
    {
        hasBlackBars = false;
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
        
        musicReader = music;
     
        surveyReader = survey;
        songTracker = 0;
        
        /*blackBar1 = new Shape(100, 50, 10, 40, Color.BLACK);
        blackBar2 = new Shape(300, 50, 10, 40, Color.BLACK);
        blackBar3 = new Shape(500, 50, 10, 40, Color.BLACK);
        blackBar4 = new Shape(100, 150, 10, 40, Color.BLACK);
        blackBar5 = new Shape(300, 150, 10, 40, Color.BLACK);
        blackBar6 = new Shape(500, 150, 10, 40, Color.BLACK);
        blackBar7 = new Shape(100, 250, 10, 40, Color.BLACK);
        blackBar8 = new Shape(300, 250, 10, 40, Color.BLACK);
        blackBar9 = new Shape(500, 250, 10, 40, Color.BLACK);
        blackBar10 = new Shape(665, 280, 10, 40, Color.BLACK);
        songTitle1 = new TextShape(80, 30, "Song 1", Color.BLACK);
        songTitle2 = new TextShape(280, 30, "Song 2", Color.BLACK);
        songTitle3 = new TextShape(480, 30, "Song 3", Color.BLACK);
        songTitle4 = new TextShape(80, 130, "Song 4", Color.BLACK);
        songTitle5 = new TextShape(280, 130, "Song 5", Color.BLACK);
        songTitle6 = new TextShape(480, 130, "Song 6", Color.BLACK);
        songTitle7 = new TextShape(80, 230, "Song 7", Color.BLACK);
        songTitle8 = new TextShape(280, 230, "Song 8", Color.BLACK);
        songTitle9 = new TextShape(480, 230, "Song 9", Color.BLACK);
        shapeHeard1 = new Shape(75, 50, 60, 10, Color.MAGENTA);
        shapeHeard2 = new Shape(275, 50, 60, 10, Color.MAGENTA);
        shapeHeard3 = new Shape(475, 50, 60, 10, Color.MAGENTA);
        shapeHeard4 = new Shape(75, 150, 60, 10, Color.MAGENTA);
        shapeHeard5 = new Shape(275, 150, 60, 10, Color.MAGENTA);
        shapeHeard6 = new Shape(475, 150, 60, 10, Color.MAGENTA);
        shapeHeard7 = new Shape(75, 250, 60, 10, Color.MAGENTA);
        shapeHeard8 = new Shape(275, 250, 60, 10, Color.MAGENTA);
        shapeHeard9 = new Shape(475, 250, 60, 10, Color.MAGENTA);
        shapeLikes1 = new Shape(75, 60, 60, 10, Color.BLUE);
        shapeLikes2 = new Shape(275, 60, 60, 10, Color.BLUE);
        shapeLikes3 = new Shape(475, 60, 60, 10, Color.BLUE);
        shapeLikes4 = new Shape(75, 160, 60, 10, Color.BLUE);
        shapeLikes5 = new Shape(275, 160, 60, 10, Color.BLUE);
        shapeLikes6 = new Shape(475, 160, 60, 10, Color.BLUE);
        shapeLikes7 = new Shape(75, 260, 60, 10, Color.BLUE);
        shapeLikes8 = new Shape(275, 260, 60, 10, Color.BLUE);
        shapeLikes9 = new Shape(475, 260, 60, 10, Color.BLUE);
        shapeSport1 = new Shape(75, 70, 60, 10, Color.YELLOW);
        shapeSport2 = new Shape(275, 70, 60, 10, Color.YELLOW);
        shapeSport3 = new Shape(475, 70, 60, 10, Color.YELLOW);
        shapeSport4 = new Shape(75, 170, 60, 10, Color.YELLOW);
        shapeSport5 = new Shape(275, 170, 60, 10, Color.YELLOW);
        shapeSport6 = new Shape(475, 170, 60, 10, Color.YELLOW);
        shapeSport7 = new Shape(75, 270, 60, 10, Color.YELLOW);
        shapeSport8 = new Shape(275, 270, 60, 10, Color.YELLOW);
        shapeSport9 = new Shape(475, 270, 60, 10, Color.YELLOW);
        shapeLegend1 = new Shape(75, 80, 60, 10, Color.GREEN);
        shapeLegend2 = new Shape(275, 80, 60, 10, Color.GREEN);
        shapeLegend3 = new Shape(475, 80, 60, 10, Color.GREEN);
        shapeLegend4 = new Shape(75, 180, 60, 10, Color.GREEN);
        shapeLegend5 = new Shape(275, 180, 60, 10, Color.GREEN);
        shapeLegend6 = new Shape(475, 180, 60, 10, Color.GREEN);
        shapeLegend7 = new Shape(75, 280, 60, 10, Color.GREEN);
        shapeLegend8 = new Shape(275, 280, 60, 10, Color.GREEN);
        shapeLegend9 = new Shape(475, 280, 60, 10, Color.GREEN);
        
        isLegend = new TextShape(610, 160, "Legend", Color.BLACK);
        options1 = new TextShape(610, 180, "Option 1", Color.MAGENTA);
        options2 = new TextShape(610, 200, "Option 2", Color.BLUE);
        options3 = new TextShape(610, 220, "Option 3", Color.YELLOW);
        options4 = new TextShape(610, 240, "Option 4", Color.GREEN);
        
        
        mainWindow.addShape(blackBar1);
        mainWindow.addShape(blackBar2);
        mainWindow.addShape(blackBar3);
        mainWindow.addShape(blackBar4);
        mainWindow.addShape(blackBar5);
        mainWindow.addShape(blackBar6);
        mainWindow.addShape(blackBar7);
        mainWindow.addShape(blackBar8);
        mainWindow.addShape(blackBar9);
        mainWindow.addShape(songTitle1);
        mainWindow.addShape(songTitle2);
        mainWindow.addShape(songTitle3);
        mainWindow.addShape(songTitle4);
        mainWindow.addShape(songTitle5);
        mainWindow.addShape(songTitle6);
        mainWindow.addShape(songTitle7);
        mainWindow.addShape(songTitle8);
        mainWindow.addShape(songTitle9); 
        mainWindow.addShape(shapeHeard1);
        mainWindow.addShape(shapeHeard2);
        mainWindow.addShape(shapeHeard3);
        mainWindow.addShape(shapeHeard4);
        mainWindow.addShape(shapeHeard5);
        mainWindow.addShape(shapeHeard6);
        mainWindow.addShape(shapeHeard7);
        mainWindow.addShape(shapeHeard8);
        mainWindow.addShape(shapeHeard9);
        mainWindow.addShape(shapeLikes1);
        mainWindow.addShape(shapeLikes2);
        mainWindow.addShape(shapeLikes3);
        mainWindow.addShape(shapeLikes4);
        mainWindow.addShape(shapeLikes5);
        mainWindow.addShape(shapeLikes6);
        mainWindow.addShape(shapeLikes7);
        mainWindow.addShape(shapeLikes8);
        mainWindow.addShape(shapeLikes9);
        mainWindow.addShape(shapeSport1);
        mainWindow.addShape(shapeSport2);
        mainWindow.addShape(shapeSport3);
        mainWindow.addShape(shapeSport4);
        mainWindow.addShape(shapeSport5);
        mainWindow.addShape(shapeSport6);
        mainWindow.addShape(shapeSport7);
        mainWindow.addShape(shapeSport8);
        mainWindow.addShape(shapeSport9);
        mainWindow.addShape(shapeLegend1);
        mainWindow.addShape(shapeLegend2);
        mainWindow.addShape(shapeLegend3);
        mainWindow.addShape(shapeLegend4);
        mainWindow.addShape(shapeLegend5);
        mainWindow.addShape(shapeLegend6);
        mainWindow.addShape(shapeLegend7);
        mainWindow.addShape(shapeLegend8);
        mainWindow.addShape(shapeLegend9);
        
        
        */
    }
    
    public void clickedExit(Button button)
    {
        System.exit(0);
    }
    
    public void clickedNext(Button button)
    {
        mainWindow.removeShape(songTitle1);
        mainWindow.removeShape(songTitle2);
        mainWindow.removeShape(songTitle3);
        mainWindow.removeShape(songTitle4);
        mainWindow.removeShape(songTitle5);
        mainWindow.removeShape(songTitle6);
        mainWindow.removeShape(songTitle7);
        mainWindow.removeShape(songTitle8);
        mainWindow.removeShape(songTitle9);
        songTracker++;
        songTitle1 = new TextShape(80, 30, musicReader.getEntry(1 + 9 * songTracker).getTitle(), Color.BLACK);
        mainWindow.addShape(songTitle1);
        songTitle2 = new TextShape(280, 30, musicReader.getEntry(2 + 9 * songTracker).getTitle(), Color.BLACK);
        mainWindow.addShape(songTitle2);
        songTitle3 = new TextShape(480, 30, musicReader.getEntry(3 + 9 * songTracker).getTitle(), Color.BLACK);
        mainWindow.addShape(songTitle3);
        songTitle4 = new TextShape(80, 130, musicReader.getEntry(4 + 9 * songTracker).getTitle(), Color.BLACK);
        mainWindow.addShape(songTitle4);
        songTitle5 = new TextShape(280, 130, musicReader.getEntry(5 + 9 * songTracker).getTitle(), Color.BLACK);
        mainWindow.addShape(songTitle5);
        songTitle6 = new TextShape(480, 130, musicReader.getEntry(6 + 9 * songTracker).getTitle(), Color.BLACK);
        mainWindow.addShape(songTitle6);
        songTitle7 = new TextShape(80, 230, musicReader.getEntry(7 + 9 * songTracker).getTitle(), Color.BLACK);
        mainWindow.addShape(songTitle7);
        songTitle8 = new TextShape(280, 230, musicReader.getEntry(8 + 9 * songTracker).getTitle(), Color.BLACK);
        mainWindow.addShape(songTitle8);
        songTitle9 = new TextShape(480, 230, musicReader.getEntry(9 + 9 * songTracker).getTitle(), Color.BLACK);
        mainWindow.addShape(songTitle9);
        
    }
    
    public void clickedHobbies(Button button)
    {
        if (!hasBlackBars)
        { 
            drawBlackBars();
            hasBlackBars = true;
            addInitialSongs();
        }
        else
        {
            mainWindow.removeShape(isLegend);
            mainWindow.removeShape(options1);
            mainWindow.removeShape(options2);
            mainWindow.removeShape(options3);
            mainWindow.removeShape(options4);
            mainWindow.removeShape(songTitle1);
            mainWindow.removeShape(songTitle2);
            mainWindow.removeShape(songTitle3);
            mainWindow.removeShape(songTitle4);
            mainWindow.removeShape(songTitle5);
            mainWindow.removeShape(songTitle6);
            mainWindow.removeShape(songTitle7);
            mainWindow.removeShape(songTitle8);
            mainWindow.removeShape(songTitle9);
            addInitialSongs();
        }
        isLegend = new TextShape(610, 160, "Hobby Legend", Color.BLACK);
        options1 = new TextShape(610, 180, "Read", Color.MAGENTA);
        options2 = new TextShape(610, 200, "Art", Color.BLUE);
        options3 = new TextShape(610, 220, "Sports", Color.YELLOW);
        options4 = new TextShape(610, 240, "Music", Color.GREEN);
        mainWindow.addShape(isLegend);
        mainWindow.addShape(options1);
        mainWindow.addShape(options2);
        mainWindow.addShape(options3);
        mainWindow.addShape(options4);

    }
    
    public void clickedMajor(Button button)
    {
        if (!hasBlackBars)
        { 
            drawBlackBars();
            hasBlackBars = true;
            addInitialSongs();
        }
        else
        {
            mainWindow.removeShape(isLegend);
            mainWindow.removeShape(options1);
            mainWindow.removeShape(options2);
            mainWindow.removeShape(options3);
            mainWindow.removeShape(options4);
            mainWindow.removeShape(songTitle1);
            mainWindow.removeShape(songTitle2);
            mainWindow.removeShape(songTitle3);
            mainWindow.removeShape(songTitle4);
            mainWindow.removeShape(songTitle5);
            mainWindow.removeShape(songTitle6);
            mainWindow.removeShape(songTitle7);
            mainWindow.removeShape(songTitle8);
            mainWindow.removeShape(songTitle9);
            addInitialSongs();
        }
        isLegend = new TextShape(610, 160, "Major Legend", Color.BLACK);
        options1 = new TextShape(610, 180, "Comp Sci", Color.MAGENTA);
        options2 = new TextShape(610, 200, "Other Eng", Color.BLUE);
        options3 = new TextShape(610, 220, "Math/CDMA", Color.YELLOW);
        options4 = new TextShape(610, 240, "Other", Color.GREEN);
        mainWindow.addShape(isLegend);
        mainWindow.addShape(options1);
        mainWindow.addShape(options2);
        mainWindow.addShape(options3);
        mainWindow.addShape(options4);
    }
    
    public void clickedRegion(Button button)
    {
        if (!hasBlackBars)
        { 
            drawBlackBars();
            hasBlackBars = true;
            addInitialSongs();
        }
        else
        {
            mainWindow.removeShape(isLegend);
            mainWindow.removeShape(options1);
            mainWindow.removeShape(options2);
            mainWindow.removeShape(options3);
            mainWindow.removeShape(options4);
            mainWindow.removeShape(songTitle1);
            mainWindow.removeShape(songTitle2);
            mainWindow.removeShape(songTitle3);
            mainWindow.removeShape(songTitle4);
            mainWindow.removeShape(songTitle5);
            mainWindow.removeShape(songTitle6);
            mainWindow.removeShape(songTitle7);
            mainWindow.removeShape(songTitle8);
            mainWindow.removeShape(songTitle9);
            addInitialSongs();
        }
        isLegend = new TextShape(610, 160, "Region Legend", Color.BLACK);
        options1 = new TextShape(610, 180, "NE US", Color.MAGENTA);
        options2 = new TextShape(610, 200, "SE US", Color.BLUE);
        options3 = new TextShape(610, 220, "Rest of US", Color.YELLOW);
        options4 = new TextShape(610, 240, "Outside the US", Color.GREEN);
        mainWindow.addShape(isLegend);
        mainWindow.addShape(options1);
        mainWindow.addShape(options2);
        mainWindow.addShape(options3);
        mainWindow.addShape(options4);
    }
    
    public void clickedPrevious(Button button)
    {
        mainWindow.removeShape(songTitle1);
        mainWindow.removeShape(songTitle2);
        mainWindow.removeShape(songTitle3);
        mainWindow.removeShape(songTitle4);
        mainWindow.removeShape(songTitle5);
        mainWindow.removeShape(songTitle6);
        mainWindow.removeShape(songTitle7);
        mainWindow.removeShape(songTitle8);
        mainWindow.removeShape(songTitle9);
        songTracker--;
        songTitle1 = new TextShape(80, 30, musicReader.getEntry(1 + 9 * songTracker).getTitle(), Color.BLACK);
        mainWindow.addShape(songTitle1);
        songTitle2 = new TextShape(280, 30, musicReader.getEntry(2 + 9 * songTracker).getTitle(), Color.BLACK);
        mainWindow.addShape(songTitle2);
        songTitle3 = new TextShape(480, 30, musicReader.getEntry(3 + 9 * songTracker).getTitle(), Color.BLACK);
        mainWindow.addShape(songTitle3);
        songTitle4 = new TextShape(80, 130, musicReader.getEntry(4 + 9 * songTracker).getTitle(), Color.BLACK);
        mainWindow.addShape(songTitle4);
        songTitle5 = new TextShape(280, 130, musicReader.getEntry(5 + 9 * songTracker).getTitle(), Color.BLACK);
        mainWindow.addShape(songTitle5);
        songTitle6 = new TextShape(480, 130, musicReader.getEntry(6 + 9 * songTracker).getTitle(), Color.BLACK);
        mainWindow.addShape(songTitle6);
        songTitle7 = new TextShape(80, 230, musicReader.getEntry(7 + 9 * songTracker).getTitle(), Color.BLACK);
        mainWindow.addShape(songTitle7);
        songTitle8 = new TextShape(280, 230, musicReader.getEntry(8 + 9 * songTracker).getTitle(), Color.BLACK);
        mainWindow.addShape(songTitle8);
        songTitle9 = new TextShape(480, 230, musicReader.getEntry(9 + 9 * songTracker).getTitle(), Color.BLACK);
        mainWindow.addShape(songTitle9);
    }
    
    public void clickedSortByArtist(Button button)
    {
        
    }
    
    public void clickedSortBySongTitle(Button button)
    {
        
    }
    
    public void clickedSortByYear(Button button)
    {
        
    }
    
    public void clickedSortByGenre(Button button)
    {
        
    }
    
    private void drawBlackBars()
    {
        blackBar1 = new Shape(100, 50, 10, 40, Color.BLACK);
        blackBar2 = new Shape(300, 50, 10, 40, Color.BLACK);
        blackBar3 = new Shape(500, 50, 10, 40, Color.BLACK);
        blackBar4 = new Shape(100, 150, 10, 40, Color.BLACK);
        blackBar5 = new Shape(300, 150, 10, 40, Color.BLACK);
        blackBar6 = new Shape(500, 150, 10, 40, Color.BLACK);
        blackBar7 = new Shape(100, 250, 10, 40, Color.BLACK);
        blackBar8 = new Shape(300, 250, 10, 40, Color.BLACK);
        blackBar9 = new Shape(500, 250, 10, 40, Color.BLACK);
        blackBar10 = new Shape(665, 280, 10, 40, Color.BLACK);
        mainWindow.addShape(blackBar1);
        mainWindow.addShape(blackBar2);
        mainWindow.addShape(blackBar3);
        mainWindow.addShape(blackBar4);
        mainWindow.addShape(blackBar5);
        mainWindow.addShape(blackBar6);
        mainWindow.addShape(blackBar7);
        mainWindow.addShape(blackBar8);
        mainWindow.addShape(blackBar9);
        mainWindow.addShape(blackBar10);
        legend1 = new Shape(600, 150, 5, 185, Color.BLACK);
        legend2 = new Shape(720, 150, 5, 185, Color.BLACK);
        legend3 = new Shape(600, 150, 120, 5, Color.BLACK);
        legend = new Shape(600, 330, 120, 5, Color.BLACK);
        mainWindow.addShape(legend);
        mainWindow.addShape(legend1);
        mainWindow.addShape(legend2);
        mainWindow.addShape(legend3);
        TitleOfSong = new TextShape(655, 260, "Song", Color.BLACK);
        heard = new TextShape(610, 290, "Heard", Color.BLACK);
        likes = new TextShape(680, 290, "Likes", Color.BLACK);
        mainWindow.addShape(TitleOfSong);
        mainWindow.addShape(likes);
        mainWindow.addShape(heard);
       
    }
    
    private  void addInitialSongs()
    {
        songTracker = 0;
        songTitle1 = new TextShape(80, 30, musicReader.getEntry(1).getTitle(), Color.BLACK);
        songTitle2 = new TextShape(280, 30, musicReader.getEntry(2).getTitle(), Color.BLACK);
        songTitle3 = new TextShape(480, 30, musicReader.getEntry(3).getTitle(), Color.BLACK);
        songTitle4 = new TextShape(80, 130, musicReader.getEntry(4).getTitle(), Color.BLACK);
        songTitle5 = new TextShape(280, 130, musicReader.getEntry(5).getTitle(), Color.BLACK);
        songTitle6 = new TextShape(480, 130, musicReader.getEntry(6).getTitle(), Color.BLACK);
        songTitle7 = new TextShape(80, 230, musicReader.getEntry(7).getTitle(), Color.BLACK);
        songTitle8 = new TextShape(280, 230, musicReader.getEntry(8).getTitle(), Color.BLACK);
        songTitle9 = new TextShape(480, 230, musicReader.getEntry(9).getTitle(), Color.BLACK);
        mainWindow.addShape(songTitle1);
        mainWindow.addShape(songTitle2);
        mainWindow.addShape(songTitle3);
        mainWindow.addShape(songTitle4);
        mainWindow.addShape(songTitle5);
        mainWindow.addShape(songTitle6);
        mainWindow.addShape(songTitle7);
        mainWindow.addShape(songTitle8);
        mainWindow.addShape(songTitle9);
    }
}

