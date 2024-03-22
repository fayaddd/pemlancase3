import java.util.ArrayList;
import java.util.Scanner;

class MataKuliah {
    String kode;
    String namaMK;
    double nilaiAngka;

    public MataKuliah(String kode, String namaMK, double nilaiAngka) {
        this.kode = kode;
        this.namaMK = namaMK;
        this.nilaiAngka = nilaiAngka;
    }
}

class Mahasiswa {
    String nim;
    String nama;
    ArrayList<MataKuliah> mataKuliahList;

    public Mahasiswa(String nim, String nama) {
        this.nim = nim;
        this.nama = nama;
        this.mataKuliahList = new ArrayList<>();
    }

    public void tambahMatkul(String kode, String namaMK, double nilaiAngka) {
        mataKuliahList.add(new MataKuliah(kode, namaMK, nilaiAngka));
    }

    public void cetakKHS() {
        System.out.println("Mahasiswa: " + nim + " - " + nama);
        System.out.println("Kartu Hasil Studi (KHS):");
        for (MataKuliah mk : mataKuliahList) {
            String nilaiHuruf = konversiNilai(mk.nilaiAngka);
            System.out.println("Mata Kuliah: " + mk.kode + " - " + mk.namaMK + ", Nilai Huruf: " + nilaiHuruf);
        }
    }

    private String konversiNilai(double nilaiAngka) {
        if (nilaiAngka >= 80) {
            return "A";
        } else if (nilaiAngka >= 70) {
            return "B";
        } else if (nilaiAngka >= 60) {
            return "C";
        } else if (nilaiAngka >= 50) {
            return "D";
        } else {
            return "E";
        }
    }
}