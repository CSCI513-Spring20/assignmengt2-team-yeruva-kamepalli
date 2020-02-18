import java.awt.Point;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.*;
import javafx.scene.shape.Rectangle;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;


public class OceanExplorer extends Application
{
final int scale = 50;
 final int dimension=10;
 int[][] oceanGrid=new int[10][10];
 AnchorPane root;
 
 Image shipImg;
 ImageView shipImgView;
 Image IslandImg;
 ImageView IslandImgView;
 ImageView Pirateshipimg1;
 ImageView Pirateshipimg2;
 OceanMap oceanMap=new OceanMap();
 Scene scene;
 Ship ship;
 Point startingPoint;
 Point piratestart1;
 Point piratestart2;
 PirateShip pirateship1;
 PirateShip pirateship2;
 
 
 int[] IslandlocationXcor = new int[15];
 int[] IslandlocationYcor = new int[15];

                       
     
 public OceanExplorer() {
oceanGrid = oceanMap.getMap();
}

public static void main(String[] args)
{
launch(args);

}

@Override
public void start(Stage oceanStage) throws Exception
{
int count =0;
Point IsstartingPoint = null;
   root = new AnchorPane();
Scene scene = new Scene(root,500,500);
oceanStage.setScene(scene);
oceanStage.setTitle("ColumbusGame");
oceanStage.show();

for(int a = 0; a < dimension; a++)
{
for(int b = 0; b < dimension; b++)
{
Rectangle rect = new Rectangle(a*scale,b*scale,scale,scale);
rect.setStroke(Color.BLACK); 
rect.setFill(Color.PALETURQUOISE); 
root.getChildren().add(rect); 
}
}



startingPoint = OceanMap.getShipLocation();
ship = new Ship(startingPoint.x,startingPoint.y);
oceanStage.setScene(scene);
displayShip(root);


	
piratestart1 = OceanMap.getPShipLocations();
piratestart2 = OceanMap.getPShipLoc();

		pirateship1 = new PirateShip(piratestart1.x,piratestart1.y,0,oceanGrid);
		ship.addObserver(pirateship1);
		
		oceanStage.setScene(scene);
		loadPirateShipImage(root);
	
		pirateship2 = new PirateShip(piratestart2.x,piratestart2.y,1,oceanGrid);
		ship.addObserver(pirateship2);
	
	oceanStage.setScene(scene);
	loadPirateShipImage2(root);
	



for(int i =0 ;i <11 ;i++)
{
       
IsstartingPoint =  OceanMap.getislandslocation();
if(IsstartingPoint.x != 0 && IsstartingPoint.y != 0)
{
IslandlocationXcor[count] = IsstartingPoint.x ;
IslandlocationYcor[count] = IsstartingPoint.y ;
displayisland(root,IsstartingPoint);
count++;
}
}
IslandlocationXcor[count] = 0;
IslandlocationYcor[count] = 0;
count++;
IslandlocationXcor[count]  = 7;
IslandlocationYcor[count]  = 3;
OceanMap.addpirateIslands(root);
OceanMap.addpirateIslands(root);
shipmovement(scene);

}

	public int[] islandlocationsX() { 
		return IslandlocationXcor;
	}
	
	public int[] islandlocationsY() {
		return IslandlocationYcor;
	}
public void displayShip(AnchorPane root)
   {
	

Image shipImage = new Image("ship.png",50,50,true,true);
shipImgView= new ImageView(shipImage);
shipImgView.setX(startingPoint.x*scale);
shipImgView.setY(startingPoint.y*scale);
root.getChildren().add(shipImgView);


}
public void displayisland(AnchorPane root,Point IsstartPoint)
{

Image IslandImage = new Image("island.jpg",50,50,true,true);
IslandImgView= new ImageView(IslandImage);
IslandImgView.setX(IsstartPoint.x*scale);
IslandImgView.setY(IsstartPoint.y*scale);

root.getChildren().add(IslandImgView);


}
   
   
public void loadPirateShipImage(AnchorPane root) 
{
	
FileInputStream fileInputStream1 = null;
    
    try {
        fileInputStream1 = new FileInputStream("src/pirateShip.png");
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    
    Image pirateShip = new Image(fileInputStream1,50,50,true,true);
    Pirateshipimg1= new ImageView(pirateShip); 
    Pirateshipimg1.setX(piratestart1.x*scale);
    Pirateshipimg1.setY(piratestart1.y*scale);
	root.getChildren().add(Pirateshipimg1); 

	
}

public void loadPirateShipImage2(AnchorPane root) 
{
FileInputStream fileInputStream1 = null;
    
    try {
         fileInputStream1 = new FileInputStream("src/pirateShip.png");
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    
    Image pirateShip = new Image(fileInputStream1,50,50,true,true);
    Pirateshipimg2= new ImageView(pirateShip); 
    Pirateshipimg2.setX(piratestart2.x*scale);
    Pirateshipimg2.setY(piratestart2.y*scale);
	root.getChildren().add(Pirateshipimg2); 

	
}


   
private void shipmovement(Scene scene)
{
scene.setOnKeyPressed(new EventHandler<KeyEvent>()
{
@Override
public void handle(KeyEvent k)
{
switch (k.getCode())
{
case RIGHT:
ship.moveright(IslandlocationXcor,IslandlocationYcor);
break;
case LEFT:
ship.moveleft(IslandlocationXcor,IslandlocationYcor);
break;
case UP:
ship.moveup(IslandlocationXcor,IslandlocationYcor);
break;
case DOWN:
ship.movedown(IslandlocationXcor,IslandlocationYcor);
break;
default:
break;
}
shipImgView.setX(ship.getShipLocation().x * scale);
shipImgView.setY(ship.getShipLocation().y * scale);

Pirateshipimg1.setX(pirateship1.getShipLocation1().x * scale); // Sets the updated pirateShipImageview
Pirateshipimg1.setY(pirateship1.getShipLocation1().y * scale);
Pirateshipimg2.setX(pirateship1.getShipLocation2().x * scale); //// Sets the updated pirateShip2Imageview
Pirateshipimg2.setY(pirateship1.getShipLocation2().y * scale);
}
});

}



}