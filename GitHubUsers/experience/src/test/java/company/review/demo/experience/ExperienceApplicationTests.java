package company.review.demo.experience;

import company.review.demo.experience.users.CalculationsDivideByZeroException;
import company.review.demo.experience.users.model.UserDTO;
import company.review.demo.experience.users.UsersService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ExperienceApplicationTests {

    @Autowired
    private UsersService userService;

    @Test
    public void checkFlowUserExistInGitHub() throws CalculationsDivideByZeroException {
        //Linux author shouldn't have 0 followers :)
        UserDTO linuxAuthor = userService.getUser("torvalds");
        Assert.assertEquals(1024025, linuxAuthor.id, 0);
    }
}
