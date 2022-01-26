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
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        
        prepare();
    }
    
    public void win()
    {
        Dialogue_box dialogue_box = new Dialogue_box();
        addObject(dialogue_box,300,370);
        Profile profile = new Profile();
        addObject(profile,35,365);
        dialogue_box.setDialogue("I got my lunch! A delicious PB&J sandwich.", profile);
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
        addObject(engineer,45,340);
        removeObject(block);
        removeObject(block2);

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
        addObject(lunch,556,72);

        int row = 280;
        int row2 = row-30;
        BotRight botRight = new BotRight();
        addObject(botRight,495,row);
        BotMid botMid2 = new BotMid();
        addObject(botMid2,465,row);
        BotMid botMid3 = new BotMid();
        addObject(botMid3,435,row);
        BotMid botMid4 = new BotMid();
        addObject(botMid4,405,row);
        BotMid botMid5 = new BotMid();
        addObject(botMid5,375,row);
        BotMid botMid6 = new BotMid();
        addObject(botMid6,345,row);
        BotMid botMid7 = new BotMid();
        addObject(botMid7,315,row);
        BotMid botMid8 = new BotMid();
        addObject(botMid8,285,row);
        BotMid botMid9 = new BotMid();
        addObject(botMid9,255,row);
        BotMid botMid10 = new BotMid();
        addObject(botMid10,225,row);
        BotMid botMid11 = new BotMid();
        addObject(botMid11,195,row);
        BotMid botMid12 = new BotMid();
        addObject(botMid12,165,row);
        BotMid botMid13 = new BotMid();
        addObject(botMid13,135,row);
        BotMid botMid14 = new BotMid();
        addObject(botMid14,105,row);
        BotMid botMid15 = new BotMid();
        addObject(botMid15,75,row);
        BotMid botMid16 = new BotMid();
        addObject(botMid16,45,row);
        BotLeft botLeft = new BotLeft();
        addObject(botLeft,15,row);
        TopLeft topLeft2 = new TopLeft();
        addObject(topLeft2,15,row2);
        TopMid topMid20 = new TopMid();
        addObject(topMid20,465,row2);
        TopMid topMid21 = new TopMid();
        addObject(topMid21,435,row2);
        TopMid topMid22 = new TopMid();
        addObject(topMid22,405,row2);
        TopMid topMid23 = new TopMid();
        addObject(topMid23,375,row2);
        TopMid topMid24 = new TopMid();
        addObject(topMid24,345,row2);
        TopMid topMid25 = new TopMid();
        addObject(topMid25,315,row2);
        TopMid topMid26 = new TopMid();
        addObject(topMid26,285,row2);
        TopMid topMid27 = new TopMid();
        addObject(topMid27,255,row2);
        TopMid topMid28 = new TopMid();
        addObject(topMid28,225,row2);
        TopMid topMid29 = new TopMid();
        addObject(topMid29,195,row2);
        TopMid topMid30 = new TopMid();
        addObject(topMid30,165,row2);
        TopMid topMid31 = new TopMid();
        addObject(topMid31,135,row2);
        TopMid topMid32 = new TopMid();
        addObject(topMid32,105,row2);
        TopMid topMid33 = new TopMid();
        addObject(topMid33,75,row2);
        TopMid topMid34 = new TopMid();
        addObject(topMid34,45,row2);
        TopRight topRight2 = new TopRight();
        addObject(topRight2,495,row2);
        Console console = new Console();
        addObject(console,15,355);
        Single single = new Single();
        addObject(single,585,310);
        
        Dialogue_box dialogue_box = new Dialogue_box();
        addObject(dialogue_box,300,370);
        Profile profile = new Profile();
        addObject(profile,35,365);
        dialogue_box.setDialogue("It's time for lunch! Better go grab my lunch bag.", profile);
    }
}
