package Interaction_learning;

public class Message {
    private boolean isSayHello;
    private int count = 0;
    public Message(boolean isSayHello) {
        this.isSayHello = isSayHello;
    }

    public boolean isSayHello() {
        return isSayHello;
    }

    public void setSayHello(boolean sayHello) {
        isSayHello = sayHello;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    public int increase(int num){
        this.count += num;
        return this.count;
    }

}
