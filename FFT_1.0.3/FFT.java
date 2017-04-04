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
	
	public static double [] ComplexArrayAbs(Complex [] array) {
		double [] arrayAfterAbs = new double [array.length];
		for (int count = 0; count < array.length; count++) {
			arrayAfterAbs[count] = array[count].getAbs();
		}
		return arrayAfterAbs;
	}

	public static void FiveWords2EightWords(String inFileName, String outFileName) {
		File inFile = new File(inFileName);

		FileInputStream inStream = null;
		FileOutputStream outStream = null;
		DataInputStream inData = null;
		DataOutputStream outData = null;
		
		try {
			inStream = new FileInputStream(inFile);
			System.out.println("Start read input file.");
			inData = new DataInputStream(inStream);
			outStream = new FileOutputStream(outFileName);
			System.out.println("Start read output file.");
			outData = new DataOutputStream(outStream);
			
			short [] dataBefore = new short [5];
			short [] dataAfter = new short [8];
			
			int num = 0;
			
			while (true) {
			//for (int i = 0; i < 30; i++) {
				for (int count = 0; count < dataBefore.length; count++) {
					try {
						dataBefore[count] = inData.readShort();
					} catch (IOException err_FiveWords2EightWords_0) {
						return;
					}
				}
				/*
				for (int count = 0; count < dataBefore.length; count++) {
					System.out.printf("%04x\t", dataBefore[count]);
				}
				System.out.println();
				*/
				dataAfter[0] = (short)(((dataBefore[0] & 0xc000) >> 14) + ((dataBefore[0] & 0x00ff) << 2) - 0x1fd);
				dataAfter[1] = (short)(((dataBefore[0] & 0x3f00) >> 4) + ((dataBefore[1] & 0x00f0) >> 4) - 0x1fd);
				dataAfter[2] = (short)(((dataBefore[1] & 0x000f) << 6) + ((dataBefore[1] & 0xfc00) >> 10) - 0x1fd);
				dataAfter[3] = (short)((dataBefore[1] & 0x0300) + (dataBefore[2] & 0x00ff) - 0x1fd);
				dataAfter[4] = (short)(((dataBefore[2] & 0xff00) >> 6) + ((dataBefore[3] & 0x00c0) >> 6) - 0x1fd);
				dataAfter[5] = (short)(((dataBefore[3] & 0x003f) << 4) + ((dataBefore[3] & 0xf000) >> 12) - 0x1fd);
				dataAfter[6] = (short)(((dataBefore[3] & 0x0f00) >> 2) + ((dataBefore[4] & 0x00fc) >> 2) - 0x1fd);
				dataAfter[7] = (short)(((dataBefore[4] & 0x0003) << 8) + ((dataBefore[4] & 0xff00) >> 8) - 0x1fd);
				/*
				for (int count = 0; count < dataAfter.length; count++) {
					System.out.printf("%4d\t", dataAfter[count]);
				}
				System.out.println();
				*/
				for (int count = 0; count < dataAfter.length; count++)
					outData.writeShort(dataAfter[count]);
				
				System.out.println(num);
				num += 1;
			}
		} catch (IOException err_FiveWords2EightWords_1) {
			err_FiveWords2EightWords_1.printStackTrace();
			return;
		} finally {
			if (inStream != null & outStream != null) {
				try {
					inData.close();
					outData.close();
					inStream.close();
					System.out.println("Input file close!");
					outStream.close();
					System.out.println("Output file close!");
				} catch (IOException err_FiveWords2EightWords_2) {}
			}
		}
	}
	
	public static double [] readDoubleData(String inFileName, int sizeOfData) {
		// 20971519
		File inFile = new File(inFileName);

		FileInputStream inStream = null;
		DataInputStream inData = null;
		double [] data = new double [sizeOfData];
		
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
		return(data);
	}

	public static short [] readShortData(String inFileName, int sizeOfData) {
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
		writeFFTData("/home/ubuntu/sync/beforeFFT.data", data);
		return(data);
	}

	public static void writeShortData(String outFileName, short[] data) {
		File outFile = new File(outFileName);

		FileOutputStream outStream = null;
		DataOutputStream outData = null;
		
		try {
			outStream = new FileOutputStream(outFile);
			outData = new DataOutputStream(outStream);

			for (int count = 0; count < data.length; count++) {
					try {
						outData.writeShort(data[count]);
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
	
	public static void writeFFTData(String outFileName, short[] data) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(outFileName));
			for (int count = 0; count < data.length; count++) {
				String s = String.valueOf(data[count]) + "\n";
				out.write(s);
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
		int point = 1024 * 64;
		// double [] inputData = readDoubleData("/home/ubuntu/桌面/FiveWords2EightWords.data", point);
		short [] inputData = readShortData("/home/ubuntu/桌面/FiveWords2EightWords.data", point);
		long fftStartTime = System.currentTimeMillis();
		// FastFourierTransformer fft = new FastFourierTransformer(DftNormalization.STANDARD);
		fast_fourier_transformer fft = new fast_fourier_transformer(DftNormalization.STANDARD);
		//Complex [] result = fft.transformComplex(inputData, TransformType.FORWARD);
		short [] result = fft.transformShort(inputData, TransformType.FORWARD);
		//writeShortData("/home/ubuntu/桌面/short.data", result);
		writeFFTData("/home/ubuntu/sync/afterFFT.data", result);
		long finishTime = System.currentTimeMillis();
		TestMemory finishMemory = new TestMemory();
		System.out.println("Finish Memory: " + finishMemory.showMemoryInfo());
		System.out.println("Use Memory: " + (startMemory.getFreeMemoryData() - finishMemory.getFreeMemoryData()) + "MB.");
		System.out.print("All Time: ");System.out.print((double)(finishTime - startTime)/1000);System.out.println("s.");
		System.out.print("FFT Time: ");System.out.print((double)(finishTime - fftStartTime)/1000);System.out.println("s.");
	}
}


