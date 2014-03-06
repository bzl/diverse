package src.verySimple;

public class GarbageCheck {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub


	}
	
	public Object add(Object valueA, Object valueB) {
		if((valueA instanceof Double) && (valueB instanceof Double)){
			return Double.parseDouble(valueA.toString()) + Double.parseDouble(valueB.toString());
		} else return valueA.toString()+valueB.toString();
	}

}
