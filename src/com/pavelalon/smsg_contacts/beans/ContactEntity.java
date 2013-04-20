package com.pavelalon.smsg_contacts.beans;

public class ContactEntity {
	
	private int _id;
	
	private String contactName;
	
	private String photoURI;
	
	public ContactEntity() {
		
	}
	
	

	public ContactEntity(int _id, String contactName, String photoURI) {
		super();
		this._id = _id;
		this.contactName = contactName;
		this.photoURI = photoURI;
	}

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getPhotoURI() {
		return photoURI;
	}

	public void setPhotoURI(String photoURI) {
		this.photoURI = photoURI;
	}

	@Override
	public String toString() {
		return "ContactEntity [_id=" + _id + ", contactName=" + contactName
				+ ", photoURI=" + photoURI + "]";
	}
	
}
