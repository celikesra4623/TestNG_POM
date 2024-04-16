package utilities;

public class ReusableMethods {

	public static void wait(int seconds) {

		try {
			Thread.sleep(1000 * seconds);
		} catch (InterruptedException e) {
			System.out.println("Bekleme süresinde sorun oluştu!:");
		}
	}
}
