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
//import java.sql.ResultSet;
//import java.sql.Statement;
import java.util.Random;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//import java.util.Arrays;

public class AlgoritmaGenetika extends PakanSapi {

//    private static final PakanSapi ps = new PakanSapi();
    DecimalFormat df = new DecimalFormat(".##");
    DecimalFormat dp = new DecimalFormat(".########");
    Random random = new Random();
    double kromosomTemp[] = new double[4];
    double kromosom_total[][];
    double Kromosom[][], OffspringC[][], OffspringM[][], maksimal_pakan;
    int harga[];
    int popsize, jum_gen, bb, max_rand_value = 50;
    double cr, mr, ketersediaan_nutrisi_pakan[][], penalty[], fitness[], Randmax, Randmin, alphaMax, alphaMin, pbb;
    int hargatot[];
    double kebutuhan_nutrisi_pakan[] = new double[6];
    String Pakan1, Pakan2, Pakan3, Pakan4, jenis_sapi;

    List<KebutuhanNutrisi> data_pakan = new ArrayList<>();
    List<KebutuhanNutrisi> kebutuhan_pakan = new ArrayList<>();
    int x = 0;
    int g;

    @Override
    public void setPbb(double pbb) {
	this.pbb = pbb;
    }

    @Override
    public double getPbb() {
	return pbb;
    }

    public double getRandmax() {
	return Randmax;
    }

    public void setRandmax(double Randmax) {
	this.Randmax = Randmax;
    }

    public double getRandmin() {
	return Randmin;
    }

    public void setRandmin(double Randmin) {
	this.Randmin = Randmin;
    }

    public double getAlphaMax() {
	return alphaMax;
    }

    public void setAlphaMax(double alphaMax) {
	this.alphaMax = alphaMax;
    }

    public double getAlphaMin() {
	return alphaMin;
    }

    public void setAlphaMin(double alphaMin) {
	this.alphaMin = alphaMin;
    }

    public int getPopsize() {
	return popsize;

    }

    public void setPopsize(int popsize) {
	this.popsize = popsize;
    }

    public int getJum_gen() {
	return jum_gen;
    }

    public void setJum_gen(int jum_gen) {
	this.jum_gen = jum_gen;
    }

    public double getCr() {
	return cr;
    }

    public void setCr(double cr) {
	this.cr = cr;
    }

    public double getMr() {
	return mr;
    }

    public void setMr(double mr) {
	this.mr = mr;
    }

    //berfungsi untuk mengambil daftar harga dari database
    private void ambilHarga(String pkn1, String pkn2, String pkn3, String pkn4) {
	data_pakan.clear();//mengosongkan list
	data_pakan = tampil(pkn1, pkn2, pkn3, pkn4);//mengambil data pakan dalam database secara keseluruhan menggunakan method tampil
	harga = new int[data_pakan.size()];//membuat array 'harga' dengan jumlah baris = jumlah baris data pakan yg didapatkan dari database
	for (x = 0; x < data_pakan.size(); x++) {
	    harga[x] = data_pakan.get(x).getHarga();//memindahkan data harga dari list kedalam array 'harga'
	}
    }

    private double[][] ambilNutrisiPakan(String pkn1, String pkn2, String pkn3, String pkn4) {
	data_pakan.clear();
	data_pakan = tampil(pkn1, pkn2, pkn3, pkn4);//invoke method tampil untuk mengambil data pakan dari database berdasarkan parameter
	ketersediaan_nutrisi_pakan = new double[data_pakan.size()][5];// membuat array dua dimensi dengan banyak baris x kolom = jumlah data pakan x 5
	for (x = 0; x < data_pakan.size(); x++) {
	    ketersediaan_nutrisi_pakan[x][0] = data_pakan.get(x).getBK();//menyimpan nutrisi bk ke array baru di kolom 1
	    ketersediaan_nutrisi_pakan[x][1] = data_pakan.get(x).getPK();//menyimpan nutrisi pk ke array baru di kolom 2
	    ketersediaan_nutrisi_pakan[x][2] = data_pakan.get(x).getTDN();//menyimpan nutrisi TDN ke array baru di kolom 3
	    ketersediaan_nutrisi_pakan[x][3] = data_pakan.get(x).getCa();//menyimpan nutrisi Ca ke array baru di kolom 4
	    ketersediaan_nutrisi_pakan[x][4] = data_pakan.get(x).getP();//menyimpan nutrisi P ke array baru di kolom 5

	}
//        System.out.println("Ketersediaan Nutrisi Pakan");
//        for (int i = 0; i < ketersediaan_nutrisi_pakan.length; i++) {
//            for (int j = 0; j < 5; j++) {
//                System.out.print(ketersediaan_nutrisi_pakan[i][j] + " ");
//            }
//            System.out.println();
//        }
	return ketersediaan_nutrisi_pakan;
    }

    private void ambilKebutuhan(double pbb) {
	kebutuhan_pakan.clear();
	kebutuhan_pakan = tampilKebutuhan(bb, pbb, jenis_sapi);
	for (x = 0; x < kebutuhan_pakan.size(); x++) {
	    kebutuhan_nutrisi_pakan[0] = kebutuhan_pakan.get(x).getBK();
	    kebutuhan_nutrisi_pakan[1] = kebutuhan_pakan.get(x).getPK();
	    kebutuhan_nutrisi_pakan[2] = kebutuhan_pakan.get(x).getTDN();
	    kebutuhan_nutrisi_pakan[3] = kebutuhan_pakan.get(x).getCa();
	    kebutuhan_nutrisi_pakan[4] = kebutuhan_pakan.get(x).getP();
	    kebutuhan_nutrisi_pakan[5] = kebutuhan_pakan.get(x).getKemampuan_konsumsi();
	}
	System.out.println("Kebutuhan Nutrisi yang harus dipenuhi");
	for (int i = 0; i < kebutuhan_nutrisi_pakan.length; i++) { //menampilkan kebutuhan nutrisi
	    System.out.println(kebutuhan_nutrisi_pakan[i] + " ");;

	}
    }

    private void inisialisasi(int BB) {
	ambilHarga(Pakan1, Pakan2, Pakan3, Pakan4);
	this.bb = BB;
	Kromosom = new double[getPopsize()][4];
	kromosom_total = new double[getJum_gen() * getPopsize()][7];
	g = 0;
	double[][] kromosom = new double[getPopsize()][4];
	ambilKebutuhan(getPbb());
	double minimalPakan = kebutuhan_nutrisi_pakan[5] / 100 * bb;
	System.out.println("Inisialisasi Awal");
	for (int i = 0; i < getPopsize(); i++) {
	    for (int j = 0; j < harga.length; j++) {
		kromosomTemp[j] = (random.nextInt(10) + 1);
	    }
//            if (total_kromosom < minimalPakan) {
//                for (int j = 0; j < harga.length; j++) {
////                    System.out.println(harga[j]);
//                    kromosom[i][j] = ((kromosomTemp[j] / total_kromosom) * minimalPakan);
//                }
//            } else {
	    for (int j = 0; j < harga.length; j++) {
		kromosom[i][j] = kromosomTemp[j];
		kromosom[i][j] = Double.valueOf(df.format(kromosom[i][j]));
	    }

//            }
	}

	for (int l = 0; l < kromosom.length; l++) {
	    for (int m = 0; m < harga.length; m++) {
		this.Kromosom[l][m] = kromosom[l][m];
		System.out.print(Kromosom[l][m] + " ");
	    }
//            System.out.println(hargatot[l]);
	    System.out.println();
	}
	normalisasi(Kromosom);
	System.out.println("kromosom setelah normalisasi");
	for (int l = 0; l < kromosom.length; l++) {
	    for (int m = 0; m < harga.length; m++) {
		System.out.print(Kromosom[l][m] + " ");
	    }
//            System.out.println(hargatot[l]);
	    System.out.println();
	}
    }

    private void normalisasi(double kromosom[][]) {
	double total_pakan;
	double total_hijauan;
	double total_konsentrat;
	for (int i = 0; i < kromosom.length; i++) {
	    total_pakan = kromosom[i][0] + kromosom[i][1] + kromosom[i][2] + kromosom[i][3];//menjumlahkan semua value dari kromosom untuk mengetahui total bobot pakan yg digunakan
	    total_konsentrat = kromosom[i][1] + kromosom[i][2] + kromosom[i][3];//menjumlah kan value kromosom untuk menyatakan jumlah total bobot pakan konsentrat
//            if (total_kromosom > kebutuhan_nutrisi_pakan[5] / 100 * bb) {
	    for (int j = 0; j < 4; j++) {
		if (j < 1) {
		    kromosom[i][j] = (kromosom[i][j] / (kromosom[i][0])) * (total_pakan * 60 / 100);// normalisasi pakan hijauan pada gen yang pertama
		} else if (j > 0) {
		    kromosom[i][j] = (kromosom[i][j] / (total_konsentrat)) * (total_pakan * 40 / 100);// normalisasi pakan konsentrat pada gen yang kedua,ketiga dan keempat
		}
//                else {
//                    kromosom[i][j] = kromosom[i][j] / (total_pakan * 40 / 100);
//
//                }
	    }
//            }

	}
    }

    private double Max(double kromosom[][], double offspringC[][], int gen) {
	int panjangkromosom = kromosom.length + offspringC.length;
	double kromosomTemporary[] = new double[panjangkromosom];
	for (int i = 0; i < kromosom.length; i++) {
	    kromosomTemporary[i] = kromosom[i][gen];
	}
	for (int i = 0; i < offspringC.length; i++) {
	    kromosomTemporary[kromosom.length + i] = offspringC[i][gen];
	}
	double max = 0;
	for (int i = 0; i < kromosomTemporary.length; i++) {
	    if (kromosomTemporary[i] > max) {
		max = kromosomTemporary[i];
	    }
	}
	return max;
    }

    private double Min(double kromosom[][], double offspringC[][], int gen) {
	int panjangkromosom = kromosom.length + offspringC.length;
	double kromosomTemporary[] = new double[panjangkromosom];
	for (int i = 0; i < kromosom.length; i++) {
	    kromosomTemporary[i] = kromosom[i][gen];
	}
	for (int i = 0; i < offspringC.length; i++) {
	    kromosomTemporary[kromosom.length + i] = offspringC[i][gen];
	}
	double min = 100;
	for (int i = 0; i < kromosomTemporary.length; i++) {
	    if (kromosomTemporary[i] < min) {
		min = kromosomTemporary[i];
	    }
	}
	return min;
    }

    public void Reproduksi() {
	double min = 0, max = 0;
	int offspringCrossover;
	int offspringMutasi;
	int random_cr[];
	int random_mr[];
	offspringCrossover = (int) Math.round(getCr() * popsize);
	if (offspringCrossover % 2 != 0) {
	    offspringCrossover = offspringCrossover + 1;
	}
	offspringMutasi = (int) Math.round(getMr() * popsize);

	random_cr = new int[offspringCrossover];
	random_mr = new int[offspringMutasi];

	ArrayList<Integer> acak = new ArrayList<>();

	for (int i = 1; i <= popsize; i++) {
	    acak.add(i);

	}
	Collections.shuffle(acak);
	System.out.print("Parent terpilih untuk crossover  : ");
	for (int i = 0; i < offspringCrossover; i++) {
	    random_cr[i] = acak.get(i);
	    System.out.print(random_cr[i] + " ");
	}
	System.out.println("");
	System.out.print("Parent terpilih untuk mutasi : ");
	for (int i = 0; i < offspringMutasi; i++) {
	    random_mr[i] = acak.get((popsize - i) - 1);
	    System.out.println(random_mr[i] + " ");

	}
	//proses crossover
	OffspringC = new double[offspringCrossover][4];
	double minAlpha = getAlphaMin();
	double maxAlpha = getAlphaMax();
	double nilaiAlpha[] = new double[harga.length];
	System.out.println("Nilai alpha :");
	for (int i = 0; i < harga.length; i++) {
	    double acak2 = random.nextInt(max_rand_value);
	    nilaiAlpha[i] = minAlpha + acak2 / max_rand_value * (maxAlpha - minAlpha);
	    System.out.println(nilaiAlpha[i]);
	}
//        int alpha;
	int last = random_cr.length - 1;
	int start = 0;
	while (start < last) {
	    int kromosom_atas;
	    int kromosom_bawah;
	    kromosom_atas = random_cr[start] - 1;
	    kromosom_bawah = random_cr[last] - 1;
	    for (int i = 0; i < nilaiAlpha.length; i++) {
		OffspringC[start][i] = Kromosom[kromosom_atas][i] + nilaiAlpha[i] * (Kromosom[kromosom_bawah][i] - Kromosom[kromosom_atas][i]);
		OffspringC[last][i] = Kromosom[kromosom_bawah][i] + nilaiAlpha[i] * (Kromosom[kromosom_atas][i] - Kromosom[kromosom_bawah][i]);
//                OffspringC[start][i] = Double.valueOf(df.format(OffspringC[start][i]));
//                OffspringC[last][i] = Double.valueOf(df.format(OffspringC[last][i]));

	    }
	    last--;
	    start++;
	}
	System.out.println("Hasil Crossover sebelum Normalisasi");
	for (int i = 0; i < OffspringC.length; i++) {
	    for (int j = 0; j < nilaiAlpha.length; j++) {
		System.out.print(OffspringC[i][j] + " ");
	    }
	    System.out.println();
	}
	normalisasi(OffspringC);
	System.out.println("Hasil Crossover Setelah Normalisasi");
	for (int i = 0; i < OffspringC.length; i++) {
	    for (int j = 0; j < nilaiAlpha.length; j++) {
		System.out.print(OffspringC[i][j] + " ");
	    }
	    System.out.println();
	}

	//proses mutasi
	OffspringM = new double[offspringMutasi][harga.length];
	int chooseGen;
	int mulai = 0;
	double minRand = getRandmin();
	double maxRand = getRandmax();
	double acak3 = random.nextInt(max_rand_value);
	double nilaiRand = minRand + acak3 / max_rand_value * (maxRand - minRand);
	System.out.println("nilai r");
	System.out.println(nilaiRand);
	while (mulai < offspringMutasi) {
	    int kromosom_mutation = random_mr[mulai] - 1;
	    for (int i = 0; i < harga.length; i++) {
		OffspringM[mulai][i] = Kromosom[kromosom_mutation][i];
	    }
	    chooseGen = random.nextInt(harga.length);
//            chooseGen = chooseGen - 1;
	    max = Max(Kromosom, OffspringC, chooseGen);
	    min = Min(Kromosom, OffspringC, chooseGen);
	    System.out.println("Gen terpilih  : " + chooseGen);
	    System.out.println("Nilai Max Gen : " + max);
	    System.out.println("Nilai Min Gen : " + min);
	    OffspringM[mulai][chooseGen] = OffspringM[mulai][chooseGen] + (nilaiRand * (max - min));
	    mulai++;
	}
	System.out.println("Hasil Mutasi sebelum Normalisasi");
	for (int i = 0; i < OffspringM.length; i++) {
	    for (int j = 0; j < harga.length; j++) {
		System.out.print(OffspringM[i][j] + " ");
	    }
	    System.out.println();
	}
	normalisasi(OffspringM);
	System.out.println("Hasil Mutasi Setelah Normalisasi");
	for (int i = 0; i < OffspringM.length; i++) {
	    for (int j = 0; j < harga.length; j++) {
		System.out.print(OffspringM[i][j] + " ");
	    }
	    System.out.println();
	}
	int index_c = 0;//index crossover
	int index_m = 0;//index mutasi
	int kl = Kromosom.length;

	int jumlah_tot_kromosom = kl + offspringCrossover + offspringMutasi;
	double kromosombaru[][] = new double[jumlah_tot_kromosom][4];
	for (int i = 0; i < jumlah_tot_kromosom; i++) {
	    if (i >= kl && i < (kl + offspringCrossover)) {
		for (int j = 0; j < harga.length; j++) {
		    if (OffspringC[index_c][j] <= 0) {
			OffspringC[index_c][j] = Math.abs(OffspringC[index_c][j]);
		    }
		    kromosombaru[i][j] = OffspringC[index_c][j];
		}
		index_c++;

	    } else if (i >= kl && i >= (kl + offspringCrossover)) {
		for (int j = 0; j < harga.length; j++) {
		    if (OffspringM[index_m][j] <= 0) {
			OffspringM[index_m][j] = Math.abs(OffspringM[index_m][j]);
		    }
		    kromosombaru[i][j] = OffspringM[index_m][j];
		}
		index_m++;

	    } else if (i < kl) {
		for (int j = 0; j < 4; j++) {
		    kromosombaru[i][j] = Kromosom[i][j];
		}
	    }
	}
	System.out.println("kromosom baru(parent+child)");
	for (int i = 0; i < kromosombaru.length; i++) {
	    for (int j = 0; j < harga.length; j++) {
		System.out.print(kromosombaru[i][j] + " ");;
	    }
	    System.out.println();
	}
	hitungPenalti(kromosombaru.length, kromosombaru);
	System.out.println("mengurutkan elitism");
	seleksi(kromosombaru);
//            
//            for (int i = 0; i < 6; i++) {
//                double[] kromosombaru1 = kromosombaru[i];
//                
//            }
//        }

    }

//    public void hitungPenalti(double pbb) {
//        double[] totalNutrisiBK = new double[getPopsize()];
//        double[] totalNutrisiPK = new double[getPopsize()];
//        double[] totalNutrisiTDN = new double[getPopsize()];
//        double[] totalNutrisiCa = new double[getPopsize()];
//        double[] totalNutrisiP = new double[getPopsize()];
//        penalty = new double[getPopsize()];
//        fitness = new double[getPopsize()];
//        ambilKebutuhan(pbb);
//        System.out.println("Menghitung Penalti");
//        for (int i = 0; i < Kromosom.length; i++) {
//            penalty[i] = 0;
//            for (int j = 0; j < ketersediaan_nutrisi_pakan.length; j++) {
//                totalNutrisiBK[i] += (Kromosom[i][j] * ketersediaan_nutrisi_pakan[j][0] / 100);
//                totalNutrisiPK[i] += (Kromosom[i][j] * ketersediaan_nutrisi_pakan[j][1] / 100) * 1000;
//                totalNutrisiTDN[i] += (Kromosom[i][j] * ketersediaan_nutrisi_pakan[j][2] / 100);
//                totalNutrisiCa[i] += (Kromosom[i][j] * ketersediaan_nutrisi_pakan[j][3] / 100) * 1000;
//                totalNutrisiP[i] += (Kromosom[i][j] * ketersediaan_nutrisi_pakan[j][4] / 100) * 1000;
//            }
//            totalNutrisiBK[i] = Double.valueOf(df.format(totalNutrisiBK[i]));
//            totalNutrisiPK[i] = Double.valueOf(df.format(totalNutrisiPK[i]));
//            totalNutrisiTDN[i] = Double.valueOf(df.format(totalNutrisiTDN[i]));
//            totalNutrisiCa[i] = Double.valueOf(df.format(totalNutrisiCa[i]));
//            totalNutrisiP[i] = Double.valueOf(df.format(totalNutrisiP[i]));
//
//            if (totalNutrisiBK[i] < kebutuhan_nutrisi_pakan[0]) {
//                penalty[i] = kebutuhan_nutrisi_pakan[0] - totalNutrisiBK[i];
//            }
//            if (totalNutrisiPK[i] < kebutuhan_nutrisi_pakan[1]) {
//                penalty[i] += kebutuhan_nutrisi_pakan[1] - totalNutrisiPK[i];
//            }
//            if (totalNutrisiTDN[i] < kebutuhan_nutrisi_pakan[2]) {
//                penalty[i] += kebutuhan_nutrisi_pakan[2] - totalNutrisiTDN[i];
//            }
//            if (totalNutrisiCa[i] < kebutuhan_nutrisi_pakan[3]) {
//                penalty[i] += kebutuhan_nutrisi_pakan[3] - totalNutrisiCa[i];
//            }
//            if (totalNutrisiP[i] < kebutuhan_nutrisi_pakan[4]) {
//                penalty[i] += kebutuhan_nutrisi_pakan[4] - totalNutrisiP[i];
//            }
//            penalty[i] = Double.valueOf(dp.format(penalty[i])); //angka dibelakang koma agar sebanyak 3 angka
//            System.out.println(totalNutrisiBK[i] + " " + totalNutrisiPK[i] + " " + totalNutrisiTDN[i] + " " + totalNutrisiCa[i] + " " + totalNutrisiP[i] + " " + hargatot[i] + " " + penalty[i]);
//
//        }
//        for (int j = 0; j < penalty.length; j++) {
//            fitness[j] = hitungFitness(penalty[j], hargatot[j]);
//            fitness[j] = Double.valueOf(dp.format(fitness[j]));
//            System.out.println(fitness[j]);
//        }
//    }
    public void hitungPenalti(int jumlah_kromosom, double[][] kromosom) {
	double total_pakan_hijauan;
	double total_pakan_konsentrat;
	maksimal_pakan = bb * (kebutuhan_nutrisi_pakan[5] / 100);
	double minimum_konsentrat;
	double minimum_hijauan;
	double nutrisi_BK;
	double[] totalNutrisiBK = new double[jumlah_kromosom];
	double[] totalNutrisiPK = new double[jumlah_kromosom];
	double[] totalNutrisiTDN = new double[jumlah_kromosom];
	double[] totalNutrisiCa = new double[jumlah_kromosom];
	double[] totalNutrisiP = new double[jumlah_kromosom];
	double[] totalKemampuanKonsumsi = new double[jumlah_kromosom];
	penalty = new double[jumlah_kromosom];
	fitness = new double[jumlah_kromosom];
	hargatot = new int[jumlah_kromosom];
	double total_kromosom;
	System.out.println("Menghitung fitness");
	//hitung harga total
	for (int j = 0; j < kromosom.length; j++) {
	    for (int k = 0; k < harga.length; k++) {
		hargatot[j] += kromosom[j][k] * harga[k];
	    }
	}
	for (int i = 0; i < kromosom.length; i++) {
	    total_kromosom = 0;
	    total_pakan_hijauan = 0;
	    total_pakan_konsentrat = 0;
//            total_pakan_hijauan = kromosom[i][0];
//            total_pakan_konsentrat = kromosom[i][1] + kromosom[i][2] + kromosom[i][3];
	    minimum_hijauan = maksimal_pakan * 0.6;
	    minimum_konsentrat = maksimal_pakan * 0.4;
	    penalty[i] = 0;
	    for (int j = 0; j < ketersediaan_nutrisi_pakan.length; j++) {
		nutrisi_BK = kromosom[i][j] * (ketersediaan_nutrisi_pakan[j][0] / 100);
		if (j == 0) {
		    total_pakan_hijauan = kromosom[i][j] * (ketersediaan_nutrisi_pakan[j][0] / 100);
		} else {
		    total_pakan_konsentrat += kromosom[i][j] * (ketersediaan_nutrisi_pakan[j][0] / 100);

		}
//                System.out.println(kromosom[i][j]);
//                System.out.println(nutrisi_BK);
//                System.out.println(ketersediaan_nutrisi_pakan[j][0]);
		totalNutrisiBK[i] += nutrisi_BK;
//                System.out.println(totalNutrisiBK[i]);
		totalNutrisiPK[i] += (nutrisi_BK * ketersediaan_nutrisi_pakan[j][1] / 100) * 1000;
		totalNutrisiTDN[i] += (nutrisi_BK * ketersediaan_nutrisi_pakan[j][2] / 100);
		totalNutrisiCa[i] += (nutrisi_BK * ketersediaan_nutrisi_pakan[j][3] / 100) * 1000;
		totalNutrisiP[i] += (nutrisi_BK * ketersediaan_nutrisi_pakan[j][4] / 100) * 1000;
//                totalNutrisiBK[i] += (kromosom[i][j] * ketersediaan_nutrisi_pakan[j][0] / 100);
//                totalNutrisiPK[i] += (kromosom[i][j] * ketersediaan_nutrisi_pakan[j][1] / 100) * 1000;
//                totalNutrisiTDN[i] += (kromosom[i][j] * ketersediaan_nutrisi_pakan[j][2] / 100);
//                totalNutrisiCa[i] += (kromosom[i][j] * ketersediaan_nutrisi_pakan[j][3] / 100) * 1000;
//                totalNutrisiP[i] += (kromosom[i][j] * ketersediaan_nutrisi_pakan[j][4] / 100) * 1000;
	    }
//            total_pakan_hijauan = kromosom[i][0] * (ketersediaan_nutrisi_pakan[0][0] / 100);
//            for (int j = 0; j < ketersediaan_nutrisi_pakan.length; j++) {
//                total_pakan_konsentrat += kromosom[i][j] * (ketersediaan_nutrisi_pakan[j][0] / 100);
//
//            }
//            totalNutrisiBK[i] = Double.valueOf(df.format(totalNutrisiBK[i]));
//            totalNutrisiPK[i] = Double.valueOf(df.format(totalNutrisiPK[i]));
//            totalNutrisiTDN[i] = Double.valueOf(df.format(totalNutrisiTDN[i]));
//            totalNutrisiCa[i] = Double.valueOf(df.format(totalNutrisiCa[i]));
//            totalNutrisiP[i] = Double.valueOf(df.format(totalNutrisiP[i]));

	    if (getPbb() != 0) {
		if (totalNutrisiBK[i] < maksimal_pakan) {
		    penalty[i] = maksimal_pakan - totalNutrisiBK[i];
		}
	    } else if (getPbb() == 0) {
		if (totalNutrisiBK[i] < kebutuhan_nutrisi_pakan[0]) {
		    penalty[i] = kebutuhan_nutrisi_pakan[0] - totalNutrisiBK[i];
		}
	    }
	    if (totalNutrisiPK[i] < kebutuhan_nutrisi_pakan[1]) {
		penalty[i] += kebutuhan_nutrisi_pakan[1] - totalNutrisiPK[i];
	    }
	    if (totalNutrisiTDN[i] < kebutuhan_nutrisi_pakan[2]) {
		penalty[i] += kebutuhan_nutrisi_pakan[2] - totalNutrisiTDN[i];
	    }
	    if (totalNutrisiCa[i] < kebutuhan_nutrisi_pakan[3]) {
		penalty[i] += kebutuhan_nutrisi_pakan[3] - totalNutrisiCa[i];
	    }
	    if (totalNutrisiP[i] < kebutuhan_nutrisi_pakan[4]) {
		penalty[i] += kebutuhan_nutrisi_pakan[4] - totalNutrisiP[i];
	    }
	    if (total_pakan_hijauan < minimum_hijauan) {
		penalty[i] += minimum_hijauan - total_pakan_hijauan;
	    }
	    if (total_pakan_konsentrat < minimum_konsentrat) {
		penalty[i] += minimum_konsentrat - total_pakan_konsentrat;
	    }
	    fitness[i] = hitungFitness(penalty[i], hargatot[i]);
	    fitness[i] = Double.valueOf(dp.format(fitness[i]));
//            }
	    penalty[i] = Double.valueOf(dp.format(penalty[i])); //angka dibelakang koma agar sebanyak 3 angka
	    System.out.println(totalNutrisiBK[i] + " " + totalNutrisiPK[i] + " " + totalNutrisiTDN[i] + " " + totalNutrisiCa[i] + " " + totalNutrisiP[i] + " " + total_pakan_hijauan + " " + total_pakan_konsentrat + " " + +hargatot[i] + " " + penalty[i] + " " + fitness[i]);
	}
    }

    public Object hitungPenalti(double[] kromosom) {
	double total_pakan_hijauan = 0;
	double total_pakan_konsentrat = 0;
	maksimal_pakan = bb * (kebutuhan_nutrisi_pakan[5] / 100);
	double minimum_konsentrat;
	double minimum_hijauan;
	double nutrisi_BK;
	double[] totalNutrisiBK = new double[kromosom.length];
	double[] totalNutrisiPK = new double[kromosom.length];
	double[] totalNutrisiTDN = new double[kromosom.length];
	double[] totalNutrisiCa = new double[kromosom.length];
	double[] totalNutrisiP = new double[kromosom.length];
	double[] totalKemampuanKonsumsi = new double[kromosom.length];
	penalty = new double[kromosom.length];
	fitness = new double[kromosom.length];
	hargatot = new int[kromosom.length];
	//hitung harga total
	for (int k = 0; k < harga.length; k++) {
	    hargatot[k] += kromosom[k] * harga[k];
	}
	for (int i = 0; i < 1; i++) {
//            total_pakan_hijauan = kromosom[i][0];
//            total_pakan_konsentrat = kromosom[i][1] + kromosom[i][2] + kromosom[i][3];
	    minimum_hijauan = maksimal_pakan * 0.6;
	    minimum_konsentrat = maksimal_pakan * 0.4;
	    penalty[i] = 0;
	    for (int j = 0; j < ketersediaan_nutrisi_pakan.length; j++) {
		nutrisi_BK = kromosom[j] * (ketersediaan_nutrisi_pakan[j][0] / 100);
		if (j == 0) {
		    total_pakan_hijauan = kromosom[j] * (ketersediaan_nutrisi_pakan[j][0] / 100);
		} else {
		    total_pakan_konsentrat += kromosom[j] * (ketersediaan_nutrisi_pakan[j][0] / 100);

		}
//                System.out.println(kromosom[i][j]);
//                System.out.println(nutrisi_BK);
//                System.out.println(ketersediaan_nutrisi_pakan[j][0]);
		totalNutrisiBK[i] += nutrisi_BK;
//                System.out.println(totalNutrisiBK[i]);
		totalNutrisiPK[i] += (nutrisi_BK * ketersediaan_nutrisi_pakan[j][1] / 100) * 1000;
		totalNutrisiTDN[i] += (nutrisi_BK * ketersediaan_nutrisi_pakan[j][2] / 100);
		totalNutrisiCa[i] += (nutrisi_BK * ketersediaan_nutrisi_pakan[j][3] / 100) * 1000;
		totalNutrisiP[i] += (nutrisi_BK * ketersediaan_nutrisi_pakan[j][4] / 100) * 1000;
//                totalNutrisiBK[i] += (kromosom[i][j] * ketersediaan_nutrisi_pakan[j][0] / 100);
//                totalNutrisiPK[i] += (kromosom[i][j] * ketersediaan_nutrisi_pakan[j][1] / 100) * 1000;
//                totalNutrisiTDN[i] += (kromosom[i][j] * ketersediaan_nutrisi_pakan[j][2] / 100);
//                totalNutrisiCa[i] += (kromosom[i][j] * ketersediaan_nutrisi_pakan[j][3] / 100) * 1000;
//                totalNutrisiP[i] += (kromosom[i][j] * ketersediaan_nutrisi_pakan[j][4] / 100) * 1000;
	    }
//            total_pakan_hijauan = kromosom[i][0] * (ketersediaan_nutrisi_pakan[0][0] / 100);
//            for (int j = 0; j < ketersediaan_nutrisi_pakan.length; j++) {
//                total_pakan_konsentrat += kromosom[i][j] * (ketersediaan_nutrisi_pakan[j][0] / 100);
//
//            }
//            totalNutrisiBK[i] = Double.valueOf(df.format(totalNutrisiBK[i]));
//            totalNutrisiPK[i] = Double.valueOf(df.format(totalNutrisiPK[i]));
//            totalNutrisiTDN[i] = Double.valueOf(df.format(totalNutrisiTDN[i]));
//            totalNutrisiCa[i] = Double.valueOf(df.format(totalNutrisiCa[i]));
//            totalNutrisiP[i] = Double.valueOf(df.format(totalNutrisiP[i]));

	    if (getPbb() != 0) {
		if (totalNutrisiBK[i] < maksimal_pakan) {
		    penalty[i] = maksimal_pakan - totalNutrisiBK[i];
		}
	    } else if (getPbb() == 0) {
		if (totalNutrisiBK[i] < kebutuhan_nutrisi_pakan[0]) {
		    penalty[i] = kebutuhan_nutrisi_pakan[0] - totalNutrisiBK[i];
		}
	    }
	    if (totalNutrisiPK[i] < kebutuhan_nutrisi_pakan[1]) {
		penalty[i] += kebutuhan_nutrisi_pakan[1] - totalNutrisiPK[i];
	    }
	    if (totalNutrisiTDN[i] < kebutuhan_nutrisi_pakan[2]) {
		penalty[i] += kebutuhan_nutrisi_pakan[2] - totalNutrisiTDN[i];
	    }
	    if (totalNutrisiCa[i] < kebutuhan_nutrisi_pakan[3]) {
		penalty[i] += kebutuhan_nutrisi_pakan[3] - totalNutrisiCa[i];
	    }
	    if (totalNutrisiP[i] < kebutuhan_nutrisi_pakan[4]) {
		penalty[i] += kebutuhan_nutrisi_pakan[4] - totalNutrisiP[i];
	    }
	    if (total_pakan_hijauan < minimum_hijauan) {
		penalty[i] += minimum_hijauan - total_pakan_hijauan;
	    }
	    if (total_pakan_konsentrat < minimum_konsentrat) {
		penalty[i] += minimum_konsentrat - total_pakan_konsentrat;
	    }
	    fitness[i] = hitungFitness(penalty[i], hargatot[i]);
	    fitness[i] = Double.valueOf(dp.format(fitness[i]));
//            }
	    penalty[i] = Double.valueOf(dp.format(penalty[i])); //angka dibelakang koma agar sebanyak 3 angka
	}
	return "Mengandung nutrisi, BK = " + totalNutrisiBK[0] + " Kg, PK = " + totalNutrisiPK[0] + " gram, TDN = " + totalNutrisiTDN[0] + " Kg, Ca =  " + totalNutrisiCa[0] + " gram, P = " + totalNutrisiP[0] + " gram , Berat Hijuan = " + total_pakan_hijauan + " Kg, Berat Konsentrat = " + total_pakan_konsentrat;
    }

    private double hitungFitness(double penalty, int harga) {
	double fitness = 0;
	fitness = 10000 / (harga + (penalty * 100000));
	return fitness;
    }

    private void seleksi(double[][] kromosombaru) {

	double kromosom_urut[][] = new double[kromosombaru.length][7];
	double max[] = new double[7];
	int k;
	int l;
	int m;
	boolean isi;
	for (int i = 0; i < kromosombaru.length; i++) {
	    kromosom_urut[i][0] = kromosombaru[i][0];
	    kromosom_urut[i][1] = kromosombaru[i][1];
	    kromosom_urut[i][2] = kromosombaru[i][2];
	    kromosom_urut[i][3] = kromosombaru[i][3];
	    kromosom_urut[i][4] = hargatot[i];
	    kromosom_urut[i][5] = penalty[i];
	    kromosom_urut[i][6] = fitness[i];
	}
	for (k = 0; k < kromosom_urut.length; k++) {
	    isi = false;
	    int maxKey = 0;
	    for (m = k; m < kromosom_urut.length; m++) {
		if (isi == false || kromosom_urut[m][6] > max[6]) {
		    maxKey = m;
		    max[6] = kromosom_urut[m][6];
		    max[0] = kromosom_urut[m][0];
		    max[1] = kromosom_urut[m][1];
		    max[2] = kromosom_urut[m][2];
		    max[3] = kromosom_urut[m][3];
		    max[4] = kromosom_urut[m][4];
		    max[5] = kromosom_urut[m][5];
		}
		isi = true;
	    }
	    kromosom_urut[maxKey][6] = kromosom_urut[k][6];
	    kromosom_urut[maxKey][0] = kromosom_urut[k][0];
	    kromosom_urut[maxKey][1] = kromosom_urut[k][1];
	    kromosom_urut[maxKey][2] = kromosom_urut[k][2];
	    kromosom_urut[maxKey][3] = kromosom_urut[k][3];
	    kromosom_urut[maxKey][4] = kromosom_urut[k][4];
	    kromosom_urut[maxKey][5] = kromosom_urut[k][5];

	    kromosom_urut[k][6] = max[6];
	    kromosom_urut[k][0] = max[0];
	    kromosom_urut[k][1] = max[1];
	    kromosom_urut[k][2] = max[2];
	    kromosom_urut[k][3] = max[3];
	    kromosom_urut[k][4] = max[4];
	    kromosom_urut[k][5] = max[5];

	}
	for (int i = 0; i < kromosom_urut.length; i++) {
	    for (int j = 0; j < 7; j++) {
		System.out.print(kromosom_urut[i][j] + " ");
	    }
	    System.out.println();
	}
	for (int i = 0; i < Kromosom.length; i++) {
	    for (int j = 0; j < 7; j++) {
		if (j < 4) {
		    Kromosom[i][j] = kromosom_urut[i][j];
		    kromosom_total[g][j] = Kromosom[i][j];
		} else if (j == 4) {
		    hargatot[i] = (int) kromosom_urut[i][j];
		    kromosom_total[g][j] = hargatot[i];
		} else if (j == 5) {
		    penalty[i] = kromosom_urut[i][j];
		    kromosom_total[g][j] = penalty[i];
		} else if (j == 6) {
		    fitness[i] = kromosom_urut[i][j];
		    kromosom_total[g][j] = fitness[i];
		}
	    }
	    g++;
	}

    }

    public List simpanIndividu() {
	double kromosom1, kromosom2, kromosom3, kromosom4, Penalty, Fitness;
	int Harga;
	List k = new ArrayList();
	for (int i = 0; i < kromosom_total.length; i++) {
	    Kromosom kr = new Kromosom();
	    kromosom1 = kromosom_total[i][0];
	    kromosom2 = kromosom_total[i][1];
	    kromosom3 = kromosom_total[i][2];
	    kromosom4 = kromosom_total[i][3];
	    Harga = (int) kromosom_total[i][4];
	    Penalty = kromosom_total[i][5];
	    Fitness = kromosom_total[i][6];
	    kr.setKromosom1(kromosom1);
	    kr.setKromosom2(kromosom2);
	    kr.setKromosom3(kromosom3);
	    kr.setKromosom4(kromosom4);
	    kr.setHarga(Harga);
	    kr.setPenalty(Penalty);
	    kr.setFitness(Fitness);
	    k.add(kr);
	}
	return k;
    }
//      public List simpanIndividu() {
//        double kromosom1, kromosom2, kromosom3, Penalty, Fitness;
//        int Harga;
//        List k = new ArrayList();
//        for (int i = 0; i < Kromosom.length; i++) {
//            Kromosom kr = new Kromosom();
//            kromosom1 = Kromosom[i][0];
//            kromosom2 = Kromosom[i][1];
//            kromosom3 = Kromosom[i][2];
//            kr.setKromosom1(kromosom1);
//            kr.setKromosom2(kromosom2);
//            kr.setKromosom3(kromosom3);
//            kr.setHarga(hargatot[i]);
//            kr.setPenalty(penalty[i]);
//            kr.setFitness(fitness[i]);
//            k.add(kr);
//        }
//        return k;
//    }

    public void generasi(String pkn1, String pkn2, String pkn3, String pkn4, int bb, String jenis_sapi) {
	int i = 0;
	this.Pakan1 = pkn1;
	this.Pakan2 = pkn2;
	this.Pakan3 = pkn3;
	this.Pakan4 = pkn4;
	this.jenis_sapi = jenis_sapi;
	ambilNutrisiPakan(pkn1, pkn2, pkn3, pkn4);
	inisialisasi(bb);
	while (i < getJum_gen()) {
	    Reproduksi();
	    i++;
	}
    }

    public static void main(String[] args) {
	AlgoritmaGenetika ag = new AlgoritmaGenetika();
	PakanSapi ps = new PakanSapi();
	ag.setPopsize(5);
	ag.setJum_gen(1);
	ag.setCr(0.1);
	ag.setPbb(0.5);
	ag.setMr(0.2);
	ag.setAlphaMin(-0.1);
	ag.setAlphaMax(0.1);
	ag.setRandmin(-0.1);
	ag.setRandmax(0.1);
	ag.generasi("Rendeng Kering", "Geplek", "Tetes", "Dedak Halus Padi", 100, "Sapi Dara");

    }
}
