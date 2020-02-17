import java.awt.Point;
import java.util.Random;

public class OceanMap  {

static int a,b;
static int IslandXcor,IslandYcor;
static Random rand=new Random();
boolean[][] oceanGrid=new boolean[10][10];
public boolean[][] getMap()
{
return oceanGrid;
}
public static Point getShipLocation() {
a=rand.nextInt(10);
b=rand.nextInt(10);
return new Point(a,b);

}

public static Point getislandslocation() {
IslandXcor=rand.nextInt(10);
IslandYcor=rand.nextInt(10);
if(a != IslandXcor || b != IslandYcor)
{
return new Point(IslandXcor,IslandYcor);
}
else
{
return new Point(0,0);
}

}
}