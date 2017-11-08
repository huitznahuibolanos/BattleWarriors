import java.awt.Graphics;


public class GameStateContext {


	private GameStateRunning run;
	private GameStatePaused pause;
	private GameStateGameOver go;
	private GameState current;
	private int width, height;
	private Entity_mgr entities;
	
	public GameStateContext(int w, int h){
		run = new GameStateRunning(this);
		pause = new GameStatePaused(this);
		go = new GameStateGameOver(this);
		current = run;
		width=w-25;
		height=h-50;
		entities= new Entity_mgr();
		
		
	}
	




	public Entity_mgr getEntities() {
		return entities;
	}





	public void setEntities(Entity_mgr entities) {
		this.entities = entities;
	}





	public int getWidth() {
		return width;
	}





	public void setWidth(int width) {
		this.width = width;
	}





	public int getHeight() {
		return height;
	}





	public void setHeight(int height) {
		this.height = height;
	}





	public GameState getRun(){
		return run;
	}
	
	public GameState getPause(){
		return pause;
	}
	
	public GameState getGameOver(){
		return go;
	}
	
	public void setCurrent(GameState gs){
		current = gs;
	}
	
	public void end(){
		current.end();
	}
	
	public void resume(){
		current.resume();
	}
	
	public void pause(){
		current.pause();
	}
	
	public void update(){
		current.update();
	}
	
	public void render(Graphics g){
		current.render(g);
	}





	public void move(int i, int j) {
		entities.pers[j].setDireccion(i);
		if(!entities.checkPersPared(j)){
			entities.pers[j].vels(i);
		}
		
	}





	public void stop(int i,int j) {
		entities.pers[j].detenerse(i);
	}





	public void dispara(int i) {
		entities.dispara(i);
	}





	public void secondP() {
		entities.pers[1].setAlive(true);
		
	}
	

	
}
