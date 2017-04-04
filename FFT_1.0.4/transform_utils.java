package FFT;

// import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.exception.DimensionMismatchException;

public class transform_utils {
	public static Complex[] createComplexArray(int[][] dataRI) throws DimensionMismatchException {
	        if (dataRI.length != 2) {
	            throw new DimensionMismatchException(dataRI.length, 2);
	        }
	        int[] dataR = dataRI[0];
	        int[] dataI = dataRI[1];
	        if (dataR.length != dataI.length) {
	            throw new DimensionMismatchException(dataI.length, dataR.length);
	        }

	        int n = dataR.length;
	        Complex[] c = new Complex[n];
	        for (int i = 0; i < n; i++) {
	            c[i] = new Complex(dataR[i], dataI[i]);
	        }
	        return c;
	    }
	
	public static int[] createIntArray(int[][] dataRI) throws DimensionMismatchException {
	        if (dataRI.length != 2) {
	            throw new DimensionMismatchException(dataRI.length, 2);
	        }
	        int[] dataR = dataRI[0];
	        int[] dataI = dataRI[1];
	        if (dataR.length != dataI.length) {
	            throw new DimensionMismatchException(dataI.length, dataR.length);
	        }

	        int n = dataR.length;
	        int [] c = new int [n];
	        for (int i = 0; i < n; i++) {
	        	double tempR = dataR[i];
	        	double tempI = dataI[i];
	        	c[i] = (int)Math.sqrt(tempR * tempR + tempI * tempI);
	        }
	        return c;
	    }
}
