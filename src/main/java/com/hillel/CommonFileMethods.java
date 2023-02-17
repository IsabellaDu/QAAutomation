package com.hillel;

import java.io.*;

public class CommonFileMethods {
    public CommonFileMethods() {
    }

    public static void serialize(String filePath, UserData userData) throws IOException {
        File firstFile = new File(filePath);
        if (!firstFile.exists()) {
            firstFile.createNewFile();
        }
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(firstFile));

        if (userData.getName() != null) {
            fileWriter.write("name: " + userData.getName());
            fileWriter.newLine();
        }
        if (userData.getEmail() != null) {
            fileWriter.write("email: " + userData.getEmail());
            fileWriter.newLine();
        }
        if (userData.getAge() > 0) {
            fileWriter.write("age: " + userData.getAge());
            fileWriter.newLine();
        }
        fileWriter.flush();
    }


    public static void deserialize(String filePath, UserData userData) throws IOException {
        File file = new File(filePath);
        if (file.exists()) {
            BufferedReader fileReader = new BufferedReader(new FileReader(file));
            while (fileReader.ready()) {
                String line = fileReader.readLine();
                if (line != null) {
                    String field = line.substring(0, line.indexOf(": "));
                    String value = line.substring(line.indexOf(": ") + 2);
                    switch (field) {
                        case "name":
                            userData.setName(value);
                            break;
                        case "email":
                            userData.setEmail(value);
                            break;
                        case "age":
                            userData.setAge(Integer.parseInt(value));
                            break;
                    }
                }
            }
        }
    }
}
