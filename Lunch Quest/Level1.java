import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends MyWorld
{

    /**
     * Constructor for objects of class Level1.
     * 
     */
    public Level1()
    {
        super(600, 400, 1, false);
        
        level = 1;
        
        prepare();
    }
    
    public void prepare()
    {
        laserList = new ArrayList<Laser>();

        screenFade = new ScreenFade();
        addObject(screenFade, 300, 200);

        //timer = new Timer();
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
                
        super.screenFade = new ScreenFade();
        addObject(screenFade, 300, 200);
        
        addObject(engineer,45,340);
        createDialogue("start-text");
    }
    
    public void createLasers()
    {
        LaserBuilder(0, 20, 20, 414,305);
        LaserBuilder(0, 20, 20, 340,168);
        LaserBuilder(20, 20, 20,144,168);
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
