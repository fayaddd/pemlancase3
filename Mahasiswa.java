import java.util.HashMap;
import java.util.Map;

class Mahasiswa {
    private String nim;
    private String nama;
    private Map<String, Integer> nilaiAngkaMap;

    public Mahasiswa() {
        nilaiAngkaMap = new HashMap<>();
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void tambahNilai(String kodeMk, int nilaiAngka) {
        nilaiAngkaMap.put(kodeMk, nilaiAngka);
    }

    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public Map<String, Integer> getNilaiAngkaMap() {
        return nilaiAngkaMap;
    }
}
