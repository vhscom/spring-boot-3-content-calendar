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

  private final List<Content> contentList = new ArrayList<>();

  public ContentCollectionRepository() {
  }

  public List<Content> findAll() {
    return contentList;
  }

  public Optional<Content> findById(Integer id) {
    return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
  }

  public void save(Content content) {
    // Remove content with the same id if it exists. This is to simulate an update operation.
    // In a real-world application, you would use a database to store the content.
    contentList.removeIf(c -> c.id().equals(content.id()));
    contentList.add(content);
  }

  public boolean existsById(Integer id) {
    return contentList.stream().anyMatch(c -> c.id().equals(id));
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
    contentList.add(c);
  }

  public void deleteById(Integer id) {
    contentList.removeIf(c -> c.id().equals(id));
  }
}
