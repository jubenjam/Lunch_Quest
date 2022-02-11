import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Level4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level4 extends MyWorld
{

    /**
     * Constructor for objects of class Level4.
     * 
     */
    public Level4(Timer oldTimer)
    {
        super(600, 400, 1, false);
        
        level = 4;
        
        prepareLevel(oldTimer);
    }
    
    public void prepareLevel(Timer oldTimer)
    {
        laserList = new ArrayList<Laser>();
        
        screenFade = new ScreenFade();
        addObject(screenFade, 300, 200);
        
        timer = new Timer(oldTimer);
        addObject(timer, 50, 30);
        
        ground();
        platform2(16, 250, 16);
        platform2(96, 113, 4);
        platform2(288, 113, 4);
        platform2(480, 113, 4);
        List<Left> list = getObjectsAt(288, 113, Left.class);
        if(!list.isEmpty()){
            removeObject(list.get(0));
            Left left = new Left();
            addObject(left, 288, 218);
        }
        Console console = new Console();
        addObject(console,15,355);
        Single single = new Single();
        addObject(single,585,310);
        Single single2 = new Single();
        addObject(single2,16,180);
        Table table = new Table();
        addObject(table,500,73);
        
        createLasers();
        
        createGoal(100, 200);
        
        renderLevelPrompt();
        
        engineer = new Engineer();
        
        super.screenFade = new ScreenFade();
        addObject(screenFade, 300, 200);
        
        addObject(engineer,45,340);
        createDialogue("start-text");
    }
    
    public void createLasers()
    {
        LaserBuilder(0, 15, 15, 45,305);
        LaserBuilder(0, 15, 15, 414,305);
        LaserBuilder(0, 15, 15, 484,168);
        LaserBuilder(0, 15, 15, 388,168);
        LaserBuilder(10, 15, 15, 356,168);
        LaserBuilder(20, 15, 15, 324,168);
        LaserBuilder(0, 15, 15, 192,168);
        LaserBuilder(20, 15, 15, 96,168);
    }
    
    protected void win()
    {
        createDialogue("end-level-" + level + "-text");
        
        Trigger trigger = new Trigger();
        trigger.setText("restart-text");
        addObject(trigger, 500, 73);
        removeObject(lunch);
    }
}
