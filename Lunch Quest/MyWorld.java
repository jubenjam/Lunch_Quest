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
        Dialogue_box dialogue = new Dialogue_box();
        addObject(dialogue,300,370);
        dialogue.setDialogue("It's time for lunch! Better go grab my lunch bag.");
        Engineer engineer = new Engineer();
        addObject(engineer,176,157);
    }
}
