package FFT;

public class TestMemory {
	private Runtime currRuntime = Runtime.getRuntime();
	private int nFreeMemory = (int)(currRuntime.freeMemory() / 1024 / 1024);
	private int nTotalMemory = (int)(currRuntime.totalMemory() / 1024 / 1024);
	
	public String showMemoryInfo() {
		return nFreeMemory + "MB/" + nTotalMemory + "M(free/total).";
	}
	
	public int getFreeMemoryData() {
		return nFreeMemory;
	}
}
