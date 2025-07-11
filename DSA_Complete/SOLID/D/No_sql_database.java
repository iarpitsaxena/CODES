package SOLID.D;

public class No_sql_database implements database{
    @Override
    public int save() {
        // Implementation for saving data in a NoSQL database
        System.out.println("Data saved in NoSQL database.");
        return 0;
    }
}
