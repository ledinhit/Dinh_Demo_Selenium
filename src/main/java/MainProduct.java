import java.lang.reflect.Array;
import java.util.Scanner;

public class MainProduct {
    static Scanner sc = new Scanner(System.in);
    static void addProduct(Product prd){
        Product prd1 = new Product();
        System.out.println("Nhập Tên sản phẩm: ");
        sc.nextLine();
        prd.setName(sc.nextLine());
        System.out.println("Nhập Giá sản phẩm: ");
        prd.setPrice(sc.nextFloat());
        System.out.println("Nhập Số lượng sản phẩm: ");
        prd.setQuality(sc.nextInt());
    }
    public static void  main(String[] args) {
        Product prod[] = null;
        int a, n = 0;

        // Thêm sản phẩm
        System.out.println("Nhập số sản phẩm muốn thêm:");
        n = sc.nextInt();
        prod = new Product[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Sản phẩm thứ " + (i + 1)+": ");
            prod[i] = new Product();
            addProduct(prod[i]);
        }

        //A. hiển thị danh sách sản phầm
        System.out.println("----DANH SÁCH SẢN PHẨM-----");
        System.out.printf("%20s %20s %20s \n","Tên sản phẩm","Giá ","Số lượng");
        for (int i = 0; i < n; i++) {
            prod[i].inProduct();
        }


        //C. In ra sản phẩm đã hết hàng
        System.out.println("----DANH SÁCH SẢN PHẨM ĐÃ HẾT HÀNG-----");
        System.out.printf("%20s %20s %20s \n","Tên sản phẩm","Giá ","Số lượng");
        for (int i = 0; i < n; i++) {
            if(prod[i].getQuality() == 0){
                prod[i].inProduct();
            }else {
                System.out.println("Không có sản phẩm nào hết hàng");
            }
        }

    }
}
