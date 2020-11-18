package test;

import java.util.logging.Logger;
import java.util.*;

public class Production {
	static boolean first1 = false;
	static Logger logger = Logger.getLogger(Production.class.getName());
	private static final String EMAIL = "nabeelkayed.9b.23@gmail.com";
	int n = 0;

	public Production() {
		n = 1;
	}

	private static EmailService emailservice;

	public static EmailService getEmailservice() {
		return emailservice;
	}

	public static void setEmailService(EmailService emailservice) {
		Production.emailservice = emailservice;
	}

	static ArrayList<Home> home = new ArrayList<Home>();

	static List<Home> type = new ArrayList<Home>();
	static List<Home> material = new ArrayList<Home>();
	static List<Home> placment = new ArrayList<Home>();
	static List<Home> bedrooms = new ArrayList<Home>();
	static List<Home> bathrooms = new ArrayList<Home>();
	static List<Home> amenities = new ArrayList<Home>();
	static List<Home> price = new ArrayList<Home>();
	static List<Home> rangOfPrices = new ArrayList<Home>();
	static List<Home> area = new ArrayList<Home>();
	static List<Home> rangOfArea = new ArrayList<Home>();
	static List<Home> leaselength = new ArrayList<Home>();
	static List<Home> pets = new ArrayList<Home>();

	public static void addHome(Home h) {
		home.add(h);

	}

	public static void seachabouttype(String p) {
		for (Home h : home)
			if (p.equalsIgnoreCase(h.getHomeType())) {
				type.add(h);
			}
		getEmailservice().sendEmail(EMAIL, "By Type", type);
		getEmailservice().sendEmail(EMAIL, "By Type", type);

	}

	public static void seachaboutmaterial(String p) {
		for (Home h : home)
			if (p.equalsIgnoreCase(h.getHomeMaterial())) {
				material.add(h);
			}
		getEmailservice().sendEmail(EMAIL, "By Material", material);
	}

	public static void seachaboutplacment(String p) {
		for (Home h : home)
			if (p.equalsIgnoreCase(h.getHomePlacement())) {
				placment.add(h);
			}
		getEmailservice().sendEmail(EMAIL, "By Placement", placment);

	}

	public static void searchPrice(Integer int1) {
		for (Home h : home) {
			int t = Integer.parseInt(h.getPrice());
			if (t == int1) {
				price.add(h);
			}
		}
		getEmailservice().sendEmail(EMAIL, "By Price", price);
	}

	public static void searchPricelessThan(Integer int1) {

		for (Home h : home) {
			int t = Integer.parseInt(h.getPrice());
			if (t <= int1) {
				rangOfPrices.add(h);
			}
		}
		getEmailservice().sendEmail(EMAIL, "By RangOfPrices", rangOfPrices);
	}

	public static void searchBedrooms(Integer int1) {
		for (Home h : home) {
			int t = Integer.parseInt(h.getBedrooms());
			if (t == int1) {
				bedrooms.add(h);
			}
		}
		getEmailservice().sendEmail(EMAIL, "By Number Of Bedrooms", bedrooms);
	}

	public static void searchBathrooms(Integer int1) {
		for (Home h : home) {
			int t = Integer.parseInt(h.getBathrooms());
			if (t == int1 && int1 <= 3 && int1 >= 1) {
				bathrooms.add(h);
			}
		}
		getEmailservice().sendEmail(EMAIL, "By Number Of Bathrooms", bathrooms);
	}

	public static void searchamenities(String string) {
		String[] q = string.split(",");
		ArrayList<String> amenitieS = new ArrayList<String>();
		for (Home h : home) {
			for (int v = 0; v < q.length; v++) {
				if (h.getAmenties().indexOf(q[v]) != -1)
					amenitieS.add("true");
				else
					amenitieS.add("false");
			}

			if (!amenitieS.contains("false"))
				amenities.add(h);
			amenitieS.clear();
		}
		getEmailservice().sendEmail(EMAIL, "By Amenities", amenities);
	}

	public static void searchArea(Integer int1) {

		for (Home h : home) {
			int t = Integer.parseInt(h.getArea());
			if (t == int1) {
				area.add(h);
			}
		}
		getEmailservice().sendEmail(EMAIL, "By Area", area);
	}

	public static void searchAreaLessThan(Integer int1) {

		for (Home h : home) {
			int t = Integer.parseInt(h.getArea());
			if (t <= int1) {
				rangOfArea.add(h);
			}
		}
		getEmailservice().sendEmail(EMAIL, "By RangOfArea", rangOfArea);
	}

	public static void searchleaselength(Integer int1) {

		for (Home h : home) {
			int t = Integer.parseInt(h.getLeaselength());
			if (t == int1) {
				leaselength.add(h);
			}
		}
		getEmailservice().sendEmail(EMAIL, "By Lease Length", leaselength);
	}

	public static void searchPets(String string) {

		for (Home h : home) {
			if (string.equalsIgnoreCase(h.getPets())) {
				pets.add(h);
			}
		}
		getEmailservice().sendEmail(EMAIL, "By Pets", pets);
	}

}
