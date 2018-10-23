package Lab_8.v_5;

import java.io.*;
import java.util.*;

public class Test {
    private static final String PATH = "src\\Lab_8\\v_5\\data.dat";

    public static Map<Object, Long> write(List<User> users) {
        Map<Object, Long> indexList = new HashMap<>();
        try (RandomAccessFile data = new RandomAccessFile(PATH, "rw")) {
            for (var user : users) {
                long dataPointer = data.getFilePointer();
                indexList.put(user.getField(), dataPointer);
                data.write(serialize(user));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return indexList;
    }

    public static User read(Object index, Map<Object, Long> users) {
        long dataPointer = users.get(index);
        try (RandomAccessFile data = new RandomAccessFile(PATH, "rw")) {
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

    public static byte[] serialize(User user) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream(); ObjectOutputStream oos = new ObjectOutputStream(baos);) {
            oos.writeObject(user);
            oos.flush();
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static User deserialize(byte[] byteArray) {
        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(byteArray));) {
            User user = (User) ois.readObject();
            return user;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static void main(String[] args) {
        List<User> users = List.of(
                new User("Artem",
                        "Dachevsky",
                        "Viktorovich",
                        "375257916408",
                        "Ozerco",
                        "Polesskaya",
                        1432670,
                        new Date(30000),
                        1432670,
                        new Date(30000)),

                new User("Katya",
                        "Galkina",
                        "Olegovna",
                        "375291828747",
                        "Serebraynka",
                        "undefined1",
                        1432672,
                        new Date(20000),
                        1432672,
                        new Date(20000)),
                new User("Timofey",
                        "Kruk",
                        "Sergeevich",
                        "375336834100",
                        "Kolodischy",
                        "undefined2",
                        1432671,
                        new Date(10000),
                        1432671,
                        new Date(10000))
        );
        User.setField("lastPay");
        Map<Object, Long> write = write(users);
        System.out.println("Вывод данных по убыванию ключа");
        for (var entry : write.entrySet()) {
            System.out.println("Key: " + entry.getKey());
            System.out.println(read(entry.getKey(), write));
        }
        System.out.println();
        System.out.println("Вывод данных по возрастанию ключа");
        Object[] entries = write.keySet().toArray();
        Arrays.sort(entries);

        Arrays.stream(entries).forEach(a->{
            System.out.println("Key: " + a);
            System.out.println(read(a,write));
        }
        );

    }
}
