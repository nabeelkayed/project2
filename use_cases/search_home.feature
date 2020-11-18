Feature: Search about suitable home
  
Background: The System has a repository of homes with their specifications (type-material-placement-pets-amenities-price-area-bedrooms-bathrooms-leaselength)
Given  these homes are contained in the system
                |HOUSE_WOOD_VILLAGE_NO_GARAGEPARKING,FIREPLACE,ELEVATOR|510_150_3_2_6|
                |APARTMENT_BRICK_CITY_yes_ELEVATOR|230_120_4_2_12|
               
@ByCombination1
   Scenario: I search about home with many things1
   When I search about home by several things
   And I search about home Type by "HOUSE"
   And I search about home with area less than 150
   And I search about home with lease length 6
   Then A list of homes that matches this Combination should be returned and printed on the console
   And email with the result of several things should be send to "nabeelkayed.9b.23@gmail.com" with subject "By Several Things"               
@byType     
  Scenario: Search home by type
  When I search about home Type by "HOUSE"
  Then A list of homes that matches the  type specification should be returned and printed on the console
  And email with the result of type should be send to "nabeelkayed.9b.23@gmail.com" with subject "By Type"

@bymaterial
  Scenario: Search home by material
  When I search about home material by "Brick"
  Then A list of homes that matches the material specification should be returned and printed on the console
  And email with the result of material should be send to "nabeelkayed.9b.23@gmail.com" with subject "By Material"
  
@byplacement
  Scenario: Search home by placement
  When I search about home placment by "Village"
  Then A list of homes that matches the placement specification should be returned and printed on the console
  And email with the result of placement should be send to "nabeelkayed.9b.23@gmail.com" with subject "By Placement"
 @byspecificprice
  Scenario: Search about home with a specific price
  When I search about home with price  510
  Then A list of homes that matches the price specification should be returned and printed on the console
  And email with the result of price should be send to "nabeelkayed.9b.23@gmail.com" with subject "By Price"
  
 @bynumberofbedroom
   Scenario: Search home By Number of bedrooms 
   When I Search about home with number of bedrooms 4
   Then A list of homes that matches the number of bedrooms specification should be returned and printed on the console
   And email with the result of Number of bedrooms should be send to "nabeelkayed.9b.23@gmail.com" with subject "By Number Of Bedrooms"
    
@byNumberofBathrooms
   Scenario: Search home By Number of bathrooms 
   When I Search about home with number of bathrooms 2
   Then A list of homes that matches the number of bathrooms specification should be returned and printed on the console
   And email with the result of Number of bathrooms should be send to "nabeelkayed.9b.23@gmail.com" with subject "By Number Of Bathrooms"
     
@byamenties
   Scenario: Search home contains amenities
   When I search about home contains amenities "FIREPLACE"
   Then A list of homes that matches amenities should be returned and printed on the console
   And email with the result of amenities should be send to "nabeelkayed.9b.23@gmail.com" with subject "By Amenities"

@byRangOfPrices
   Scenario: Search about home with price less than a specific price
   When I search about home with price less than 510
   Then A list of homes that matches the rangofprices specification should be returned and printed on the console
   And email with the result of RangOfPrices should be send to "nabeelkayed.9b.23@gmail.com" with subject "By RangOfPrices"
    
@byspecificArea
   Scenario: Search about home with a specific area
   When I search about home with area  150
   Then A list of homes that matches the area specification should be returned and printed on the console
   And email with the result of area should be send to "nabeelkayed.9b.23@gmail.com" with subject "By Area"
    
@byRangOfArea
   Scenario: Search about home with area less than a specific area 
   When I search about home with area less than 150
   Then A list of homes that matches the rangofarea specification should be returned and printed on the console
   And email with the result of RangOfArea should be send to "nabeelkayed.9b.23@gmail.com" with subject "By RangOfArea"
     
@byLeaseLength
   Scenario: Search about home with lease length
   When I search about home with lease length 6
   Then A list of homes that matches lease length specification should be returned and printed on the console   
   And email with the result of lease length should be send to "nabeelkayed.9b.23@gmail.com" with subject "By Lease Length"
     
@byAllowPets
   Scenario: Search about home Allow Pets
   When I search about home Allow Pets "yes"
   Then A list of homes that matches Allow Pets should be returned and printed on the console
   And email with the result of Pets should be send to "nabeelkayed.9b.23@gmail.com" with subject "By Pets"
     
@ByCombination
   Scenario: I search about home with many things
   When I search about home by several things
   And I search about home Type by "HOUSE"
   And I search about home with area less than 150
   And I search about home with lease length 6
   Then A list of homes that matches this Combination should be returned and printed on the console
   And email with the result of several things should be send to "nabeelkayed.9b.23@gmail.com" with subject "By Several Things"