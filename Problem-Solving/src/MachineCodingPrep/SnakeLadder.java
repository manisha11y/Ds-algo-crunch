package MachineCodingPrep;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

class Player {

	private String name;
	private Integer position = 0;
	private Boolean snakeBite = false;
	private Boolean ladderClimb = false;

	Player(String name) {
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public Integer getPosition() {
		return this.position;
	}

	public void setSnakeBite(Boolean snakeBite) {
		this.snakeBite = snakeBite;
	}

	public Boolean getSnakeBite() {
		return this.snakeBite;
	}

	public void setLadderClimb(Boolean ladderClimb) {
		this.ladderClimb = ladderClimb;
	}

	public Boolean getLadderClimb() {
		return this.ladderClimb;
	}

}

class Play {

	public void makeTurn(Player player, int totalDice, Map<Integer, Integer> snakeMap,
			Map<Integer, Integer> ladderMap) {
		Integer oldPosition = player.getPosition();
		int dice = diceRoll(totalDice);
		Integer newPosition = player.getPosition() + dice;

		player = checkSnakeBite(player, newPosition, snakeMap);
		if (!player.getSnakeBite()) {
			player = checkladderClimb(player, newPosition, ladderMap);
		}

		System.out.printf("%s %s Rolled %d, Moved From %d to %d\n",
				player.getLadderClimb() == true ? "GOT LADDER!" : player.getSnakeBite() == true ? "SNAKE BITE!" : "",
				player.getName(), dice, oldPosition, player.getPosition());

//		StringBuilder msg = new StringBuilder();
		if (player.getSnakeBite()) {
//			msg.re "Snake Bite!";
			player.setSnakeBite(false);
		} else if (player.getLadderClimb()) {
//			msg = "Got Ladder!";
			player.setLadderClimb(false);
		}

	}

	public int diceRoll(Integer totalDice) {
		int max = 6 * totalDice;
		int min = 1;
		return (int) ((Math.random() * ((max + 1) - min)) + min);
	}

	// try to remove return statement.
	public Player checkSnakeBite(Player player, Integer startPosition, Map<Integer, Integer> snakeMap) {
		if (snakeMap.containsKey(startPosition)) {
			player.setPosition(snakeMap.get(startPosition));
			player.setSnakeBite(true);
		} else {
			if (startPosition <= 100)// to avoid outbound
				player.setPosition(startPosition);
		}
		return player;
	}

	public Player checkladderClimb(Player player, Integer startPosition, Map<Integer, Integer> ladderMap) {
		if (ladderMap.containsKey(startPosition)) {
			player.setPosition(ladderMap.get(startPosition));
			player.setLadderClimb(true);
		} else {
			if (startPosition <= 100) // avoid outbound
				player.setPosition(startPosition);
		}
		return player;
	}
}

public class SnakeLadder {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// Input snake, ladder, player

		Integer totalSnake;
		Map<Integer, Integer> snake = new HashMap<>();

		Integer totalLadder;
		Map<Integer, Integer> ladder = new HashMap<>();

		Integer totalPlayer;
		Player player = null;
		List<Player> players = new ArrayList<>();
//Testable hardcoded inputs
//		totalSnake = 4;
//		totalLadder = 3;
//		totalPlayer = 3;

//		snake.put(56, 6);
//		snake.put(42, 2);
//		snake.put(30, 7);
//		snake.put(98, 5);
//		ladder.put(3, 57);
//		ladder.put(18, 34);
//		ladder.put(39, 75);
//		players.add(0, new Player("Vansh"));
//		players.add(1, new Player("Mini Didi"));
//		players.add(1, new Player("Ashi"));		

		totalSnake = sc.nextInt();
		for (int i = 0; i < totalSnake; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			snake.put(start, end);
		}

		totalLadder = sc.nextInt();
		for (int i = 0; i < totalLadder; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			ladder.put(start, end);
		}

		totalPlayer = sc.nextInt();
		for (int i = 0; i <= totalPlayer; i++) {
//			 String name = sc.nextLine();			 
			players.add(i, new Player(sc.nextLine()));
		}

		Play play = new Play();
		Boolean winner = false;

		while (winner != true) {
			for (int pl = 0; pl < totalPlayer; pl++) {
				play.makeTurn(players.get(pl), 1, snake, ladder);
				if (players.get(pl).getPosition() == 100) {
					winner = true;
					System.out.printf("%s is the Winner!", players.get(pl).getName());
					break;
				}
			}
		}

	}

}

/*
 * 4 56 6 42 2 30 7 98 5 3 3 57 18 34 39 75 3 Vansh Mini Ashi
 */