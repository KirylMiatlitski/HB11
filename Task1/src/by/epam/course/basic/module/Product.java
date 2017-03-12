package by.epam.course.basic.module;

public class Product {
	private String category;
	private int manufactorID;
	private String creationDate;
	private String annotation;
	
	public Product(String category, int manufactorID, String creationDate, String annotation) {
		super();
		this.category = category;
		this.manufactorID = manufactorID;
		this.creationDate = creationDate;
		this.annotation = annotation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((annotation == null) ? 0 : annotation.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + manufactorID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (annotation == null) {
			if (other.annotation != null)
				return false;
		} else if (!annotation.equals(other.annotation))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (manufactorID != other.manufactorID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product " + category + " with ID = " + manufactorID + " (" + creationDate + ")" +"\n"+ "Annotation: "+ annotation;
	}

	public String getCategory() {
		return category;
	}

	public int getManufactorID() {
		return manufactorID;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public String getAnnotation() {
		return annotation;
	}
	
	
	
	
	
}
