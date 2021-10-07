package baitap;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Formatter;
import java.util.Random;
import java.io.FileReader;
import java.nio.Buffer;


public class BTFile extends Thread{
    public String namefile;

    public BTFile(String name) {
        this.namefile= name;
    }
    public synchronized void ghiFile(String s){
        System.out.println(Thread.currentThread().getName()+" ghi dữ liệu vào "+this.namefile);
        try {
            FileWriter fw = new FileWriter(this.namefile);
            fw.write(s);
            fw.close();
        } catch (Exception e) {
            //TODO: handle exception
        }
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"--Kết thúc");
    }
    public void docFile(){
        System.out.println(Thread.currentThread().getName()+" Đọc dữ liệu "+this.namefile);
        try {
            FileReader fr= new FileReader(this.namefile);
            BufferedReader br = new BufferedReader(fr);
            String txt="";
            while (true) {
                if(txt==null){
                    break;
                }else{
                    txt = br.readLine();
                    System.out.println(txt);
                }
            }
            fr.close();
        } catch (Exception e) {
            //TODO: handle exception
        }
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"--Kết thúc");
    }

    @Override
    public void run() {
        int[] array;
        array= new int[3];
        String s="";
        for (int i = 0; i < array.length; i++) {
            Random rd =new Random();
            array[i]=rd.nextInt(50);
            s+=s+" "+array[i];
        }
       ghiFile(s);
       docFile();
}
}
