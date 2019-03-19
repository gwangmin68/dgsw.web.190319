package kr.hs.dgsw.web190319;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    List<User> userList;

    UserServiceImpl(){
        userList = new ArrayList<>();

        this.userList.add(new User(1, "user1", "user111@dgsw"));
        this.userList.add(new User(2, "user2", "user222@dgsw"));
        this.userList.add(new User(3, "user3", "user333@dgsw"));
    }

    @Override
    public List<User> list() {
        return this.userList;
    }

    @Override
    public User view(int id) {
        for(User user : userList){
            if(user.getId() == id)
                return user;
        }
        return null;
    }

    @Override
    public boolean add(User user) {//중복체크 하기
        if(this.view(user.getId()) == null){
            return this.userList.add(user);
        }
        return false;
    }

    @Override
    public User update(User user) {
        User found = this.view(user.getId());
        if(found != null){
            found.setName((user.getName()));
            found.setEmail(user.getEmail());
        }
        return found;
    }

    @Override
    public boolean delete(int id) {
        User found = this.view(id);
        return this.userList.remove(found);
    }

    public User find1(String name){
        Iterator<User> iterator = this.userList.iterator();
        while(iterator.hasNext()){
            User found = iterator.next();
            if(found.getName().equals(name))
                return found;
        }
        return null;
    }

    public User find2(String name){
        for(int i = 0;i < userList.size();i++){
            User found = userList.get(i);
            if(found.getName().equals(name))
                return found;
        }
        return null;
    }

    public User find3(String name){
        User found = this.userList.stream()
                .filter(user -> user.getName().equals(name))
                .findAny()
                .orElse(null);
        return found;
    }
}
