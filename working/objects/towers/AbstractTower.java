package objects.towers;

import javafx.scene.image.ImageView;

public class AbstractTower implements ITower {
	
	private ImageView image;	// later need to replaced by IGameObject instance
	private int maxHealth;
	private int damage;
	
	public ImageView getImage() {
		return image;
	}
	
	public int getMaxHealth() {
		return maxHealth;
	}

	public int getDamage() {
		return damage;
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


}
