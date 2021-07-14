
public class Product {
    //khai báo các thuộc tính cần thiết
    private String name;
    private float price;
    private int quality;

    //khởi tạo constructor không tham số
    public Product() {
    }

    //khởi tạo constructor có tham số
    public Product(String name, float price, int quality) {
        this.name = name;
        this.price = price;
        this.quality = quality;
    }

    //------------------begin getter and setter----------------------
    // get dùng để trả về tên sản phẩm của đối tượng
    public String getName() {
        return name;
    }

    // this là từ khóa có ý nghĩa là một tham chiếu đặc biệt
    // chiếu tới đối tượng chủ của phương thức hiện hành
    // this có thể được dùng để truy cập biến đối tượng (instance variable)
    // hoặc gọi phương thức đối với đối tượng hiện hành.
    // Thông thường, công dụng này của this chỉ có ích
    // khi tên biến đối tượng bị trùng với tham số (biến cục bộ - local variable) của phương thức
    // set dùng để gán giá trị cho thuộc tính tên sản phẩm của đối tượng
    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }
    //-----------------------end getter and setter--------------------

    //tạo một phương thức khác dùng để hiển thị kết quả
//   %c: Ký tự
//%d: Số thập phân (số nguyên) (cơ số 10)
//            %e: Dấu phẩy động theo cấp số nhân
//%f: Dấu phẩy động
//%i: Số nguyên (cơ sở 10)
//%o: Số bát phân (cơ sở 8)
//%s: Chuỗi
//%u: Số thập phân (số nguyên) không dấu
//%x: Số trong hệ thập lục phân (cơ sở 16)
//%t: Định dạng ngày / giờ
//%%: Dấu phần trăm
//\%: Dấu phần trăm
    public void inProduct() {
        System.out.printf("%20s %20.2f  %20d \n", name, price, quality);
    }


}
