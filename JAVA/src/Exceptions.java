class Parent {
    int speed;

    Parent() {
        System.out.println("constructor is invoked");
    }

    {
        System.out.println("instance initializer block invoked");
    }
}

public class Exceptions {
    public static void main(String[] args) {
        System.out.println("hii");
        Parent p = new Parent();
        Parent p1 = new Parent();


    }

}
