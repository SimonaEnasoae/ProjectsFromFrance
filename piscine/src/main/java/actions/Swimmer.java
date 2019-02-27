package actions;

import java.util.ArrayList;
import java.util.List;

import actions.exceptions.ActionFinishedException;
import actions.exceptions.SchedulerStartedException;
import actions.foreseeable.GetDressedAction;
import actions.foreseeable.GetUndressedAction;
import actions.foreseeable.SwimmingAction;
import actions.free.FreeBasketAction;
import actions.free.FreeCubicleAction;
import actions.scheduler.SequentialScheduler;
import actions.take.TakeBasketAction;
import actions.take.TakeCubicleAction;
import pool.BasketPool;
import pool.CubiclePool;
import resources.Basket;
import resources.Cubicle;
import resources.ResourceUser;
/**
 * Class Swimmer
 * 
 * @author Simona Enasoae, Marcel Fernadez de la Pena
 *
 */

public class Swimmer extends SequentialScheduler{
	
	//ATTRIBUTES
	protected String name;
	protected BasketPool basketPool;
	protected CubiclePool cubiclePool;
	protected int timeGetUndressed;
	protected int timeSwimming;
	protected int timeGetDressed;
	
	//COSTRUCTORS
	/**
	 * Constructor - initialise the list of actions for the swimmer
	 * 
	 * @param name                the name of the swimmer
	 * @param basketPool          the basket pool to whom is addressing
	 * @param cubiclePool		  the cubicle pool to whom is addressing
	 * @param timeGetUndressed    the time to get undressed
	 * @param timeSwimming        the time to swimm
	 * @param timeGetDressed      the time to get dressed
	 */
	public Swimmer(String name, BasketPool basketPool, CubiclePool cubiclePool, int timeGetUndressed, int timeSwimming, int timeGetDressed) {
		this.name = name;
		this.basketPool = basketPool;
		this.cubiclePool = cubiclePool;
		this.timeGetUndressed = timeGetUndressed;
		this.timeSwimming = timeSwimming;
		this.timeGetDressed = timeGetDressed;		
		List<Action> listActions = new ArrayList<>();
		ResourceUser<Basket> basketUser = new ResourceUser<Basket>();
		ResourceUser<Cubicle> cubicleUser = new ResourceUser<Cubicle>();
		
		TakeBasketAction takeBasket = new TakeBasketAction(basketUser, basketPool);
		TakeCubicleAction takeCubicle1 = new TakeCubicleAction(cubicleUser, cubiclePool);
		GetUndressedAction getUndressedAction = new GetUndressedAction(timeGetUndressed);
		FreeCubicleAction  freeCubicleAction1 = new FreeCubicleAction(cubicleUser, cubiclePool);
		SwimmingAction  swimmingAction = new SwimmingAction(timeSwimming);
		TakeCubicleAction takeCubicle2 = new TakeCubicleAction(cubicleUser, cubiclePool);
		GetDressedAction getDressedAction = new GetDressedAction(timeGetDressed);
		FreeCubicleAction  freeCubicleAction2 = new FreeCubicleAction(cubicleUser, cubiclePool);
		FreeBasketAction   freeBasketAction = new FreeBasketAction (basketUser, basketPool);
		
		listActions.add(takeBasket);
		listActions.add(takeCubicle1);
		listActions.add(getUndressedAction);
		listActions.add(freeCubicleAction1);
		listActions.add(swimmingAction);
		listActions.add(takeCubicle2);
		listActions.add(getDressedAction);
		listActions.add(freeCubicleAction2);
		listActions.add(freeBasketAction);

		this.setSchedulerActions(listActions);
	}	
	
	/**
	 * Constructor
	 * 
	 * @param actions  the list of actions to be done by the swimmer
	 */
	public Swimmer(List<Action> actions) {
		super(actions);
	}
	
	//METHODS
	/**
	 * @return a representation for the class Swimmer
	 */
	@Override
	public String toString() {
		return name+"'s turn \n" ;
	}
	
}
