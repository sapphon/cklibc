package space.codekingdoms.sapphon.libcncbr;

import com.codekingdoms.nozzle.base.BasePlayer;
import org.bukkit.Location;
import org.bukkit.Material;
import java.lang.Integer;

public class Player extends BasePlayer {
	
	public void onRunCommand( String command, String[] args ) {
		
		Wolf libc = new Wolf();
		switch (command) {
			
			case "/setrect":
				
				libc.setRectangle(libc.toI(args[0]), libc.toI(args[1]), libc.toI(args[2]), libc.toI(args[3]), libc.toI(args[4]), libc.toI(args[5]), args[6]);
				break;
				
				
			
			case "/explosion":
				
				libc.explosion(libc.toI(args[0]), libc.toI(args[1]), libc.toI(args[2]), libc.toF(args[3]));
				break;
				
				
			
			default :
				
				return;
				
				
			
		}
		
	
	}
	
	
}