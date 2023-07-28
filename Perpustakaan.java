import java.util.ArrayList;
import java.util.Scanner;

class Buku {
    private String judul;
    private String penulis;
    private int tahunTerbit;

    public Buku(String judul, String penulis, int tahunTerbit) {
        this.judul = judul;
        this.penulis = penulis;
        this.tahunTerbit = tahunTerbit;
    }

    public String getJudul() {
        return judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }

    @Override
    public String toString() {
        return "Judul: " + judul + " | Penulis: " + penulis + " | Tahun Terbit: " + tahunTerbit;
    }
}

public class Perpustakaan {
    private ArrayList<Buku> daftarBuku = new ArrayList<>();

    public void tambahBuku(String judul, String penulis, int tahunTerbit) {
        Buku bukuBaru = new Buku(judul, penulis, tahunTerbit);
        daftarBuku.add(bukuBaru);
        System.out.println("Buku berhasil ditambahkan!");
    }

    public Buku cariBuku(String judul) {
        for (Buku buku : daftarBuku) {
            if (buku.getJudul().equalsIgnoreCase(judul)) {
                return buku;
            }
        }
        return null;
    }

    public void tampilkanDaftarBuku() {
        if (daftarBuku.isEmpty()) {
            System.out.println("Tidak ada buku dalam perpustakaan.");
        } else {
            System.out.println("Daftar Buku:");
            for (Buku buku : daftarBuku) {
                System.out.println(buku);
            }
        }
    }

    public static void main(String[] args) {
        Perpustakaan perpustakaan = new Perpustakaan();
        Scanner scanner = new Scanner(System.in);

        System.out.println("--------------------------------------");
        System.out.println("Selamat Datang di Layanan Perpustakaan");
        System.out.println("--------------------------------------");

        while (true) {

            System.out.println("\nMenu Perpustakaan Online:");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Cari Buku");
            System.out.println("3. Tampilkan Daftar Buku");
            System.out.println("4. Keluar");
            System.out.print("\nPilihan Anda: ");
            int pilihan = scanner.nextInt();

            scanner.nextLine(); // Mengonsumsi karakter baru (newline) setelah memasukkan pilihan

            switch (pilihan) {
                case 1:
                    System.out.print("\nMasukkan judul buku: ");
                    String judulBuku = scanner.nextLine();
                    System.out.print("Masukkan nama penulis: ");
                    String penulisBuku = scanner.nextLine();
                    System.out.print("Masukkan tahun terbit: ");
                    int tahunTerbit = scanner.nextInt();
                    perpustakaan.tambahBuku(judulBuku, penulisBuku, tahunTerbit);
                    break;
                case 2:
                    System.out.print("Masukkan judul buku yang dicari: ");
                    String judulCari = scanner.nextLine();
                    Buku hasilCari = perpustakaan.cariBuku(judulCari);
                    if (hasilCari != null) {
                        System.out.println("\nBuku ditemukan:");
                        System.out.println(hasilCari);
                    } else {
                        System.out.println("\nBuku tidak ditemukan.");
                    }
                    break;
                case 3:
                    perpustakaan.tampilkanDaftarBuku();
                    break;
                case 4:
                    System.out.println("----------------------------------------------------");
                    System.out.println("Terima kasih sudah mengunjungi layanan Perpustakaan!");
                    System.out.println("----------------------------------------------------");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih angka 1-4.");
                    break;
            }
        }
    }
}
