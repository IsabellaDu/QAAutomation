import com.hillel.UserData;

import java.io.*;

import static com.hillel.CommonFileMethods.deserialize;
import static com.hillel.CommonFileMethods.serialize;

public class IOStreamTest {

    public static void main(String[] args) throws IOException {
        String filePath = "src/main/resources/userDataFile.txt";
        UserData user = new UserData("Ivan", "ivan@mail.com", 34);
        UserData emptyUser = new UserData(null, null, 0);

        serialize(filePath, user);
        //deserialize(filePath, emptyUser);
        //System.out.println(emptyUser.getName() + emptyUser.getEmail() + emptyUser.getAge());
    }
}
