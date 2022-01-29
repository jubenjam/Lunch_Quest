import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A Mover is an actor that also has 'move' and 'turn' ability. Both moving and turning 
 * are relative to its current position. When moving, the Mover will move in the direction 
 * it is currently facing.
 * 
 * Both 'move' and 'turn' methods are available with or without parameters.
 * 
 * The 'Mover' class is a subclass of Actor. It can be used by creating subclasses, or
 * copied into scenarios and edited inline.
 * 
 * The initial direction is to the right. Thus, this class works best with images that
 * face right when not rotated.
 * 
 * This class can also check whether we are close to the edge of the world.
 * 
 * @author Michael Kolling
 * @version 1.0 (July 2007)
 */
public class Mover extends AnimatedActor
{
    public static final int IDLE = 0;
    public static final int RUN = 1;
    public static final int JUMP = 2;
    
    public boolean facingL = false;
    public int currentAction = IDLE;
    public int nextAction = IDLE;
    private int momentum = 0;
    private int runSpeed = 3;
    
    public Mover(String basename, String startingKey)
    {
        super(basename, startingKey);
    }
    
    public void act()
    {
        advanceBuffer();       
        setFrame(currentAnimationKey);
    }
    
    public void advanceBuffer()
    {
        if (animateBuffer())
        {
            if (facingL)
                currentImage = (currentImage + 1) % animations.get(currentAnimationKey + "L").length;
            else
                currentImage = (currentImage + 1) % animations.get(currentAnimationKey + "R").length;
        }
    }
    
    public void setFrame(String key)
    {
        if (facingL)
            setImage(animations.get(currentAnimationKey + "L")[currentImage]);
        else
            setImage(animations.get(currentAnimationKey + "R")[currentImage]);
    }
    
    /**
     * Turn 90 degrees to the right (clockwise).
     */
    public void turn()
    {
        turn(180);
    }
    

    /**
     * Turn 'angle' degrees towards the right (clockwise).
     */
    public void turn(int angle)
    {
        if (angle > 90)
            facingL = !facingL;
        else
            setRotation(getRotation() + angle);
    }
    
    public int move()
    {
        int action = IDLE;
        Actor block;
        
        //Move Left and right
        if (Greenfoot.isKeyDown("left"))
        {
            action = RUN;
            facingL = true;
            setLocation(getX()-runSpeed, getY());
            if(getX() < 0){
                setLocation(0, getY());
            }
        }   
        if (Greenfoot.isKeyDown("right"))
        {
            action = RUN;
            facingL = false;
            setLocation(getX()+runSpeed, getY());
            if(getX() > getWorld().getWidth()){
                setLocation(getWorld().getWidth(), getY());
            }
        }
        
        // Correct for any clipping into blocks
        block = getOneIntersectingObject(Block.class);
        if(block != null)
        {   
            if(facingL){
                setLocation(getX()+runSpeed, getY());
            }
            if(!facingL){
                setLocation(getX()-runSpeed, getY());
            }
        }
        
        //Move up and down
        setLocation(getX(), getY()-momentum); // gravity
        block = getOneIntersectingObject(Block.class);
        System.out.println(getY());
        if(block == null) // mid-air
        {
            momentum -= 1;
            if (getOneObjectAtOffset(0, getImage().getHeight()/2, Block.class) == null) {
                action = JUMP;
            }
        }
        else
        {   
            setLocation(getX(), getY()+momentum);
            momentum = 0;
            if (Greenfoot.isKeyDown("up") && block.getY() > getY())
            {
                momentum = 13;
                action = JUMP;
            }
        }
        
        return action;
    }
    
    ///**
    // * Move a bit forward in the current direction.
    // */
    //public void move()
    //{
    //    move(WALKING_SPEED);
    //}

    
    ///**
    // * Move a specified distance forward in the current direction.
    // */
    //public void move(double distance)
    //{
    //    double angle = Math.toRadians( getRotation() );
    //    int x = (int) Math.round(getX() + Math.cos(angle) * distance);
    //    int y = (int) Math.round(getY() + Math.sin(angle) * distance);
    //    
    //    setLocation(x, y);
    //}

    
    /**
     * Test if we are close to one of the edges of the world. Return true is we are.
     */
    public boolean atWorldEdge()
    {
        if(getX() < 2 || getX() > getWorld().getWidth() - 2)
            return true;
        if(getY() < 2 || getY() > getWorld().getHeight() - 2)
            return true;
        else
            return false;
    }
}
