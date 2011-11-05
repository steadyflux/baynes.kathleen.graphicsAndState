package baynes.kathleen.graphics;

public interface RubeItem {
	public void addTransition(State currentState, Event event, State nextState);
	public void getNextState(Event event);
}
