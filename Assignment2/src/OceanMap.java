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
static void addpirateIslands(AnchorPane root) {
	final int scale = 50;
	 final int dimension=10;
    FileInputStream fileInputStream1 = null;
    
    try {
        fileInputStream1 = new FileInputStream("src/pirateIsland.png");
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    
    Image pirateIsland = new Image(fileInputStream1,50,50,true,true);
  
            
            //PIRATE ISLAND
            ImageView pirateIslandView = new ImageView(pirateIsland);
            pirateIslandView.setX(3*scale);
            pirateIslandView.setY(7*scale);
      
           // pirateIslandView.setFitHeight(60.0);
           // pirateIslandView.setFitWidth(60.0);
            
            //PIRATE ISLAND
            ImageView pirateIslandView1 = new ImageView(pirateIsland);
            
            pirateIslandView.setX(7*scale);
            pirateIslandView.setY(3*scale);
            root.getChildren().add(pirateIslandView);
            root.getChildren().add(pirateIslandView1);
        
        
    
}

}