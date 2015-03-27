package domain;

public class Brand extends Entity {


	private String brand;
	
	
	public Brand() {}

	public String getBrandName() {
		return brand;
	}

	public void setBrandName(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "id="+super.getId() +", brand=" + brand;
	}



	
	
}
