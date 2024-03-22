import java.util.*;

class Mahasiswa {
    String nim;
    String nama;
    Map<String, Integer> nilaiAngkaMap;

    public Mahasiswa() {
        nilaiAngkaMap = new HashMap<>();
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public void tambahNilai(String kode, int nilaiAngka) {
        nilaiAngkaMap.put(kode, nilaiAngka);
    }

    public Map<String, Integer> getNilaiAngkaMap() {
        return nilaiAngkaMap;
    }
}

class MataKuliah {
    String kode;
    String nama;

    public void setKode(String kode) {
        this.kode = kode;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input data Mahasiswa
        Mahasiswa mahasiswa = new Mahasiswa();
        System.out.println("Menyimpan KHS");
        System.out.println("Mahasiswa");

        System.out.println("\nMasukkan NIM Mahasiswa:");
        mahasiswa.setNim(scanner.nextLine());
        System.out.println("Masukkan Nama Mahasiswa:");
        mahasiswa.setNama(scanner.nextLine());

        // Loop untuk mengisi Mata Kuliah
        List<MataKuliah> mataKuliahs = new ArrayList<>();
        while (true) {
            MataKuliah mataKuliah = new MataKuliah();
            System.out.println("\nMasukkan Kode MataKuliah:");
            mataKuliah.setKode(scanner.nextLine());
            System.out.println("Masukkan Nama MataKuliah:");
            mataKuliah.setNama(scanner.nextLine());
            mataKuliahs.add(mataKuliah);

            System.out.println("\nApakah Anda ingin menambahkan Mata Kuliah lagi? (yes/no)");
            String input = scanner.nextLine();
            if (!input.equalsIgnoreCase("yes")) {
                break;
            }
        }

        // Input nilai angka Mata Kuliah
        for (MataKuliah mataKuliah : mataKuliahs) {
            System.out.println("\nMasukkan Nilai Angka Mata Kuliah " + mataKuliah.getNama() + ":");
            int nilaiAngka = Integer.parseInt(scanner.nextLine());
            mahasiswa.tambahNilai(mataKuliah.getKode(), nilaiAngka);
        }

        scanner.close();

        // Mencetak KHS
        System.out.println("\nKHS Mahasiswa");
        System.out.println("NIM: " + mahasiswa.getNim());
        System.out.println("Nama: " + mahasiswa.getNama());
        System.out.println("Mata Kuliah:");
        for (MataKuliah mataKuliah : mataKuliahs) {
            System.out.println("Kode: " + mataKuliah.getKode());
            System.out.println("Nama: " + mataKuliah.getNama());
            int nilaiAngka = mahasiswa.getNilaiAngkaMap().get(mataKuliah.getKode());
            String nilaiHuruf = konversiNilaiAngkaKeHuruf(nilaiAngka);
            System.out.println("Nilai Huruf: " + nilaiHuruf);
            System.out.println();
        }
    }

    public static String konversiNilaiAngkaKeHuruf(int nilaiAngka) {
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
