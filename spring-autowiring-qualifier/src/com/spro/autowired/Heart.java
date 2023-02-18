package com.spro.autowired;

public class Heart {

	private String animalName;
	private int noOfHeart;
	
	public void pump() {
		System.out.println(animalName+" heart is pumping");
		System.out.println(animalName+" is alive and have "+noOfHeart+" hearts");
		
	}
	
	public String getAnimalName() {
		return animalName;
	}



	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}



	public int getNoOfHeart() {
		return noOfHeart;
	}



	public void setNoOfHeart(int noOfHeart) {
		this.noOfHeart = noOfHeart;
	}




}
