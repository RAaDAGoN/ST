package ru.st;

public class PizzaOrder {
    enum pizzaSize{
        SMALL,
        MEDIUM,
        BIG
    }

    private String name;
    private pizzaSize size;
    private boolean sauce;
    private String deliveryAddress;
    private boolean orderAccepted;

    public PizzaOrder(String name, pizzaSize size, boolean sauce, String deliveryAddress) {
        this.name = name;
        this.size = size;
        this.sauce = sauce;
        this.deliveryAddress = deliveryAddress;
        this.orderAccepted = false;
    }

    public void order(){
        if (orderAccepted){
            System.out.println("Заказ уже был принят.");
        } else {
            orderAccepted = true;
            System.out.println("Заказ принят. " + getSize() +
                    " пицца '" + getName() +
                    "' " + (isSauce() ? "с соусом " : " без соуса ") +
                    "на адрес " + getDeliveryAddress());
        }
    }

    public void cancel(){
        if (orderAccepted){
            orderAccepted = false;
            System.out.println("Заказ отменен.");
        } else System.out.println("Заказ не был принят");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return switch (size) {
            case SMALL -> "Маленькая";
            case MEDIUM -> "Средняя";
            case BIG -> "Большая";
            default -> "";
        };
    }

    public void setSize(pizzaSize size) {
        this.size = size;
    }

    public boolean isSauce() {
        return sauce;
    }

    public void setSauce(boolean sauce) {
        this.sauce = sauce;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    @Override
    public String toString() {
        return "PizzaOrder{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", sauce=" + sauce +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", orderAccepted=" + orderAccepted +
                '}';
    }
}

class testingPizzaOrder{
    public void testPizzaOrder(){
        PizzaOrder order1 = new PizzaOrder("Маргарита", PizzaOrder.pizzaSize.MEDIUM, true, "ул. Ленина 15");
        PizzaOrder order2 = new PizzaOrder("Аль-Капчоне", PizzaOrder.pizzaSize.BIG, false, "Ярославская 101");

        System.out.println("--- Первый заказ ---");
        System.out.println(order1);
        order1.order(); // Принимаем заказ
        order1.order(); // Пытаемся принять повторно
        order1.cancel(); // Отменяем заказ
        order1.cancel(); // Пытаемся отменить снова

        System.out.println("\n--- Второй заказ ---");
        System.out.println(order2);
        order2.order(); // Принимаем заказ
        order2.setDeliveryAddress("Новый адрес 123"); // Меняем адрес
        System.out.println("Новый адрес доставки: " + order2.getDeliveryAddress());
        System.out.println(order2);
    }
}


