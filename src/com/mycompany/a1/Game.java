package com.mycompany.a1;

import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import java.lang.String;

public class Game extends Form {
	private GameWorld gw;

	public Game() {
		gw = new GameWorld();
		this.gw.init();
		play();

	}

	private void play() {
		System.out.println("new Game");
		Label myLabel = new Label("enter a command");
		this.addComponent(myLabel);
		final TextField myTextField = new TextField();
		this.addComponent(myTextField);
		this.show();

		myTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userCommands = myTextField.getText().toString();

				switch (userCommands.charAt(0)) {
				case 'a':
					System.out.println("You added a asteroid");
					gw.addAsteroid();
					break;
				case 'b':
					gw.addSpaceStation();
					break;
				case 's':
					gw.addShip();
					break;
				case 'i':
					System.out.println("Increase sheep speed.");
					gw.increaseShipSpeed();
					break;
				case 'd':
					System.out.println("decrease speed");
					gw.decreaseShipSpeed();
					break;
				case 'l':
					System.out.println("turning left");
					gw.turnShipLeft();
					break;
				case 'r':
					System.out.println("turning right");
					gw.turnShipRight();
					break;
				case 'f':
					gw.FireMissiles();
					break;
				case 'j':
					System.out.println("hyperspace");
					gw.jumpHyperspace();
					break;
				case 'n':
					break;
				case 'k':
				case 'c':
				case 'x':
				case 't':
					gw.tickTimer();
					break;
				case 'm':
					gw.printMap();
					break;
				case 'p':
					gw.printCurrentStateOfGame();
					break;
				case 'q':
					break;	
				default:
					System.out.println("invalid key");
				}
			}
		});

	} // end play

}
