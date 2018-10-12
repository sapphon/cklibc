package space.codekingdoms.sapphon.libcncbr;

import com.codekingdoms.nozzle.base.BaseWolf;
import com.codekingdoms.nozzle.utils.Random;
import com.codekingdoms.nozzle.utils.Direction;
import java.lang.Math;
import java.lang.Integer;
import java.lang.Float;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.Material;
import java.util.List;
import java.util.ArrayList;

public class Wolf extends BaseWolf {
	
	public String getBlock( int x, int y, int z ) {
		
		String s = getWorld().getBlockAt(x, y, z).toString();
		return s;
	
	}
	
	public void setBlock( int x, int y, int z, Material block ) {
		
		getGame().setBlockTypeAtLocation(block, new Location(world, x, y, z));
	
	}
	
	public void findStoryPointWithinRadius(int radius, Player seeker){
		String result = "You can detect no disturbances in the world code within that distance.";
		double difference = getDistanceBetweenLocations(seeker.getLocation(), getGame().nextStoryPoint);
		if(radius >= difference){
			result = String.valueOf(difference);
		}
		getGame().broadcastMessage(result);
	}
	
	public double getDistanceBetweenLocations(Location origin, Location destination){
		double xDiffSquared = squareDifference(origin.getX(), destination.getX());
		double yDiffSquared = squareDifference(origin.getY(), destination.getY());
		double zDiffSquared = squareDifference(origin.getZ(), destination.getZ());
		
		return Math.sqrt(xDiffSquared + yDiffSquared + zDiffSquared);
	}
	
	public double squareDifference(double num1, double num2){
		double difference = num2 - num1;
		return difference * difference;
	}
	
	public void setRectangle( int x, int y, int z, int x2, int y2, int z2, String blockName ) {
		
		Material block = Material.getMaterial(blockName.toUpperCase());
		getGame().setBlockTypeInArea(block, new Location(world, x, y, z), new Location(world, x2, y2, z2));
	
	}
	
	public void explosion( int x, int y, int z, float power ) {
		getGame().getWorld().createExplosion(new Location(world, x, y, z), power);
	}
	
	public int toI( String toConvert ) {
		
		int toReturn = Integer.parseInt(toConvert);
		return toReturn;
	
	}
	
	public float toF( String toConvert ) {
		
		float toReturn = Float.parseFloat(toConvert);
		return toReturn;
	
	}
	
	
}
