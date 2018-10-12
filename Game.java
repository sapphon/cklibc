package space.codekingdoms.sapphon.libcncbr;

import com.codekingdoms.nozzle.base.BaseGame;
import com.codekingdoms.nozzle.utils.Random;
import com.codekingdoms.nozzle.utils.Direction;
import java.lang.Math;
import java.lang.Integer;
import java.lang.Float;
import org.bukkit.Material;
import java.util.List;
import java.util.ArrayList;
import org.bukkit.Location;

public class Game extends BaseGame {
	
	public Location nextStoryPoint;
	
	public void onCodeUpdate(){
		nextStoryPoint = new Location(world, 100d, 100d, 100d);
	}
	
	
}
