package DesignPatterns.CreationalPattern.Singleton.Solution;

/*
 * Similar to eager initialization but instance is created in static block
 */
public class DatabaseConnectionStaticBlock {
    private static DatabaseConnectionStaticBlock instance;

    private DatabaseConnectionStaticBlock() {
        System.out.println("Satic Block DB connection established.");
    }

    static{
        try{
            instance = new DatabaseConnectionStaticBlock();
        }
        catch(Exception e){
            System.out.println("Unable to establish Static Block DB connection." + e);
        }
    }

    public static DatabaseConnectionStaticBlock getInstance(){
        return instance;
    }

    public void query(String sql) {
        System.out.println("LAZY executing: " + sql);
    }
}
