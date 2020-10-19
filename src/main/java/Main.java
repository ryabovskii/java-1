
public class Main {

    public static void main(String[] args) {

        Container<Integer> ar = new Container<>();
        ar.add(1);
        ar.add(2);
        ar.add(5);
        ar.print();
        System.out.println(".get(3) :  " + ar.get(3));
        System.out.println(".get(1) :  " + ar.get(1));
        ar.print();
        ar.delete(1);
        ar.print();
        ar.add(9);
        ar.add(11);
        ar.print();
        ar.delete(1);
        ar.delete(1);
        ar.add(13);
        ar.print();

    }
}
