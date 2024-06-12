package com.vhsdev.contentcalendar.repository;

import com.vhsdev.contentcalendar.model.Content;
import com.vhsdev.contentcalendar.model.Status;
import com.vhsdev.contentcalendar.model.Type;
import jakarta.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class ContentCollectionRepository {

  private final List<Content> content = new ArrayList<>();

  public ContentCollectionRepository() {
  }

  public List<Content> findAll() {
    return content;
  }

  public Optional<Content> findById(Integer id) {
    return content.stream().filter(c -> c.id().equals(id)).findFirst();
  }

  @PostConstruct
  private void init() {
    Content c = new Content(
        1,
        "Spring Boot",
        "Spring Boot is a Java framework",
        Status.PUBLISHED,
        Type.ARTICLE,
        LocalDateTime.now(),
        null,
        "https://spring.io/projects/spring-boot"
    );
    content.add(c);
  }
}
