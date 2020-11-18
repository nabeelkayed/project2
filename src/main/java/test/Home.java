package test;

public class Home {
private String homeType;
private String homeMaterial;
private String homePlacement;
private String pets;
private String amenties;
private String price;
private String area;
private String bedrooms;
private String bathrooms;
private String leaselength;
public Home (String []t,String []g) {
	
	setHomeType(t[0]);
	setHomeMaterial(t[1]);
	setHomePlacement(t[2]);
	setPets(t[3]);
	setAmenties(t[4]);
	setPrice(g[0]);
	setArea(g[1]);
	setBedrooms(g[2]);
    setBathrooms(g[3]);
	setLeaselength(g[4]);
}
public String toString() {
	return "Home [type ="+this.homeType+", material ="+this.homeMaterial+", placement ="+this.homePlacement+", pets ="+this.pets+", amenties ="+this.amenties+", the price is ="+this.price
			+", area ="+this.getArea()+", number of bedrooms ="+this.bedrooms+", number of bathrooms ="+this.bathrooms+", leaselength ="+this.leaselength+"]";
}
public String getHomeType() {
	return homeType;
}
public void setHomeType(String homeType) {
	this.homeType = homeType;
}
public String getHomeMaterial() {
	return homeMaterial;
}
public void setHomeMaterial(String homeMaterial) {
	this.homeMaterial = homeMaterial;
}
public String getPets() {
	return pets;
}
public void setPets(String pets) {
	this.pets = pets;
}
public String getHomePlacement() {
	return homePlacement;
}
public void setHomePlacement(String homePlacement) {
	this.homePlacement = homePlacement;
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
}
