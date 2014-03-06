package src.verySimple;

import java.io.File;


public class FolderCreation {

	private static String folderName;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		folderName = "mappe";
		File newFolder = new File(folderName);
		boolean didSucceed = newFolder.mkdir();
		System.out.println("New folder was "+(didSucceed ? "created." : "not created."));

		long currTime = System.currentTimeMillis();

		//		for(File fil : newFolder.listRoots()){
		//			System.out.println(fil);
		//		}

		//System.out.println(sizeOfFolder(newFolder));

		/*
		 * 3,16 MB (3 322 253 bytes)
		 * 3,17 MB (3 325 952 bytes)
		 * 19,3 MB (20 278 749 bytes
		 */
	}

	/**
	 * Recursivly traverses through an entire folder and its subfolders,
	 * summarizing the size.
	 * @param folder
	 * @return size of folder/file
	 */
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
