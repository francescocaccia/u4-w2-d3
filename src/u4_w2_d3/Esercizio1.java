package u4_w2_d3;

public class Esercizio1 {

	public static void main(String[] args) {
		Thread theread1 = new Thread(new StampaSimbolo("#"));
		Thread theread2 = new Thread(new StampaSimbolo("#"));
		theread1.start();
		theread2.start();

	}

	private static class StampaSimbolo implements Runnable {
		private final String simbolo;

		public StampaSimbolo(String simbolo) {
			this.simbolo = simbolo;
		}

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				System.out.print(simbolo);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
