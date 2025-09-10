class HinhChuNhat {
    private double chieuDai;
    private double chieuRong;

    public HinhChuNhat(double chieuDai, double chieuRong) {
        this.chieuDai = chieuDai;
        this.chieuRong = chieuRong;
    }

    public HinhChuNhat() {
        this.chieuDai = 1.0;
        this.chieuRong = 1.0;
    }

    public double tinhChuVi() {
        return 2 * (chieuDai + chieuRong);
    }

    public double tinhDienTich() {
        return chieuDai * chieuRong;
    }

    public void hienThi() {
        System.out.println("Dài: " + chieuDai + ", Rộng: " + chieuRong);
        System.out.println("Chu vi: " + tinhChuVi());
        System.out.println("Diện tích: " + tinhDienTich());
    }
}

public class btvn {
    public static void main(String[] args) {
        HinhChuNhat hcn1 = new HinhChuNhat(5, 3);
        HinhChuNhat hcn2 = new HinhChuNhat(10, 4);
        HinhChuNhat hcn3 = new HinhChuNhat();

        hcn1.hienThi();
        hcn2.hienThi();
        hcn3.hienThi();
    }
}
