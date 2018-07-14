package service;

public class Status {

	boolean queryStatus;

	public Status() {

	}

	public Status(boolean queryStatus) {
		super();
		this.queryStatus = queryStatus;
	}

	public boolean isQueryStatus() {
		return queryStatus;
	}

	public void setQueryStatus(boolean queryStatus) {
		this.queryStatus = queryStatus;
	}

	@Override
	public String toString() {
		return "Status [queryStatus=" + queryStatus + "]";
	}

}
