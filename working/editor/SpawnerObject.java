package editor;

import javafx.scene.image.ImageView;

public class SpawnerObject {

	private ImageView image;	// later need to replaced by IGameObject instance
	private int maxHealth;
	private int damage;
	private int spawnNum;
	
	public ImageView getImage() {
		return image;
	}
	
	public int getMaxHealth() {
		return maxHealth;
	}

	public int getDamage() {
		return damage;
	}
	
	public int getSpawnNum() {
		return spawnNum;
	}
	
	public void setImage(ImageView image) {
		this.image = image;
	}
	
	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}
	
	public void setDamage(int damage) {
		this.damage = damage;
	}

	public void setSpawnNum(int spawnNum) {
		this.spawnNum = spawnNum;
	}

}