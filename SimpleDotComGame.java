import java.io.*;
class SimpleDotComGame{
	public static void main(String []args){
		int numOfGuess = 0;
		GameHelper helper = new GameHelper();
		SimpleDotCom com = new SimpleDotCom();
		int randomNum = (int) (Math.random() * 5);

		int[] locations = {randomNum, randomNum + 1, randomNum + 2};
		com.setLocationCells(locations);

		boolean isAlive = true;

		while(isAlive == true){
			String guess = helper.getUserInput("Enter a number");
			String result = com.checkYourself(guess);
			numOfGuess++;
			if(result.equals("kill")){
				isAlive = false;
				System.out.println("You took "+numOfGuess+" Guesses.");
			}
		}
	}
}
class SimpleDotCom{
	int[] locationCells;
	int numOfHits = 0;
	public void setLocationCells(int[] cells){
		locationCells = cells;
	}
	public String checkYourself(String stringGuess){
		int guess = Integer.parseInt(stringGuess);
		String result = "miss";
		for(int cell : locationCells){
			if(guess == cell){
				result = "hit";
				numOfHits++;
				break;
			}
		}
		if(numOfHits == locationCells.length){
			result = "kill";
		}
		System.out.println(result);
		return result;
	}
}
class GameHelper{
	public String getUserInput(String prompt){
		String inputLine = null;
		System.out.println(prompt+ " ");
		try{
		   BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
		   inputLine = is.readLine();
		   if(inputLine.length() == 0) 
		   return null;
		}catch(Exception e){
			System.out.println("IOException: "+e);
			}
		return inputLine;
	}
}