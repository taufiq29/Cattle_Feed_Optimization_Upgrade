/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optimasipakansapi;

/**
 *
 * @author Muhammad
 */
public class Kromosom {

    int harga;
    double kromosom1, kromosom2, kromosom3, kromosom4;
    double penalty, fitness;

    public double getFitness() {
	return fitness;
    }

    public double getKromosom4() {
	return kromosom4;
    }

    public void setKromosom4(double kromosom4) {
	this.kromosom4 = kromosom4;
    }

    public void setFitness(double fitness) {
	this.fitness = fitness;
    }

    public int getHarga() {
	return harga;
    }

    public double getPenalty() {
	return penalty;
    }

    public void setPenalty(double penalty) {
	this.penalty = penalty;
    }

    public void setHarga(int harga) {
	this.harga = harga;
    }

    public double getKromosom1() {
	return kromosom1;
    }

    public void setKromosom1(double kromosom1) {
	this.kromosom1 = kromosom1;

    }

    public double getKromosom2() {
	return kromosom2;
    }

    public void setKromosom2(double kromosom2) {
	this.kromosom2 = kromosom2;
    }

    public double getKromosom3() {
	return kromosom3;
    }

    public void setKromosom3(double kromosom3) {
	this.kromosom3 = kromosom3;
    }

}
