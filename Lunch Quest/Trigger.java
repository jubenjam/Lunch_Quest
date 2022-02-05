import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Trigger here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Trigger extends Actor
{
    /**
     * Act - do whatever the Trigger wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public String text = "";
    public void setText(String textSet){
         text = textSet;
    }
    public void act()
    {
        Actor man = getOneIntersectingObject(Engineer.class);
        if(man != null)
        {
            ((MyWorld)getWorld()).createGoal();
            ((MyWorld)getWorld()).createDialogue(text);
            ((MyWorld)getWorld()).engineer.setLocation(45, 340);
            getWorld().removeObject(this);
        }
        
    }
}
