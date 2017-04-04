package FFT;
/*************************************************************************
 *  Compilation:  javac FFT.Java
 *  Execution:    java FFT
 *  Dependencies: Complex.Java
 *
 *  
 *************************************************************************/
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.math3.transform.*;
//import org.apache.commons.math3.complex.*;

public class FFT {
	private final static int point = 32 * 1024 * 1024;
	private final static String inFileNameAs16Bit = "/home/ubuntu/桌面/FiveWords2EightWords.data";
	private final static String writeFileNameAfterFFT = "/home/ubuntu/sync/afterFFT.data";
	
	public static short [] inShortData(String inFileName, int sizeOfData) {
		// 20971519
		File inFile = new File(inFileName);

		FileInputStream inStream = null;
		DataInputStream inData = null;
		short [] data = new short [sizeOfData];
		
		try {
			inStream = new FileInputStream(inFile);
			inData = new DataInputStream(inStream);

			for (int count = 0; count < sizeOfData; count++) {
					try {
						data[count] = inData.readShort();
					} catch (IOException err_0) {
						return null;
					}
			}
		} catch (IOException err_1) {
			err_1.printStackTrace();
			return null;
		} finally {
			if (inStream != null) {
				try {
					inData.close();
					inStream.close();
				} catch (IOException err_2) {}
			}
		}
		writeShortData("/home/ubuntu/sync/beforeFFT.data", data);
		return(data);
	}

	public static void outIntData(String outFileName, int[] data) {
		File outFile = new File(outFileName);

		FileOutputStream outStream = null;
		DataOutputStream outData = null;
		
		try {
			outStream = new FileOutputStream(outFile);
			outData = new DataOutputStream(outStream);

			for (int count = 0; count < data.length; count++) {
					try {
						outData.writeInt(data[count]);
					} catch (IOException err_0) {
						return;
					}
			}
		} catch (IOException err_readData_1) {
			err_readData_1.printStackTrace();
			return;
		} finally {
			if (outStream != null) {
				try {
					outData.close();
					outStream.close();
				} catch (IOException err_readData_2) {}
			}
		}
	}
	
	public static void writeIntData(String outFileName, int[] data) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(outFileName));
			for (int count = 0; count < data.length; count++) {
				out.write(data[count] + "\n");
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeShortData(String outFileName, short[] data) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(outFileName));
			for (int count = 0; count < data.length; count++) {
				out.write(data[count] + "\n");
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		TestMemory startMemory = new TestMemory();
		System.out.println("Start Memory: " + startMemory.showMemoryInfo());
		short [] inputData = inShortData(inFileNameAs16Bit, point);
		long fftStartTime = System.currentTimeMillis();
		fast_fourier_transformer fft = new fast_fourier_transformer(DftNormalization.STANDARD);
		int [] result = fft.transformInt(inputData, TransformType.FORWARD);
		writeIntData(writeFileNameAfterFFT, result);
		long finishTime = System.currentTimeMillis();
		TestMemory finishMemory = new TestMemory();
		System.out.println("Finish Memory: " + finishMemory.showMemoryInfo());
		System.out.println("Use Memory: " + (startMemory.getFreeMemoryData() - finishMemory.getFreeMemoryData()) + "MB.");
		System.out.print("All Time: ");System.out.print((double)(finishTime - startTime)/1000);System.out.println("s.");
		System.out.print("FFT Time: ");System.out.print((double)(finishTime - fftStartTime)/1000);System.out.println("s.");
	}
}


