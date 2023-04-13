//package com.zhulang.chapter11;
//
//import java.io.*;
//
//import org.apache.commons.io.IOUtils;
//import org.apache.commons.io.FileUtils;
//
///**
// * @Author zhulang
// * @Date 2023-03-28
// **/
//public class SerializableTest {
//    public static void main(String[] args) {
//        ObjectOutputStream oos = null;
//        try {
//            oos = new ObjectOutputStream(new FileOutputStream("tempFile"));
//            oos.writeObject(Singleton.getSingleton());
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            IOUtils.closeQuietLy(oos);
//        }
//
//        File file = new File("tempFile");
//        ObjectInputStream ois = null;
//        try {
//            ois = new ObjectInputStream(new FileInputStream(file));
//            Singleton newInstance = (Singleton) ois.readObject();
//            System.out.println(newInstance == Singleton.getSingleton());
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            IOUtils.closeQuietLy(oos);
//            try {
//                FileUtils.forceDelete(file);
//            } catch (IOException e){
//                e.printStackTrace();
//            }
//        }
//
//    }
//}
