package src.verySimple;

import java.io.*;

/**
 * Example code used for university course work.
 * 
 * --- NEVER RUN THIS ---
 * 
 * @author Kristoffer Tverå (Bluekristoffer@gmail.com)
 */
class WebTest
{
	public static void main (String[] args)
	{
		File fil = new File("dump");
		File parent = fil.getParentFile();
		sizeOfFolder(parent);
		int magicValue = 0; //modify
		for (int i = 0; i < magicValue; i++) {
			for (int j = 0; j < magicValue; j++) { 
				for (int x = 0; x < magicValue; x++) {
					for (int y = 0; y < magicValue; y++) {
						//File bomb = new File("bomb"+i+"-"+j+"-"+x+"."+y);
					}
				}
			}
		}


	}

	private static long sizeOfFolder(File folder){
		long size = 0;
		if(folder.isFile()){//Basecase
			System.out.println(folder.toString());
			return folder.length();
		} 

		for(File subFile : folder.listFiles()){//Recursive case (if not file, we can assume its a folder)
			size += sizeOfFolder(subFile);
		}
		return size;
	}
}
