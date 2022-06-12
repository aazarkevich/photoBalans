package photoBalans.dao;

import photoBalans.models.User;

public interface UserDao {
    User findByUsername(String username);
}
