package DesignPatterns.CreationalPattern.Singleton;
public class Main {
    // 1. Eager Initialization
    public class Eager{
        private Eager(){}

        private Eager instance = new Eager();

        public Eager getInstance(){
            return instance;
        }
    }

    //2. Lazy Loading
    public class Lazy{
        private Lazy(){}
        private Lazy instance;

        public Lazy getIstance(){
            if(instance == null) instance = new Lazy();

            return instance;
        }
    }

    //3. Thread-safe
    static class ThreadSafe{
        private ThreadSafe(){}

        private static ThreadSafe instance;

        public static synchronized ThreadSafe  getInstance(){
            if(instance == null){
                instance = new ThreadSafe();
            }
            return instance;
        }
    }

    // 4. Double Locking
    static class DoubleLocking{
        private DoubleLocking(){}

        private static volatile DoubleLocking instance;

        public static DoubleLocking getInstance(){
            if(instance == null){
                synchronized(DoubleLocking.class){
                    if(instance == null) instance = new DoubleLocking();
                }
            }
            return instance;
        }
    }

    // 5. Bill Pugh
    static class BillPugh{
        private BillPugh(){}

        private static class Holder{
            private static final BillPugh INSTANCE = new BillPugh();
        }

        public static BillPugh getInstance(){
            return Holder.INSTANCE;
        }
    }

    // 6. static block Initialization
    static class StaticBlock{
        private StaticBlock(){}

        private static StaticBlock instance;

        static{
            try {
                if(instance == null) instance = new StaticBlock();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

        public static StaticBlock getInstance(){
            return instance;
        }
    }

    // 7. Enum Singleton
    enum Singleton{
        INSTANCE;

        public String doSomething(){
            return "Doing....";
        }
    }
}
