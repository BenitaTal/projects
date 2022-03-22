package model;

import java.io.IOException;
import java.io.RandomAccessFile;

import observer.Observable;
import observer.Observer;

public class Customer implements Observer {
	private String name;
	private String phoneNumber;
	private boolean isInterested;

	public Customer() {
		this.name = "";
		this.phoneNumber = "12345678";
		this.isInterested = false;
	}

	public Customer(String name, String phoneNumber, boolean isInterested) {
		if (setPhoneNumber(phoneNumber)) {
			this.name = name;
			this.isInterested = isInterested;
		}

	}

	public Customer(RandomAccessFile raf) {
		try {
			this.name = raf.readUTF();
			this.phoneNumber = raf.readUTF();
			this.isInterested = raf.readBoolean();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "\t\tCustomer:  " + name + " , Phone Number:  " + phoneNumber + " , Notification? :  " + isInterested
				+ "\n";
	}

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public boolean setPhoneNumber(String phoneNumber) {
		if (phoneNumber.contains("[a-zA-Z]+") == true || phoneNumber.length()<8)
			return false;
		this.phoneNumber = phoneNumber;
		return true;
	}

	public boolean isInterested() {
		return isInterested;
	}

	public boolean setAllValues(String name, String phoneNumber, boolean isInterested) {
		if (setPhoneNumber(phoneNumber)) {
			this.name = name;
			this.isInterested = isInterested;
			return true;
		}
		return false;
	}

	public boolean writeCustomerToBinFile(RandomAccessFile raf) {
		try {
			raf.writeUTF(name);
			raf.writeUTF(phoneNumber);
			raf.writeBoolean(isInterested);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean readCustomerFromBinFile(RandomAccessFile raf) {
		try {
			raf.writeUTF(name);
			raf.writeUTF(phoneNumber);
			raf.writeBoolean(isInterested);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public String update(Observable obs) {
		if (obs instanceof StoreFunc) {
			return this.getName();
		}
		return "";
	}// TODO Auto-generated method stub

}
