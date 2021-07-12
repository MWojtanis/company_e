package company.review.demo.experience.users.model;


import company.review.demo.experience.users.database.GitHubUser;

import java.util.Date;

public class UserDTO {
    public Long id;
    public String login;
    public String name;
    public String type;
    public String avatarUrl;
    public Date createdAt;
    public double calculations;

    public UserDTO(GitHubUser downloadedUser) {
        id = downloadedUser.id;
        login = downloadedUser.login;
        name = downloadedUser.name;
        type = downloadedUser.type;
        avatarUrl = downloadedUser.avatarUrl;
        createdAt = downloadedUser.createdAt;
        calculations = calculateStuff(downloadedUser);
    }

    private double calculateStuff(GitHubUser downloadedUser) {
        double out = 0;
        var followers = downloadedUser.followers != null ? downloadedUser.followers.doubleValue() : 0;
        var publicRepos = downloadedUser.publicRepos != null ? downloadedUser.publicRepos.doubleValue() : 0;
        out = 6 / followers * (2 + publicRepos);
        return out;
    }
}
