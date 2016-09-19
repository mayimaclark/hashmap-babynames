import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;


public class Test {

	public static void main(String[] args) throws FileNotFoundException {
		
		for(int i = 0; i < 10; i++) {
			int j = new Random().nextInt(10);
			i--;
		}

	}

}
