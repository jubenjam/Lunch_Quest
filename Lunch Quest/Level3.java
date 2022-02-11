import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Level3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level3 extends MyWorld
{

    /**
     * Constructor for objects of class Level3.
     * 
     */
    public Level3(Timer oldTimer)
    {
        super(600, 400, 1, false);
        
        level = 3;
        
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
        addObject(engineer,45,340);
        createDialogue("start-text");
    }
    
    public void createLasers()
    {
        LaserBuilder(0, 20, 15, 45,305);
        LaserBuilder(0, 20, 15, 414,305);
        LaserBuilder(0, 20, 20, 484,168);
        LaserBuilder(0, 20, 20, 388,168);
        LaserBuilder(20, 20, 20, 288,168);
        LaserBuilder(0, 20, 20, 192,168);
        LaserBuilder(20, 20, 20, 96,168);
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
