package domain;

public class Product extends Entity {

	private Type type;
	private Brand brand;
	private String name;
	private Double cost;
	private String description;

	
	
	public Product() {
		super();
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Id: "+super.getId()+" Product ["+type+ "], [" + brand + "], name=" + name
				+ ", cost=" + cost + ", description=" + description + "]";
	}

}
