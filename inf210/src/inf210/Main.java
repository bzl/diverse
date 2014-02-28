package inf210;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		/*
		 * All the variables (alphabet, state set Q, 
		 * list of tuples representing delta and lambda,
		 * and the pair (w,q) representing input and 
		 * start state has been hardcorded for simplicity.
		 * 
		 * The actual FSM's algorithm has been implemented
		 * generic to remain universal to FSMs, but I was
		 * unable to produce good results with 3.10 ripple
		 * adder alphabet. 
		 */
		Character[] alphabet = new Character[]{'0','1'};
		int stateQ = 1;
		/*
		 * String[] alphabet2 = new String[]{"00","01,"10","11"};
		 * stateQ = 4;
		 */
		Character[][] tuples = new Character[][]{
				{'0','0','0','0'},
				{'0','1','1','1'},
				{'1','0','1','1'},
				{'1','1','0','0'}};

		// Input is hardcorded for simplicisty.
		Character[] inputTuple = new Character[]{'0','1','1','1'};	
		int inputState = 0;

		//current Q state
		int currentState = inputState;
		//Total concatinated output
		String output = "";

		//FSM
		for(Character[] tup : tuples){
			if(Arrays.equals(tup, inputTuple)){
				System.out.println("Input state is present in the delta/lambda collection ("+Arrays.toString(tup)+")");
				if(inputState <= stateQ){
					System.out.println("Valid starting point, Q"+inputState);
					for(int i= 0; i < inputTuple.length; i++){

						if(inputTuple[i].equals(alphabet[0])){
							output += alphabet[currentState];
						} else{
							currentState++;
							currentState %= (stateQ+1);
							output += alphabet[currentState];
						}
					}
				}
			}
		}
		System.out.println("Ending state: Q"+currentState+", with output: "+output);
	}
}

/*
 * 
// Mealey: 	write(lambda*(state,letter));
			state = delta(state,letter);
			
// Moore: 	write(lambda(state);
	write(state);
 */
