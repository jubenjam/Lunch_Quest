import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

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
    
    private List<Laser> laserList;

    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        
        prepare();
    }
    
    public void createGoal(){
        level+=1;
        eraseLasers();
        createLasers();
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
    
    private void LaserBuilder(int delay, int on, int off, int x, int y){
        Laser laser = new Laser(delay, on, off);
        laserList.add(laser);
        addObject(laser,x,y);
    }
    
    public void createLasers(){
        switch (level) {
            case 1:     LaserBuilder(0, 20, 20, 414,305);
                        LaserBuilder(0, 20, 20, 340,168);
                        LaserBuilder(20, 20, 20,144,168);
                        List<Left> listA = getObjectsAt(288, 113, Left.class);
                        if(listA.isEmpty()){
                            Left left = new Left();
                            addObject(left, 288, 113);
                        }
                        List<Left> listB = getObjectsAt(288, 218, Left.class);
                        if(!listB.isEmpty()){
                            removeObject(listB.get(0));
                        }
                        List<Mid> listC = getObjectsAt(272, 250, Mid.class);
                        if(listC.isEmpty()){
                            Mid mid = new Mid();
                            addObject(mid, 272, 250);
                        }
                        List<Mid> listD = getObjectsAt(304, 250, Mid.class);
                        if(listD.isEmpty()){
                            Mid mid = new Mid();
                            addObject(mid, 304, 250);
                        }
                        List<Mid> listE = getObjectsAt(272, 353, Mid.class);
                        if(!listE.isEmpty()){
                            removeObject(listE.get(0));
                        }
                        List<Mid> listF = getObjectsAt(304, 353, Mid.class);
                        if(!listF.isEmpty()){
                            removeObject(listF.get(0));
                        }
                        break;
            
            case 2:     LaserBuilder(0, 20, 20, 414,305);
                        LaserBuilder(0, 20, 20, 388,168);
                        LaserBuilder(20, 20, 20, 292,168);
                        LaserBuilder(0, 20, 20, 192,168);
                        LaserBuilder(20, 20, 20, 96,168);
                        break;
                        
            case 3:     LaserBuilder(0, 20, 15, 45,305);
                        LaserBuilder(0, 20, 15, 414,305);
                        LaserBuilder(0, 20, 20, 484,168);
                        LaserBuilder(0, 20, 20, 388,168);
                        LaserBuilder(20, 20, 20, 288,168);
                        LaserBuilder(0, 20, 20, 192,168);
                        LaserBuilder(20, 20, 20, 96,168);
                        break;
            
            case 4:     LaserBuilder(0, 15, 15, 45,305);
                        LaserBuilder(0, 15, 15, 414,305);
                        LaserBuilder(0, 15, 15, 484,168);
                        LaserBuilder(0, 15, 15, 388,168);
                        LaserBuilder(10, 15, 15, 356,168);
                        LaserBuilder(20, 15, 15, 324,168);
                        LaserBuilder(0, 15, 15, 192,168);
                        LaserBuilder(20, 15, 15, 96,168);
                        List<Left> list = getObjectsAt(288, 113, Left.class);
                        if(!list.isEmpty()){
                            removeObject(list.get(0));
                            Left left = new Left();
                            addObject(left, 288, 218);
                        }
                        break;
                        
            case 5:     LaserBuilder(0, 10, 10, 45,305);
                        LaserBuilder(5, 10, 10, 77,305);
                        LaserBuilder(10, 10, 10, 109,305);
                        LaserBuilder(15, 10, 10, 141,305);
                        LaserBuilder(0, 15, 15, 414,305);
                        LaserBuilder(0, 15, 15, 484,168);
                        LaserBuilder(0, 15, 15, 388,168);
                        LaserBuilder(10, 15, 15, 356,168);
                        LaserBuilder(20, 15, 15, 324,168);
                        LaserBuilder(0, 15, 15, 192,168);
                        LaserBuilder(20, 15, 15, 96,168);
                        List<Left> list2 = getObjectsAt(288, 218, Left.class);
                        if(!list2.isEmpty()){
                            removeObject(list2.get(0));
                        }
                        List<Mid> list3 = getObjectsAt(272, 250, Mid.class);
                        if(!list3.isEmpty()){
                            removeObject(list3.get(0));
                            Mid mid = new Mid();
                            addObject(mid, 272, 353);
                        }
                        List<Mid> list4 = getObjectsAt(304, 250, Mid.class);
                        if(!list4.isEmpty()){
                            removeObject(list4.get(0));
                            Mid mid = new Mid();
                            addObject(mid, 304, 353);
                        }
                        break;
                        
            default:    break;
        }
    }
    
    public void eraseLasers(){
        for (Laser laser : laserList){
            removeObject(laser);
        }
        laserList.clear();
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
        level += 1;
        if(level > 6)
            level = 1;
        eraseLasers();
        createLasers();
        if(level != 6){
            music.playLoop();
        }
        else{
            music.stop();
        }
        
    }
    
    public void endScreen()
    {
        textOnScreen = true;
        EndScreen end = new EndScreen();
        title = true;
        end.setText(timer.getMinutes(), timer.getSeconds());
        addObject(end, 300, 200);
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
        removeObject(timer);
        showText("", 50, 30);
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
        laserList = new ArrayList<Laser>();

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
