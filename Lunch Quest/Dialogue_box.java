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
    
    public void setDialogue(String fn_dialogue){
         GreenfootImage dialogueBox = new GreenfootImage("./dialogue/dialogue-box.png");
         dialogueBox.drawImage(new GreenfootImage("./dialogue/" + fn_dialogue + ".png"), 110, 335);
         setImage(dialogueBox);
         ((MyWorld)getWorld()).textOnScreen = true;
    }
    //
    public void act()
    {
        if (((MyWorld)getWorld()).title == false && Greenfoot.isKeyDown("space"))
        {
            ((MyWorld)getWorld()).textOnScreen = false;
            if (((MyWorld)getWorld()).level == 6 && ((MyWorld)getWorld()).finaldia == true){
                while(Greenfoot.isKeyDown("space"));
                ((MyWorld)getWorld()).nextLevel();
                ((MyWorld)getWorld()).finaldia = false;
            }
            getWorld().removeObject(this);
        }
        else{
            Mover.run.stop();
        }
    }
}
