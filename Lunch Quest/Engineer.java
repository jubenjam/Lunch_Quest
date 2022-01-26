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
    private int runSpeed = 4;
    private boolean collectedLunch = false;
    public void act()
    {
        if(((MyWorld)getWorld()).textOnScreen == false){

            //Move up and down
            setLocation(getX(), getY()-momentum);  
            Actor block;
            block = getOneIntersectingObject(Block.class);
            if(block == null)
            {
                momentum-=1;
            }
            else 
            {   
                setLocation(getX(), getY()+momentum);
                momentum = 0;
                if (Greenfoot.isKeyDown("up") && block.getY()>getY())
                {
                    momentum = 13;
                }
            }
            //Move Left and right
            boolean left = false;
            boolean right = false;
            if (Greenfoot.isKeyDown("left"))
            {
                left = true;
                setLocation(getX()-runSpeed, getY());
                if(getX() < 0){
                    setLocation(0, getY());
                }
            }   
            if (Greenfoot.isKeyDown("right"))
            {
                right = true;
                setLocation(getX()+runSpeed, getY());
                if(getX() > getWorld().getWidth()){
                    setLocation(getWorld().getWidth(), getY());
                }
            }
            block = getOneIntersectingObject(Block.class);
            if(block != null)
            {   
                if(left){
                    setLocation(getX()+runSpeed, getY());
                }
                if(right){
                    setLocation(getX()-runSpeed, getY());
                }
            }
            Actor lunch = getOneIntersectingObject(Lunch.class);
            if(lunch != null && collectedLunch == false)
            {   
                MyWorld world = (MyWorld)getWorld();
                world.win();
                collectedLunch = true;
            }
        }
    }
}
