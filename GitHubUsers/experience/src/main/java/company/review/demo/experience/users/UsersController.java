package company.review.demo.experience.users;
import company.review.demo.experience.users.model.UserDTO;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
public class UsersController {

    private final UsersService userService;

    public UsersController(UsersService postService) {
        this.userService = postService;
    }

    @CrossOrigin
    @GetMapping("/api/users/{login}")
    public UserDTO index(@PathVariable(value="login") String login) throws CalculationsDivideByZeroException {
        return userService.getUser(login);
    }

    @ExceptionHandler({ NoSuchElementException.class })
    public String handleException() {
        return "That login doesn't exist.";
    }

    @ExceptionHandler({ CalculationsDivideByZeroException.class })
    public String handleCustomException() {
        return "Calculations for that user can't be done.";
    }


}
