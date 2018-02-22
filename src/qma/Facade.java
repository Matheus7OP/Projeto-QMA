package qma;
import easyaccept.EasyAccept;

public class Facade {
	public static void main(String[] args) {
		args = new String[] {"qma.Facade", "acceptanceTest/us1_test.txt", "acceptanceTest/us2_test.txt"};
		EasyAccept.main(args);
	}
}
