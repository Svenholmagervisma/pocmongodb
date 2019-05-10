package pocmongodb.util;

public class CVRObject {

	private int cvrNumber;
	private int timestamp;
	private String data;
	
	public CVRObject() {
	}
	
	public int getCvrNumber() {
		return cvrNumber;
	}
	
	public void setCvrNumber(int cvrNumber) {
		this.cvrNumber = cvrNumber;
	}
	
	public int getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}

}