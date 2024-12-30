import java.io.*;
public class File {
    public static void main(String[] args) {
        String fileName = "data.dat";
        writeFile(fileName);
        readRecord(fileName, 2);
    }
    public static void writeFile ( String fileName ) {
        try ( RandomAccessFile raf = new RandomAccessFile(fileName, "rw") ) {
            raf.writeUTF("Alice");
            raf.writeInt(100);

            raf.writeUTF("Bob");
            raf.writeInt(60);

            raf.writeUTF("Christy");
            raf.writeInt(89);

            System.out.println("Successfully writter");
        } catch ( FileNotFoundException e) {
            e.printStackTrace();
        } catch ( IOException e ) {
            e.printStackTrace();
        }


    }
    public static void readRecord(String fileName, int recordNumber) {
        try (RandomAccessFile raf = new RandomAccessFile(fileName, "r")) {
            int recordSize = 20; // Assuming name (UTF-8) + int takes around 20 bytes
            raf.seek((recordNumber - 1) * recordSize);

            String name = raf.readUTF();
            int marks = raf.readInt();

            System.out.println("Record " + recordNumber + ": " + name + ", " + marks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
