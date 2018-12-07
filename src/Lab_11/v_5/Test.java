package Lab_11.v_5;



import java.io.*;
import java.util.*;

public class Test {

    public static User move(Object index, Map<Object, Long> users, int direction, String path) {
        Object[] objects = users.keySet().toArray();
        if (direction == 0) {
            for (int i = 0; i < objects.length - 1; ++i) {
                if (objects[i].equals(index)) {
                    try (RandomAccessFile data = new RandomAccessFile(path, "rw")) {
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
                    try (RandomAccessFile data = new RandomAccessFile(path, "rw")) {
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

    public static void removeByIndex(Object index, Map<Object, Long> users, String path) {
        for (var entry : users.entrySet()) {
            if (entry.getKey().equals(index)) {
                try (RandomAccessFile data = new RandomAccessFile(path, "rw")) {
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

    public static Map<Object, Long> write(List<User> users, String path) {
        Map<Object, Long> indexList = new HashMap<>();
        try (RandomAccessFile data = new RandomAccessFile(path, "rw")) {
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

    public static User read(Object index, Map<Object, Long> users, String path) {
        long dataPointer = users.get(index);

        try (RandomAccessFile data = new RandomAccessFile(path, "rw")) {
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
             ObjectOutputStream oos = new ObjectOutputStream(baos)) {
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

}
