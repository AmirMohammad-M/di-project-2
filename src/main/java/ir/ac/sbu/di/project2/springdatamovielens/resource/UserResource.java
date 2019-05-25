package ir.ac.sbu.di.project2.springdatamovielens.resource;

import ir.ac.sbu.di.project2.springdatamovielens.dto.UserDto;
import ir.ac.sbu.di.project2.springdatamovielens.model.User;
import ir.ac.sbu.di.project2.springdatamovielens.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rest/neo4j/user")
public class UserResource {

    @Autowired
    UserService userService;

    @PostMapping(consumes = {"application/JSON"})
    public String create(@RequestBody UserDto user) {
        if (userService.find(user.getUsername()) == null) {
            userService.create(new User(user.getUsername(), user.getPassword(), user.getName(), user.getAge()));
            return "redirect:/" + user.getUsername();
        }
        return null;
    }

    @GetMapping(value = "/{username}", produces = {"application/JSON"})
    public UserDto findOneUser(@PathVariable("username") String username) {
        User user = userService.find(username);
        return new UserDto(user.getUsername(), user.getPassword(), user.getName(), user.getAge());
    }

}
