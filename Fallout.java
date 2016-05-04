import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

public class Fallout extends JFrame
{
     BufferedImage rifle, supermarket, mantis, nukacola, supermutant, g, houses;
     
    static boolean rifboo = false;
    static boolean supboo = false;
    static boolean houseboo = false;
     
   public Fallout () throws IOException
   {
        rifle=ImageIO.read(new File("rifle.jpg"));
        supermarket=ImageIO.read(new File("supermarket.jpg"));
        mantis=ImageIO.read(new File("mantis.jpg"));
        houses=ImageIO.read(new File("houses.png"));
       Container mw = getContentPane();
       ColorPanel cp = new ColorPanel(Color.WHITE);
       mw.add(cp);
       setSize(300,300);
       setVisible(false);
       
    }
    
    
   public static void main(String [] args) throws IOException
   {
       Fallout app = new Fallout();
       Scanner reader = new Scanner(System.in);
       
       int hp = 150;
       Random randy = new Random();
       
       System.out.println("Welcome to fallout 5.");
       

       System.out.println("Here are your objectives.");
       System.out.println("Search for food and supplies");
       System.out.println("Survive\n");
       
       System.out.println("How would you like to proceed?");
       System.out.println("1.Head forward");
       System.out.println("2.Go left");
       System.out.println("3.Go right");
       int d = reader.nextInt();
       switch(d)
       {
           case 1: System.out.println("You have stumbled across a lazer rifle");
           rifboo = true;
           app.setVisible(true);
           app.repaint();
           System.out.println("The road is blocked, you head back\n");
           System.out.println("How would you like to proceed?");
           System.out.println("1.Go left");
           System.out.println("2.Go right");
           
           int d2 = reader.nextInt();
           randomEncounter(33);

           rifboo = false;
           
           app.repaint();
           app.setVisible(false);
           // Random Encounters and Battle
            
          switch(d2)
           {
               case 1: System.out.println("You have found a path behind a set of trees and keep going.");
               System.out.println("You see the light of the Grelysaty' supermarket and walk inside");
               supboo = true;
               app.setVisible(true); 
               app.repaint();
               app.setVisible(false);
               
               System.out.println("You find a sixpack of Nuka Cola and a pound of brahmin meat");
               
               break;
           
               case 2:System.out.println("You find a desolated place that once was a neighborhood, now ruined by radiation\n");
               System.out.println("and death.");
               houseboo = true;
               app.setVisible(true);
               app.repaint();
               break;
            }
           break;
           
           case 2: System.out.println("You have found a path behind a set of trees and keep going.\n");
           System.out.println("You see the light of the Grelysaty' supermarket and walk inside");
           System.out.println("You find a sixpack of Nuka Cola and a pound of brahmin meat");
           supboo = true;
           app.setVisible(true); 
           app.repaint();
           //app.setVisible(false);
           break;
           
           case 3:System.out.println("You find a desolated place that once was a neighborhood, now ruined by radiation\n");
           System.out.println("and death.");
           break;
        }
        
        
        System.out.println("\nNew Objective: Visit Crater’s Creek in the east.");
        System.out.println("1.Head forward");
        System.out.println("2.Go left");
        System.out.println("3.Go right");
        System.out.println("4.Check Status");
        int jo = reader.nextInt();
        randomEncounter(33);
        switch(jo)
        {
                case 1: System.out.println("You have been confronted by a group of raiders.");
                System.out.println("You survived and fended them off but you got badly injured.");
                hp -= 36;
                break;

                case 2: System.out.println("You found a pistol underneath a log.");
                break;

                case 3:System.out.println("You were attacked by three feral ghouls.\n");
                System.out.println("You killed two and the third ran away.\n");
                System.out.println("You made it with only minor injuries.");
                hp -= 10;
                if(hp == 0)
                {
                    System.out.println("You died.");
                }
                break;

                case 4: System.out.println(hp);

            }

        System.out.println("You followed a road for two miles, the road is now blocked by fallen trees and rubble, you climb over\nand see a sign saying that Crater’s Creek is another 5 miles away, the path is blocked by super mutants.");
        int ja = randy.nextInt((4) + 1);

            if(ja == 1)
            {
                System.out.println("You have been attacked by a super mutant. You have a broken arm and have sprained your leg.");
                System.out.println("Despite your injuries, you have made it to crater's creek.");
            }

            if(ja == 2)
            {
                System.out.println("You made it safely to Crater’s Creek.");
            }

            if(ja == 3)
            {
                System.out.println("You were attacked by a mutated gecko.");
                hp -= 5;
                System.out.println("Despite your injuries, you have made it to crater's creek.");
            }

            if(ja ==4)
            {
                System.out.println("You killed a mantis and ate it’s legs.");
                hp += 20;
            }
            
       System.out.println("You wander around and have recieved a distress signal on your pipboy.");
       System.out.println("New Objective: Investigate the distress signal in Reltsy Mowiasmohre Canyon.\n");
       System.out.println("1.Head forward");
       System.out.println("2.Go left");
       System.out.println("3.Go right");
       System.out.println("4.Check Status");       
       int ds = reader.nextInt();
       randomEncounter(33);
       switch(ds)
       {
           case 1: System.out.println("You run across a stranger saying that he wants to sell you something.");
           System.out.println("1.Inquire 2.reject 3.[Bargain, 25%] 4.Intimidate[Strength, 95%]");
           int x = reader.nextInt();
           switch(x)
            {
                case 1: System.out.println("You:What do you have to sell?");
                System.out.println("Merchant:I sell everything from meds to weapons.");
                System.out.println("1.meds 2.food 3.clothing 4.guns");
                int stuff= reader.nextInt();
                switch(stuff)
                {
                    case 1: System.out.println("You now have purchased some med-x.");
                    break;
                    case 2: System.out.println("You now have purchased water and some Brahmin meat.");
                    hp += 45;
                    break;
                    case 3: System.out.println("Your character now has armor.");
                    hp += 10;
                    //tyler find out how to code damage resistance
                    break;
                    case 4: System.out.println("You have purchased a double barrel shotgun.");
                    break;
                }
                
                break;

                case 2: System.out.println("You:Sorry I am not interested");
                System.out.println("Merchant: Ok have a nice day.");
                break;

                case 3: System.out.println("You:I'm short on caps, can you cut me a deal?");
                System.out.println("[Bargain level insufficient]Merchant: Sorry I cannot.");
                System.out.println("Uninterested in your busisness the merchant leaves.");
                break;
                case 4: System.out.println("You: Get out of my way"); 
                System.out.println("Merchant:Yeesh what's your problem?!");
                System.out.println("Uninterested in your busisness the merchant leaves.");
                break; 
            }
            System.out.println("After gaining supplies, you pack up and carry on with your journey to Reltsy Mowiasmohre.");
            break;
           case 2: System.out.println("You have reached a sign saying that Reltsy Mowiasmohre is a three hour hike. You keep moving and are ambushed by a supermutant.You survive by killing it and take it's hammer.");
           hp -= 12;
           break;
           case 3:System.out.println("You picked up a knife off the ground.");
           break;
           case 4:System.out.println(hp);
           break;
        }
        
        System.out.println("As you walk down through the valleys of the ruined dry Nevada landscape, you find water and a note on the ground.\n");
        System.out.println("As you look up you see the shadow of a man behind you, he hits you with his gun and you are knocked out.");
        System.out.println("To be continued...");

        


        int level;

        int Strength, Perception, Endurance, Charisma, Intelligence, Agility, Luck;



    }
    
        public class Mutant
    {
        Random randy = new Random();
        int hp = randy.nextInt((11)+40);
        int damage = hp - 40;
    }
    
    public class Hero
    {
     int hp = 150;
    }
    
    
    public static void randomEncounter (int chance)
    {
        Random encount = new Random();
        int encrate = encount.nextInt(101);
        if (encrate <= chance)
        {
        startCombat();
    }
    }
         
    public static void startCombat ()
    {
        System.out.println("You have encountered a blank");
        
        
    }
    
    
    
     public class ColorPanel extends JPanel 
  {
   
    public ColorPanel (Color backColor)
    {
        setBackground(backColor);
        
       
    }
    
    public void paintComponent(Graphics g)
    {
        if(rifboo)
        g.drawImage(rifle,0,0,300,300,null);
        if(supboo)
        g.drawImage(supermarket,0,0,300,300,null);   
        if(houseboo)
        g.drawImage(houses,0,0,300,300,null);
        
    }
    
  }
    
}
