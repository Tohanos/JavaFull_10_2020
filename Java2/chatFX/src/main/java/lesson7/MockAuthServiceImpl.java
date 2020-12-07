package lesson7;

import java.util.HashMap;

public class MockAuthServiceImpl implements AuthService{
    private static MockAuthServiceImpl instance;
    private HashMap<String, String> userDao;
    private static String currentUser = "";

    private MockAuthServiceImpl() {
        userDao = new HashMap<>();
        userDao.put("user", "pass");
        currentUser = "user";
    }

    public static MockAuthServiceImpl getInstance() {
        if (instance == null) {
            instance = new MockAuthServiceImpl();
        }
        return instance;
    }

    public static String getCurrentUser() {
        return currentUser;
    }

    @Override
    public void addUser(String name, String pass) {
        userDao.put(name, pass);
        currentUser = name;
    }

    @Override
    public boolean auth(String name, String pass) {

        if (userDao.get(name) != null) {
            currentUser = name;
            return true;
        }
        return false;
    }

}
