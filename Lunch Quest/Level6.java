import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Level6 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level6 extends MyWorld
{

    /**
     * Constructor for objects of class Level6.
     * 
     */
    public Level6(Timer oldTimer)
    {
        super(600, 400, 1, false);
        
        level = 6;
        
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
        }
        List<Mid> list2 = getObjectsAt(272, 250, Mid.class);
        if(!list2.isEmpty()){
            removeObject(list2.get(0));
            Mid mid = new Mid();
            addObject(mid, 272, 353);
        }
        List<Mid> list3 = getObjectsAt(304, 250, Mid.class);
        if(!list3.isEmpty()){
            removeObject(list3.get(0));
            Mid mid = new Mid();
            addObject(mid, 304, 353);
        }
        List<Mid> list4 = getObjectsAt(240, 250, Mid.class);
        if(!list4.isEmpty()){
            removeObject(list4.get(0));
        }
        Mid mid = new Mid();
        addObject(mid, 304, 331);
        Console console = new Console();
        addObject(console,15,355);
        Single single = new Single();
        addObject(single,585,310);
        Single single2 = new Single();
        addObject(single2,16,180);
        Single single3 = new Single();
        addObject(single3, 410,168);
        Table table = new Table();
        addObject(table,500,73);
        
        createLasers();
        
        createGoal(500, 40);
        
        renderLevelPrompt();
        music.pause();
        
        engineer = new Engineer();
        
        super.screenFade = new ScreenFade();
        addObject(screenFade, 300, 200);
        
        addObject(engineer,45,340);
        createDialogue("start-text");
    }
    
    public void createLasers()
    {
        
    }
    
    protected void win()
    {
        createDialogue("end-level-" + level + "-text");
        finaldia = true;
        
        Trigger trigger = new Trigger();
        trigger.setText("restart-text");
        addObject(trigger, 500, 73);
        removeObject(lunch);
    }
}
