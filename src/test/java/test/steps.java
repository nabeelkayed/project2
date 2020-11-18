package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;
import java.util.ArrayList;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class steps {

	private Production production;
	private MockHolder MockHolder;
	static ArrayList<ArrayList<Home>> allLists = new ArrayList<ArrayList<Home>>();
	static List<ArrayList<Home>> matchLists = new ArrayList<ArrayList<Home>>();

	public steps(Production production, MockHolder MockHolder) {

		this.production = production;
		this.MockHolder = MockHolder;
	}

	ArrayList<String> index = new ArrayList<String>();

	@Given("these homes are contained in the system")
	public void these_homes_are_contained_in_the_system(List<List> table) {
		List<List> data = table;
		for (int i = 0; i < data.size(); i++) {

			String s = data.get(i).get(0).toString();
			String e = data.get(i).get(1).toString();

			String[] t = s.split("_");
			String g[] = e.split("_");
			Home h = new Home(t, g);
			Production.addHome(h);
		}
	}

	@When("I search about home Type by {string}")
	public void i_search_about_home_type_by(String p) {
		index.add(p);
		Production.seachabouttype(p);
	}

	@Then("A list of homes that matches the  type specification should be returned and printed on the console")
	public void a_list_of_homes_that_matches_the_type_specification_should_be_returned_and_printed_on_the_console() {
		System.out.println("Type_" + index.get(0));
		for (Home h : Production.type) {
			assertTrue(index.get(0).equalsIgnoreCase(h.getHomeType()));
			System.out.println(h.toString());
		}
		Production.home.clear();
	}

	@Then("email with the result of type should be send to {string} with subject {string}")
	public void emailWithTheResultOfTypeShouldBeSendToWithSubject(String string, String string2) {
		verify(MockHolder.getEmailService(), times(2)).sendEmail(string, string2, Production.type);
		if (!Production.first1)
			Production.type.clear();
	}

	@When("I search about home material by {string}")
	public void i_search_about_home_material_by(String p) {

		index.add(p);
		Production.seachaboutmaterial(p);

	}

	@Then("A list of homes that matches the material specification should be returned and printed on the console")
	public void a_list_of_homes_that_matches_the_material_specification_should_be_returned_and_printed_on_the_console() {
		System.out.println("material_" + index.get(0));
		for (Home h : Production.material) {
			assertTrue(index.get(0).equalsIgnoreCase(h.getHomeMaterial()));
			System.out.println(h.toString());
		}
		Production.home.clear();
	}

	@Then("email with the result of material should be send to {string} with subject {string}")
	public void emailWithTheResultOfMaterialShouldBeSendToWithSubject(String string, String string2) {
		verify(MockHolder.getEmailService(), times(1)).sendEmail(string, string2, Production.material);
		if (!Production.first1)
			Production.material.clear();
	}

	@When("I search about home placment by {string}")
	public void i_search_about_home_placment_by(String p) {
		index.add(p);
		Production.seachaboutplacment(p);
	}

	@Then("A list of homes that matches the placement specification should be returned and printed on the console")
	public void a_list_of_homes_that_matches_the_placement_specification_should_be_returned_and_printed_on_the_console() {
		System.out.println("placement_" + index.get(0));
		for (Home h : Production.placment) {
			assertTrue(index.get(0).equalsIgnoreCase(h.getHomePlacement()));
			System.out.println(h.toString());
		}
		Production.home.clear();
	}

	@Then("email with the result of placement should be send to {string} with subject {string}")
	public void emailWithTheResultOfPlacementShouldBeSendToWithSubject(String string, String string2) {
		verify(MockHolder.getEmailService(), times(1)).sendEmail(string, string2, Production.placment);
		if (!Production.first1)
			Production.placment.clear();
	}

	@When("I search about home with price  {int}")
	public void i_search_about_home_with_price(Integer int1) {
		index.add(int1 + "");
		Production.searchPrice(int1);
	}

	@Then("A list of homes that matches the price specification should be returned and printed on the console")
	public void a_list_of_homes_that_matches_the_price_specification_should_be_returned_and_printed_on_the_console() {
		System.out.println("price_" + index.get(0));
		for (Home h : Production.price) {
			assertEquals(Integer.parseInt(index.get(0)), Integer.parseInt(h.getPrice()));
			System.out.println(h.toString());
		}
		Production.home.clear();
	}

	@Then("email with the result of price should be send to {string} with subject {string}")
	public void emailWithTheResultOfPriceShouldBeSendToWithSubject(String string, String string2) {
		verify(MockHolder.getEmailService(), times(1)).sendEmail(string, string2, Production.price);
		if (!Production.first1)
			Production.price.clear();
	}

	@When("I search about home with price less than {int}")
	public void i_search_about_home_with_price_less_than(Integer int1) {
		index.add(int1 + "");
		Production.searchPricelessThan(int1);
	}

	@Then("A list of homes that matches the rangofprices specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesTheRangrfpricesSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		System.out.println("RangOfPrices_" + index.get(0));
		for (Home h : Production.rangOfPrices) {
			assertTrue(Integer.parseInt(index.get(0)) >= Integer.parseInt(h.getPrice()));
			System.out.println(h.toString());
		}
		Production.home.clear();
	}

	@Then("email with the result of RangOfPrices should be send to {string} with subject {string}")
	public void emailWithTheResultOfRangOfPricesShouldBeSendToWithSubject(String string, String string2) {
		verify(MockHolder.getEmailService(), times(1)).sendEmail(string, string2, Production.rangOfPrices);
		if (!Production.first1)
			Production.rangOfPrices.clear();
	}

	@When("I Search about home with number of bedrooms {int}")
	public void i_search_about_home_with_number_of_bedrooms(Integer int1) {
		index.add(int1 + "");
		Production.searchBedrooms(int1);

	}

	@Then("A list of homes that matches the number of bedrooms specification should be returned and printed on the console")
	public void a_list_of_homes_that_matches_the_number_of_bedrooms_specification_should_be_returned_and_printed_on_the_console() {
		System.out.println("Bedrooms_" + index.get(0));
		for (Home h : Production.bedrooms) {
			assertTrue(h.getBedrooms().equalsIgnoreCase(index.get(0)));
			System.out.println(h.toString());
		}
		Production.home.clear();
	}

	@Then("email with the result of Number of bedrooms should be send to {string} with subject {string}")
	public void emailWithTheResultOfNumberOfBedroomsShouldBeSendToWithSubject(String string, String string2) {
		verify(MockHolder.getEmailService(), times(1)).sendEmail(string, string2, Production.bedrooms);
		if (!Production.first1)
			Production.bedrooms.clear();
	}

	@When("I Search about home with number of bathrooms {int}")
	public void i_search_about_home_with_number_of_bathrooms(Integer int1) {
		index.add(int1 + "");
		Production.searchBathrooms(int1);
	}

	@Then("A list of homes that matches the number of bathrooms specification should be returned and printed on the console")
	public void a_list_of_homes_that_matches_the_number_of_bathrooms_specification_should_be_returned_and_printed_on_the_console() {
		System.out.println("bathrooms_" + index.get(0));
		for (Home h : Production.bathrooms) {
			assertTrue(h.getBathrooms().equalsIgnoreCase(index.get(0)));
			System.out.println(h.toString());
		}
		Production.home.clear();
	}

	@Then("email with the result of Number of bathrooms should be send to {string} with subject {string}")
	public void emailWithTheResultOfNumberOfBathroomsShouldBeSendToWithSubject(String string, String string2) {
		verify(MockHolder.getEmailService(), times(1)).sendEmail(string, string2, Production.bathrooms);
		if (!Production.first1)
			Production.bathrooms.clear();
	}

	@When("I search about home contains amenities {string}")
	public void i_search_about_home_contains_amenities(String string) {
		index.add(string);
		Production.searchamenities(string);
	}

	@Then("A list of homes that matches amenities should be returned and printed on the console")
	public void a_list_of_homes_that_matches_amenities_should_be_returned_and_printed_on_the_console() {
		System.out.println("amenities_" + index.get(0));
		for (Home h : Production.amenities) {
			assertNotEquals(h.getAmenties().indexOf(index.get(0)), -1);
			System.out.println(h.toString());
		}
		Production.home.clear();
	}

	@Then("email with the result of amenities should be send to {string} with subject {string}")
	public void emailWithTheResultOfAmenitiesShouldBeSendToWithSubject(String string, String string2) {
		verify(MockHolder.getEmailService(), times(1)).sendEmail(string, string2, Production.amenities);
		if (!Production.first1)
			Production.amenities.clear();
	}

	@When("I search about home with area  {int}")
	public void i_search_about_home_with_area(Integer int1) {
		index.add(int1 + "");
		Production.searchArea(int1);
	}

	@Then("A list of homes that matches the area specification should be returned and printed on the console")
	public void a_list_of_homes_that_matches_the_area_specification_should_be_returned_and_printed_on_the_console() {
		System.out.println("area_" + index.get(0));
		for (Home h : Production.area) {
			int t = Integer.parseInt(h.getArea());
			assertEquals(t, (Integer.parseInt(index.get(0))));
			System.out.println(h.toString());
		}
		Production.home.clear();
	}

	@Then("email with the result of area should be send to {string} with subject {string}")
	public void emailWithTheResultOfAreaShouldBeSendToWithSubject(String string, String string2) {
		verify(MockHolder.getEmailService(), times(1)).sendEmail(string, string2, Production.area);
		if (!Production.first1)
			Production.area.clear();
	}

	@When("I search about home with area less than {int}")
	public void i_search_about_home_with_area_less_than(Integer int1) {
		index.add(int1 + "");
		Production.searchAreaLessThan(int1);
	}

	@Then("A list of homes that matches the rangofarea specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesTheRangofareaSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		System.out.println("RangOfArea_" + index.get(0));
		for (Home h : Production.rangOfArea) {
			int t = Integer.parseInt(h.getArea());
			assertTrue(t <= (Integer.parseInt(index.get(0))));
			System.out.println(h.toString());
		}
		Production.home.clear();
	}

	@Then("email with the result of RangOfArea should be send to {string} with subject {string}")
	public void emailWithTheResultOfRangOfAreaShouldBeSendToWithSubject(String string, String string2) {
		verify(MockHolder.getEmailService(), times(1)).sendEmail(string, string2, Production.rangOfArea);
		if (!Production.first1)
			Production.rangOfArea.clear();
	}

	@When("I search about home with lease length {int}")
	public void i_search_about_home_with_lease_length(Integer int1) {
		index.add(int1 + "");
		Production.searchleaselength(int1);
	}

	@Then("A list of homes that matches lease length specification should be returned and printed on the console")
	public void a_list_of_homes_that_matches_lease_length_specification_should_be_returned_and_printed_on_the_console() {
		System.out.println("lease length_" + index.get(0));
		for (Home h : Production.leaselength) {
			assertTrue(h.getLeaselength().equalsIgnoreCase(index.get(0)));
			System.out.println(h.toString());
		}
		Production.home.clear();
	}

	@Then("email with the result of lease length should be send to {string} with subject {string}")
	public void emailWithTheResultOfLeaseLengthShouldBeSendToWithSubject(String string, String string2) {
		verify(MockHolder.getEmailService(), times(1)).sendEmail(string, string2, Production.leaselength);
		if (!Production.first1)
			Production.leaselength.clear();
	}

	@When("I search about home Allow Pets {string}")
	public void i_search_about_home_allow_pets(String string) {
		index.add(string);
		Production.searchPets(string);

	}

	@Then("A list of homes that matches Allow Pets should be returned and printed on the console")
	public void a_list_of_homes_that_matches_allow_pets_should_be_returned_and_printed_on_the_console() {
		System.out.println("Allow Pets _" + index.get(0));
		for (Home h : Production.pets) {
			assertTrue(h.getPets().equalsIgnoreCase(index.get(0)));
			System.out.println(h.toString());
		}
		Production.home.clear();
	}

	@Then("email with the result of Pets should be send to {string} with subject {string}")
	public void emailWithTheResultOfPetsShouldBeSendToWithSubject(String string, String string2) {
		verify(MockHolder.getEmailService(), times(1)).sendEmail(string, string2, Production.pets);
		if (!Production.first1)
			Production.pets.clear();
	}

	@When("I search about home by several things")
	public void iSearchAboutHomeBySeveralThings() {
		Production.first1 = true;

	}

	@Then("A list of homes that matches this Combination should be returned and printed on the console")
	public void a_list_of_homes_that_matches_this_combination_should_be_returned_and_printed_on_the_console() {
		allLists.add((ArrayList<Home>) Production.type);
		allLists.add((ArrayList<Home>) Production.material);
		allLists.add((ArrayList<Home>) Production.placment);
		allLists.add((ArrayList<Home>) Production.bedrooms);
		allLists.add((ArrayList<Home>) Production.bathrooms);
		allLists.add((ArrayList<Home>) Production.amenities);
		allLists.add((ArrayList<Home>) Production.price);
		allLists.add((ArrayList<Home>) Production.rangOfPrices);
		allLists.add((ArrayList<Home>) Production.area);
		allLists.add((ArrayList<Home>) Production.rangOfArea);
		allLists.add((ArrayList<Home>) Production.leaselength);
		allLists.add((ArrayList<Home>) Production.pets);
		for (ArrayList<Home> g : allLists)
			if (!g.isEmpty())
				matchLists.add(g);
		/*
		 * for (ArrayList<Home> h : matchLists) for (Home j :h)
		 */
		Senario13.senario(matchLists);
		Production.first1 = false;

		Senario13.finalresult.clear();

		Production.home.clear();
		Production.type.clear();
		Production.material.clear();
		Production.placment.clear();
		Production.bedrooms.clear();
		Production.bathrooms.clear();
		Production.amenities.clear();
		Production.price.clear();
		Production.rangOfPrices.clear();
		Production.area.clear();
		Production.rangOfArea.clear();
		Production.leaselength.clear();
		Production.pets.clear();

	}

	@Then("email with the result of several things should be send to {string} with subject {string}")
	public void emailWithTheResultOfSeveralThingsShouldBeSendToWithSubject(String string, String string2) {
		verify(MockHolder.getEmailService(), times(1)).sendEmail(string, string2, Senario13.finalresult);

	}

}
