import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    
    public boolean textOnScreen = false;
    public boolean title = true;
    public Lunch lunch;
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        
        prepare();
    }
    
    public void createGoal(){
        lunch = new Lunch();
        addObject(lunch,556,80);
    }
    
    public void createDialogue(String text)
    {
        Dialogue_box dialogue_box = new Dialogue_box();
        addObject(dialogue_box,300,370);
        Profile profile = new Profile();
        addObject(profile,35,365);
        dialogue_box.setDialogue(text, profile);
    }
    
    public void win()
    {
        createDialogue("I got my lunch! A delicious PB&J sandwich.\nI should probably head back now.");
        Trigger trigger = new Trigger();
        trigger.setText("Made it back, but now I'm getting hungry...");
        addObject(trigger, 15, 340);
        removeObject(lunch);
    }
    
    private void ground()
    {
        TopLeft topLeft = new TopLeft();
        addObject(topLeft,16,385);
        int spot = 16 + 32;
        while (spot < this.getWidth() - 16){
            TopMid topMid = new TopMid();
            addObject(topMid,spot,385);
            spot += 32;
        }
        TopRight topRight = new TopRight();
        addObject(topRight,spot,385);
    }
    
    private void platform(int x, int y, int width){
        TopLeft topLeft = new TopLeft();
        addObject(topLeft,x,y);
        BotLeft botLeft = new BotLeft();
        addObject(botLeft,x,y+32);
        int i=1;
        x+=32;
        while(i < width - 1){
            TopMid topMid = new TopMid();
            addObject(topMid,x,y);
            BotMid botMid = new BotMid();
            addObject(botMid,x,y+32);
            i+=1;
            x+=32;
        }
        TopRight topRight = new TopRight();
        addObject(topRight,x,y);
        BotRight botRight = new BotRight();
        addObject(botRight,x,y+32);
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        ground();
        createGoal();
        platform(16, 250, 16);
        
        Console console = new Console();
        addObject(console,15,355);
        Single single = new Single();
        addObject(single,585,310);
        
        Engineer engineer = new Engineer();
        addObject(engineer,45,340);
        createDialogue("It's time for lunch! Better go grab my lunch bag.");
        
        TitleScreen title = new TitleScreen();
        title.setText();
        addObject(title, 300, 200);
    }
}
