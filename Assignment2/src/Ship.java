import java.awt.Point;
import java.util.Observable;

import javafx.scene.layout.AnchorPane;

public class Ship extends Observable{  
int a,b;
Point Location;
AnchorPane root;
public Ship(int c, int d) {

a = c;
b = d;

}

public Point getShipLocation() {    //gets the ship location
	// TODO Auto-generated method stubss
	return new Point(a,b);

	}

public Ship(OceanMap oceanMap) 
{
// TODO Auto-generated constructor stub
}

public void movedown(int[] IslandlocationXcor,int[] IslandlocationYcor) { //moves the ship toward down
	// TODO Auto-generated method stub
	Boolean squareempty = true;
	if (b != 9)
	{
	for(int i=0;i<IslandlocationYcor.length;i++)
	{
	if(IslandlocationXcor[i] != 0 && IslandlocationYcor[i] != 0 && a == IslandlocationXcor[i] && b+1 == IslandlocationYcor[i])
	{
	squareempty =false;
	break;
	}
	}
	if(squareempty) {
	b++;
	setChanged();
	notifyObservers();
	}
	}}


public void moveleft(int[] IslocX,int[] IslocY) //moves the ship towards the left side
{
// TODO Auto-generated method stub
Boolean squareempty = true;
if (a != 0)
{
for(int i=0;i<IslocX.length;i++)
{
if(IslocX[i] != 0 && IslocY[i] != 0 && a-1 == IslocX[i] && b == IslocY[i])
{
squareempty =false;
break;
}

}
if(squareempty) {
	a--;
setChanged();
notifyObservers();

}}

}

public void moveup(int[] IslandlocationXcor,int[] IslandlocationYcor) //moves the ship towards up direction
{
// TODO Auto-generated method stub
Boolean squareempty = true;
if (b != 0)
{
	
for(int i=0;i<IslandlocationYcor.length;i++)
{
if(IslandlocationXcor[i] != 0 && IslandlocationYcor[i] != 0 && a == IslandlocationXcor[i] && b-1 == IslandlocationYcor[i])
{
squareempty =false;
break;
}
}
if(squareempty) {
b--;
setChanged();
notifyObservers();
}}

}
public void moveright(int[] IslocX,int[] IslocY) //moves the ship towards right
{
// TODO Auto-generated method stub
Boolean iscellempty = true;
if (a != 9)
{
for(int i=0;i<IslocX.length;i++)
{
if(IslocX[i] != 0 && IslocY[i] != 0 && a+1 == IslocX[i] && b == IslocY[i])
{
iscellempty =false;
break;
}
}
if(iscellempty) {
a++;
setChanged();
notifyObservers();
}}
}
}