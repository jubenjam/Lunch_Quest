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
    
    public Engineer()
    {
        super("engineer", "idle");
        LoadAnimation("idle", 9);
        LoadAnimation("run", 8);
        LoadAnimation("jump", 6);
    }
    
    public void act()
    {
        if (!myWorld.textOnScreen)
        {
            advanceImage();   
            setFrame(currentAnimationKey);
        
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
            Actor spike = getOneIntersectingObject(Spike.class);
            if(spike!=null){
                die();
            }
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
    
    public void die()
    {
        MyWorld world = (MyWorld)getWorld();
        setLocation(45,340);
        world.eraseLasers();
        switch(world.level){
            case 1: ((Level1)world).createLasers();
                    break;
            case 2: ((Level2)world).createLasers();
                    break;
            case 3: ((Level3)world).createLasers();
                    break;
            case 4: ((Level4)world).createLasers();
                    break;
            case 5: ((Level5)world).createLasers();
                    break;
            default: break;
        }
        world.createDialogue("ouch-text");
    }
}
