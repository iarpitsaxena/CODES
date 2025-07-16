package SOLID;


public class Singleton {

    // Eager Way

    /*private static Singleton s = new Singleton();

    private Singleton(){}

    public static Singleton getS(){
        return s;
    }*/

    //lazy way
    /*private static Singleton s;
    private Singleton() {}
    public static Singleton getSingleton() {
        if (s == null) {
            s = new Singleton();
        }
        return s;
    }*/

   /* //synchronized
    private static Singleton s;
    private Singleton() {}
    synchronized public static Singleton getSingleton() {
        if (s == null) {
            s = new Singleton();
        }
        return s;
    }*/


    //double checked locking
    /*private static Singleton s;
    private Singleton() {}
    public static Singleton getSingleton() {
        if (s == null) {
            synchronized(Singleton.class)){
                if (s == null) {
                    s = new Singleton();
                }
            }
        }
        return s;
    }*/

    //volatile keyword
    // volatile keyword ensures that the variable is read from and written to main memory, not from the thread's local cache.
    // This prevents issues with visibility and ensures that changes made by one thread are visible to others.
    // It is used to ensure that the singleton instance is always read from the main memory, preventing stale data issues.
    // It is particularly useful in a multi-threaded environment where multiple threads may access the singleton instance concurrently.
    // It ensures that the instance is created only once and is visible to all threads.
    // It is a way to ensure thread safety without using synchronized blocks, which can be more efficient.
    // However, it is important to note that volatile does not provide atomicity, so the double-checked locking pattern is still necessary.
    private static volatile Singleton s;//changes directly in the memory

    private Singleton() {
        if(s!= null){
            throw new RuntimeException("bklol exception ban chuka hai");
        }
    }

    public static Singleton getSingleton() throws Exception{
        if (s == null) {
            synchronized (Singleton.class) {
                if (s == null) {
                    s = new Singleton();
                }
            }
        }
        return s;
    }
    public Object readResolve(){
        return s;
    }
}

    // Bill Pugh Singleton Design Pattern
    // This approach uses a static inner class to hold the singleton instance.
    // The inner class is not loaded into memory until it is referenced, which means the singleton instance is created only when it is needed.
    // This is a thread-safe way to implement the singleton pattern without using synchronized blocks.
    // it is not important and should not be discussed in the interview.
    /*private Singleton() {
    }
    private class Singleton_create{
        //static Singleton s = new Singleton();
        private static final Singleton s = new Singleton();
    }
    public static Singleton getSingleton() {
        return Singleton_create.s;
    }
}*/



