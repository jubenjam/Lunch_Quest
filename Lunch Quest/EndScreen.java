import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndScreen extends Actor
{
    public void setText(int min, int sec){
         GreenfootImage img = new GreenfootImage(600, 400);
         img.setColor(Color.BLUE);
         img.fill();
         img.setColor(Color.WHITE);
         img.setFont(new Font("OptimusPrinceps", false, false , 30));
         img.drawString("Congratulations!", 120, 100);
         img.setFont(new Font("OptimusPrinceps", false, false , 20));
         img.drawString("You beat the game in: " + String.valueOf(min) + ":" + String.format("%02d", sec), 120, 130);
         if(min == 0){
            img.drawString("That's either really impressive, or a sign you cheated.", 120, 150);
         }
         else if(min >= 60){
            img.drawString("Did you really need to mess with our timer like that?", 120, 150);
         }
         else{
            img.drawString("Thanks for helping with the... experiment.", 120, 150);

         }
         img.setFont(new Font("OptimusPrinceps", false, false , 10));
         if(min < 4){
             img.drawString("You were fast enough: Lunch Quest\\images\\TOP_SECRET", 120, 170);
         }
         else{
             img.drawString("Too slow 4 now...", 120, 170);
         }
         setImage(img);
         Mover.run.stop();
    }
    
    /**
     * Act - do whatever the EndScreen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.isKeyDown("space"))
        {                        
            while(Greenfoot.isKeyDown("space")){}
            ((MyWorld)getWorld()).reset();
            getWorld().removeObject(this);
        }    
    }
}
