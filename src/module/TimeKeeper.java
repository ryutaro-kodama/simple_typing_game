package module;

public class TimeKeeper {
	private long start=0, end=0;
	
	public void setStart() {
		start = System.currentTimeMillis();
	}
	
	public void setEnd() {
		end = System.currentTimeMillis();
	}
	
	public double calculateTime() {
		return (double)(end - start)/1000;
	}
}
