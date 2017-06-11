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
public class KebutuhanNutrisi {

         String bahan_pakan;
         double BK, PK, TDN, Ca, P, kemampuan_konsumsi, pbbh;
         int harga;

         public double getPbbh() {
                  return pbbh;
         }

         public void setPbbh(double pbbh) {
                  this.pbbh = pbbh;
         }

         public double getKemampuan_konsumsi() {
                  return kemampuan_konsumsi;
         }

         public void setKemampuan_konsumsi(double kemampuan_konsumsi) {
                  this.kemampuan_konsumsi = kemampuan_konsumsi;
         }

         public String getBahan_pakan() {
                  return bahan_pakan;
         }

         public void setBahan_pakan(String bahan_pakan) {
                  this.bahan_pakan = bahan_pakan;
         }

         public Double getBK() {
                  return BK;
         }

         public void setBK(Double BK) {
                  this.BK = BK;
         }

         public Double getPK() {
                  return PK;
         }

         public void setPK(Double PK) {
                  this.PK = PK;
         }

         public Double getTDN() {
                  return TDN;
         }

         public void setTDN(Double TDN) {
                  this.TDN = TDN;
         }

         public Double getCa() {
                  return Ca;
         }

         public void setCa(Double Ca) {
                  this.Ca = Ca;
         }

         public Double getP() {
                  return P;
         }

         public void setP(Double P) {
                  this.P = P;
         }

         public int getHarga() {
                  return harga;
         }

         public void setHarga(int harga) {
                  this.harga = harga;
         }

}
