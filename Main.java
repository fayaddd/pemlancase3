//FAYYADH RADHWA FERDIA
//235150401111058
//PEMLAN CASE 3
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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

        for (MataKuliah mataKuliah : mataKuliahs) {
            System.out.println("\nMasukkan Nilai Angka Mata Kuliah " + mataKuliah.getNama() + ":");
            mahasiswa.tambahNilai(mataKuliah.getKode(), Integer.parseInt(scanner.nextLine()));
        }

        KHS khs = new KHS();
        khs.setMahasiswa(mahasiswa);

        scanner.close();

        System.out.println("\nKHS Mahasiswa");
        System.out.println("NIM: " + khs.getMahasiswa().getNim());
        System.out.println("Nama: " + khs.getMahasiswa().getNama());
        System.out.println("Mata Kuliah:");
        for (MataKuliah mataKuliah : mataKuliahs) {
            System.out.println("Kode: " + mataKuliah.getKode());
            System.out.println("Nama: " + mataKuliah.getNama());
            int nilaiAngka = khs.getMahasiswa().getNilaiAngkaMap().get(mataKuliah.getKode());
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