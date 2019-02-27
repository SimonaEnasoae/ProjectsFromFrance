package menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import actions.Swimmer;
import actions.exceptions.ActionFinishedException;
import actions.exceptions.SchedulerStartedException;
import actions.scheduler.FairScheduler;
import pool.BasketPool;
import pool.CubiclePool;
import util.ScannerInt;
/**
 * Class SwimmingPool
 * 
 * @author Simona Enasoae, Marcel Fernandez de la Pena 
 *
 */
public class SwimmingPool {
	//ATRIBUTES
	final BasketPool baskets;
	final CubiclePool cubicles;
	static FairScheduler scheduler = new FairScheduler();
	List<Swimmer> swimmersList;

	//CONSTRUCTOR
	/**
	 * 
	 * @param numberBaskets number of available baskets 
	 * @param numberCubicles number of available cubicles
	 */
	public SwimmingPool(int numberBaskets, int numberCubicles) {
		swimmersList = new ArrayList<Swimmer>();
		baskets = new BasketPool(numberBaskets);
		cubicles = new CubiclePool(numberCubicles);
	}
	
	/**
	 * 
	 * @param baskets           the basket pool to whom is addressing
	 * @param cubicles          the cubicle pool to whom is addressing
	 * @param s                 the scheduler with the swimmers
	 */
	public SwimmingPool(BasketPool baskets, CubiclePool cubicles,FairScheduler s) {
		this.scheduler = s;
		this.baskets = baskets;
		this.cubicles = cubicles;
	}
	/**
	  * 
	  * @throws IOException if there is a problem during the reading process
	  */
	public void registerSwimmer() throws IOException {
		
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Name: ");
		String name = read.readLine();
		
		int undressingTime = ScannerInt.readInt("Time to undress: ");
		int swimmingTime = ScannerInt.readInt("Time to swim");
		int dressingTime = ScannerInt.readInt("Time to get dressed");
		
		Swimmer swimmer = new Swimmer(name, baskets, cubicles, undressingTime, swimmingTime, dressingTime);
		
		swimmersList.add(swimmer);
		try {
			scheduler.addAction(swimmer);
		} catch (ActionFinishedException e) {
		} catch (SchedulerStartedException e) {
		}
	}
	/**
	 * 
	 * @return the number of steps to finish the activity of all swimmers 
	 */
	public static int execute()  {
		int nbSteps = 0;
		while(!scheduler.isFinished()) {
			nbSteps++;
			scheduler.doStep();
		}
		
		System.out.println("Steps: "+nbSteps);
		return nbSteps;
	}
}
