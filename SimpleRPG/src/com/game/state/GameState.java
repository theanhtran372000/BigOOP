package com.game.state;

import com.game.gameinteface.GameWorldState;
import com.game.gameobject.Camera;
import com.game.gameobject.Hero;
import com.game.userinterface.GamePanel;


public class GameState extends State implements GameWorldState {
	
	public Hero megaman;
	public Camera camera;
	
	public GameState(GamePanel gamePanel) {
		super(gamePanel);
		
		megaman = new  Hero(0, 0, 0, 0, 0, 0, 0, this);
		camera = new Camera(0, 0, 0, 0, this);
		
	}

	@Override
	public void processPressButton(int keyEvent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processReleaseButton(int keyEvent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Render() {
		// TODO Auto-generated method stub
		
	}

}
