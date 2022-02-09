import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends Actor
{
    
    /**
     * Act - do whatever the TitleScreen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    
    public void act()
    {
        if (Greenfoot.isKeyDown("space"))
        {                        
            while(Greenfoot.isKeyDown("space")){}
            MyWorld world = (MyWorld)getWorld();
            world.title = false;
            world.addObject(world.timer, 50, 30);
            world.createGoal();
            getWorld().removeObject(this);
        }    
    }
}
