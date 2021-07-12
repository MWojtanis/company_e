package company.review.demo.experience.users.database;

import company.review.demo.experience.users.model.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GitHubUser {
    public Long id;
    public String login;
    public String name;
    public String type;
    public String avatarUrl;
    public Date createdAt;
    public Long publicRepos;
    public Long followers;
}
