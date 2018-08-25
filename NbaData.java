//the purpose of this class is to store every single data
//from CVS File

package nba2kRater;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
//import links multiple classes together.
import nba2kRater.NbaPlayer;

public class NbaData {
	private ArrayList<NbaPlayer> records;
//the constructer 
	public NbaData()
	{
		records = new ArrayList<NbaPlayer>();
		
	}
	
	// tells us how many sizes in the roster
public ArrayList<NbaPlayer> getRecords() {
		return records;
	}

//The toString method to show players
	@Override
public String toString() {
	// TODO Auto-generated method stub
	String text="Player List\n";
	for(NbaPlayer player:records){
		text=text+player.toString()+"\n";
	}
	
	return text;
}

	public void setRecords(ArrayList<NbaPlayer> records) {
		this.records = records;
	}

public NbaPlayer getRecordNumber(int i)
{
return records.get(i);

}

public int getNumberOfRecords(){
	
	return records.size();
}


public void loadDataFromFile(String filepath)
{
	try{
		Scanner scanner = new Scanner(new FileReader(filepath));
		String line;
		NbaPlayer player;
		scanner.nextLine();//the reason we put this line here so we can avoid  the top columns to be parse
	while(scanner.hasNextLine()){
		line = scanner.nextLine();//gets the line
		String[] results = line.split(",");//split it up on the commas
		
		////the following code parse the results
		Double offense = Double.parseDouble(results[3]);//prase the results
		Double rebound = Double.parseDouble(results[4]);
		double speed = Double.parseDouble(results[5]);
		double defense = Double.parseDouble(results[6]);
		double overallRating = Double.parseDouble(results[7]);
		//creating the record :3 
player = new NbaPlayer(results[0],results[1],results[2],offense,rebound,speed,defense,overallRating);
		
		records.add(player);//add the record into a list
	}
	scanner.close();
	
	
	}
	
	catch(Exception e){
		System.out.println("Error: " + e.getMessage());
		
	}

}

}
