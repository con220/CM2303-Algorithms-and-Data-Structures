import java.io.*;
import java.util.*;
import java.lang.Integer;

public class perfectHash {
	public static int universalHash(int key, int a, int b, int p, int m) {
		/*	Chosen hash function from H (universal class of hash functions)
			input: rnd int a, rnd int b, prime p, size of table m, key to be hashed
			output: hash value for key  */
		return ((a*key + b) % p) % m;
	}

	public static int countCollisions(int[] array, int newHash, int currentIndex) {
		int count = 0;

		for (int i=0; i<(currentIndex); i++) {
			if(array[i] == newHash) {
				count++;
			}
		}
		return count;
	}

	public static String outputArray(int[] unformatedArray) {
		/*	Function used to convert any arraylist from current output format
			e.g. [1, 2 ,3, 4, 5] to string of 1 2 3 4 5  */
		String formatedString = Arrays.toString(unformatedArray);
		formatedString = formatedString.replace("[",""); //remove both brackets
		formatedString = formatedString.replace("]","");
		formatedString = formatedString.replace(",",""); //remove all commas

		return formatedString;
	}

	public static void main(String[] args) {
		//initialisation of parameters
		int a = 13;
		int b = 1207;
		int p = 40487;

		//read first data file and store all values in an arraylist in order given
		try(BufferedReader re = new BufferedReader(new FileReader(args[0]))){
			int size = Integer.parseInt(re.readLine());
			int[] initialData = new int[size];
			
			int i = 0;
			String nextLine;
			while ((nextLine = re.readLine()) != null) { //go through all lines in file
				initialData[i] = Integer.parseInt(nextLine); //set current line to value in array
				i++;
			}

			System.out.println("SETTING HASH TABLE SIZE: " + size);
			System.out.println("READ SET OF KEYS: " + outputArray(initialData));
			System.out.println("INITAL OUTER HASH FUNCTION PARAMETERS: a = " + a + "; b = " + b + "; p = " + p);

			int[] hashArray = new int[size];
			int numCollisions = 0;
			for (int j=0; j<size; j++) {
				hashArray[j] = universalHash(initialData[j], a, b, p, size);
				numCollisions = numCollisions + countCollisions(hashArray, hashArray[j], j);
			}
			System.out.println("HASHED TO OUTER HASH TABLE AT: " + outputArray(hashArray) + "\n");

			System.out.println("NUMBER OF PAIRS OF COLLISIONS IN OUTER HASH TABLE: " + numCollisions);

			int count = 1;
			boolean modified = false;
			while (numCollisions > size) {
				a++;
				b += 177;
				count++;
				modified = true;
				numCollisions = 0;

				for (int j=0; j<size; j++) {
					hashArray[j] = universalHash(initialData[j], a, b, p, size);
					numCollisions = numCollisions + countCollisions(hashArray, hashArray[j], j);
				}
				System.out.println("NUMBER OF PAIRS OF COLLISIONS IN OUTER HASH TABLE: " + numCollisions);
			}

			if (modified == true) {
				System.out.println(count + " OUTER HASH FUNCTIONS TESTED");
				System.out.println("MODIFIED OUTER HASH FUNCTION PARAMETERS: a = " + a + "; b = " + b + "; p = " + p);
				System.out.println("MODIFIED HASHING TO OUTER HASH TABLE AT: "  + outputArray(hashArray) + "\n");
			} else {
				System.out.println(count + " OUTER HASH FUNCTION TESTED");
			}

		}catch (IOException e) {
			System.out.println(e);
		}
	}
}