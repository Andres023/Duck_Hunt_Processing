package game;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Classic Atari Game - Duck Hunt - Foundaments of data structures
 * @author Andrés
 * 01/12/2018
 */
public class DuckHunt extends PApplet{
	
	//Positions and velocities of ducks
	int x = (int) (Math.random() * 1280) + 1;
	int y = (int) (Math.random() * 769) + 1;
	int vx = 8;
	int vy = 8;
	int x2 = (int) (Math.random() * 1280) + 1;
	int y2 = (int) (Math.random() * 769) + 1;
	int vx2 = 8;
	int vy2 = 8;
	int diameter = 80;
	
	//Postion of dog
	int xd = 20;
	int yd = 500;
	int vd = 4;
	
	//Score
	int score = 0;
	
	//Declarate the sprites of the game
	PImage background;
	PImage duck;
	PImage duckR;
	PImage duckL;
	PImage duck2;
	PImage duckR2;
	PImage duckL2;
	PImage dog;
	PImage dogR;
	PImage dogL;
	
	/**
	 * Setup class
	 */
	public void settings() {
		  size(1280, 769);//Set the dimensions of the window
		  background = loadImage("DuckHunt_Background.png"); //Load the background
		  
		  //Load the sprietes of the ducks
		  duck = loadImage ("Duck_Sprite_Rigth.png");
		  duckR = loadImage ("Duck_Sprite_Rigth.png");
		  duckL = loadImage ("Duck_Sprite_Left.png");
		  duck2 = loadImage ("Duck_Sprite_Rigth.png");
		  duckR2 = loadImage ("Duck_Sprite_Rigth.png");
		  duckL2 = loadImage ("Duck_Sprite_Left.png");
		  dog = loadImage ("Dog_Sprite_R.png");
		  dogR = loadImage ("Dog_Sprite_R.png");
		  dogL = loadImage ("Dog_Sprite_L.png");
		  //textSize(20);
		  
		}
	
	/**
	 * Draw class
	 */
	public void draw() {
		//background(0,0,0);
		image(background, 0, 0);//Set the background image in the position 0,0
		image (duck, x, y);//Set the sprite of the duck in the position x,y
		image (duck2, x2, y2);//Set the sprite of the duck in the position x2,y2
		text("Score = " + score, 1100, 40); 
		image (dog, xd, yd);
		
		//ellipse (x,y,50,50);
		//ellipse (x2,y2,50,50);
		
		//Move the duck in a diagonal sense
		x += vx;
		y += vy;
		x2 += vx2;
		y2 += vy2;
		
		xd += vd;//Move the dog in a horizontal sense
		
		//Move dog
		if (xd > 1100) {
			vd = -4;
			dog = dogL;
		}
		if(xd < 20) {
			vd = 4;
			dog = dogR;
		}
		
		//Move first Duck
		if (x > 1200) {
			vx = -8;
			duck = duckL;
		}
		if(x < 0) {
			vx = 8;
			duck = duckR;
		}
		if (y > 580 || y < 0) {
			vy *= -1;
		}
		
		//Move second duck
		if (x2 > 1200) {
			vx2 = -8;
			duck2 = duckL2;
		}
		if(x2 < 0) {
			vx2 = 8;
			duck2 = duckR2;
		}
		if (y2 > 580 || y2 < 20) {
			vy2 *= -1;
		}
		
		//Determinate the distance of the mouse position respect than the position of the duck
		int distance = (int) dist(mouseX , mouseY, x, y); 
		int distance2 = (int) dist(mouseX , mouseY, x2, y2);
		
		if(mousePressed) {
			if(distance < diameter) {
				x = (int) (Math.random() * 450) + 1;
				y = (int) (Math.random() * 500) + 1;
				score += 900;
				fill(255);
				text("Score = " + score, 110, 40); 
				System.out.println("Score = " + score);
			}
		}
		if(mousePressed) {
			if(distance2 < diameter) {
				x2 = (int) (Math.random() * 450) + 1;
				y2 = (int) (Math.random() * 500) + 1;
				score += 900;
				fill(255);
				text("Score = " + score, 1100, 40); 
				System.out.println("Score = " + score);
			}
		}
	  }	
	
	/**
	 * Main Class
	 * @param args
	 */
	public static void main (String [] args) {
		String[] appletArgs = new String[] {"game.DuckHunt"};
		PApplet.main(appletArgs);
	}

	}