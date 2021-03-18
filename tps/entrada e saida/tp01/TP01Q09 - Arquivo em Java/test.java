import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class test {

	/**
	 * 
	 * @param filename target file
	 * @param charset  encoding format of the target file
	 */
	public static void read(String filename, String charset) throws IOException {

		RandomAccessFile rf = null;

		rf = new RandomAccessFile(filename, "r");
		long len = rf.length();
		long start = rf.getFilePointer();
		long nextend = start + len - 1;
		String line;
		rf.seek(nextend);
		int c = -1;
		while (nextend > start) {
			c = rf.read();
			if (c == '\n' || c == '\r') {
				line = rf.readLine();
				if (line != null) {
					System.out.println(new String(line.getBytes("ISO-8859-1"), charset));
				} else {
					System.out.println(line);
				}
				nextend--;
			}
			nextend--;
			rf.seek(nextend);

		}

	}

	public static void main(String args[]) throws IOException {
		read("test.txt", "UTF-8");
	}
}