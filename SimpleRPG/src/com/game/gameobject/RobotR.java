package com.game.gameobject;

import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.game.effect.Animation;
import com.game.effect.DataLoader;
import com.game.state.GameState;



public class RobotR extends SpecificObject{
private Animation forwardAnim, backAnim;

private long startTimeToShoot;
private float x1,x2,y1,y2;
private AudioClip shooting;

public RobotR(float x, float y, GameState gameState) {
	super(x,y, 127, 89,0, 100, 90, gameState);
	backAnim=DataLoader.getInstance().getAnimations().get("robotR");
	forwardAnim= DataLoader.getInstance().getAnimations().get("robotR");
	forwardAnim.flipAllImages();
	startTimeToShoot=0;
	setBeginTimeToBeHurt(300000000);
	setDamage(20);
	
	x1=x-100;
	x2=x+100;
	y1=y-50;
	y2=y+50;
	
	setSpeedX(1);
	setSpeedY(1);
	
	shooting=DataLoader.getInstance().getSounds().get("robotRshooting");
	
}


@Override
public void attack() {
//	shooting.play();
//	Bullet bullet= new RobotRBullet(getPosX(),getPosY(), getGameState());
//	
//	if(getDirection()==LEFT_DIR) 
//		bullet.setSpeedX(5);
//		else bullet.setSpeedX(-5);
//		bullet.setTeamType(getTeamType());
//		getGameState().bulletManager.addObject(bullet);
	
	
}

@Override
public Rectangle getBoundForCollisionWithEnemy() {
Rectangle rect= getBoundForCollisionWithMap();
rect.x+=20;
rect.width-=40;

return rect;
}

@Override
public void draw(Graphics g) {
	if(!isOutOfCameraView()) {
		if(getState()==CANTBEHURT && (System.nanoTime()/10000000)%2!=1) {
			//plash...
		}
		else {
			if(getDirection()==LEFT_DIR) {
				backAnim.Update(System.nanoTime());
				backAnim.draw(g, (int)(getPosX()-getGameState().camera.getPosX()), (int)(getPosY()-getGameState().camera.getPosY()));
			}
			else {
				forwardAnim.Update(System.nanoTime());
				forwardAnim.draw(g, (int)(getPosX()-getGameState().camera.getPosX()), (int)(getPosY()-getGameState().camera.getPosY()));
			}
		}
	}
	
}
@Override
public void Update(){
    super.Update();
    
    if(getPosX() - getGameState().megaman.getPosX() > 0) setDirection(SpecificObject.RIGHT_DIR);
    
    else setDirection(SpecificObject.LEFT_DIR);
    
    if(getPosX()-getGameState().megaman.getPosX() < 5)   
        setSpeedX(1);
    else if(getPosX()-getGameState().megaman.getPosX() > 5)
        setSpeedX(-1);
    setPosX(getPosX() + getSpeedX());
    
    if(getPosY()-getGameState().megaman.getPosY() < 5)
        setSpeedY(1);
    else if(getPosY()-getGameState().megaman.getPosY()  > 5)
        setSpeedY(-1);
    setPosY(getPosY() + getSpeedY());
    
    if(System.nanoTime() - startTimeToShoot > 1000*10000000*1.5){
        attack();
        startTimeToShoot = System.nanoTime();
    }

}

}
