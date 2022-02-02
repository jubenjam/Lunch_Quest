import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Laser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Laser extends AnimatedActor
{
    private String basename = "laser";
    private float startDelay;
    
    private MyWorld myWorld = (MyWorld)getWorld();
    
    public Laser()
    {
        super("laser", "off");
        LoadAnimation("active", 2);
        LoadAnimation("turn-off", 7);
        LoadAnimation("turn-on", 7);
        LoadAnimation("off", 1);
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
