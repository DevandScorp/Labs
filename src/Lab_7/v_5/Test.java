package Lab_7.v_5;

import java.io.*;
import java.util.*;

public class Test {
    private static final String PATH = "src\\Lab_7\\v_5\\data.dat";

    public static Map<Integer,Long> write(List<User> users){
        Map<Integer,Long> indexList = new HashMap<>();
        int i = 0;
        try(RandomAccessFile data = new RandomAccessFile(PATH,"rw")){
            for(var user:users){
                long dataPointer = data.getFilePointer();
                indexList.put(i,dataPointer);
                ++i;
                data.write(serialize(user));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return indexList;
    }

    public static User read(int index,Map<Integer,Long> users){
        long dataPointer = users.get(index);
        try(RandomAccessFile data = new RandomAccessFile(PATH,"rw")){
            data.seek(dataPointer);
            byte[] b = new byte[1024];
            data.read(b);
            return deserialize(b);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] serialize(User user){
        try(ByteArrayOutputStream baos = new ByteArrayOutputStream();ObjectOutputStream oos = new ObjectOutputStream(baos);){
            oos.writeObject(user);
            oos.flush();
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static User deserialize(byte[] byteArray){
        try(ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(byteArray));){
            User user = (User) ois.readObject();
            return user;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static void main(String[] args){
    List<User> users = List.of(
            new User(  "Artem",
                    "Dachevsky",
                    "Viktorovich",
                    "375257916408",
                    "Ozerco",
                    "Polesskaya",
                    1432670,
                    new Date(),
                    1432670,
                    new Date()),

            new User(  "Katya",
                    "Galkina",
                    "Olegovna",
                    "375291828747",
                    "Serebraynka",
                    "undefined",
                    1432670,
                    new Date(),
                    1432670,
                    new Date()),
            new User(  "Timofey",
                    "Kruk",
                    "Sergeevich",
                    "375336834100",
                    "Kolodischy",
                    "undefined",
                    1432670,
                    new Date(),
                    1432670,
                    new Date())
    );
    Map<Integer, Long> write = write(users);
        for(var entry:write.entrySet()){
            System.out.println(read(entry.getKey(),write));
        }
    }
}
