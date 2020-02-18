

import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

import javafx.scene.layout.AnchorPane;

public class PirateShip implements Observer {
	
	static int A1;
	 static int B1;
	
	   static int A2;
		static int B2;
		
		int[] Xloccord;
		int[] Yloccord;
		int[][] oceanGrid;
	 Point currentLocation;
	 AnchorPane root;
	 public Point Shiploc = new Point();
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
	
	public static Point getShipLocation1() //returns the 1st pirateship location
	{
		return new Point(A1,B1);
	}
	public static Point getShipLocation2() // returns the 2nd ship location
	{  
		return new Point(A2,B2);
	}

	@Override
	public void update(Observable S, Object arg) { //overides the update method to catch ship movement
		if(S instanceof Ship)
		{
			Shiploc = ((Ship)S).getShipLocation();
			OceanExplorer ocean = new OceanExplorer();
			Xloccord = ocean.islandlocationsX();
			Yloccord =  ocean.islandlocationsY();
			Movement();
		}
		
	}

	private void Movement() { //it gets the coordinates of ship and pirate ship tries to get closer to the ship by decreasing or incresing the coordinates
	
		if(ship == 0)
		{
	
		  if (A1 - Shiploc.x == 0) {
	       } else if (A1- Shiploc.x < 0) {
	           
	    	   
	           if (A1 < 9 && oceanGrid[A1 + 1][B1] != 1)
	        	   A1++;
	       } else if (A1 > 0 && oceanGrid[A1 - 1][B1] != 1)
	    	   A1--;

	     
	       if (B1 - Shiploc.y == 0) {
	       } else if (B1 - Shiploc.y < 0) {
	           
	           if (B1 < 9 && oceanGrid[A1][B1 + 1] != 1)
	        	   B1++;
	       } else if (B1 > 0 && oceanGrid[A1][B1 - 1] != 1)
	    	   B1--;

		}
		else if(ship == 1)
		{
			  if (A2 - Shiploc.x == 0) {
		       } else if (A2- Shiploc.x < 0) {
		           
		    	   
		           if (A2 < 9 && oceanGrid[A2 + 1][B2] != 1)
		        	   A2++;
		       } else if (A2 > 0 && oceanGrid[A2 - 1][B2] != 1)
		    	   A2--;

		       
		       if (B2 - Shiploc.y == 0) {
		       } else if (B2 - Shiploc.y < 0) {
		           
		           if (B2 < 9 && oceanGrid[A2][B2 + 1] != 1)
		        	   B2++;
		       } else if (B2 > 0 && oceanGrid[A2][B2 - 1] != 1)
		    	   B2--;
		}
		
		
	}


}
