import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Laser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Laser extends AnimatedActor
{
    public static final int OFF = 0;
    public static final int TURN_ON = 1;
    public static final int ALMOST_ON = 2;
    public static final int ACTIVE = 3;
    public static final int ALMOST_OFF = 4;
    public static final int TURN_OFF = 5;
    
    public boolean laserActive = false;
    
    private String basename = "laser";
    private String[] keyList;
    private int _keyCounter;
    private int startDelay;
    private int onDuration;
    private int onBuffer;
    private int offDuration;
    private int offBuffer;
    
    private Actor player;
    
    public Laser(int startDelay, int onDuration, int offDuration)
    {
        super("laser", "off");
        LoadAnimation("off", 1);
        LoadAnimation("turn-on", 5);
        LoadAnimation("almost-on", 2);
        LoadAnimation("active", 2);
        LoadAnimation("almost-off", 4);
        LoadAnimation("turn-off", 3);
        
        keyList = new String[]{ "off", "turn-on", "almost-on", "active", "almost-off", "turn-off" };
        _keyCounter = 0;
        
        startDelay = startDelay;
        this.onDuration = onDuration;
        onBuffer = onDuration;
        this.offDuration = offDuration;
        offBuffer = offDuration;
    }
    
    public Laser()
    {
        super("laser", "off");
        LoadAnimation("off", 1);
        LoadAnimation("turn-on", 5);
        LoadAnimation("almost-on", 2);
        LoadAnimation("active", 2);
        LoadAnimation("almost-off", 4);
        LoadAnimation("turn-off", 3);
        
        keyList = new String[]{ "off", "turn-on", "almost-on", "active", "almost-off", "turn-off" };
        _keyCounter = 0;
        
        startDelay = 0;
        onDuration = 30;
        onBuffer = onDuration;
        offDuration = 30;
        offBuffer = offDuration;
    }
    
    public void act()
    {
        if (!myWorld.textOnScreen)
        {
            if (laserActive) {
                checkForKill();
            }
            
            advanceImage();       
            setFrame(currentAnimationKey);
        }
    }
    
    public void advanceImage()
    {
        if (advanceBuffer() && !delayStart())
        {
            // _keyCounter = 0 == "off"
            if (_keyCounter == OFF) {
                if (advanceOffBuffer()) {
                    nextKey();
                }
            } else if (_keyCounter == ACTIVE) {
                if (advanceOnBuffer()) {
                    if (currentImage == 0) {
                        currentImage++;
                    } else {
                        currentImage--;
                    }
                } else {
                    nextKey();
                }
            } else if (currentImage == animations.get(currentAnimationKey).length - 1) {
                nextKey();
            } else {
                currentImage++;
            }
        }
    }
    
    /**
     *  Returns true while delaying, false when delay is up.
     */
    private boolean delayStart()
    {
        if (startDelay == 0) {
            return false;
        }
        
        startDelay--;
        return true;
    }
    
    private boolean advanceOffBuffer()
    {
        if (offBuffer < 1)
        {
            offBuffer = offDuration;
            return true;
        }
        else
            offBuffer--;
            
        return false;
    }
    
    /** 
     *  advanceOnBuffer() returns true for the duration of onDuration and
     *  returns false when it resets.
     */
    private boolean advanceOnBuffer()
    {
        if (onBuffer < 1)
        {
            onBuffer = onDuration;
            return false;
        }
        else
            onBuffer--;
            
        return true;
    }
    
    private void nextKey()
    {
        // Change sprite sequence
        if (_keyCounter == keyList.length - 1) {
            _keyCounter = 0;
            currentAnimationKey = keyList[0];
        }
        else {
            currentAnimationKey = keyList[++_keyCounter];
        }
        
        // Check if laser is lethal or not
        if (_keyCounter == ALMOST_ON) {
            laserActive = true;
        } else if (_keyCounter == TURN_OFF) {
            laserActive = false;
        }
        
        currentImage = 0;
    }
    
    private void checkForKill()
    {
        player = getOneIntersectingObject(Engineer.class);
        
        if (player != null) {
            ((Engineer)player).die();
        }
    }
}
