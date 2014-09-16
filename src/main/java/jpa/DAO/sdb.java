package jpa.DAO;

public class sdb {
    private static sdb ourInstance = new sdb();

    public static sdb getInstance() {
        return ourInstance;
    }

    private sdb() {
    }
}
