package FFT;

// import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.exception.DimensionMismatchException;

public class transform_utils {
	public static Complex[] createComplexArray(short[][] dataRI)
	        throws DimensionMismatchException{

	        if (dataRI.length != 2) {
	            throw new DimensionMismatchException(dataRI.length, 2);
	        }
	        short[] dataR = dataRI[0];
	        short[] dataI = dataRI[1];
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
	
	public static short[] createShortArray(short[][] dataRI)
	        throws DimensionMismatchException{

	        if (dataRI.length != 2) {
	            throw new DimensionMismatchException(dataRI.length, 2);
	        }
	        short[] dataR = dataRI[0];
	        short[] dataI = dataRI[1];
	        if (dataR.length != dataI.length) {
	            throw new DimensionMismatchException(dataI.length, dataR.length);
	        }

	        int n = dataR.length;
	        short [] c = new short [n];
	        // final Complex[] c = new Complex[n];
	        for (int i = 0; i < n; i++) {
	            // c[i] = new Complex(dataR[i], dataI[i]);
	        	c[i] = (short)(Math.sqrt(dataR[i] * dataR[i] + dataI[i] * dataI[i]));
	        }
	        return c;
	    }
}
