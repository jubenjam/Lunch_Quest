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
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
    }
    
    public void win()
    {
        Dialogue_box dialogue_box = new Dialogue_box();
        addObject(dialogue_box,300,370);
        dialogue_box.setDialogue("I got my lunch! A delicious PB&J sandwich.");
        Profile profile = new Profile();
        addObject(profile,35,365);        
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Block block = new Block();
        addObject(block,300,339);
        Block block2 = new Block();
        addObject(block2,438,184);
        Engineer engineer = new Engineer();
        addObject(engineer,15,340);
        removeObject(block);
        removeObject(block2);
        //Dialogue_box dialogue_box = new Dialogue_box();
        //addObject(dialogue_box,300,370);
        //dialogue_box.setDialogue("It's time for lunch! Better go grab my lunch bag.");
        //Profile profile = new Profile();
        //addObject(profile,35,365);
        TopLeft topLeft = new TopLeft();
        addObject(topLeft,15,385);
        TopMid topMid = new TopMid();
        addObject(topMid,45,385);
        TopMid topMid2 = new TopMid();
        addObject(topMid2,75,385);
        TopMid topMid3 = new TopMid();
        addObject(topMid3,105,385);
        TopMid topMid4 = new TopMid();
        addObject(topMid4,135,385);
        TopMid topMid5 = new TopMid();
        addObject(topMid5,165,385);
        TopMid topMid6 = new TopMid();
        addObject(topMid6,195,385);
        TopMid topMid7 = new TopMid();
        addObject(topMid7,225,385);
        TopMid topMid8 = new TopMid();
        addObject(topMid8,255,385);
        TopMid topMid9 = new TopMid();
        addObject(topMid9,285,385);
        TopMid topMid10 = new TopMid();
        addObject(topMid10,315,385);
        TopMid topMid11 = new TopMid();
        addObject(topMid11,345,385);
        TopMid topMid12 = new TopMid();
        addObject(topMid12,375,385);
        TopMid topMid13 = new TopMid();
        addObject(topMid13,405,385);
        TopMid topMid14 = new TopMid();
        addObject(topMid14,435,385);
        TopMid topMid15 = new TopMid();
        addObject(topMid15,465,385);
        TopMid topMid16 = new TopMid();
        addObject(topMid16,495,385);
        TopMid topMid17 = new TopMid();
        addObject(topMid17,525,385);
        TopMid topMid18 = new TopMid();
        addObject(topMid18,555,385);
        TopRight topRight = new TopRight();
        addObject(topRight,585,385);
        Lunch lunch = new Lunch();
        addObject(lunch,576,348);
    }
}
