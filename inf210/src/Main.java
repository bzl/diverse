/**
 * 
 * @author Kristoffer Tverå
 * 
 * INF210 mandatory assignment 1
 * 
 *
 */
public class Main {

	public static void main(String[] args) {
		/*
		 * All the variables (alphabet, state set Q, 
		 * list of tuples representing delta and lambda,
		 * and the pair (w,q) representing input and 
		 * start state has been hardcorded for simplicity.
		 * 
		 * Toggling between the two different hardcoded datasets
		 * (rippleadder VS assignment 1 example text) is done through
		 * boolean "rippleadder". It has additional comment upon
		 * declaration that explains its function. true = ripple adder
		 * data is utilized, and FSM runs with ripple adder simulation.
		 * false = example text from assignment.
		 * 
		 * FSM has been coded with universality in mind and will work 
		 * with any alphabet size and ruleset, input, and starting state,
		 *  as long as the data is valid. No valid check is ran, so program
		 *  will crash if it is fed toxic data.
		 */


		/*
		 * Om rippleadder er true vil variablene få verdier til seg som simulrerer 
		 * figur 3.10 altså rippleadder, med test tallene 14+28. 
		 * 
		 * Om rippleadder er false brukes test tallene fra oppgave teksten.
		 */
		boolean rippleadder = false;


		String[] alphabetX; // Sigma, input alphabet
		int numberOfStates; // Q, finite set of states
		String[][] nextStateFunction; // delta, next-state-function

		//representerer input data og start state
		String inputData;
		int startState;

		if (rippleadder) {
			alphabetX = new String[]{"00","01","10","11"};
			numberOfStates = 4;
			nextStateFunction = new String[][]{ // current state, input, resulting state, resulting "print"
					{"0","00","0","0"},
					{"0","10","1","1"},
					{"0","01","1","1"},
					{"0","11","2","0"},

					{"1","00","0","0"},
					{"1","10","1","1"},
					{"1","01","1","1"},
					{"1","11","2","0"},

					{"2","00","1","1"},
					{"2","10","2","0"},
					{"2","01","2","0"},
					{"2","11","3","1"},

					{"3","00","1","1"},
					{"3","10","2","0"},
					{"3","01","2","0"},
					{"3","11","3","1"}};
			/*
			 * I mitt ripple adder eksempel bruker jeg tallene 14+28, altså
			 * 001110+011100. Da eksemplet i forelesningsnotatene har tillat
			 * seg å gjøre forenklingen som skal til for at det parses, gjør
			 * jeg også dette, så regnestykkets input format blir da
			 * 00 10 11 11 01 00, siden vi parer de 2 bakerste bits fra 
			 * hvert tall, og beveger oss fra venstre til høyre på tallene.
			 * Dette gjør forsåvidt at output svaret kommer i "feil retning".
			 * Det løser vi ved å manuelt snu svaret i min implementasjon.
			 * 
			 * Jeg har verifisert at maskinen fungerer. Den avslutter i 
			 * state Q1, med output 010101, snur man outputten får man 101010,
			 * altså 42, altså svaret på 14+28 :=)
			 * Visualisert ser det hele slik ut:
			 * https://www.youtube.com/watch?v=exIJ7sBBuB4
			 * 
			 */
			inputData = "001011110100";
			startState = 0;
		} else {
			alphabetX = new String[]{"0","1"};
			numberOfStates = 2;
			nextStateFunction = new String[][]{
					{"0","0","0","0"},
					{"0","1","1","1"},

					{"1","0","1","1"},
					{"1","1","0","0"}};
			inputData = "0111";
			startState = 0;
		}

		//Her starter FSM logikken.
		boolean complete = false;
		int currentXState = startState;
		assert currentXState <= numberOfStates; //Potentially posioned.
		String outputX = "";
		do{
			String currentData; //representerer den delen av hele input stringen vi er interesert i ved denne iterasjonen

			if(inputData.length() == alphabetX[0].length()){ //Hånderer slutten av en iterasjon
				complete = true;
				currentData = inputData;
			} else {
				currentData  = inputData.substring(0, alphabetX[0].length()); 
				inputData = inputData.substring(alphabetX[0].length(), inputData.length()); //beskjærer input (i stedefor å lage en ny variabel som lagrer vår posisjon).
			}

			for(int i = 0; i < nextStateFunction.length; i++){ //iterer igjennom alle regler for å finne den aktuelle for denne iterasjonen
				if(Integer.parseInt(nextStateFunction[i][0]) == currentXState){
					if(nextStateFunction[i][1].equals(currentData)){
						currentXState = Integer.parseInt(nextStateFunction[i][2]);
						assert currentXState <= numberOfStates; //Potentially posioned.
						outputX += nextStateFunction[i][3];
						break; // Stop når vi har funnet aktuel regel, og lest/endret nødvendigt.
					}
				}
			}
			//System.out.println("state: Q"+currentXState+", parsing "+currentData+" with output: "+outputX); //debug
		} while (!complete);

		System.out.println("Ending state: Q"+currentXState+", with output: "+outputX);
	}
}