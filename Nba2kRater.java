package nba2kRater;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Nba2kRater {
	
	private ArrayList<NbaTeam>teams;
	private NbaData nba = new NbaData();
	private NbaTeam team1=new NbaTeam("Bulls");
	private NbaTeam team2=new NbaTeam("Lakers");
	
	//displays the menu
	public void display_menu() 
    {
	System.out.println("Good Evening, Welcome to NBA 2k Rater Database System");
	System.out.println("1) Create A New Player \n2) View/Compare Player "
			+ "\n3) Add Existing player To A Team \n4) Compare Teams/Team VS"+ 
			"\n5) Print Roster\n6)View Team");
	System.out.print("Selection: ");
	Scanner in = new Scanner(System.in);
 	
	switch (in.nextInt()) 
	{
	
	//In case 1, we prompt the user to enter the new player's name and his stats
	//then we calculate the average stats of the user..
	//The user then will have to prompt which team should the player added
   
	    case 1:
	    	System.out.println ( "You picked option 1" );
	    	System.out.println("You better not rig your status >:( ");
	    	String name=writeText("Please enter your name");
	    	String position=writeText("Please enter your position");
	    	String height=writeText("Please enter your height");
	    	double offense=Double.parseDouble(writeText("Please enter your offense"));
	    	double rebound=Double.parseDouble(writeText("Please enter your rebound"));
	    	double speed=Double.parseDouble(writeText("Please enter your speed"));
	    	double defense=Double.parseDouble(writeText("Please enter your defense"));
	    	NbaPlayer player=new NbaPlayer(name, position, height, offense, rebound, speed, defense);
	    	player.calculateOverall();
	    	System.out.println("Your overall rating is: "+player.getOverallRating());
	    	nba.getRecords().add(player);	    		
	    	question();
	    break;
  
	    case 2:
	    	System.out.println ( "You picked option 2" );
	    	 for(int i=0;i<nba.getRecords().size();i++)//print the list
		   		{
		   			System.out.printf("\n%s",nba.getRecords().get(i).getName());
		   		}
	    	String player1Name=writeText("\nEnter a players name");
	    	int player1Pos=findPlayer(player1Name);
	    	if(player1Pos>=0)
	    	{
	    		System.out.println("Selected Player: " + nba.getRecords().get(player1Pos).toString());
	    		NbaPlayer player1=nba.getRecords().get(player1Pos);
	    		
	    		String player2Name=writeText("Enter a players name");
		    	int player2Pos=findPlayer(player2Name);
		    	//the following syntaxes will compare players and give feedbacks
		    	if(player2Pos>=0)
		    	{
		    		System.out.println("Selected Player: " + nba.getRecords().get(player2Pos).toString());
		    		NbaPlayer player2=nba.getRecords().get(player2Pos);
		            System.out.println();
		    		System.out.println("--------------------------Comparing Players-----------------------");
		    		if(player1.getOffense()>player2.getOffense())
		    		{
		    			System.out.println(player1.getName() +" will outscore more "+player2.getName());	
		    		}else{
		    			System.out.println(player2.getName() +" will outscore more "+player1.getName());	
		    		}
		    		if(player1.getDefense()>player2.getDefense())
		    		{
		    			System.out.println(player1.getName() +" is more defensive than "+player2.getName());	
		    		}else{
		    			System.out.println(player2.getName() +" is more defensive than "+player1.getName());	
		    		}
		    		if(player1.getDefense()>player2.getOffense())
		    		{
		    			System.out.println(player1.getName() +"'s defenense will stop "+player2.getName()+"'s offense");	
		    		}else{
		    			System.out.println(player2.getName() +"'s defense will stop "+player1.getName()+"'s offense");	
		    		}
		    		
		    		if(player1.getSpeed()>player2.getSpeed())
		    		{
		    			System.out.println(player1.getName() +"is faster than "+player2.getName());	
		    		}else{
		    			System.out.println(player2.getName() +"is faster than "+player1.getName());	
		    		}
		    		if(player1.getRebound()>player2.getRebound())
		    		{
		    			System.out.println(player1.getName() +" outrebounds  "+player2.getName());	
		    		}else{
		    			System.out.println(player2.getName() +" outrebounds "+player1.getName());	
		    		}
		    		if(player1.getOverallRating()>player2.getOverallRating())
		    		{
		    			System.out.println(player1.getName() +" is better than "+player2.getName());	
		    		}else{
		    			System.out.println(player2.getName() +" is better than "+player1.getName());	
		    		}	
		    	
		    		
		    	}else
		    	{
		    		writeText("Press any key to continue...");
		    	
		    	}
	    	}
		    else
	    	{
	    		writeText("Press any key to continue...");
	    	}
	    	question();
	    break;   
	    case 3:
	   
			System.out.print("THE LIST\n");
	        for(int i=0;i<nba.getRecords().size();i++)//print the list
	   		{
	   			System.out.printf("\n %d.%s",i,nba.getRecords().get(i));
	   		}

			Scanner input = new Scanner(System.in);
			int[] numbers = new int[5];
		
			System.out.print("\nPlease enter the player for team1(5max)\n");
	        for(int i = 0; i < 5; ++i)//prompt the user to enter 5 number
	        {
	            numbers[i] = input.nextInt();
	            if(numbers[i]>nba.getRecords().size()-1)//if number doesnt exist, ask them to do it again. This list accepts duplicate, dont know if that matters or not. or maybe we should do no dup.    	
	            {
	            	System.out.print("NUMBER DOESNT EXIST\n");
	            	question();
	            	
	            }          
	        }
	        
	        for(int i = 0; i < 5; ++i)// add selected player to team 1
	        {
	        	team1.addPlayer(nba.getRecords().get(numbers[i]));
	        }
	       
	        int[] number2 = new int[5];
	        System.out.print("\nThe List");
	        
	        System.out.print("\n\nPlease enter the player for team2(5max)\n");
	        for(int i = 0; i < 5; ++i)//ask for team 2 
	        {
	            number2[i] = input.nextInt();
	            if(number2[i]>nba.getRecords().size()-1)
	            {
	            	System.out.print("NUMBER DOESNT EXIST\n");
	            	question();
	            	
	            }          
	        }
	        for(int i = 0; i < numbers.length; i++)
	        {
	            for(int j = 0; j < number2.length; j++)
	            {
	                if(numbers[i] == number2[j])
	                {
	                    System.out.println("DUPLICATES EXIST");
	                    question();
	                }
	        
	            }
	        }
	        
	        for(int i = 0; i < 5; ++i)// add selected player to team 2
	        {
	        	team2.addPlayer(nba.getRecords().get(number2[i]));
	        }
	        System.out.print(team1);
	        System.out.print(team2);      
	    
	    
	       
	   question(); 	
	    break;
	    
	    
	    case 4:
	    	
	    if(team1.getsize() == 0 && team2.getsize() == 0 )
	    	
	    {
	    	System.out.println("There are no players in both teams");
	        question();	
	    }
	    
	    else{
    System.out.println("-----------------Team Vs----------------- ");
	    		if(team1.getOffense()>team2.getOffense())
	    		{
	    			System.out.println(team1.getName() +" are more aggressive than "+team2.getName());	
	    		}else{
	    			System.out.println(team2.getName() +" are more aggressive than "+team1.getName());	
	    		}
	    		if(team1.getDefense()>team2.getDefense())
	    		{
	    			System.out.println(team1.getName() +" are more defensive than "+team2.getName());	
	    		}else{
	    			System.out.println(team2.getName() +" are more defensive than "+team1.getName());	
	    		}
	    		if(team1.getSpeed()>team2.getSpeed())
	    		{
	    			System.out.println(team1.getName() +" are faster than "+team2.getName());	
	    		}else{
	    			System.out.println(team2.getName() +" are faster than "+team1.getName());	
	    		}
	    		if(team1.getRebound()>team2.getRebound())
	    		{
	    			System.out.println(team1.getName() +" outrebounds  "+team2.getName());	
	    		}else{
	    			System.out.println(team2.getName() +" outrebounds "+team1.getName());	
	    		}
	    		if(team1.getOverallRating()>team2.getOverallRating())
	    		{
	    			System.out.println(team1.getName() +" are better than "+team2.getName());	
	    		}else{
	    			System.out.println(team2.getName() +" are better than "+team1.getName());	
	    		}	
	    	
	   
	  
    	question();
	    }
    break;
	    
	    //Case 5 prints every player that exists in the roster. 
	    case 5:
	    	System.out.println(nba.toString());
	    	
	    	question();
		break;
		//Case 6 we view every team that only exists.
	    case 6:
	    	 System.out.println(team1);
	    	 System.out.println(team2);
	    	question();
	    break;
	    default:
	    	System.err.println ( "Unrecognized option" );
	    	question();
	    break;
	}

    }
    
    public ArrayList<NbaTeam> getTeams() {
		return teams;
	}

	public void setTeams(ArrayList<NbaTeam> teams) {
		this.teams = teams;
	}

	public NbaData getNba() {
		return nba;
	}

	public void setNba(NbaData nba) {
		this.nba = nba;
	}

	public void question()
    {
		System.out.println("Would you like to proceed or quit?");
		System.out.println("To return to the main menu, please press 9");
		System.out.println("If you wish to quit enter 0.");
		Scanner q = new Scanner(System.in);   
		switch (q.nextInt()) 
		{
		    case 0:
		    	System.out.println ("Thank you and Praise the Sun.");
		    break;
	  
		    case 9:
			    System.out.println ("Please proceed.");
			    display_menu();
		    break;
		    default:
		    	System.err.println ( "Unrecognized option" );
		    break;
		}
    }
 
    public Nba2kRater() 
    {
    	//loads the cvs data file into the program
    	nba.loadDataFromFile("c:\\data\\nba.csv");
    	teams=new ArrayList<>();
    	//creates 2 nba teams, the Bulls and the Lakers
    
    	display_menu();
      }

	public static void main(String[] args){
		
		Nba2kRater nbaRater=new Nba2kRater();
			
	
		
	}

	//another method to write 
	//System.out.println();
	public String writeText(String text)
	{
		System.out.println(text);
		return new java.util.Scanner(System.in).nextLine();
	}
	
	
	//method to find existing team
	public int findTeam(String name)
	{
	 //loops through the arrays of team
		for(int i=0 ;i<teams.size();i++)
		{
			//the method tries matches the user's team he's looking for. 
			//if not, it will return team not found
			if(teams.get(i).getName().equalsIgnoreCase(name))
			{
				System.out.println("Team Found");
				return i;
			}
		}
	
		System.out.println("Team not Found");
		return -1;
		
	}
	
	//similar to findTeam method except it looks for the find player
	public int findPlayer(String name)
	{   //player position represents the position of a player in the array.
		int playerPos;
		//loops through the roster size, not team array
		for(int i=0 ;i<nba.getRecords().size();i++)
		{  //then for each team, it loops the players
				if(nba.getRecords().get(i).getName().equalsIgnoreCase(name))
				{
					System.out.println("Player Found");
					playerPos=i;
					return playerPos;
				}
		}
		System.out.println("Player not Found");

		return -1;
		
	}
	
	
}


