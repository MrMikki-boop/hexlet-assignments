package exercise;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import exercise.model.Post;

@SpringBootApplication
@RestController
public class Application {
    // Хранилище добавленных постов
    private List<Post> posts = Data.getPosts();

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // BEGIN
    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getAllPosts() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Total-Count", String.valueOf(posts.size()));
        return ResponseEntity.ok().headers(headers).body(posts);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> getPost(@PathVariable String id) {
        Optional<Post> maybePost = posts.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();

        return maybePost.map(post -> ResponseEntity.ok().body(post))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/posts")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        posts.add(post);
        URI location = URI.create("/posts/" + post.getId());
        return ResponseEntity.created(location).body(post);
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable String id, @RequestBody Post data) {
        Optional<Post> maybePost = posts.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();

        return maybePost.map(post -> {
            post.setTitle(data.getTitle());
            post.setBody(data.getBody());
            return ResponseEntity.ok().body(post);
        }).orElseGet(() -> ResponseEntity.noContent().build());
    }
    // END

    @DeleteMapping("/posts/{id}")
    public void destroy(@PathVariable String id) {
        posts.removeIf(p -> p.getId().equals(id));
    }
}
