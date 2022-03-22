package observer;

public interface Observable {
	void addObserver(Observer obs);

	void deleteObserver(Observer obs);

	void notifyObservers();
}
