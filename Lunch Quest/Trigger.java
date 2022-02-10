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
            ((MyWorld)getWorld()).textOnScreen = true;
            
            Actor screenFade = getOneIntersectingObject(ScreenFade.class);
            int currImg = 15;
            if (screenFade != null)
            {
               currImg = ((ScreenFade)screenFade).play();
            }
            
            if (currImg == 9)
            {
                ((MyWorld)getWorld()).createDialogue(text);
                ((MyWorld)getWorld()).nextLevel();
            }
        }
        
    }
}
