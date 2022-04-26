package pas.dto;

public class TeamNameDto {

	private String teamNameKey;
	private String teamNameValue;

	/**
	 * 
	 */
	public TeamNameDto() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param teamNameKey
	 * @param teamNameValue
	 */
	public TeamNameDto(String teamNameKey, String teamNameValue) {
		this.teamNameKey = teamNameKey;
		this.teamNameValue = teamNameValue;
	}

	public String getCategoryKey() {
		return teamNameKey;
	}

	public void setCategoryKey(String teamNameKey) {
		this.teamNameKey = teamNameKey;
	}

	public String getCategoryValue() {
		return teamNameValue;
	}

	public void setCategoryValue(String teamNameValue) {
		this.teamNameValue = teamNameValue;
	}
}
