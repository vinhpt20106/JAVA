public class SinhVien {

    private String maSv;
    private String hoTen;
    private int tuoi;
    
    private static int soLuong = 0;

    public SinhVien() {
        this.maSv = "";
        this.hoTen = "";
        this.tuoi = 0;
        soLuong++;
    }
    
    public SinhVien(String maSv, String hoTen, int tuoi) {
        this.maSv = maSv;
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        soLuong++;
    }
    
    public void setThongTin(String maSv, String hoTen, int tuoi) {
        this.maSv = maSv;
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        System.out.println(" Đã cập nhật thông tin sinh viên: " + hoTen);
    }
    
    public void hienThiThongTin() {
        System.out.println("=== THÔNG TIN SINH VIÊN ===");
        System.out.println("Mã SV: " + this.maSv);
        System.out.println("Họ tên: " + this.hoTen);
        System.out.println("Tuổi: " + this.tuoi);
        System.out.println("==========================");
    }
    
    public static void hienThiSoLuong() {
        System.out.println(" Tổng số sinh viên đã tạo: " + soLuong);
    }
    
    public String getMaSv() {
        return maSv;
    }
    
    public String getHoTen() {
        return hoTen;
    }
    
    public int getTuoi() {
        return tuoi;
    }
    
    public static int getSoLuong() {
        return soLuong;
    }
    
    public static void resetSoLuong() {
        soLuong = 0;
        System.out.println(" Đã reset số lượng sinh viên về 0");
    }
    
    @Override
    public String toString() {
        return "SinhVien{" +
                "maSv='" + maSv + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", tuoi=" + tuoi +
                '}';
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println(" CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN\n");
        
        System.out.println(" Số lượng sinh viên ban đầu:");
        SinhVien.hienThiSoLuong();
        System.out.println();
        
        System.out.println(" Tạo sinh viên bằng constructor có tham số:");
        SinhVien sv1 = new SinhVien("SV001", "Nguyễn Văn An", 20);
        SinhVien sv2 = new SinhVien("SV002", "Trần Thị Bình", 19);
        
        sv1.hienThiThongTin();
        sv2.hienThiThongTin();
        
        SinhVien.hienThiSoLuong();
        System.out.println();
        
        System.out.println(" Tạo sinh viên rỗng và set thông tin:");
        SinhVien sv3 = new SinhVien();
        sv3.setThongTin("SV003", "Lê Minh Tuấn", 21);
        sv3.hienThiThongTin();
        
        System.out.println(" Tạo thêm sinh viên:");
        SinhVien sv4 = new SinhVien("SV004", "Phạm Thị Dung", 18);
        SinhVien sv5 = new SinhVien("SV005", "Hoàng Văn Đức", 22);
        
        System.out.println();
        System.out.println(" DANH SÁCH TẤT CẢ SINH VIÊN:");
        SinhVien[] danhSachSV = {sv1, sv2, sv3, sv4, sv5};
        
        for (int i = 0; i < danhSachSV.length; i++) {
            System.out.println((i + 1) + ". Mã: " + danhSachSV[i].getMaSv() + 
                             " | Tên: " + danhSachSV[i].getHoTen() + 
                             " | Tuổi: " + danhSachSV[i].getTuoi());
        }
        
        System.out.println();
        System.out.println(" THỐNG KÊ CUỐI CÙNG:");
        SinhVien.hienThiSoLuong();
        
        System.out.println("\n DEMO THAY ĐỔI THÔNG TIN:");
        sv1.setThongTin("SV001", "Nguyễn Văn An (Đã cập nhật)", 21);
        sv1.hienThiThongTin();
        
        System.out.println("\n SỬ DỤNG PHƯƠNG THỨC STATIC:");
        System.out.println("Số lượng hiện tại: " + SinhVien.getSoLuong());
        
        System.out.println("\n GIẢI THÍCH THUỘC TÍNH STATIC:");
        System.out.println("- Thuộc tính static 'soLuong' được chia sẻ cho tất cả đối tượng");
        System.out.println("- Mỗi khi tạo sinh viên mới, soLuong tự động tăng");
        System.out.println("- Có thể truy cập qua tên class: SinhVien.getSoLuong()");
        System.out.println("- Giá trị hiện tại: " + SinhVien.getSoLuong());
        
        System.out.println("\n DEMO RESET SỐ LƯỢNG:");
        SinhVien.resetSoLuong();
        SinhVien.hienThiSoLuong();
    }
}
