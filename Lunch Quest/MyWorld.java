import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public Lunch lunch;
    public Engineer engineer;
    public Timer timer;
    public ScreenFade screenFade;
    
    public boolean textOnScreen = false;
    public boolean title = false;
    public int level = 0;
    public boolean finaldia = false;
    
    static GreenfootSound music = new GreenfootSound("AcidJazz.mp3");
    
    protected List<Laser> laserList;

    public MyWorld(int worldWidth, int worldHeight, int cellSize, boolean bounded)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        
        prepare();
    }
    
    public void act(){
        if (!textOnScreen)
        {
            if (Greenfoot.isKeyDown("f"))
            {
                while(Greenfoot.isKeyDown("f"));
                skip();
            }
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    protected void prepare()
    {
        laserList = new ArrayList<Laser>();
        
        screenFade = new ScreenFade();
        addObject(screenFade, 300, 200);
    }
    
    public void started()
    {
        music.playLoop();
    }
    
    public void stopped()
    {
        music.pause();
    }
    
    /**
     *  Create goal at x and y location.
     */
    public void createGoal(int x, int y){
        lunch = new Lunch();
        addObject(lunch,x, y); // 100, 200
    }
    
    protected void renderLevelPrompt()
    {
        LevelPrompt levelPrompt = new LevelPrompt();
        levelPrompt.setText(level);
        addObject(levelPrompt,300, 200);
    }
    
    protected void LaserBuilder(int delay, int on, int off, int x, int y){
        Laser laser = new Laser(delay, on, off);
        laserList.add(laser);
        addObject(laser,x,y);
    }
    
    public void createDialogue(String text)
    {
        Dialogue_box dialogue_box = new Dialogue_box();
        addObject(dialogue_box, 300, 200);
        dialogue_box.setDialogue(text);
    }
    
    protected void win()
    {
    }
    
    public void skip(){
        nextLevel();        
    }
    
    public void reset()
    {
        Greenfoot.setWorld(new TitleWorld());
    }
    
    protected void ground()
    {
        TopLeft topLeft = new TopLeft();
        addObject(topLeft,16,385);
        int spot = 16 + 32;
        while (spot < this.getWidth() - 16){
            TopMid topMid = new TopMid();
            addObject(topMid,spot,385);
            spot += 32;
        }
        TopRight topRight = new TopRight();
        addObject(topRight,spot,385);
    }
    
    protected void platform(int x, int y, int width){
        TopLeft topLeft = new TopLeft();
        addObject(topLeft,x,y);
        BotLeft botLeft = new BotLeft();
        addObject(botLeft,x,y+32);
        int i=1;
        x+=32;
        while(i < width - 1){
            TopMid topMid = new TopMid();
            addObject(topMid,x,y);
            BotMid botMid = new BotMid();
            addObject(botMid,x,y+32);
            i+=1;
            x+=32;
        }
        TopRight topRight = new TopRight();
        addObject(topRight,x,y);
        BotRight botRight = new BotRight();
        addObject(botRight,x,y+32);
    }
    
    protected void platform2(int x, int y, int width){
        Left left = new Left();
        addObject(left,x,y);
        int i=1;
        x+=32;
        while(i < width - 1){
            Mid mid = new Mid();
            addObject(mid,x,y);
            i+=1;
            x+=32;
        }
        Right right = new Right();
        addObject(right,x,y);
    }
    
    protected void prepareLevel()
    {
    }
    
    protected void nextLevel()
    {
        switch (++level) {
            case 0:     Greenfoot.setWorld(new TitleWorld());
                        break;
                        
            case 1:     Greenfoot.setWorld(new Level1());
                        screenFade.fadeIn();
                        break;
                        
            case 2:     Greenfoot.setWorld(new Level2(timer));
                        break;
                        
            case 3:     Greenfoot.setWorld(new Level3(timer));
                        break;
                        
            case 4:     Greenfoot.setWorld(new Level4(timer));
                        break;
                        
            case 5:     Greenfoot.setWorld(new Level5(timer));
                        break;
                        
            case 6:     Greenfoot.setWorld(new Level6(timer));
                        break;
                        
            case 7:     Greenfoot.setWorld(new EndScreenWorld(timer));
                        break;
                        
            case 8:     Greenfoot.setWorld(new Credits());
                        break;
                        
            default:    break;
        }
    }
    
    public void act(){
        if (!textOnScreen)
        {
            if (Greenfoot.isKeyDown("f"))
            {
                while(Greenfoot.isKeyDown("f"));
                skip();
            }
        }
    }
}
