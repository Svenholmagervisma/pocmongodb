package pocmongodb.util;

public class CVRObject {
	private long _id;
	private long timestamp;
	
	public CVRObject() {
	}
	
	public long get_id() {
		return _id;
	}
	
	public void set_id(long cvrNumber) {
		this._id = cvrNumber;
	}
	
	public long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
}