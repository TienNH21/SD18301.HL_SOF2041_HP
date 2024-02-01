package repositories;

// B1: Import thư viện
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import models.NhanVien;
import utils.JdbcUtils;

public class NhanVienRepository {
    private Connection conn;
    
    public NhanVienRepository()
    {
        // B2: Kết nối CSDL
        this.conn = JdbcUtils.getConnection();
    }
    
    /*
     * truy vấn table NhanVien trong CSDL, lấy ra toàn bộ các bản ghi.
     * Do vậy, cần trả về danh sách nhân viên - ArrayList<NhanVien>
     */
    public ArrayList<NhanVien> findAll()
    {
        // Khởi tạo ArrayList<NhanVien>
        ArrayList<NhanVien> ds = new ArrayList<>();
        
        
        // B3: Viết câu lệnh truy vấn SQL
        String query = "SELECT * FROM NhanVien";
        
        try {
            // B4: Khởi tạo đối tượng PreparedStatement để thực thi câu truy vấn.
            PreparedStatement ps = this.conn.prepareStatement(query);
            
            // B5: Thực thi truy vấn CSDL.
            ps.execute();
            
            // B6: Đọc dữ liệu từ ResultSet.
            // ResultSet là đối tượng chứa dữ liệu do CSDL trả về.
            ResultSet rs = ps.getResultSet();
            
            /*
             * Sử dụng cấu trúc lặp while để duyệt lần lượt từng bản ghi.
             * ResultSet cung cấp hàm next() để duyệt bản ghi tiếp theo.
             * ResultSet trả về false nếu không còn bản ghi nào để đọc.
             * Nếu rs.next() == true, vẫn còn dữ liệu để đọc -> vẫn duyệt tiếp.
             */
            while (rs.next() == true) {
                /*
                 * Do HoTen khi lấy ra có kiểu dữ liệu là String
                 *  nên sẽ dùng phương thức getString để đọc dữ liệu.
                 * Tương tự với MaNV, MatKhau.
                 * Còn VaiTro trong DB có kiểu int
                 *  nên khi lấy ra sẽ dùng phương thức getInt
                 * Các phương thức get<DataType>() có tham số truyền vào là 
                 *      tên cột cần lấy dữ liệu.
                 */
                String hoTen = rs.getString("HoTen");
                String maNV = rs.getString("MaNV");
                String matKhau = rs.getString("MatKhau");
                int vaiTro = rs.getInt("VaiTro");
                
                NhanVien nv = new NhanVien(maNV, matKhau, hoTen, vaiTro);
                ds.add(nv);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return ds;
    }


    public void delete(String maNV)
    {
        // B1: Viết truy vấn
        String query = "DELETE FROM NhanVien WHERE MaNV = ?";
        
        try {
            // B2: Tạo PreparedStatement
            PreparedStatement ps = this.conn.prepareStatement(query);
            /**
             * Dấu "?" trong câu truy vấn được gọi là tham số của câu truy vấn.
             * Do giá trị cần truyền vào cho tham số có kiểu dữ liệu là String
             *      nên phương thức truyền giá trị sẽ là setString.
             *      Nếu tham số có kiểu là int thì phương thức sẽ là setInt() ...
             * Phương thức setString() có 2 tham số:
             *      Tham số 1: vị trí của dấu "?" trong câu truy vấn
             *      Tham số 2: giá trị cần truyền vào cho dấu "?"
             * Câu truy vấn có bao nhiêu tham số (dấu "?") thì phải truyền đủ
             *      giá trị cho bấy nhiêu tham số.
             */
            
            // B3: Gán giá trị cho tham số trong câu truy vấn
            ps.setString(1, maNV);
            
            // B4: Thực thi câu truy vấn
            ps.execute();
        } catch (Exception e) { e.printStackTrace(); }
    }
    
    public void create(NhanVien nv)
    {
        String query = "INSERT INTO NhanVien(MaNV, HoTen, MatKhau, VaiTro) "
            + " VALUES (?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = this.conn.prepareStatement(query);
            ps.setString(1, nv.getMaNV());
            ps.setString(2, nv.getHoTen());
            ps.setString(3, nv.getMatKhau());
            ps.setInt(4, nv.getVaiTro());
            
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void update(NhanVien nv)
    {
        String query = "UPDATE NhanVien SET HoTen = ?, MatKhau = ?, VaiTro = ? "
                + " WHERE MaNV = ?";
        
        try {
            PreparedStatement ps = this.conn.prepareStatement(query);
            ps.setString(1, nv.getHoTen());
            ps.setString(2, nv.getMatKhau());
            ps.setInt(3, nv.getVaiTro());
            ps.setString(4, nv.getMaNV());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
