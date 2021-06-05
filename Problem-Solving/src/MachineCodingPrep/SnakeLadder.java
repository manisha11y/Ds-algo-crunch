import java.util.Scanner;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;


class Player{

	private String name;
	private Integer position = 0;
	private Boolean snakeBite;
	private Boolean ladderClimb;

	public void setName(String name){
	 this.name = name;
	}
	public String getName(){
	 return this.name;
	}
	
	public void setPosition(Integer position){
	 this.position = position;
	}
	public Integer getPosition(){
	 return this.position;
	}

	public void setSnakeBite(Boolean snakeBite){
	 this.snakeBite = snakeBite;
	}
	public Boolean getSnakeBite(){
	 return this.snakeBite;
	}

	public void setLadderClimb(Boolean ladderClimb){
	 this.ladderClimb = ladderClimb;
	}
	public Boolean getLadderClimb(){
	 return this.ladderClimb;
	}

}

class Play{

	public void makeTurn(Player player, int totalDice, Map<Integer, Integer> snakeMap, Map<Integer, Integer> ladderMap ){
		Integer oldPosition = player.getPosition();
		int dice = diceRoll(totalDice);
		Integer newPosition = player.getPosition()+dice;

		player = checkSnakeBite(player, newPosition, snakeMap);
		player = checkladderClimb(player, newPosition, ladderMap);

		String msg="";
		if(player.getSnakeBite()){
			msg = "Snake Bite!";
			player.setSnakeBite(false);
		}
		else if(player.getLadderClimb()){
			msg = "Got Ladder!";
			player.setLadderClimb(false);
		}

		System.out.printf("%b %s Rolled %d Moved From %d to %d",
		 msg, player.getName(), dice, oldPosition, player.getPosition());

	}

	public int diceRoll(Integer totalDice){
		return (int) ((Math.random() * ((6*totalDice) - 1)) + 1);
	}

	// try to remove return statement.
	public Player checkSnakeBite(Player player, Integer startPosition,
	 Map<Integer, Integer> snakeMap){
		if(snakeMap.containsKey(startPosition)){
			player.setPosition(snakeMap.get(startPosition));
			player.setSnakeBite(true);
		} else{
			player.setPosition(startPosition);
		}
		return player;
	}

	public Player checkladderClimb(Player player, Integer startPosition,
	 Map<Integer, Integer> ladderMap){
		if(ladderMap.containsKey(startPosition)){
			player.setPosition(ladderMap.get(startPosition));
			player.setSnakeBite(true);
		} else{
			player.setPosition(startPosition);
		}
		return player;		
	}
}




public class SnakeLadder{

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		// Input snake, ladder, player

		Integer totalSnake;
		Map<Integer, Integer> snake = new HashMap<>();

		Integer totalLadder;
		Map<Integer, Integer> ladder = new HashMap<>();

		Integer totalPlayer;
		Player player = new Player();
		List<Player> players = new ArrayList<>();

		totalSnake = 4;
		totalLadder = 3;
		totalPlayer = 3;

		snake.put(56, 6);
		snake.put(42, 2);
		snake.put(30, 7);
		snake.put(98, 5);
		ladder.put(3, 57);
		snake.put(18, 34);
		snake.put(39, 75);
		player.setName("Vansh");
		players.add(0, player);
		player.setName("Mini Didi");
		players.add(1, player);

		Play play = new Play();
		for(Player pl: players){
			if(pl.getPosition() == 100){
				System.out.printf("%s is the Winner!", pl.getName());
			}
			else play.makeTurn(pl, 1, snake, ladder);
		}




		totalSnake = sc.nextInt();
		// for(int i = 0; i< totalSnake ;i++){

		// 	snake.put(sc.nextInt(), sc.next)
		// }

		totalLadder = sc.nextInt();
		// for(int i = 0; i< totalSnake ;i++){

		// 	snake.put(sc.nextInt(), sc.next)
		// }

		totalPlayer = sc.nextInt();
		// for(int i = 0; i< totalSnake ;i++){

		// 	snake.put(sc.nextInt(), sc.next)
		// }


	}

	
}