import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Level2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends MyWorld
{

    /**
     * Constructor for objects of class Level2.
     * 
     */
    public Level2(Timer oldTimer)
    {
        super(600, 400, 1, false);

        level = 2;

        prepare(oldTimer);
    }

    public void prepare(Timer oldTimer)
    {
        laserList = new ArrayList<Laser>();

        timer = new Timer(oldTimer);
        addObject(timer, 50, 30);

        ground();
        platform2(140, 250, 12);
        platform2(156, 113, 12);

        Console console = new Console();
        addObject(console,15,355);
        Single single = new Single();
        addObject(single,585,310);
        Single single2 = new Single();
        addObject(single2,16,180);
        Table table = new Table();
        addObject(table,500,73);
        
        TopLeft topLeft2 = new TopLeft();
        addObject(topLeft2,112,309);
        MidLeft midLeft = new MidLeft();
        addObject(midLeft,112,328);
        MidLeft midLeft2 = new MidLeft();
        addObject(midLeft2,112, 358);
        MidLeft midLeft3 = new MidLeft();
        addObject(midLeft3,112,387);
        single2.setLocation(17,217);
        single2.setLocation(21,184);
        single2.setLocation(41,170);

        createLasers();

        createGoal(195,340);

        renderLevelPrompt();
        music.playLoop();

        engineer = new Engineer();

        super.screenFade = new ScreenFade();
        addObject(screenFade, 300, 200);

        addObject(engineer,45,340);
        createDialogue("start-text");
    }

    public void createLasers()
    {
        LaserBuilder(0, 20, 20, 414,305);
        LaserBuilder(0, 20, 20, 388,168);
        LaserBuilder(20, 20, 20, 292,168);
        LaserBuilder(0, 20, 20, 192,168);
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
