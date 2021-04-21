package by.chernyavski.springsecurity.rest;

import by.chernyavski.springsecurity.model.Developer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/developers")
public class DeveloperRestControllerV1 {

    private final List<Developer> DEVELOPERS = List.of(
            new Developer(1L, "Vlad", "Vladov"),
            new Developer(2L, "Vladik", "Vladov"),
            new Developer(3L, "Vlados", "Vladov")
    );

    @GetMapping
    public List<Developer> getAll() {
        return DEVELOPERS;
    }

    @GetMapping("/{id}")
    public Developer getById(@PathVariable Long id) {
        return DEVELOPERS.stream()
                .filter(d -> d.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

}
