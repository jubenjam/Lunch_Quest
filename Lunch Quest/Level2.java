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

        screenFade = new ScreenFade();
        addObject(screenFade, 300, 200);

        timer = new Timer(oldTimer);
        addObject(timer, 50, 30);

        ground();
        platform2(16, 250, 16);
        platform2(96, 113, 4);
        platform2(288, 113, 4);
        platform2(480, 113, 4);
        
        MidLeft midLeft = new MidLeft();
        addObject(midLeft,109,315);
        MidLeft midLeft2 = new MidLeft();
        addObject(midLeft2,109,346);
        MidLeft midLeft3 = new MidLeft();
        addObject(midLeft3,109,377);
        MidLeft midLeft4 = new MidLeft();
        addObject(midLeft4,172,273);
        MidLeft midLeft5 = new MidLeft();
        addObject(midLeft5,172,241);
        MidLeft midLeft6 = new MidLeft();
        addObject(midLeft6,172,208);
        midLeft6.setLocation(168,204);
        MidRight midRight = new MidRight();
        addObject(midRight,142,319);
        midRight.setLocation(148,321);
        MidRight midRight2 = new MidRight();
        addObject(midRight2,142,352);
        midRight2.setLocation(145,356);
        midRight2.setLocation(141,351);
        MidRight midRight3 = new MidRight();
        addObject(midRight3,143,384);
        midLeft5.setLocation(175,244);
        MidRight midRight4 = new MidRight();
        addObject(midRight4,142,287);
        midRight4.setLocation(137,280);
        MidRight midRight5 = new MidRight();
        addObject(midRight5,143,256);
        midRight5.setLocation(142,245);
        MidRight midRight6 = new MidRight();
        addObject(midRight6,142,226);
        midRight6.setLocation(137,227);
        MidRight midRight7 = new MidRight();
        addObject(midRight7,142,193);

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

        //renderLevelPrompt();
        music.playLoop();

        engineer = new Engineer();

        super.screenFade = new ScreenFade();
        addObject(screenFade, 300, 200);

        addObject(engineer,45,340);
        //createDialogue("start-text");
    }

    public void createLasers()
    {
        LaserBuilder(0, 20, 20, 414,305);
        LaserBuilder(0, 20, 20, 388,168);
        LaserBuilder(20, 20, 20, 292,168);
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
