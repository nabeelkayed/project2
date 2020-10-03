package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.ArrayList;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class steps {
	 
	 ArrayList<home> by_type_list= new ArrayList<home>();
	 ArrayList<String> index =new ArrayList<String>();
	// ArrayList<home> list= new ArrayList<home>();
	 int count1=0;
	 int count2=0;
	@Given("these homes are contained in the system")
	public void these_homes_are_contained_in_the_system(List<List> table) {
		 List<List> data = table;
	    for(int i=0;i<data.size();i++) {
	    
	    		String s=data.get(i).get(0).toString();
	    		String e=data.get(i).get(1).toString();
	    	
	    String[]t=s.split("_");
	    String g[]=e.split("_");
	  home h=new home(t[0],t[1],t[2],t[3],t[4],g[0],g[1],g[2],g[3],g[4]);
	  HomeFeature.addHome(h);}
	}

	@When("I search about home by {string}")
	public void i_search_about_home_by(String p) {
		
		
	    if(p.equalsIgnoreCase("house") || p.equalsIgnoreCase("Apartment")) {
	    	count1++;
	    	index.add("Type_"+p);
	    	for(home h:HomeFeature.Home) {
	    		if(p.equalsIgnoreCase(h.getHome_type())) {
	    			by_type_list.add(h);	    			
	    			
	    		}
	    	}
	    }
	    if(p.equalsIgnoreCase("Stone")||p.equalsIgnoreCase("Brick") ||p.equalsIgnoreCase("Wood")) {
	    	index.add("material_"+p);
	    	count1++;
	    	for(home h:HomeFeature.Home) {
	    		if(p.equalsIgnoreCase(h.getHome_material())) {
	    			by_type_list.add(h);	    			
	    		}
	    	}

	    }
	    if(p.equalsIgnoreCase("City")||p.equalsIgnoreCase("Village")) {
	    	count1++;
	    	index.add("placement_"+p);
	    	for(home h:HomeFeature.Home) {
	    		if(p.equalsIgnoreCase(h.getHome_placement())) {
	    			by_type_list.add(h);	    			
	    			}
	    	}
	    }
	}

	@Then("A list of homes that matches the  type specification should be returned and printed on the console")
	public void a_list_of_homes_that_matches_the_type_specification_should_be_returned_and_printed_on_the_console() {
	
           String[] k=index.get(0).split("_");
		if(k[0].equalsIgnoreCase("type")){
			System.out.println(index.get(0));
			for(home h:by_type_list) {
				assertEquals(h.getHome_type().equalsIgnoreCase(k[1]),k[1].equalsIgnoreCase(h.getHome_type()));
				System.out.println(h.toString());
			}
			HomeFeature.Home.clear();
		}
		if(k[0].equalsIgnoreCase("material")) {
			System.out.println(index.get(0));
			for(home h:by_type_list) {
				assertEquals(h.getHome_material().equalsIgnoreCase(k[1]),k[1].equalsIgnoreCase(h.getHome_material()));
				System.out.println(h.toString());
			}HomeFeature.Home.clear();	
		}
		if(k[0].equalsIgnoreCase("placement")) {
			System.out.println(index.get(0));
			for(home h:by_type_list) {
				assertEquals(h.getHome_placement().equalsIgnoreCase(k[1]),k[1].equalsIgnoreCase(h.getHome_placement()));
		
				System.out.println(h.toString());
				}
		}HomeFeature.Home.clear();
	}
	@When("I search about home with price  {int}")
	public void i_search_about_home_with_price(Integer int1) {

		index.add("price_"+int1.toString());
		count1++;
		for(home h:HomeFeature.Home) {
			int t= Integer.parseInt(h.getPrice());
			if(t == int1) {
				
    			by_type_list.add(h);	    			
				}	
		}
	   
	}

	@Then("A list of homes that matches the price specification should be returned and printed on the console")
	public void a_list_of_homes_that_matches_the_price_specification_should_be_returned_and_printed_on_the_console() {
		 
		String[] k=index.get(0).split("_");
		System.out.println(index.get(0));
		for(home h:by_type_list) {
			int t=Integer.parseInt(h.getPrice());
			if(k[0].equalsIgnoreCase("price")) {
			assertTrue(t==(Integer.parseInt(k[1])));
			System.out.println(h.toString());}
			if(k[0].equalsIgnoreCase("price less than")) {
				assertTrue(t<=(Integer.parseInt(k[1])));
				System.out.println(h.toString());
			}
		}
		 
		HomeFeature.Home.clear();
	}
	@When("I Search about home with number of bedrooms {int}")
	public void i_search_about_home_with_number_of_bedrooms(Integer int1) {

		index.add("Bedrooms_"+int1.toString());
		count1++;
	  for(home h:HomeFeature.Home) {
			int t= Integer.parseInt(h.getBedrooms());
			if(t == int1) {
    			by_type_list.add(h);	    			
				}
	  }
	}
	@Then("A list of homes that matches the number of bedrooms specification should be returned and printed on the console")
	public void a_list_of_homes_that_matches_the_number_of_bedrooms_specification_should_be_returned_and_printed_on_the_console() {
		String[] k=index.get(0).split("_");
		System.out.println(index.get(0));
		for(home h:by_type_list) {
			assertTrue(Integer.parseInt(h.getBedrooms())==(Integer.parseInt(k[1])));
			System.out.println(h.toString());
		}HomeFeature.Home.clear();
	}
	@When("I Search about home with number of bathrooms {int}")
	public void i_search_about_home_with_number_of_bathrooms(Integer int1) {

		index.add("bathrooms_"+int1.toString());
		count1++;
		  for(home h:HomeFeature.Home) {
				int t= Integer.parseInt(h.getBathrooms());
				if(t == int1 && int1<=3 &&int1>=1) {
	    			by_type_list.add(h);	    			
					}
	     }
	}

	@Then("A list of homes that matches the number of bathrooms specification should be returned and printed on the console")
	public void a_list_of_homes_that_matches_the_number_of_bathrooms_specification_should_be_returned_and_printed_on_the_console() {
		String[] k=index.get(0).split("_");
		System.out.println(index.get(0));
		for(home h:by_type_list) {
			assertTrue(Integer.parseInt(h.getBathrooms())==(Integer.parseInt(k[1])));
			System.out.println(h.toString());
		}HomeFeature.Home.clear();
	}
	@When("I search about home contains amenities {string}")
	public void i_search_about_home_contains_amenities(String string) {

		index.add("amenities_"+string);
		String[] q = string.split(",");
		ArrayList<String> amenities = new ArrayList<String>();
		for (home h :HomeFeature.Home) {
		
			//String[] u = h.getAmenties().split(",");
			for (int v = 0; v < q.length; v++) {
				if (h.getAmenties().indexOf(q[v]) != -1)
					amenities.add("true");
				else
					amenities.add("false");
			}
			
			if (!amenities.contains("false"))
    			by_type_list.add(h);	    			
			amenities.clear();
		}
		
	}
	   

	@Then("A list of homes that matches amenities should be returned and printed on the console")
	public void a_list_of_homes_that_matches_amenities_should_be_returned_and_printed_on_the_console() {
		System.out.println(index.get(0));
		for(home h:by_type_list) {
			  System.out.println(h.toString());  
		}HomeFeature.Home.clear();	
	}
	@When("I search about home with price less than {int}")
	public void i_search_about_home_with_price_less_than(Integer int1) {

		index.add("price less than_"+int1.toString());
		count1++;
		for(home h:HomeFeature.Home) {
			int t= Integer.parseInt(h.getPrice());
			if(t <= int1) {
    			by_type_list.add(h);	    			
				}	
		}  
	}
	@When("I search about home with area  {int}")
	public void i_search_about_home_with_area(Integer int1) {

	   index.add("area_"+int1);
	   count1++;
		for(home h:HomeFeature.Home) {
			int t= Integer.parseInt(h.getArea());
			if(t == int1) {
    			by_type_list.add(h);	    			
				}	
		} 
	}

	@When("I search about home with area less than {int}")
	public void i_search_about_home_with_area_less_than(Integer int1) {

		  index.add("area less than_"+int1);
		  count1++;
			for(home h:HomeFeature.Home) {
				int t= Integer.parseInt(h.getArea());
				if(t <= int1) {
	    			by_type_list.add(h);	    			
					}	
			} 
	}
	@Then("A list of homes that matches the area specification should be returned and printed on the console")
	public void a_list_of_homes_that_matches_the_area_specification_should_be_returned_and_printed_on_the_console() {
		String[] k=index.get(0).split("_");
		System.out.println(index.get(0));
		for(home h:by_type_list) {
			int t=Integer.parseInt(h.getArea());
			if(k[0].equalsIgnoreCase("area")) {
			assertTrue(t==(Integer.parseInt(k[1])));
			System.out.println(h.toString());
			}
			if(k[0].equalsIgnoreCase("area less than")) {
				assertTrue(t<=(Integer.parseInt(k[1])));
				System.out.println(h.toString());
				
			}
		}HomeFeature.Home.clear(); 
	}
	@When("I search about home with lease length {int}")
	public void i_search_about_home_with_lease_length(Integer int1) {

         index.add("lease length_"+int1);
         count1++;
     	for(home h:HomeFeature.Home) {
			int t= Integer.parseInt(h.getLeaselength());
			if(t == int1) {
    			by_type_list.add(h);	    			
				}	
		}
         
	}

	@Then("A list of homes that matches lease length specification should be returned and printed on the console")
	public void a_list_of_homes_that_matches_lease_length_specification_should_be_returned_and_printed_on_the_console() {
		String[] k=index.get(0).split("_");
		System.out.println(index.get(0));
		for(home h:by_type_list) {
			assertTrue(Integer.parseInt(h.getLeaselength())==(Integer.parseInt(k[1])));
			System.out.println(h.toString());
		}HomeFeature.Home.clear();
	}
	@When("I search about home Allow Pets {string}")
	public void i_search_about_home_allow_pets(String string) {

	   index.add("Allow Pets _"+string);
	   count1++;
	   for(home h:HomeFeature.Home) {
		   if(string.equalsIgnoreCase(h.getPets())) {
   			by_type_list.add(h);	    			
			   }
	   }
	}
	@Then("A list of homes that matches Allow Pets should be returned and printed on the console")
	public void a_list_of_homes_that_matches_allow_pets_should_be_returned_and_printed_on_the_console() {
		String[] k=index.get(0).split("_");
		System.out.println(index.get(0));
		for(home h:by_type_list) {
			assertTrue(h.getPets().equalsIgnoreCase(k[1]));
			System.out.println(h.toString());
		}HomeFeature.Home.clear();
	}
	@Then("A list of homes that matches this Combination should be returned and printed on the console")
	public void a_list_of_homes_that_matches_this_combination_should_be_returned_and_printed_on_the_console() {
	  for(int i=0;i<by_type_list.size();i++) {
		  for(int j=0;j<by_type_list.size();j++) {
			  boolean h=by_type_list.get(i).count(by_type_list.get(i), by_type_list.get(j)); 
		       if(h) {
		    	   count2++;
		       } }
		  if(count2==count1) {
			  assertTrue(count2==count1);
			  HomeFeature.list(by_type_list.get(i));
		  }
		  count2=0;
	  }
	  for(int i=0;i<HomeFeature.list.size();i++) {
		  for(int j=1;j<HomeFeature.list.size();j++) {
			  if(HomeFeature.list.get(i).count(HomeFeature.list.get(i), HomeFeature.list.get(j))) {
				  HomeFeature. list.remove(j);
			  }
		  }
	  }
	  System.out.println("list of houses");
	  for(home h:HomeFeature.list) {
		  System.out.println(h.toString()+"");
	  }HomeFeature.Home.clear();
	}

}
