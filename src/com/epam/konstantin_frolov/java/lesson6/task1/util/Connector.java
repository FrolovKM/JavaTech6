package com.epam.konstantin_frolov.java.lesson6.task1.util;

import java.io.*;

public class Connector {
    public static void printObject(File file, Object object) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(object);
        }
    }

    public static Object readObject(File file) throws IOException, ClassNotFoundException {
        Object readObject = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            readObject = in.readObject();
        }
        return readObject;
    }
}