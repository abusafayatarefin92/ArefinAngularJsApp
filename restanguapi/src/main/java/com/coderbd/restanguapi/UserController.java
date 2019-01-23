package com.coderbd.restanguapi;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/users")
public class UserController {

    private List<User> users = new ArrayList();


    UserController() {
        this.users = buildUsers();
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUsers() {
        return this.users;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable("id") Long id) {
        return this.users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }

    @RequestMapping(method = RequestMethod.POST)
    public User saveUser(@RequestBody User user) {
        Long nextId = 0L;
        if (this.users.size() != 0) {
            User lastUser = this.users.stream().skip(this.users.size() - 1).findFirst().orElse(null);
            nextId = lastUser.getId() + 1;
        }

        user.setId(nextId);
        this.users.add(user);
        return user;

    }

    @RequestMapping(method = RequestMethod.PUT)
    public User updateUser(@RequestBody User user) {
        User modifiedUser = this.users.stream().filter(u -> u.getId() == user.getId()).findFirst().orElse(null);
        modifiedUser.setFirstName(user.getFirstName());
        modifiedUser.setLastName(user.getLastName());
        modifiedUser.setEmail(user.getEmail());
        return modifiedUser;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean deleteUser(@PathVariable Long id) {
        User deleteUser = this.users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
        if (deleteUser != null) {
            this.users.remove(deleteUser);
            return true;
        } else  {
            return false;
        }


    }

    List<User> buildUsers() {
        List<User> users = new ArrayList<>();

        User user1 = buildUser(1L, "Rajaul", "Islam", "rajaul@gmail.com");
        User user2 = buildUser(2L, "Shamim", "sarkar", "shamim@gmail.com");
        User user3 = buildUser(3L, "Ruhul", "Amin", "ruhul@gmail.com");
        User user4 = buildUser(4L, "Atik", "Hasan", "atik@gmail.com");
        User user5 = buildUser(5L, "Shabib", "Hasan", "shabib@gmail.com");
        User user6 = buildUser(6L, "Urmi", "Akter", "urmi@gmail.com");
        User user7 = buildUser(7L, "Fahmida", "Akter", "fahmida@gmail.com");

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);
        users.add(user7);

        return users;

    }

    User buildUser(Long id, String fname, String lname, String email) {
        User user = new User();
        user.setId(id);
        user.setFirstName(fname);
        user.setLastName(lname);
        user.setEmail(email);
        return user;
    }

}
