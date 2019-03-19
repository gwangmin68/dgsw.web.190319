package kr.hs.dgsw.web190319;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController{

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/user")
    @ResponseBody
    public List<User> list(){
        return userService.list();
    }

    @GetMapping("/user/{id}")
    @ResponseBody
    public User view(@PathVariable int id){
        return this.userService.view(id);
    }

    @PostMapping("/user")
    @ResponseBody
    public boolean add(@RequestBody User user){
        return this.userService.add(user);
    }

    @PutMapping("/user")
    @ResponseBody
    public User update(@RequestBody User user){
        return this.userService.update(user);
    }

    @DeleteMapping("/user/{id}")
    @ResponseBody
    public boolean delete(@PathVariable int id){
        return this.userService.delete(id);
    }
}
// CRUD Create Read   Update Delete
// SQL  insert select update delete
// HTTP POST   GET    PUT    DELETE