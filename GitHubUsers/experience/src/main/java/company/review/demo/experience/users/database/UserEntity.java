package company.review.demo.experience.users.database;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "githubusers")
public class UserEntity {

    @Id
    @Column(length = 40, name = "LOGIN")
    public String login;

    @Column(name = "REQUEST_COUNT")
    public Long requestCount;

}
