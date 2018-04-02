package com.example.demo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column
	@NotNull(message = "error.title.notnull")
	@Size(min = 1, max = 30, message = "error.title.size")
	private String address;

	private int age;

	@Lob
	@Column(name = "file_data")
	private byte[] fileData;

	@Column(name = "file_name")
	private String fileName;

	@Size(max = 100, message = "error.name.size")
	private String name;

	public User(
			@NotNull(message = "error.title.notnull") @Size(min = 1, max = 30, message = "error.title.size") String address,
			int age, byte[] fileData, String fileName, @Size(max = 100, message = "error.name.size") String name) {
		super();
		this.address = address;
		this.age = age;
		this.fileData = fileData;
		this.fileName = fileName;
		this.name = name;
	}

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public byte[] getFileData() {
		return this.fileData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}