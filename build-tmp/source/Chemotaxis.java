import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Chemotaxis extends PApplet {

int bacNum = 80;
int sizing = 500;
Bacteria[] gel = new Bacteria[bacNum];
 public void setup()   
 {
   for(int i = 0; i <= (bacNum-1); i++)
   {
     gel[i] = new Bacteria(((int)(Math.random()*500)),((int)(Math.random()*500)),((int)(Math.random()*50)),i);
   }     
   size(sizing,sizing);
   rectMode(CENTER); 
 }

 public void draw()   
 {
   background(49, 230, 73,30);
   for(int i = 0; i <= (bacNum-1); i++)
   {
      //if(exploding == false)
      //{
      //  gel[i].move();
      //}
      //if(exploding == true)
      //{
      // gel[i].explode();
      //}
     gel[i].explode();    
     gel[i].show();
     gel[i].move();
   }
 }

 public void mousePressed()
 {
  
  for(int i = 0; i <= (bacNum-1); i++)
   {
     gel[i].exploding = true;    
     gel[i].explode();
   }
 }

 class Bacteria    
 {
   float myX,myY,color1,color2,color3,mySize;
   int myNum;
   boolean exploding;
   Bacteria(int x,int y,int size,int i)
   {
     myX = x;
     myY = y;
     color1 = (int)(Math.random()*255);
     color2 = (int)(Math.random()*255);
     color3 = (int)(Math.random()*255);
     mySize = size;
     myNum = i;
     exploding = false;
   }
   public void move()
   {
    if(mouseX > myX)
    {
      myX = myX + (int)(Math.random()*5)-1;
    }
    else 
    {
      myX = myX + (int)(Math.random()*5)-4;
    }
    if(mouseY > myY)
    {
      myY = myY + (int)(Math.random()*5)-1;
    }
    else 
    {
      myY = myY + (int)(Math.random()*5)-4;
    }  
   }
   public void show()
   {
     stroke(165,162,243);
     fill(color1,color2,color3,80);
     rect(myX,myY,mySize,mySize);
   }
   public void explode()
   {
    if(exploding == true)
    {
    if(myX > (mouseX))
    {
      myX = myX + 3;
      if(myX >500)
      {
        exploding = false;
      }
    }
    if(myY > (mouseY))
    {
      myY = myY + 3;
      if(myY > 500)
      {
        exploding = false;
      }
    }
    if(myX <= (mouseX))
    {
      myX = myX - 3;
      if(myX < 0)
      {
        exploding = false;
      }
    }
    if(myY <= (mouseY))
    {
      myY = myY - 3;
      if(myY < 0)
      {
        exploding = false;
      }
    }
  }
  }
 }      
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Chemotaxis" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
