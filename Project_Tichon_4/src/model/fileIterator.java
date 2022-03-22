package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.Map.Entry;

public class fileIterator implements Iterator<Entry<String, Product>> {

	private String fileName;
	private RandomAccessFile raf;
	private int currentPos;
	private int lastPos;
	private int writePointer;

	public fileIterator(String fileName) {
		try {
			this.fileName = fileName;
			raf = new RandomAccessFile(fileName, "rw");
			this.currentPos = 0;
			this.lastPos = -1;
			this.writePointer = 0;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getFileName() {
		return fileName;
	}

	public int getCurrentPos() {
		return currentPos;
	}

	public boolean isEmpty() {
		try {
			return raf.length() == 0;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public void setCurrentPos(int pos) {
		try {
			raf.seek(pos);
			currentPos = (int) raf.getFilePointer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public RandomAccessFile getRaf() {
		return raf;
	}

	public int getLastPos() {
		return lastPos;
	}

	public void setLastPos(int lastPos) {
		this.lastPos = lastPos;
	}

	public int getWritePointer() {
		return writePointer;
	}

	public void setWritePointer(int writePointer) {
		this.writePointer = writePointer;
	}

	public void setLengthOfFile(int pos) {
		try {
			raf.setLength(pos);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean hasNext() {
		try {
			if (getCurrentPos() == raf.length())
				return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public Entry<String, Product> next() {
		if (!hasNext())
			return null;
		else {
			try {
				setLastPos(getCurrentPos());
				String idOfProduct = raf.readUTF();
				Product product = new Product(raf);
				ProductEntry myEntry = new ProductEntry(idOfProduct, product);
				setCurrentPos((int) raf.getFilePointer());
				return myEntry;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public void remove() {
		ProductEntry entry;
		int pos;
		setWritePointer(getLastPos());
		while (hasNext()) {
			try {
				entry = new ProductEntry((ProductEntry) next());
				pos = getCurrentPos();
				setCurrentPos(getWritePointer());
				getRaf().writeUTF(entry.getKey());
				entry.getValue().writeProductToBinFile(raf);
				setWritePointer((int) raf.getFilePointer());
				setCurrentPos(pos);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		setLengthOfFile(writePointer);
		setCurrentPos(writePointer);
	}

}
