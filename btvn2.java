import java.util.*;

class TaiKhoan {
    private String soTaiKhoan;
    private String tenChuTaiKhoan;
    private double soDu;

    private static double laiSuatNam = 0.05;

    public TaiKhoan(String soTaiKhoan, String tenChuTaiKhoan, double soDu) {
        this.soTaiKhoan = soTaiKhoan;
        this.tenChuTaiKhoan = tenChuTaiKhoan;
        this.soDu = soDu;
    }

    public void napTien(double soTien) {
        if (soTien > 0) {
            soDu += soTien;
            System.out.println("Nạp " + soTien + " vào TK " + soTaiKhoan + " thành công.");
        }
    }

    public void rutTien(double soTien) {
        if (soTien > 0 && soTien <= soDu) {
            soDu -= soTien;
            System.out.println("Rút " + soTien + " từ TK " + soTaiKhoan + " thành công.");
        } else {
            System.out.println("Rút tiền thất bại (số dư không đủ)!");
        }
    }

    public void tinhLaiMotThang() {
        double lai = soDu * (laiSuatNam / 12);
        soDu += lai;
    }

    public void hienThi() {
        System.out.println("Số TK: " + soTaiKhoan +
                           " | Chủ TK: " + tenChuTaiKhoan +
                           " | Số dư: " + soDu);
    }

    public String getSoTaiKhoan() {
        return soTaiKhoan;
    }

    public double getSoDu() {
        return soDu;
    }

    public static void thayDoiLaiSuat(double ls) {
        if (ls >= 0) {
            laiSuatNam = ls;
        }
    }

    public static void hienThiLaiSuat() {
        System.out.println("Lãi suất năm hiện tại: " + (laiSuatNam * 100) + "%");
    }
}

public class btvn2 {
    public static void main(String[] args) {
        ArrayList<TaiKhoan> danhSach = new ArrayList<>();

        TaiKhoan tk1 = new TaiKhoan("001", "Nguyen Van A", 5000);
        TaiKhoan tk2 = new TaiKhoan("002", "Tran Thi B", 10000);
        TaiKhoan tk3 = new TaiKhoan("003", "Le Van C", 2000);

        danhSach.add(tk1);
        danhSach.add(tk2);
        danhSach.add(tk3);

        TaiKhoan.hienThiLaiSuat();

        tk1.napTien(2000);
        tk2.rutTien(3000);
        tk3.tinhLaiMotThang();

        TaiKhoan.thayDoiLaiSuat(0.07);
        TaiKhoan.hienThiLaiSuat();

        System.out.println("\nDanh sách tài khoản sau giao dịch:");
        for (TaiKhoan tk : danhSach) {
            tk.hienThi();
        }

        String tim = "002";
        System.out.println("\nTìm kiếm tài khoản số " + tim + ":");
        for (TaiKhoan tk : danhSach) {
            if (tk.getSoTaiKhoan().equals(tim)) {
                tk.hienThi();
            }
        }

        danhSach.sort((a, b) -> Double.compare(b.getSoDu(), a.getSoDu()));

        System.out.println("\nDanh sách sau khi sắp xếp theo số dư giảm dần:");
        for (TaiKhoan tk : danhSach) {
            tk.hienThi();
        }
    }
}
