//The NBA record class creates and sets the player objects

package nba2kRater;

import java.util.ArrayList;

public class NbaPlayer {
	
	private double offense, rebound, speed, defense,overallRating;
    private String name,position,height;
	//the constructor
	public NbaPlayer(String name, String position, String height, double offense, double rebound, double speed, double defense) {
		this.name = name;
		this.position = position;
		this.height = height;
		this.offense = offense;
		this.rebound = rebound;
		this.speed = speed;
		this.defense = defense;
	}
	//Overload constructer, why? because the overallRating calculates itself, and the overall rating
	public NbaPlayer(String name, String position, String height, double offense, double rebound, double speed, double defense,double overallrating) {
		this.name = name;
		this.position = position;
		this.height = height;
		this.offense = offense;
		this.rebound = rebound;
		this.speed = speed;
		this.defense = defense;
		this.overallRating=overallrating;
	}

	//calculates the averages of the players
	public void calculateOverall()
	{
		overallRating=offense+rebound+speed+defense;
		overallRating=overallRating/4;
	}
	
	
//the following methods are the setters and getters method
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}





	public String getPosition() {
		return position;
	}





	public void setPosition(String position) {
		this.position = position;
	}





	public String getHeight() {
		return height;
	}





	public void setHeight(String height) {
		this.height = height;
	}





	public double getOffense() {
		return offense;
	}

	public void setOffense(double offense) {
		this.offense = offense;
	}

	public double getRebound() {
		return rebound;
	}

	public void setRebound(double rebound) {
		this.rebound = rebound;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public double getDefense() {
		return defense;
	}

	public void setDefense(double defense) {
		this.defense = defense;
	}

	public double getOverallRating() {
		return overallRating;
	}

	public void setOverallRating(double overallRating) {
		this.overallRating = overallRating;
	}

//The toString method formats the printing style of the player object class

	@Override
	public String toString() {
		return "Player [name = " + name + ", offense =" + offense + ", rebound=" + rebound + ", speed=" + speed + ", defense =" + defense
				+ ", Overall Rating =" + overallRating + ", position =" + position + ", height="
				+ height + "]";
	}
	
	
}

