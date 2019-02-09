import java.util.Random;
import java.lang.*;
public class MainActivity {
	
	public static void main(String[] args) {
		
		
		int tick = 0;
		Random rnd = new Random();
		int randomValue = rnd.nextInt(4) + 15;
		District DistrictArray[] = new District[randomValue];
		for (int i = 0; i != randomValue; i++) {
			DistrictArray[i] = new District();
			DistrictArray[i].name = "District " + i;
		}
		for (int i = 1; i != randomValue; i++) {
			boolean uniqueCoords = false;
			while (uniqueCoords == false) {	
				uniqueCoords = true;
				DistrictArray[i].setX(rnd.nextInt(5) - 2);
				DistrictArray[i].setY(rnd.nextInt(5) - 2);
				for (int j = 0; j!=i; j++){
					if (DistrictArray[i].x == DistrictArray[j].x && DistrictArray[i].y == DistrictArray[j].y) {
						uniqueCoords = false;
					}
				}
			
			}
			for (int j = 0; j!=i; j++) {
				if (Math.abs(DistrictArray[i].x-DistrictArray[j].x) <= 1 && (DistrictArray[i].y-DistrictArray[j].y) == 0 || Math.abs(DistrictArray[i].y-DistrictArray[j].y) <= 1 && (DistrictArray[i].x-DistrictArray[j].x) == 0) {
					System.out.println("I'm here! " + i + " " + j);
					DistrictArray[i].setAdjacent(DistrictArray[j].name);
					DistrictArray[j].setAdjacent(DistrictArray[i].name);
				}
			}
		}
		while (tick != 100) {
			System.out.println("Current tick:" + tick);
			System.out.println(randomValue);
			for (int i = 0; i != randomValue; i++) {
				DistrictArray[i].doAPrintOut();
			}
			tick++;
		}
		for (int i = 0; i != randomValue; i++) {
			System.out.print(DistrictArray[i].name + " x-" + DistrictArray[i].x + " y-" + DistrictArray[i].y + " :");
			for (int j = 0; j != 4; j++) {
				System.out.println(DistrictArray[i].adjacent[j] + ", ");
			}
		}
	}
}
class District {
	public String name;
	public int homes = 0;
	public int jobs = 0;
	public int residents = 0;
	public int x = 0;
	public int y = 0;
	public String adjacent[] = new String[4];
	public void changePop(int var) {
		residents = residents + var;
		if (residents < 0) {
			residents = 0;
		}
	}
	public void changeHome(int var) {
		homes = homes + var;
		if (homes < 0) {
			homes = 0;
		}
	}
	public void changeJob(int var) {
		jobs = jobs + var;
		if (jobs < 0) {
			jobs = 0;
		}
	}
	public void doAPrintOut() {
		System.out.println(name + ": Homes " + homes + " Pop " + residents + " Jobs " + jobs );
	}
	public void setX(int var) {
		x = var;
	}
	public void setY(int var) {
		y = var;
	}
	public void setAdjacent(String newName) {
		for (int i = 0; i != 4; i++) {
			if (adjacent[i] == null) {
				adjacent[i] = newName;
				return;
				}
		}
		
	}
	public boolean checkAdjacency(String nameToCheck) {
		for (int i = 0; i != adjacent.length; i++) {
			if (adjacent[i] == nameToCheck) {
				return true;
			}
		}
		return false;
	}
}


