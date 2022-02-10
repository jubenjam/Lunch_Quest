import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleWorld extends MyWorld
{

    /**
     * Constructor for objects of class TitleWorld.
     * 
     */
    public TitleWorld()
    {
        super(600, 400, 1, false);
        setBackground("title-screen.png");
        
        level = 0;
    }
    
    public void act()
    {
        if (Greenfoot.isKeyDown("space"))
        {
            while (Greenfoot.isKeyDown("space"));
            super.title = false;
            nextLevel();
        }    
    }
}
