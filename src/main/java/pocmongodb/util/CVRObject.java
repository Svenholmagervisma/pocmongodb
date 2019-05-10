package pocmongodb.util;

public class CVRObject {
	private int _id;
	private long timestamp;
	
	public CVRObject() {
	}
	
	public int get_id() {
		return _id;
	}
	
	public void set_id(int cvrNumber) {
		this._id = cvrNumber;
	}
	
	public long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
}