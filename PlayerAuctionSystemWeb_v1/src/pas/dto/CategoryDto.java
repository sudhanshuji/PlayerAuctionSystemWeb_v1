package pas.dto;

public class CategoryDto {

	private String categoryKey;
	private String categoryValue;

	/**
	 * 
	 */
	public CategoryDto() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param categoryKey
	 * @param categoryValue
	 */
	public CategoryDto(String categoryKey, String categoryValue) {
		this.categoryKey = categoryKey;
		this.categoryValue = categoryValue;
	}

	/**
	 * @return the categoryKey
	 */
	public String getCategoryKey() {
		return categoryKey;
	}

	/**
	 * @param categoryKey the categoryKey to set
	 */
	public void setCategoryKey(String categoryKey) {
		this.categoryKey = categoryKey;
	}

	/**
	 * @return the categoryValue
	 */
	public String getCategoryValue() {
		return categoryValue;
	}

	/**
	 * @param categoryValue the categoryValue to set
	 */
	public void setCategoryValue(String categoryValue) {
		this.categoryValue = categoryValue;
	}
}
