import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelPrompt here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelPrompt extends Actor
{
    /**
     * Act - do whatever the LevelPrompt wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int delay_count = 0;
    public void setText(int level){
         GreenfootImage img = new GreenfootImage("Level-" + String.valueOf(level) + ".png");
         setImage(img);
    }
    public void act()
    {
        delay_count += 1;
        if (delay_count >= 100)
        {                        
            getWorld().removeObject(this);
        }    
    }
}
