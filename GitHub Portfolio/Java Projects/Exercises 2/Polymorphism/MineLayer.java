/**
 * Write a description of class MineLayer here.
 * 
 * @author Your Name
 * @version 1.0
 */
public class MineLayer extends Aircraft
{
    private int nbrMines;

    /**
     * Constructor for objects of class MineLayer
     */
    public MineLayer()
    {
        super();
        nbrMines = 20;
    }

    /**
     * Create a MineLayer making sure that altitude, speed, and nbrMines are kept >= 0
     * 
     * @param altitude the initial altitude of the MineLayer
     * @param speed the initial speed of the MineLayer
     * @param nbrMines the initial number of mines onboard
     */
    public MineLayer(int altitude, int speed, int nbrMines)
    {
        super(altitude, speed);
        setNbrMines(nbrMines);
    }

    /**
     * @return the number of mines onboard
     */
    public int getNbrMines()
    {
        return nbrMines;
    }

    /**
     * Set the number of mines onboard, ignoring if the actual parameter is < 0
     * @param nbrMines the number of mines
     */
    public void setNbrMines(int nbrMines)
    {
        if (nbrMines >= 0)
        {
            this.nbrMines = nbrMines;
        }
    }

    /**
     * Drop a mine
     */
    public void dropMine()
    {
        int nbrToDrop = (int) (Math.random() * 10 + 10);
        if (nbrToDrop > nbrMines)
        {
            nbrToDrop = nbrMines;
        }
        if (nbrToDrop > 0)
        {
            System.out.print("MineLayer is dropping a mine ");
            for (int i = 0; i < nbrToDrop; i++)
            {
                System.out.print("#");
                nbrMines--;
            }
            System.out.println();
        }
        else
        {
            System.out.println("MineLayer has no more mines");
        }
    }

    /**
     * Get a description of a MineLayer
     */
    public String toString()
    {
        String s = "MineLayer   ";
        s += "[speed " + getSpeed() + " mph at altitude ";
        s += getAltitude() + " ft] ";
        s += "has " + nbrMines + " mines left";
        return s;
    }
}
