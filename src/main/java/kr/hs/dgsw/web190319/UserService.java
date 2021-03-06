package kr.hs.dgsw.web190319;

import java.util.List;

public interface UserService {
    List<User> list();
    User view(int id);
    boolean add(User user);
    User update(User user);
    boolean delete(int id);
}
