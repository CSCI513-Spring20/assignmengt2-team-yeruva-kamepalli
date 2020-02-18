

import java.awt.Point;

import javafx.scene.layout.AnchorPane;

public class PirateShip {
	
	static int A1;
	 static int B1;
	
	   static int A2;
		static int B2;
		
		int[] IslocX;
		int[] IslocY;
		int[][] oceanGrid;
	 Point currentLocation;
	 AnchorPane root;
	 public Point Shippos = new Point();
	 int ship;
	 public PirateShip(int a, int b,int Ship,int[][] oceangrid) {
		 ship = Ship;
if(ship == 0) 
{
			A1 = a;
			B1 = b;
}
else 
{
			
			A2 = a;
			
			B2 = b;
}
		oceanGrid = 	oceangrid;
		
		}
	 
	public PirateShip(OceanMap oceanMap) {
	
	}
	
	public static Point getShipLocation1() 
	{
		return new Point(A1,B1);
	}
	public static Point getShipLocation2() 
	{  
		return new Point(A2,B2);
	}


}
