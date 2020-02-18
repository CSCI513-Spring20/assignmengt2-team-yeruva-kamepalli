import java.awt.Point;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class OceanMap  {

static int a,b;
static int IslandXcor,IslandYcor;
static int[] Px = new int[20];   
static int[] Py = new int[20];
static int countpx=0; 

static Random rand=new Random();
int[][] oceanGrid=new int[10][10];
public int[][] getMap()
{
return oceanGrid;
}
public static Point getShipLocation() {    //randomly generating the ship position
a=rand.nextInt(10);
b=rand.nextInt(10);
if(a != 3 || b != 7 && a != 7 || b != 3 && a != 3 || b != 8 && a != 8 || b != 3 )
{
return new Point(a,b);
}
else
{
	a=5;
	b=5;
	return new Point(5,5);
}


}

public static Point getislandslocation() { //randomly generating the islands 
IslandXcor=rand.nextInt(10);
IslandYcor=rand.nextInt(10);
if(a != IslandXcor || b != IslandYcor && 3!= IslandXcor|| 7!= IslandYcor && 7!=IslandXcor || 3!=IslandYcor &&
3!= IslandXcor|| 8!= IslandYcor  && 8!= IslandXcor|| 3!= IslandYcor && 5!= IslandXcor|| 5!= IslandYcor)
{
return new Point(IslandXcor,IslandYcor);
}
else
{
return new Point(0,0);
}

}



static void addpirateIslands(AnchorPane root) { //Adding the pirate islands to the ship
	final int scale = 50;
	 final int dimension=10;
    FileInputStream fileInputStream1 = null;
    
    try {
         fileInputStream1 = new FileInputStream("src/pirateIsland.png");
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    
    Image pirateIsland = new Image(fileInputStream1,50,50,true,true);
  
            
            
            ImageView pirateIslandView = new ImageView(pirateIsland);
            pirateIslandView.setX(3*scale);
            pirateIslandView.setY(7*scale);
      
           
            
            
            ImageView pirateIslandView1 = new ImageView(pirateIsland);
            
            pirateIslandView.setX(7*scale);   
            pirateIslandView.setY(3*scale);
            root.getChildren().add(pirateIslandView);
            root.getChildren().add(pirateIslandView1);
        
        
    
}
public static Point getPShipLocations() {
	// TODO Auto-generated method stub
	   return new Point(3,8);
}

public static Point getPShipLoc() {
	// TODO Auto-generated method stub
	   return new Point(8,3);
}

}