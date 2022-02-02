import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class AnimatedActor here.
 * 
 * @author Barrett Lo
 * @version 0.1 (January 2022)
 */
public class AnimatedActor extends Actor
{
    public Dictionary<String, GreenfootImage[]> animations = new Hashtable<String, GreenfootImage[]>();
    public String currentAnimationKey;
    public MyWorld myWorld;
    
    public int currentImage = 0;
    private int imageBuffer = 5;
    private String basename;
    
    public AnimatedActor(String basename, String startingKey)
    {
        this.basename = basename;
        
        currentAnimationKey = startingKey;
    }
        
    protected void addedToWorld(World world)
    {
        myWorld = (MyWorld)world;
    }
    
    /**
     * Act - do whatever the AnimatedActor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (!myWorld.textOnScreen)
        {
            advanceImage();       
            setFrame(currentAnimationKey);
        }
    }
    
    /**
     * Must be called at the instatiation!
     */
    public void LoadAnimation(String key, int numOfImages)
    {
        // make Load() methods for each sprite animation
        GreenfootImage[] animL = new GreenfootImage[numOfImages];
        GreenfootImage[] animR = new GreenfootImage[numOfImages];
        String fp_basenameKey = basename + "-" + key;
        
        for(int i = 0; i < numOfImages; i++) {
            animL[i] = new GreenfootImage("./images/" + fp_basenameKey + "/" + fp_basenameKey + "-" + Integer.toString(i) + ".png");
            animR[i] = new GreenfootImage(animL[i]);
            animL[i].mirrorHorizontally();
        }
        
        animations.put(key + "L", animL);
        animations.put(key + "R", animR);
    }
    
    public void advanceImage()
    {
        if (advanceBuffer())
        {
            currentImage = (currentImage + 1) % animations.get(currentAnimationKey).length;
        }
    }
    
    public boolean advanceBuffer() 
    {
        if (imageBuffer < 1)
        {
            imageBuffer = 5;
            return true;
        }
        else
            imageBuffer--;
            
        return false;
    }
    
    public void setFrame(String key)
    {
        GreenfootImage[] sequence = animations.get(currentAnimationKey);
        setImage(sequence[currentImage]);
    }
    
    public void changeAnimation(String key)
    {
        currentAnimationKey = key;
        currentImage = 0;
    }
}
