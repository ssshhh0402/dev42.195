package com.ssafy.manv.response;

public class MemberNumberResult {

	private int number;
	private String name;
	private String state;
	
	public MemberNumberResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberNumberResult(int number, String name, String state) {
		super();
		this.number = number;
		this.name = name;
		this.state = state;
	}

	@Override
	public String toString() {
		return "BookNumberResult [number=" + number + ", name=" + name + ", state=" + state + "]";
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
	
}
