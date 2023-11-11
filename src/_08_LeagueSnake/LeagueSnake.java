package _08_LeagueSnake;

import java.util.ArrayList;

import processing.core.PApplet;

public class LeagueSnake extends PApplet {
	static final int WIDTH = 800;
	static final int HEIGHT = 800;

	/*
	 * Game variables
	 * 
	 * Put all the game variables here.
	 */

	Segment head;
	int foodX;
	int foodY;
	int direction = UP;
	int foodEaten = 0;
	ArrayList<Segment> snakeTail = new ArrayList<Segment>();

	/*
	 * Setup methods
	 * 
	 * These methods are called at the start of the game.
	 */
	@Override
	public void settings() {
		size(500,500);
	}

	@Override
	public void setup() {
		head = new Segment(50, 50);
		frameRate(20);
		dropFood();

	}

	void dropFood() {
		// Set the food in a new random location
		foodX = ((int)random(50)*10);
		foodY = ((int)random(50)*10);
	}

	/*
	 * Draw Methods
	 * 
	 * These methods are used to draw the snake and its food
	 */

	@Override
	public void draw() {
		background(0,0,0);
		drawFood();
		move();
		drawSnake();
		eat();
	}

	void drawFood() {
		// Draw the food
		fill(255,0,0);
		rect(foodX,foodY,10,10);

	}

	void drawSnake() {
		// Draw the head of the snake followed by its tail
		fill(0,255,0);
		rect(head.x,head.y,10,10);
		manageTail();

	}

	void drawTail() {
		// Draw each segment of the tail

		fill(0,255,0);

		for(int i = 0; i < snakeTail.size(); i++) {
			rect(snakeTail.get(i).x, snakeTail.get(i).y, 10, 10);
		}
	}

	/*
	 * Tail Management methods
	 * 
	 * These methods make sure the tail is the correct length.
	 */

	void manageTail() {

		checkTailCollision();
		drawTail();

		// After drawing the tail, add a new segment at the "start" of the tail and
		// remove the one at the "end"
		// This produces the illusion of the snake tail moving.

		snakeTail.add(new Segment(head.x, head.y));
		snakeTail.remove(0);


	}

	void checkTailCollision() {
		// If the snake crosses its own tail, shrink the tail back to one segment
		for(int i = 0; i < snakeTail.size(); i++) {
			if(head.x == snakeTail.get(i).x && head.y == snakeTail.get(i).y) {
				foodEaten = 1;
				snakeTail.clear();
				snakeTail.add(new Segment(head.x, head.y));
			}

		}		

	}

	/*
	 * Control methods
	 * 
	 * These methods are used to change what is happening to the snake
	 */

	@Override
	public void keyPressed() {
		// Set the direction of the snake according to the arrow keys pressed
		if(key == CODED) {
			if(keyCode == UP && direction != DOWN) {
				direction = UP;
			}
			else if(keyCode == DOWN && direction != UP) {
				direction = DOWN;
			}
			else if(keyCode == LEFT && direction != RIGHT) {
				direction = LEFT;
			}
			else if (keyCode == RIGHT && direction != LEFT) {
				direction = RIGHT;
			}
		}

	}

	void move() {
		// Change the location of the Snake head based on the direction it is moving.

		if (direction == UP) {
			// Move head up
			head.y = head.y - 10;

		} else if (direction == DOWN) {
			// Move head down
			head.y = head.y + 10;

		} else if (direction == LEFT) {

			head.x = head.x - 10;

		} else if (direction == RIGHT) {

			head.x = head.x + 10;

		}

		checkBoundaries();

	}

	void checkBoundaries() {
		// If the snake leaves the frame, make it reappear on the other side
		if(head.x > 500) {
			head.x = -10;
		}

		if(head.x < -10) {
			head.x = 500;
		}

		if(head.y < -10) {
			head.y = 500;
		}

		if(head.y > 500) {
			head.y = -10;
		}
	}

	void eat() {
		// When the snake eats the food, its tail should grow and more
		// food appear

		if(head.x == foodX && head.y == foodY) {
			foodEaten ++;
			snakeTail.add(new Segment(head.x, head.y));
			dropFood();
		}



	}

	static public void main(String[] passedArgs) {
		PApplet.main(LeagueSnake.class.getName());
	}
}
