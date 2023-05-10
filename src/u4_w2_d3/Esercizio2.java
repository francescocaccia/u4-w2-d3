package u4_w2_d3;

import java.util.Arrays;
import java.util.Random;

public class Esercizio2 {

	public static void main(String[] args) {

		int[] array = new int[3000];
		Random random = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(100);
		}

		SumThread[] threads = new SumThread[3];
		for (int i = 0; i < threads.length; i++) {
			int startIndex = i * 1000;
			int endIndex = (i + 1) * 1000;
			threads[i] = new SumThread(Arrays.copyOfRange(array, startIndex, endIndex));
			threads[i].start();
		}

		int sum = 0;
		for (SumThread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			sum += thread.getResult();
		}

		System.out.println("La somma totale dell'array è: " + sum);
	}

	private static class SumThread extends Thread {
		private final int[] array;
		private int result;

		public SumThread(int[] array) {
			this.array = array;
		}

		public int getResult() {
			return result;
		}

		@Override
		public void run() {
			for (int value : array) {
				result += value;
			}
		}

	}

}
