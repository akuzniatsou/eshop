package domain;

public class Type extends Entity {


	private String typeName;

	
	public Type() {
		super();
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Override
	public String toString() {
		return "id="+super.getId() +", typeName=" + typeName;
	}

	

}
