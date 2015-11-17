package objects;

import javafx.scene.image.ImageView;
import view.IView;

public class SpawnerTester implements IView{

	private ImageView image;
	private int spawnHealth;
	private int spawnNum;
	
	public SpawnerTester(int spnHp, int spnNum) {
		spawnHealth = spnHp;
		spawnNum = spnNum;
	}

	@Override
	public ImageView getView() {
		return image;
	}

	@Override
	public void setImage(ImageView iv) {
		image = iv;
		
	}

	public int getSpawnHealth() {
		return spawnHealth;
	}

	public void setSpawnHealth(int spawnHealth) {
		this.spawnHealth = spawnHealth;
	}

	public int getSpawnNum() {
		return spawnNum;
	}

	public void setSpawnNum(int spawnNum) {
		this.spawnNum = spawnNum;
	}

}
