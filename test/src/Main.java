public class Main {

    public static void main(String[] args) {
            // TODO Auto-generated method stub
        Thread th=new Thread(()->System.out.println("你好"));
        th.start();
    }
}