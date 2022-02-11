import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Credits here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Credits extends MyWorld
{
    private GreenfootImage bg;

    /**
     * Constructor for objects of class Credits.
     * 
     */
    public Credits()
    {
        super(600, 400, 1, false);
        setBackground("end-background.png");
        bg = getBackground();
        
        level = 8;
        
        prepare();
    }
    
    public void prepare()
    {        
        bg.setColor(Color.WHITE);
        bg.setFont(new Font("OptimusPrinceps", false, false , 30));
        bg.drawString("Credits", 20, 50);
        bg.setFont(new Font("OptimusPrinceps", false, false , 18));
        bg.drawString("IMAGES:\nlunch bag: https://opengameart.org/content/recycle-items-set\nCharacter and World: https://ollieberzs.itch.io/industrial-pack\nBackground: https://opengameart.org/content/industrial-background-2d\n", 20, 100);         
        bg.drawString("SOUNDS:\nJump: https://soundbible.com/1343-Jump.html\nRunning: https://www.youtube.com/watch?v=oNxnum6g3Lc", 20, 220);
        bg.drawString("Acid Trumpet by Kevin MacLeod | https://incompetech.com/\nMusic promoted by https://www.chosic.com/free-music/all/\nCreative Commons Creative Commons: By Attribution 3.0 License\nhttp://creativecommons.org/licenses/by/3.0/", 20, 310);
    }
    
    public void act()
    {
        if (Greenfoot.isKeyDown("space"))
        {
            while (Greenfoot.isKeyDown("space"));
            super.title = false;
            reset();
        }    
    }
    
}
