//package FFT;

// import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.exception.DimensionMismatchException;

public class transform_utils {
	public static Complex[] createComplexArray(final short[][] dataRI)
	        throws DimensionMismatchException{

	        if (dataRI.length != 2) {
	            throw new DimensionMismatchException(dataRI.length, 2);
	        }
	        final short[] dataR = dataRI[0];
	        final short[] dataI = dataRI[1];
	        if (dataR.length != dataI.length) {
	            throw new DimensionMismatchException(dataI.length, dataR.length);
	        }

	        final int n = dataR.length;
	        final Complex[] c = new Complex[n];
	        for (int i = 0; i < n; i++) {
	            c[i] = new Complex(dataR[i], dataI[i]);
	        }
	        return c;
	    }
}
