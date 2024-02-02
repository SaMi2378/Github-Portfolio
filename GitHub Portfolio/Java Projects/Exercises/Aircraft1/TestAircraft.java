//package ar5;

import java.util.ArrayList;

//import javax.activation.MailcapCommandMap;

/**
 * Write a description of class TestAircraft here.
 * 
 * @author Abdul Razak
 * @version 1.0
 */
public class TestAircraft
{
    // instance variables - replace the example below with your own
    private ArrayList<Fighter> fighters;
    private ArrayList<Bomber> bombers;

    /**
     * Constructor for objects of class TestAircraft
     */
    public TestAircraft()
    {
        // initialise instance variables
        fighters = new ArrayList<Fighter>();
        bombers = new ArrayList<Bomber>();      
    }

    public void test_1()
    {
        createFighters();
        displayFighters();  
        createBombers();
        displayBombers();
    }

    public void testFighters()
    {
        createFighters();
        displayFighters();  
        attackWithFighters();
        displayFighters();
    }

    public void testBombers()
    {
        createBombers();
        displayBombers();
        attackWithBombers();
        displayBombers();
    }

    private void createFighters()
    {
        fighters.clear();
        Fighter f;
        f = new Fighter(1000,230,500);
        fighters.add(f);
        f = new Fighter(900,330,440);
        fighters.add(f);
        f = new Fighter(220,120,450);
        fighters.add(f);
        f = new Fighter(1100,500,300);
        fighters.add(f);
        f = new Fighter(1000,230,560);
        fighters.add(f);
    }

    private void attackWithFighters()
    {
        for(Fighter f : fighters){
            f.fireGuns();
        }
    }

    private void displayFighters()
    {
        System.out.println("## Fighters ##");
        for(Fighter f : fighters){
            System.out.println(f);
        }
        System.out.println("-----------------------------");
    }

    private void createBombers()
    {
        bombers.clear();
        Bomber b;
        b = new Bomber(100, 230, 20);
        bombers.add(b);
        b = new Bomber(110, 280, 18);
        bombers.add(b);
        b = new Bomber(400, 300, 60);
        bombers.add(b);
        b = new Bomber(420, 290, 50);
        bombers.add(b);
        b = new Bomber(260, 290, 36);
        bombers.add(b);
    }

    private void attackWithBombers()
    {
        System.out.println("## Bombers Attack ##");
        for(Bomber b : bombers){
            b.dropBombs();
        }
    }

    private void displayBombers()
    {
        System.out.println("## Bombers ##");
        for(Bomber b : bombers){
            System.out.println(b);
        }
        System.out.println("-----------------------------");
    }
    public static void main(String[] args) {
    	
    	TestAircraft ta = new TestAircraft();
    	ta.test_1();
}}
