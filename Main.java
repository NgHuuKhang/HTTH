package baitap;

public class Main {
    public static void main(String[] args) {
        BTFile a =new BTFile("fileA.txt");
        a.start();
        BTFile b =new BTFile("fileB.txt");
        b.start();
        BTFile c =new BTFile("fileC.txt");
        c.start();


    }
}
