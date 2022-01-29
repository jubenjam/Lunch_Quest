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
    
    public void setText(){
         GreenfootImage img = new GreenfootImage(600, 400);
         img.setColor(Color.BLUE);
         img.fill();
         img.setColor(Color.WHITE);
         img.setFont(new Font("OptimusPrinceps", false, false , 30));
         img.drawString("Elmer the Hungry Engineer", 120, 100);
         img.setFont(new Font("OptimusPrinceps", false, false , 20));
         img.drawString("by Juan Benjamin and Barrett Lo", 150, 130);
         img.drawString("Move Elmer using the arrow keys", 145, 190);
         img.drawString("Press Space to close dialogue boxes", 130, 210);
         img.drawString("Press Space to continue", 190, 230);         
         setImage(img);
    }
    public void act()
    {
        if (Greenfoot.isKeyDown("space"))
        {                        
            while(Greenfoot.isKeyDown("space")){}
            ((MyWorld)getWorld()).title = false;
            ((MyWorld)getWorld()).createGoal();
            getWorld().removeObject(this);
        }    
    }
}
