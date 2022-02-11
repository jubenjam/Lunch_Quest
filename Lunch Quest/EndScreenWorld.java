import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndScreenWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndScreenWorld extends MyWorld
{
    private GreenfootImage bg;

    /**
     * Constructor for objects of class EndScreenWorld.
     * 
     */
    public EndScreenWorld(Timer timer)
    {
        super(600, 400, 1, false);
        setBackground("end-background.png");
        bg = getBackground();
        
        level = 7;
        
        prepare(timer);
    }
    
    public void prepare(Timer timer)
    {
        int min = timer.getMinutes();
        int sec = timer.getSeconds();
        
        music.playLoop();
        
        bg.setColor(Color.WHITE);
        bg.setFont(new Font("OptimusPrinceps", false, false , 30));
        bg.drawString("Congratulations!", 20, 100);
        bg.setFont(new Font("OptimusPrinceps", false, false , 20));
        bg.drawString("You beat the game in: " + String.valueOf(min) + ":" + String.format("%02d", sec), 20, 130);
        if(min == 0){
           bg.drawString("That's either really impressive, or a sign you cheated.", 20, 150);
        }
        else if(min >= 60){
           bg.drawString("Did you really need to mess with our timer like that?", 20, 150);
        }
        else{
           bg.drawString("Thanks for helping with the... experiment.", 20, 150);
    
        }
        bg.setFont(new Font("OptimusPrinceps", false, false , 10));
        if(min < 4){
            bg.drawString("You were fast enough: Lunch Quest\\images\\TOP_SECRET", 20, 190);
        }
        else{
            bg.drawString("Too slow 4 now...", 20, 190);
        }
        bg.setFont(new Font("OptimusPrinceps", false, false , 20));
        bg.drawString("Press Space for credits.", 20, 170);
        Mover.run.stop();
    }
    
    public void act()
    {
        if (Greenfoot.isKeyDown("space"))
        {
            while (Greenfoot.isKeyDown("space"));
            super.title = false;
            nextLevel();
        }    
    }
    
}
