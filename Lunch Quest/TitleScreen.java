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
         //GreenfootImage img = new GreenfootImage(600, 400);
         GreenfootImage img = new GreenfootImage("title-screen.png");
         setImage(img);
         
         /*
         img.setColor(Color.BLUE);
         img.fill();
         img.setColor(Color.WHITE);
         img.setFont(new Font("Courier New", true, false , 30));
         img.drawString("Elmer the Hungry Engineer", 120, 100);
         img.setFont(new Font("Courier New", true, false , 20));
         img.drawString("by Juan Benjamin and Barrett Lo", 150, 130);
         img.setFont(new Font("Courier New", false, false , 20));
         img.drawString("Help Elmer get the free lunch offered by", 120, 190);
         img.drawString("his employers. Nothing suspicious here...", 115, 210); 
         img.setFont(new Font("Courier New", true, false , 20));
         img.drawString("Move Elmer using the arrow keys", 145, 250);
         img.drawString("Press Space to close dialogue boxes", 130, 270);
         img.drawString("Press Space to continue", 190, 290);        
         setImage(img);
         */
    }
    public void act()
    {
        if (Greenfoot.isKeyDown("space"))
        {                        
            while(Greenfoot.isKeyDown("space")){}
            MyWorld world = (MyWorld)getWorld();
            world.title = false;
            world.addObject(world.timer, 50, 30);
            world.createGoal();
            getWorld().removeObject(this);
        }    
    }
}
