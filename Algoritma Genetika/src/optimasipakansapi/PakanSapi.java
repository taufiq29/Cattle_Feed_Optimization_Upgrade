/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optimasipakansapi;

import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author noortopik
 */
public class PakanSapi {

    Connection con = null;
    Statement st = null;
    ResultSet[] rs1 = new ResultSet[4];
    ResultSet rs = null;
    String[] sql1 = new String[4];
    String sql = null;

    public double pbb, BK, PK, TDN, Ca, P;
    int kategori, beratbadan;
    String Pakan1, Pakan2, Pakan3;

    public PakanSapi() {
	try {
	    Class.forName("com.mysql.jdbc.Driver");
	    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_sapipotong", "root", "");
	    st = con.createStatement();
	} catch (Exception e) {
	    JOptionPane.showMessageDialog(null, "koneksi gagal");
	}
    }

    //mengeset nilai pbb
    public void setPbb(double pbb) {
	this.pbb = pbb;
    }

    //mendapatkan nilai pbb
    public double getPbb() {
	return pbb;
    }

    //mengeset nilai berat badan dan mengkategorikanya
    public void setBeratBadan(int BB) {
	this.beratbadan = BB;
    }

    public int getBeratBadan() {
	return beratbadan;
    }

    //mendapatkan nilai BK
    public double getBK() {
	return BK;
    }

    //mendapatkan nilai PK
    public double getPK() {
	return PK;
    }

    //mendapatkan nilai TDN
    public double getTDN() {
	return TDN;
    }

    //mendapatkan nilai Ca
    public double getCa() {
	return Ca;
    }

    //mendapatkan nilai P
    public double getP() {
	return P;
    }

    private int berat_badan(int berat_badan, String jenis_sapi) {
	switch (jenis_sapi) {
	    case "Sapi Jantan":
		if (berat_badan <= 150) {
		    berat_badan = 150;
		} else if (berat_badan <= 200) {
		    berat_badan = 200;
		} else if (berat_badan <= 250) {
		    berat_badan = 250;
		} else if (berat_badan <= 300) {
		    berat_badan = 300;
		} else if (berat_badan <= 350) {
		    berat_badan = 350;
		} else if (berat_badan <= 400) {
		    berat_badan = 400;
		} else if (berat_badan <= 450) {
		    berat_badan = 450;
		}
		break;
	    case "Sapi Dara":
		if (berat_badan <= 100) {
		    berat_badan = 100;
		} else if (berat_badan <= 150) {
		    berat_badan = 150;
		} else if (berat_badan <= 200) {
		    berat_badan = 200;
		} else if (berat_badan <= 250) {
		    berat_badan = 250;
		} else if (berat_badan <= 300) {
		    berat_badan = 300;
		}
		break;
	    case "Sapi Menyusui":
		if (berat_badan > 430 && berat_badan <= 450) {
		    berat_badan = 450;
		} else if (berat_badan > 390) {
		    berat_badan = 400;
		} else if (berat_badan > 340) {
		    berat_badan = 350;
		} else if (berat_badan > 290) {
		    berat_badan = 300;
		} else if (berat_badan > 240) {
		    berat_badan = 250;
		}
		break;
	}
	return berat_badan;
    }

    public List daftarpbbh(int berat_badan, String jenis_sapi) {
	List nutrisi = new ArrayList();
	berat_badan = berat_badan(berat_badan, jenis_sapi);
//        if (berat_badan <= 150) {
//            berat_badan = 150;
//        } else if (berat_badan <= 200) {
//            berat_badan = 200;
//        } else if (berat_badan <= 250) {
//            berat_badan = 250;
//        } else if (berat_badan <= 300) {
//            berat_badan = 300;
//        } else if (berat_badan <= 350) {
//            berat_badan = 350;
//        }
	sql = "select pbbh from keb_nutrisi_sapi where jenis_sapi in ('" + jenis_sapi + "')and berat_badan in ('" + berat_badan + "')";
	try {
	    rs = st.executeQuery(sql);
	    while (rs.next()) {
		KebutuhanNutrisi KN = new KebutuhanNutrisi();
		KN.setPbbh(rs.getDouble("pbbh"));
		nutrisi.add(KN);
	    }
	} catch (Exception e) {
	    JOptionPane.showConfirmDialog(null, "Terjadi kesalahan");
	}
	return nutrisi;
    }

    public List tampil(String Pakan1, String Pakan2, String Pakan3, String Pakan4) {
	List nutrisi = new ArrayList();
	String pakan = null;
	for (int i = 0; i < 4; i++) {
	    if (i == 0) {
		pakan = Pakan1;
	    } else if (i == 1) {
		pakan = Pakan2;
	    } else if (i == 2) {
		pakan = Pakan3;
	    } else if (i == 3) {
		pakan = Pakan4;
	    }
	    sql1[i] = "select bahan_pakan,harga,berat_kering,protein_kering,tot_digestible_nut,calsium,fosfor from komposisi_bpakan where bahan_pakan in ('" + pakan + "')";
	}
	try {
	    for (int i = 0; i < sql1.length; i++) {
		rs = st.executeQuery(sql1[i]);
		while (rs.next()) {
		    KebutuhanNutrisi KN = new KebutuhanNutrisi();
		    KN.setBahan_pakan(rs.getString("bahan_pakan"));
		    KN.setHarga(rs.getInt("harga"));
		    KN.setBK(rs.getDouble("berat_kering"));
		    KN.setPK(rs.getDouble("protein_kering"));
		    KN.setTDN(rs.getDouble("tot_digestible_nut"));
		    KN.setCa(rs.getDouble("calsium"));
		    KN.setP(rs.getDouble("fosfor"));
		    nutrisi.add(KN);
		}
	    }
	} catch (Exception e) {
	    JOptionPane.showConfirmDialog(null, "Terjadi kesalahan");
	}
	return nutrisi;
    }

    public List tampilKebutuhan(int berat_badan, double pbb, String jenis_sapi) {
	List kebutuhan = new ArrayList();
	berat_badan = berat_badan(berat_badan, jenis_sapi);
//        switch (jenis_sapi) {
//            case "Sapi Jantan":
//                if (berat_badan <= 150) {
//                    berat_badan = 150;
//                } else if (berat_badan <= 200) {
//                    berat_badan = 200;
//                } else if (berat_badan <= 250) {
//                    berat_badan = 250;
//                } else if (berat_badan <= 300) {
//                    berat_badan = 300;
//                } else if (berat_badan <= 350) {
//                    berat_badan = 350;
//                }
//                break;
//            case "Sapi Dara":
//                if (berat_badan <= 100) {
//                    berat_badan = 100;
//                } else if (berat_badan <= 150) {
//                    berat_badan = 150;
//                } else if (berat_badan <= 200) {
//                    berat_badan = 200;
//                } else if (berat_badan <= 250) {
//                    berat_badan = 250;
//                } else if (berat_badan <= 300) {
//                    berat_badan = 300;
//                }
//                break;
//        }
	sql = "select bk,pk,tdn,ca,p,kemampuan_konsumsi from keb_nutrisi_sapi where jenis_sapi in ('" + jenis_sapi + "') and berat_badan in ('" + berat_badan + "') and pbbh in ('" + pbb + "')";
	try {
	    rs = st.executeQuery(sql);
	    while (rs.next()) {
		KebutuhanNutrisi KN = new KebutuhanNutrisi();
		KN.setBK(rs.getDouble("bk"));
		KN.setPK(rs.getDouble("pk"));
		KN.setTDN(rs.getDouble("tdn"));
		KN.setCa(rs.getDouble("ca"));
		KN.setP(rs.getDouble("p"));
		KN.setKemampuan_konsumsi(rs.getDouble("kemampuan_konsumsi"));
		kebutuhan.add(KN);
	    }
	} catch (Exception e) {
	    JOptionPane.showConfirmDialog(null, "Terjadi kesalahan");
	}
	return kebutuhan;
    }

//    public static void main(String[] args) {
//        PakanSapi ps = new PakanSapi();
//        ps.setKebutuhanNutrisi(150,0);
//        System.out.println(ps.getBK());
//        System.out.println(ps.getPK());
//        System.out.println(ps.getTDN());
//        System.out.println(ps.getCa());
//        System.out.println(ps.getP());
//    }
}
