package nba2kRater;
//the NBA team class creates the nba "team" object
import java.util.ArrayList;

public class NbaTeam {

	String name;
	ArrayList<NbaPlayer>roster;
	
	private double offense, rebound, speed, defense,overallRating;
	
	public NbaTeam(String name)
	{
		this.name=name;
		roster=new ArrayList<NbaPlayer>();
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

	
	//adds the player to the team
	public void addPlayer(NbaPlayer player)
	{
		if(this.roster.size()<5)
		{ 
			if(this.roster.contains(player))
			{
				System.out.println("Player already exists!");
			}
			else
			{
				this.roster.add(player);
			}
		}
		else
		{
			System.out.println("The Team is already full, cannot be added");
		}
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<NbaPlayer> getRoster() {
		return roster;
	}
	public void setRoster(ArrayList<NbaPlayer> roster) {
		this.roster = roster;
	}
	public int getsize()
	{
		return this.roster.size();
	}

	@Override
	public String toString() {
		String myRoster="Team Name :"+name+"\n";
		for(NbaPlayer player: roster)
		{
			myRoster=myRoster+player.toString()+"\n";
		}
		return myRoster;
	}


	public void calculateStats()
	{
		this.offense=0;
		this.defense=0;
		this.speed=0;
		this.rebound=0;
		this.overallRating=0;
		for(NbaPlayer player:roster)
		{
			this.offense+=player.getOffense();
			this.defense+=player.getDefense();
			this.speed+=player.getSpeed();
			this.rebound+=player.getRebound();
			this.overallRating+=player.getOverallRating();
		}
		this.offense=this.offense/this.roster.size();
		this.defense=this.defense/this.roster.size();
		this.speed=this.speed/this.roster.size();
		this.rebound=this.rebound/this.roster.size();
		this.overallRating=this.overallRating/this.roster.size();
		
	}
	
}
