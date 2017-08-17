/**
 * Project for Database TCSS 445
 * @author Jake Knowles
 * @author Patrick Stevens
 * @version 08/16/2017
 *
 */
import java.awt.EventQueue;

public class PJMain {

	public static void main(String[] args) {
		 EventQueue.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                new RecruitingGUI().start();
	            }
	        });

	}

}
