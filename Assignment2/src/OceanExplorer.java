import java.awt.Point;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.*;
import javafx.scene.shape.Rectangle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;



public class OceanExplorer extends Application //it creates and places the ship in the grid
{
final int scale = 50;  //declaring scale and dimension
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
 Point startingPoint; //declaring initial ship coordinates
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
public void start(Stage oceanStage) throws Exception // it creates the ocean grid and reset buttons
//it gets the pirate ship cooordinates ,island coordinates,pirate islands,ship and passes to respective functions and load the images on grid.
{
int count =0;
Point IsstartingPoint = null;
   root = new AnchorPane();
   
   Button reset = new Button("reset");
   reset.setLayoutX(0);
   reset.setLayoutY(500);
   root.getChildren().add(reset);
   
Scene scene = new Scene(root,550,550);
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

reset.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent e) {
        try {
            start(oceanStage);
        } catch (Exception e1) {
            // TODO Auto-generated catch block
        	System.out.println(e1);
            e1.printStackTrace();
        }
    }
});

shipmovement(scene);

}

	public int[] islandlocationsX() { 
		return IslandlocationXcor;
	}
	
	public int[] islandlocationsY() {
		return IslandlocationYcor;
	}
public void displayShip(AnchorPane root)  //it dispalys the ship in the grid
   {
	

Image shipImage = new Image("ship.png",50,50,true,true);
shipImgView= new ImageView(shipImage);
shipImgView.setX(startingPoint.x*scale);
shipImgView.setY(startingPoint.y*scale);
root.getChildren().add(shipImgView);


}
public void displayisland(AnchorPane root,Point IsstartPoint) //it adds the islands in the grid 
{

Image IslandImage = new Image("island.jpg",50,50,true,true);
IslandImgView= new ImageView(IslandImage);
IslandImgView.setX(IsstartPoint.x*scale);
IslandImgView.setY(IsstartPoint.y*scale);

root.getChildren().add(IslandImgView);


}
   
   
public void loadPirateShipImage(AnchorPane root) // it displays the pirateshipimage1
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

public void loadPirateShipImage2(AnchorPane root) // it displays the pirateshipimage2
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


   
private void shipmovement(Scene scene)  // it changes the ship movement by giving inputs
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