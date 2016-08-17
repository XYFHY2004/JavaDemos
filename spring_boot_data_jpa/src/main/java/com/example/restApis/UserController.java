package com.example.restApis;

import org.springframework.web.bind.annotation.*;

import java.util.*;

import com.example.entities.User;

/**
 * Created by xyfhy on 16/7/28.
 */

//@RestController
//@RequestMapping("users")
public class UserController {
//    private static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());
//
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public List<User> getUserList(){
//        List<User> userList = new ArrayList<User>(users.values());
//        return userList;
//    }
//
//    @RequestMapping(value = "/", method = RequestMethod.POST)
//    public String postUser(@ModelAttribute User user){
//        users.put(user.getId(), user);
//        return "success";
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public User getUser(@PathVariable Long id){
//        return users.get(id);
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//    public String putUser(@PathVariable Long id, @ModelAttribute User user){
//        User u = users.get(id);
//        u.setName(user.getName());
//        u.setAge(user.getAge());
//        users.put(id, u);
//        return "success";
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    public String deleteUser(@PathVariable Long id){
//        users.remove(id);
//        return "success";
//
//    }

}
