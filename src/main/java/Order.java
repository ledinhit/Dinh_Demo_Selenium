public class Order extends Product{
    String orderId;

    public Order(){
    }
    public Order(String orderId){
        this.orderId = orderId;
    }
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
