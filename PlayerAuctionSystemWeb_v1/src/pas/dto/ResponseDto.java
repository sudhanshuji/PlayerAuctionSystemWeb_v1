package pas.dto;

import java.util.List;

public class ResponseDto {

	private String id;

	private Object data;

	private List<String> error;

	/**
	 * 
	 */
	public ResponseDto() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param apiKey
	 * @param data
	 * @param error
	 */
	public ResponseDto(String apiKey, Object data, List<String> error) {
		this.id = apiKey;
		this.data = data;
		this.error = error;
	}

	/**
	 * @return the apiKey
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param apiKey the apiKey to set
	 */
	public void setId(String apiKey) {
		this.id = apiKey;
	}

	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * @return the error
	 */
	public List<String> getError() {
		return error;
	}

	/**
	 * @param error the error to set
	 */
	public void setError(List<String> error) {
		this.error = error;
	}

}
