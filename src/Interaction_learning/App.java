package Interaction_learning;

public class App {
    public static void main(String[] args) {
        Message message = new Message(false);
//        SayHello sayHello = new SayHello(message);
//        SayHi sayHi = new SayHi(message);
//
//        sayHello.start();
//        sayHi.start();


        Relay relay1 = new Relay(message);
        Relay relay2 = new Relay(message);
        Relay relay3 = new Relay(message);
        relay1.setNext(relay2);
        relay2.setNext(relay3);
        relay3.setNext(relay1);
        relay1.start();
        relay2.start();
        relay3.start();
        try {
            Thread.sleep(1000);
            synchronized (relay1){
                relay1.notify();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
