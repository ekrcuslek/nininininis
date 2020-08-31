package com.kopo.dto;

public class VoteVO {
	private int no;
	private int age10;
	private int age20;
	private int age30;
	private int age40;
	private int age50;
	private int age60;
	private int age70;
	private int age80;
	private int age90;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getAge10() {
		return age10;
	}

	public void setAge10(int age10) {
		this.age10 = age10;
	}

	public int getAge20() {
		return age20;
	}

	public void setAge20(int age20) {
		this.age20 = age20;
	}

	public int getAge30() {
		return age30;
	}

	public void setAge30(int age30) {
		this.age30 = age30;
	}

	public int getAge40() {
		return age40;
	}

	public void setAge40(int age40) {
		this.age40 = age40;
	}

	public int getAge50() {
		return age50;
	}

	public void setAge50(int age50) {
		this.age50 = age50;
	}

	public int getAge60() {
		return age60;
	}

	public void setAge60(int age60) {
		this.age60 = age60;
	}

	public int getAge70() {
		return age70;
	}

	public void setAge70(int age70) {
		this.age70 = age70;
	}

	public int getAge80() {
		return age80;
	}

	public void setAge80(int age80) {
		this.age80 = age80;
	}

	public int getAge90() {
		return age90;
	}

	public void setAge90(int age90) {
		this.age90 = age90;
	}

	public int sum() {
		return age10 + age20 + age30 + age40 + age50 + age60 + age70 + age80 + age90;
	}
}
