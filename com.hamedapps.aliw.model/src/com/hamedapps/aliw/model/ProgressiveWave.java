/**
 * 
 */
package com.hamedapps.aliw.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hamed Mohammadi
 *
 */
public class ProgressiveWave {
	private double t, d, h, l, k, s;
	
	public ProgressiveWave() {
		
	}

	public ProgressiveWave(double t, double d, double h) {
		this.t = t;
		this.d = d;
		this.h = h;
		
		update();
	}
	
	private void update() {
		computeS();
		computeK();
		computeL();
	}
	
	public List<Etta> computeEttas(double x1, double x2, double t, int numOfPoints) {
		List<Etta> ettas = new ArrayList<>();
		double dx = Math.abs(x2-x1)/numOfPoints;
		System.out.println("dx = " + dx);
		double x = x1;
		for (int i = 0; i < numOfPoints; i++) {
			double z = (h/2.0)*Math.cos(k*x - s*t);
			Etta etta = new Etta(x, z);
			ettas.add(etta);
			x+=dx;
		}
		return ettas;
	}
	
	/**
	 * 
	 */
	private void computeL() {
		l = (2*Math.PI)/k;
	}

	/**
	 * 
	 */
	private void computeK() {
		k = solveDispersionEquation();		
	}

	/**
	 * @return
	 */
	private double solveDispersionEquation() {
		double kh = 0;
		double y = Math.pow(s, 2)*d/9.81;
		double kh_i = (Math.pow(s, 2)*d)/(9.81*Math.sqrt(Math.tanh(y)));
		System.out.println("kh_i = " + kh_i);
		
		boolean next = true;
		while (next) {
			double f_kh = y/kh_i - Math.tanh(kh_i);
			double fp_kh = -y/Math.pow(kh_i, 2) - Math.pow(1.0/Math.cosh(kh_i), 2);
			kh = kh_i - f_kh/fp_kh;
			System.out.println("kh = " + kh);
			if(Math.abs(kh-kh_i)<0.0000000000001)
				next = false;
			kh_i=kh;
		}
		k=kh/d;
		return k;
	}

	/**
	 * 
	 */
	private void computeS() {
		s = (2*Math.PI)/t;
	}

	/**
	 * @return the t
	 */
	public double getT() {
		return t;
	}

	/**
	 * @param t the t to set
	 */
	public void setT(double t) {
		this.t = t;
	}

	/**
	 * @return the d
	 */
	public double getD() {
		return d;
	}

	/**
	 * @param d the d to set
	 */
	public void setD(double d) {
		this.d = d;
	}

	/**
	 * @return the h
	 */
	public double getH() {
		return h;
	}

	/**
	 * @param h the h to set
	 */
	public void setH(double h) {
		this.h = h;
	}

	/**
	 * @return the l
	 */
	public double getL() {
		return l;
	}

	/**
	 * @param l the l to set
	 */
	public void setL(double l) {
		this.l = l;
	}

	/**
	 * @return the k
	 */
	public double getK() {
		return k;
	}

	/**
	 * @param k the k to set
	 */
	public void setK(double k) {
		this.k = k;
	}

	/**
	 * @return the s
	 */
	public double getS() {
		return s;
	}

	/**
	 * @param s the s to set
	 */
	public void setS(double s) {
		this.s = s;
	}

}
