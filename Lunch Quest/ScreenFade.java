import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScreenFade here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScreenFade extends AnimatedActor
{
    private String basename = "fade";
    private boolean playAnimation = false;
    
    public ScreenFade()
    {
        super("fade", "sequence");
        LoadAnimation("sequence", 15);
    }
    
    public void act()
    {
        if (currentImage == 14)
        {
            currentImage = 0;
            playAnimation = false;
        }
        
        if (playAnimation)
        {
            advanceImage();       
            setFrame(currentAnimationKey);
        }
    }
    
    public int play()
    {
        playAnimation = true;
        
        return currentImage;
    }
}
