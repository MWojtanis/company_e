package company.review.demo.experience.users;

import company.review.demo.experience.users.database.GitHubUser;
import company.review.demo.experience.users.model.UserDTO;
import company.review.demo.experience.users.database.UserEntity;
import company.review.demo.experience.users.database.UsersRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import java.util.NoSuchElementException;


@Service
@AllArgsConstructor
public class UsersService {

    private final UsersRepository usersRepository;
    private final WebClient.Builder webClientBuilder;

    public UserDTO getUser(String login) throws CalculationsDivideByZeroException {
        countUpRequest(login);
        GitHubUser userFromWebsite = getUserFromWebsite(login);

        if(userFromWebsite == null){
            throw new NoSuchElementException();
        }
        if (userFromWebsite.followers == 0) {
            throw new CalculationsDivideByZeroException();
        }
        return new UserDTO(userFromWebsite);
    }

    private GitHubUser getUserFromWebsite(String login) {
        GitHubUser https = webClientBuilder.build()
                .get().uri(
                        uriBuilder -> uriBuilder
                                .scheme("https")
                                .host("api.github.com")
                                .port(-1)
                                .path("/users/{login}")
                                .build(login))
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(GitHubUser.class)
                .onErrorResume(WebClientResponseException.class,
                        ex -> ex.getRawStatusCode() == 404 ? Mono.empty() : Mono.error(ex))
                .block();
        return https;
    }






    private void countUpRequest(String login) {
        UserEntity user = usersRepository.findByLogin(login).orElse(null);
        if (user == null) {
            user = new UserEntity();
            user.login = login;
            user.requestCount = 1L;
        } else {
            user.requestCount = user.requestCount + 1;
        }
        usersRepository.save(user);
    }
}