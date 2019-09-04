package util;

import java.awt.Desktop;
import java.net.URI;

public class Web {
	private static final String MY_GITHUB = "https://github.com/Camposm97";
	private static final String THIS_REPO = MY_GITHUB + "/Pazaak";
	
	public static void browse(String url) {
		try {
			Desktop desktop = Desktop.getDesktop();
			desktop.browse(new URI(url));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void openThisRepo() {
		browse(THIS_REPO);
	}
	
	public static void openMyGithub() {
		browse(MY_GITHUB);
	}
}
