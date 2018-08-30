package model;

public abstract class AbstractEntity {
	public abstract Long getId();

	public abstract void setId(Long id);

	@Override
	public boolean equals(Object obj) {
		AbstractEntity entity = (AbstractEntity) obj;
		return entity.getId() != null && entity.getId().equals(this.getId());
	}

	public boolean hasValidId() {
		return getId() != null && getId() != 0;
	}
}
