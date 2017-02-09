// Doubly-link by Jacob Zimmerman
public class LocationOutOfBounds extends RuntimeException {
	public LocationOutOfBounds () {
		System.out.println("Looks like the location you chose is not in range of the list!");
	}
}
