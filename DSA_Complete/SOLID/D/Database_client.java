package SOLID.D;

public class Database_client {
    public static void main(String[] args) {
        database d1 = new SQL_database();
        DBA d = new DBA(d1);
        database d2 = new No_sql_database();
        DBA dnosql = new DBA(d2);
    }

}
