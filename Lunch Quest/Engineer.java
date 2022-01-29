import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Engineer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Engineer extends Mover
{
    private String basename = "engineer";
    
    /**
     * Act - do whatever the Engineer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public Engineer()
    {
        super("engineer", "idle");
        LoadAnimation("idle", 9);
        LoadAnimation("run", 8);
        LoadAnimation("jump", 6);
    }
    
    public void act()
    {
        advanceBuffer();       
        setFrame(currentAnimationKey);
        
        if(((MyWorld)getWorld()).textOnScreen == false){
            nextAction = move();
            if (nextAction != currentAction)
            {
                currentAction = nextAction;
                switch (currentAction)
                {
                    case IDLE:  changeAnimation("idle");
                                // System.out.println("idle");
                                break;
                    case RUN:   changeAnimation("run");
                                // System.out.println("run");
                                break;
                    case JUMP:  changeAnimation("jump");
                                // System.out.println("jump");
                                break;
                }
            }
            checkWin();
        }
    }
    
    public void checkWin()
    {
        Actor lunch = getOneIntersectingObject(Lunch.class);
        if(lunch != null)
        {   
            MyWorld world = (MyWorld)getWorld();
            world.win();
        }
    }
}
