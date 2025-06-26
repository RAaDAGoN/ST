package ru.st;

import java.util.List;

public class Phone {
    private String number;
    private String model;
    private double weight;

    public Phone() {}

    public Phone(String number, String model, double weight) {
        this.number = number;
        this.model = model;
        this.weight = weight;
    }

    public Phone(String number, String model) {
        this.number = number;
        this.model = model;
    }

    public String getNumber() {
        return number;
    }

    public void receiveCall(String name){
        System.out.printf("Звонит %s\n",name);
    }

    public void receiveCall(String name, String number){
        System.out.printf("Звонит %s с телефона %s\n",name, number);
    }

    public void sendMessage(String... listNumbers){


        for (String s : listNumbers){
            System.out.println(s);
        }
    }

    @Override
    public String toString() {
        return "Телефон{" +
                "номер=" + number +
                ", модель='" + model + '\'' +
                ", вес=" + weight +
                '}';
    }
}

class testPhone{
    public void testPH(){
        Phone phone1 = new Phone("+79123456789", "iPhone 13", 0.174);
        Phone phone2 = new Phone("+79234567890", "Samsung Galaxy S21");
        Phone phone3 = new Phone();

        // Вывод информации о телефонах
        System.out.println(phone1.toString());
        System.out.println(phone2.toString());
        System.out.println(phone3.toString());

        // Демонстрация методов receiveCall
        phone1.receiveCall("Алексей");
        phone2.receiveCall("Мария", "+79876543210");

        // Демонстрация метода getNumber
        System.out.println("Номер телефона 1: " + phone1.getNumber());
        System.out.println("Номер телефона 2: " + phone2.getNumber());

        // Демонстрация метода sendMessage
        phone1.sendMessage("+79111111111", "+79222222222", "+79333333333");
    }
}
