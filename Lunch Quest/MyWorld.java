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
    public int level = 0;
    public boolean finaldia = false;
    public Engineer engineer;
    public Timer timer;
    static GreenfootSound music = new GreenfootSound("AcidJazz.mp3");

    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        
        prepare();
    }
    
    public void createGoal(){
        level+=1;
        lunch = new Lunch();
        addObject(lunch,100,200);
        LevelPrompt levelPrompt = new LevelPrompt();
        levelPrompt.setText(level);
        addObject(levelPrompt,300, 200);
        if(level != 6){
            music.playLoop();
        }
        else{
            music.stop();
        }
    }
    
    public void createDialogue(String text)
    {
        Dialogue_box dialogue_box = new Dialogue_box();
        addObject(dialogue_box, 300, 200);
        dialogue_box.setDialogue(text);
    }
    
    public void win()
    {
        switch (level) {
            case 1:     createDialogue("end-level-1-text");
                        break;
            
            case 2:     createDialogue("end-level-2-text");
                        break;
                        
            case 3:     createDialogue("end-level-3-text");
                        break;
                        
            case 4:     createDialogue("end-level-4-text");
                        break;
                        
            case 5:     createDialogue("end-level-5-text");
                        break;
                        
            case 6:     createDialogue("end-level-6-text");
                        finaldia = true;
                        break;
        }
        
        if(level != 6){
            Trigger trigger = new Trigger();
            trigger.setText("restart-text");
            addObject(trigger, 500, 73);
        }
        removeObject(lunch);
    }
    
    public void skip(){
        level = 5;
    }
    
    public void reset()
    {
        engineer.setLocation(45, 340);
        createDialogue("start-text");
        TitleScreen titleScreen = new TitleScreen();
        titleScreen.setText();
        title = true;
        level = 0;
        timer.reset();
        addObject(titleScreen, 300, 200);
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
    
    private void platform2(int x, int y, int width){
        Left left = new Left();
        addObject(left,x,y);
        int i=1;
        x+=32;
        while(i < width - 1){
            Mid mid = new Mid();
            addObject(mid,x,y);
            i+=1;
            x+=32;
        }
        Right right = new Right();
        addObject(right,x,y);
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        ground();
        platform2(16, 250, 16);
        platform2(96, 113, 4);
        platform2(288, 113, 4);
        platform2(480, 113, 4);

        Console console = new Console();
        addObject(console,15,355);
        Single single = new Single();
        addObject(single,585,310);
        Single single2 = new Single();
        addObject(single2,16,180);
        Table table = new Table();
        addObject(table,500,73);
        Laser laser = new Laser();
        addObject(laser,414,305);

        engineer = new Engineer();
        addObject(engineer,45,340);
        createDialogue("start-text");

        TitleScreen title = new TitleScreen();
        title.setText();
        addObject(title, 300, 200);
        
        ScreenFade screenFade = new ScreenFade();
        addObject(screenFade, 300, 200);
        
        timer = new Timer();
        addObject(timer, 50, 30);
    }
}
