package exercise.controller;

import exercise.dto.AuthorDTO;
import exercise.dto.AuthorCreateDTO;
import exercise.dto.AuthorUpdateDTO;
import exercise.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorsController {

    @Autowired
    private AuthorService authorService;

    // BEGIN
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    List<AuthorDTO> index() {
        return authorService.getAll();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    AuthorDTO create(@RequestBody @Valid AuthorCreateDTO authorCreateDTO) {
        return authorService.create(authorCreateDTO);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    AuthorDTO show(@PathVariable Long id) {
        return authorService.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    AuthorDTO update(@RequestBody @Valid AuthorUpdateDTO dto, @PathVariable Long id) {
        return authorService.update(dto, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable Long id) {
        authorService.delete(id);
    }
    // END
}
