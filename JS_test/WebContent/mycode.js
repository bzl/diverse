/**
 * 
 */

function calc(numA, numB){
	return numA+numB;
}

function dropRate(rate, attempts){
	return 1-(Math.pow((1-rate), attempts)).toFixed(5);
}