package Lab_6.v_5;

import java.io.*;

public class Connector {
    public static void writeEnrollee(String path,Enrollee[] object){
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path))){
            objectOutputStream.writeObject(object);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Enrollee[] readEnrollee(String path){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            Enrollee[] p=(Enrollee[])ois.readObject();
            return p;
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
        return null;
    }
    public static void writeTeachers(String path,Teacher[] object){
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path))){
            objectOutputStream.writeObject(object);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Teacher[] readTeachers(String path){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            Teacher[] p=(Teacher[])ois.readObject();
            return p;
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
        return null;
    }
    public static void writeExams(String path,Exam[] object){
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path))){
            objectOutputStream.writeObject(object);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Exam[] readExams(String path){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            Exam[] p=(Exam[])ois.readObject();
            return p;
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
        return null;
    }
}
