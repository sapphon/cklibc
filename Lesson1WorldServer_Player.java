package space.codekingdoms.sapphon.sheepcity2;

import com.codekingdoms.nozzle.base.BasePlayer;
import java.lang.Integer;
import java.lang.Float;
import java.util.Map;
import java.util.LinkedHashMap;

public class Player extends BasePlayer {
	
	protected Map<String,Integer> commandToCostMap;
	
	public void jump( String height ) {
		
		jump(Float.parseFloat(height));
	
	}
	
	public void onRunCommand( String command, String[] args ) {
		if (command.contains("jump")) {
			if(checkXP(command)){
				deductXp(command);
				jump("1.1");
			}
			else{
				getGame().broadcastMessage("Not enough experience.");
			}
		}
	}
	
	public void onStart(){
		commandToCostMap = new LinkedHashMap<String, Integer>();
		commandToCostMap.put("/jump", 2);
	}

	protected void deductXp(String command){
		Integer cost = getCostForCommandOrNegativeOneIfNotFound(command);
		setLevel(getLevel() - cost);
	}
	
	Boolean checkXP(String command){
		Integer costOfCommand = getCostForCommandOrNegativeOneIfNotFound(command);
		if(costOfCommand < 0){
			return false;
		}
		return getLevel() >= costOfCommand;
	}
	
	Integer getCostForCommandOrNegativeOneIfNotFound(String command){
		return commandToCostMap.get(command) == null ? -1 : commandToCostMap.get(command);
}
	
	
}
