package test;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;


public class Senario13 {
	private Senario13() {
		//system.out
	}
	private static EmailService emailservice;
	public static EmailService getEmailservice() {
		return emailservice;
	}

	public static void setEmailService(EmailService emailservice) {
		Senario13.emailservice = emailservice;
	}
	static Logger logger = Logger.getLogger(Senario13.class.getName());
	static List<Home> finalresult = new ArrayList <Home>();
	static List<ArrayList<Home>> matchLists;
	static ArrayList<Home> matchHomes = new ArrayList<Home>();

	public static List<Home> senario(List<ArrayList<Home>> matchLists) {
		Senario13.matchLists=matchLists;
		
		for (ArrayList<Home> u : matchLists) {
			for (int i = 0; i < u.size(); i++) {
				Home k =  u.get(i);
				matchHomes.add(k);
			}
		}

		int count = 0;
		for (int i = 0; i < matchHomes.size(); i++) {
			count = 0;
			Home k =  matchHomes.get(i);
			for (int f = 0; f < matchHomes.size(); f++) {
				if (k.equals(matchHomes.get(f)))
					count++;
			}
			if (count == matchLists.size() && !finalresult.contains(k))
					finalresult.add(k);
		}

		logger.info("list of houses");
		for (Home h : finalresult) {
			String str = (h.toString());
			logger.log(Level.SEVERE, str);
		}
		getEmailservice().sendEmail("nabeelkayed.9b.23@gmail.com", "By Several Things", finalresult);
		return finalresult;

	}
	}