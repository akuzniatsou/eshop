package domain;


public abstract class Entity {



	@Override
	public String toString() {
		return "id=" + id ;
	}

	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@Override
    public boolean equals(Object object) {
        if(object != null) {
            if(object != this) {
                if(object.getClass() == getClass()) {
                    Entity entity = (Entity) object;
                    return entity.getId().equals(getId());
                }
                return false;
            }
            return true;
        }
        return false;
    }

}
