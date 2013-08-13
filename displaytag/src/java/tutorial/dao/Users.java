/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial.dao;

import tutorial.model.User;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author hantsy
 */
public class Users {

    static List<User> users = new ArrayList<User>();


    static {
        users.add(new User(1L, "Harry", "Potter"));
        users.add(new User(2L, "Bill", "Gates"));
        users.add(new User(3L, "Steven", "Jobs"));
        users.add(new User(4L, "Bob", "Lee"));
        users.add(new User(5L, "test", "test"));
        users.add(new User(6L, "test2", "test2"));
        users.add(new User(7L, "test3", "test3"));
        users.add(new User(8L, "test4", "test4"));
        users.add(new User(9L, "test5", "test5"));
        users.add(new User(10L, "test6", "test6"));
        users.add(new User(11L, "test7", "test7"));
        users.add(new User(12L, "test8", "test8"));
    }

    public static List<User> getUserList() {
        return users;
    }

    public static void deleteUser(Long id) {
        for (Iterator iterator =users.iterator(); iterator.hasNext();) {
            if (((User) iterator.next()).getId().longValue() == id) {
                iterator.remove();
            }
        }
    }

    public static List<User> subList(int start, int len) {
        if (start + len > users.size()) {
            return users.subList(start, users.size());
        }
        return users.subList(start, start + len);
    }
}
