package algorithm.comp3203;

//from algs4.cs.prinston.edu/14analysis/Stopwatch.java.html
public class StopWatch {
	private final long start;
	
	public StopWatch() {
		start = System.currentTimeMillis();
	}
	
	public double elapsedTime() {
		long now = System.currentTimeMillis();
		return (now - start) / 1000;
	}
}

