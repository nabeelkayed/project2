Feature: Search about suitable home
  
Background: The System has a repository of homes with their specifications (type-material-placement-pets-amenities-price-area-bedrooms-bathrooms-leaselength)
Given  these homes are contained in the system
                |HOUSE_WOOD_VILLAGE_NO_GARAGEPARKING,FIREPLACE,ELEVATOR|510_150_3_2_6|
                |APARTMENT_BRICK_CITY_yes_ELEVATOR|230_120_4_2_12|
               
                
@byType     
  Scenario: Search home by type
  When I search about home by "HOUSE"
  Then A list of homes that matches the  type specification should be returned and printed on the console

@bymaterial
 Scenario: Search home by material
  When I search about home by "Brick"
  Then A list of homes that matches the  type specification should be returned and printed on the console
  
  @byplacement
   Scenario: Search home by placement
  When I search about home by "Village"
  Then A list of homes that matches the  type specification should be returned and printed on the console
 @byspecificprice
  Scenario: Search about home with a specific price
   When I search about home with price  510
    Then A list of homes that matches the price specification should be returned and printed on the console
  
 @bynumberofbedroom
   Scenario: Search home By Number of bedrooms 
   When I Search about home with number of bedrooms 4
    Then A list of homes that matches the number of bedrooms specification should be returned and printed on the console
    
@byNumberofBathrooms
    Scenario: Search home By Number of bathrooms 
    When I Search about home with number of bathrooms 2
     Then A list of homes that matches the number of bathrooms specification should be returned and printed on the console
     
@byamenties
    Scenario: Search home contains amenities
    When I search about home contains amenities "FIREPLACE"
    Then A list of homes that matches amenities should be returned and printed on the console
  
  @byRangOfPrices
   Scenario: Search about home with price less than a specific price
   When I search about home with price less than 510
  Then A list of homes that matches the price specification should be returned and printed on the console
    
    @byspecificArea
  Scenario: Search about home with a specific area
    When I search about home with area  150
    Then A list of homes that matches the area specification should be returned and printed on the console
    
    @byRangOfArea
    Scenario: Search about home with area less than a specific area 
    When I search about home with area less than 150
    Then A list of homes that matches the area specification should be returned and printed on the console
     
     @byLeaseLength
     Scenario: Search about home with lease length
     When I search about home with lease length 6
     Then A list of homes that matches lease length specification should be returned and printed on the console   
     
     @byAllowPets
       Scenario: Search about home Allow Pets
        When I search about home Allow Pets "yes"
    Then A list of homes that matches Allow Pets should be returned and printed on the console
     
     @ByCombination
     Scenario: I search about home with many things
     When I search about home contains amenities "ELEVATOR"
     And I search about home with area less than 150
     And I search about home with lease length 12
     Then A list of homes that matches this Combination should be returned and printed on the console
     
     
     
     
     
     
     
     