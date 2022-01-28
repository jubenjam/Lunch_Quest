import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Color;

/**
 * Write a description of class Dialogue_box here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dialogue_box extends Actor
{
    /**
     * Act - do whatever the Dialogue_box wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //set the text of the dialogue box
    public Profile profile;
    
    public void setDialogue(String test, Profile profileSet){
         GreenfootImage img = new GreenfootImage(600, 75);
         img.setColor(Color.BLUE);
         img.fill();
         img.setColor(Color.WHITE);
         img.setFont(new Font("OptimusPrinceps", false, false , 20));
         img.drawString("Elmer: " + test, 90, 20);
         setImage(img);
         profile = profileSet;
         ((MyWorld)getWorld()).textOnScreen = true;
    }
    //
    public void act()
    {
        if (((MyWorld)getWorld()).title == false && Greenfoot.isKeyDown("space"))
        {                        
            ((MyWorld)getWorld()).textOnScreen = false;
            getWorld().removeObject(profile);
            getWorld().removeObject(this);
        }
    }
}
