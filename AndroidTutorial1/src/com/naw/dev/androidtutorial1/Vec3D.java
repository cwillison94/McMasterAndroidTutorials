package com.naw.dev.androidtutorial1;

import java.util.Locale;

/**
 * @author Cole Willison
 * @since 2014-11-25
 * 
 * 
 * */
public class Vec3D {
	private double a1, a2, a3;

	public Vec3D(double a1, double a2, double a3) {
		this.a1 = a1;
		this.a2 = a2;
		this.a3 = a3;
	}

	public Vec3D cross(Vec3D vec) {
		return new Vec3D(a2 * vec.getA3() - a3 * vec.getA2(), a3 * vec.getA1() - a1 * vec.getA3(),
				a1 * vec.getA2() - a2 * vec.getA1());
	}
	
	@Override
	public String toString(){
		//ignore the Locale.CANADA it is to make android LINT checker happy
		return String.format(Locale.CANADA,"<%.3f, %.3f, %.3f>", a1, a2, a3);
	}

	public double getA1() {
		return a1;
	}

	public void setA1(double a1) {
		this.a1 = a1;
	}

	public double getA2() {
		return a2;
	}

	public void setA2(double a2) {
		this.a2 = a2;
	}

	public double getA3() {
		return a3;
	}

	public void setA3(double a3) {
		this.a3 = a3;
	}

}
