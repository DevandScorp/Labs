package Lab_8.v_5;

import java.io.*;
import java.util.*;

public class Test {
    private static final String PATH = "src\\Lab_8\\v_5\\data.dat";

    public static User move(Object index, Map<Object, Long> users, int direction) {
        Object[] objects = users.keySet().toArray();
        if (direction == 0) {
            for (int i = 0; i < objects.length - 1; ++i) {
                if (objects[i].equals(index)) {
                    try (RandomAccessFile data = new RandomAccessFile(PATH, "rw")) {
                        int j = i + 1;
                        data.seek(users.get(objects[j]));
                        byte[] b = new byte[1024];
                        data.read(b);
                        User deserialize = deserialize(b);
                        while (deserialize.isDeleted()) {
                            ++j;
                            if (j >= objects.length) return null;
                            data.seek(users.get(objects[j]));
                            byte[] bytes = new byte[1024];
                            data.read(bytes);
                            deserialize = deserialize(b);
                        }
                        return deserialize;
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else if (direction == 1) {
            for (int i = 1; i < objects.length; ++i) {
                if (objects[i].equals(index)) {
                    try (RandomAccessFile data = new RandomAccessFile(PATH, "rw")) {
                        int j = i - 1;
                        data.seek(users.get(objects[j]));
                        byte[] b = new byte[1024];
                        data.read(b);
                        User deserialize = deserialize(b);
                        while (deserialize.isDeleted()) {
                            --j;
                            if (j < 0) return null;
                            data.seek(users.get(objects[j]));
                            byte[] bytes = new byte[1024];
                            data.read(bytes);
                            deserialize = deserialize(b);
                        }
                        return deserialize;
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }

    public static void removeByIndex(Object index, Map<Object, Long> users) {
        for (var entry : users.entrySet()) {
            if (entry.getKey().equals(index)) {
                try (RandomAccessFile data = new RandomAccessFile(PATH, "rw")) {
                    data.seek(entry.getValue());
                    byte[] b = new byte[1024];
                    data.read(b);
                    User deserialize = deserialize(b);
                    deserialize.setDeleted(true);
                    data.seek(entry.getValue());
                    data.write(serialize(deserialize));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

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
            User deserialize = deserialize(b);
            if (deserialize.isDeleted()) return null;
            return deserialize(b);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] serialize(User user) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(baos);) {
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
        User.setField("userPay");
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

        System.out.println();
        System.out.println("Удаление по индексу");
        removeByIndex(users.get(0).getUserPay(), write);
        for (var entry : write.entrySet()) {
            User user = read(entry.getKey(), write);
            if (user != null) {
                System.out.println("Key: " + entry.getKey());
                System.out.println(read(entry.getKey(), write));
            }
        }

        System.out.println();
        System.out.println("Вывод объекта,находящегося ниже заданного");
        System.out.println(move(users.get(1).getUserPay(), write, 0));
        System.out.println("Вывод объекта,находящегося выше заданного");
        System.out.println(move(users.get(2).getUserPay(), write, 1));
    }
}
