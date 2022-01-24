import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Engineer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Engineer extends Actor
{
    /**
     * Act - do whatever the Engineer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int momentum = 0;
    public void act()
    {
        setLocation(getX(), getY()-momentum);  
        if (Greenfoot.isKeyDown("left"))
        {
            setLocation(getX()-4, getY());
        }
        if (Greenfoot.isKeyDown("right"))
        {
            setLocation(getX()+4, getY());
        }

        Actor floor;
        floor = getOneIntersectingObject(Floor.class);
        //gravity makes ball fall faster when not touching floor
        if(floor == null)
        {
            momentum-=1;
        }
        else 
        {   
            momentum = 0;
            if (Greenfoot.isKeyDown("up"))
            {
                momentum = 13;
            }
        }

    }
}
