package test;

public class home {
private String home_type;
private String home_material;
private String home_placement;
private String pets;
private String amenties;
private String price;
private String area;
private String bedrooms;
private String bathrooms;
private String leaselength;
public home (String home_type,String home_material,String home_placement,String pets,String amenties,String price,String area,String bedrooms,String bathrooms,String leaselength) {
	this.home_type=home_type;
	this.home_material=home_material;
	this.home_placement=home_placement;
	this.pets=pets;
	this.amenties=amenties;
	this.price=price;
	this.area=area;
	this.bedrooms=bedrooms;
	this.bathrooms=bathrooms;
	this.leaselength=leaselength;
}
public String toString() {
	return "Home [type ="+this.home_type+", material ="+this.home_material+", placement ="+this.home_placement+", pets ="+this.pets+", amenties ="+this.amenties+", the price is ="+this.price
			+", area ="+this.getArea()+", number of bedrooms ="+this.bedrooms+", number of bathrooms ="+this.bathrooms+", leaselength ="+this.leaselength+"]";
}
public String getHome_type() {
	return home_type;
}
public void setHome_type(String home_type) {
	this.home_type = home_type;
}
public String getHome_material() {
	return home_material;
}
public void setHome_material(String home_material) {
	this.home_material = home_material;
}
public String getPets() {
	return pets;
}
public void setPets(String pets) {
	this.pets = pets;
}
public String getHome_placement() {
	return home_placement;
}
public void setHome_placement(String home_placement) {
	this.home_placement = home_placement;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public String getAmenties() {
	return amenties;
}
public void setAmenties(String amenties) {
	this.amenties = amenties;
}
public String getArea() {
	return area;
}
public void setArea(String area) {
	this.area = area;
}
public String getBedrooms() {
	return bedrooms;
}
public void setBedrooms(String bedrooms) {
	this.bedrooms = bedrooms;
}
public String getBathrooms() {
	return bathrooms;
}
public void setBathrooms(String bathrooms) {
	this.bathrooms = bathrooms;
}
public String getLeaselength() {
	return leaselength;
}
public void setLeaselength(String leaselength) {
	this.leaselength = leaselength;
}
public boolean count (home h1, home h2) {
	boolean b=false;
	if(h1.getAmenties().equalsIgnoreCase(h2.getAmenties())&& h1.getArea().equalsIgnoreCase(h2.getArea())&& h1.getBathrooms().equalsIgnoreCase(h2.getBathrooms())&&h1.getBedrooms().equalsIgnoreCase(h2.getBedrooms())
			&&h1.getHome_material().equalsIgnoreCase(h2.getHome_material())&&h1.getHome_placement().equalsIgnoreCase(h2.getHome_placement())&& h1.getHome_type().equalsIgnoreCase(h2.getHome_type())&&h1.getLeaselength().equalsIgnoreCase(h2.getLeaselength())
			&&h1.getPets().equalsIgnoreCase(h2.getPets())&&h1.getPrice().equalsIgnoreCase(h2.getPrice())) {
		b=true;
	}
	return b;
	
}
}
