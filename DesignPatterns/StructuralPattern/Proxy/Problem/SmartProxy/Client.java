/**
 * Client (Problem) - manual resource management, can leak handles.
 */
public class Client {
    public static void main(String[] args) {
        FileHandle fh = new FileHandle("/var/log/app.log");
        System.out.println(fh.read());
        // Forgot to close in some flows -> leak risk
    }
}
