import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Credits here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Credits extends MyWorld
{
    private GreenfootImage bg;

    /**
     * Constructor for objects of class Credits.
     * 
     */
    public Credits()
    {
        super(600, 400, 1, false);
        setBackground("end-background.png");
        bg = getBackground();
        
        level = 8;
        
        prepareLevel();
    }
    
    public void prepareLevel()
    {        
        bg.setColor(Color.WHITE);
        bg.setFont(new Font("OptimusPrinceps", false, false , 30));
        bg.drawString("PLACEHOLDER CREDITS", 120, 100);
    }
    
    public void act()
    {
        if (Greenfoot.isKeyDown("space"))
        {
            while (Greenfoot.isKeyDown("space"));
            super.title = false;
            reset();
        }    
    }
    
}
