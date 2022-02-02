import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Timer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Timer extends Actor
{
    /**
     * Act - do whatever the Timer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int frames = 0;
    private int seconds = 0;
    private int minutes = 0;
    
    public void reset()
    {
        frames = 0;
        seconds = 0;
        minutes = 0;
    }
    
    public int getSeconds()
    {
        return seconds;
    }
    
    public int getMinutes()
    {
        return minutes;
    }
    
    public void act()
    {
        if (!((MyWorld)getWorld()).textOnScreen)
        {
            frames++;
            if(frames == 60){
                frames = 0;
                seconds++;
            }
            if(seconds == 60){
                seconds = 0;
                minutes++;
            }
            ((MyWorld)getWorld()).showText(minutes+":"+String.format("%02d", seconds), 50, 30);
        }
    }
}
