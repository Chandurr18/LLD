/**
 * FileHandle (Problem)
 * Client directly opens file handles and must manage lifecycle; risk of leaks.
 */
public class FileHandle {
    private final String path;
    public FileHandle(String path) {
        this.path = path;
        System.out.println("[FileHandle] Opening file: " + path);
    }
    public String read() {
        System.out.println("[FileHandle] Reading file: " + path);
        return "content:" + path;
    }
    public void close() {
        System.out.println("[FileHandle] Closing file: " + path);
    }
}
