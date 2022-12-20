/**
 * @author Ryan Nitz 3605318
 * @version November 20, 2017
 *
 *          Program to display a histogram of 2000 random numbers and the
 *          range they fall into.
 */

public class Histogram {
	public static void main(String[] args) {

		// allows full customization of histogram template
		/////////////////////////////////////////////////
		final char SYMBOL = '=';
		final int BIN_SIZE = 10;
		final int NUM_PER_SYMBOL = 5;
		final int MAX_NUM = 100;
		final int GENERATE = 2000;
		/////////////////////////////////////////////////

		int num;
		int[] rangeAmount = new int[MAX_NUM / BIN_SIZE];

		for (int i = 0; i < GENERATE; i++) {
			num = (int) (Math.random() * MAX_NUM) + 1;
			for (int h = 1; h <= MAX_NUM / BIN_SIZE; h++) {
				if (num > ((h * BIN_SIZE) - (BIN_SIZE - 1)) && num <= h * BIN_SIZE) {
					rangeAmount[h - 1]++;
				}
			}
		}

		for (int i = 1; i <= (MAX_NUM / BIN_SIZE); i++) {
			String templateLine = ((i * BIN_SIZE) - (BIN_SIZE - 1)) + "-" + (i * BIN_SIZE) + "\t|";
			for (int p = 0; p < (rangeAmount[i - 1] / NUM_PER_SYMBOL); p++) {
				templateLine += SYMBOL;
			}
			System.out.println(templateLine);
		}
	}
}