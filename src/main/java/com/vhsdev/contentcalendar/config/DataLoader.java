package com.vhsdev.contentcalendar.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vhsdev.contentcalendar.repository.ContentRepository;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!production")
@Component
public class DataLoader implements CommandLineRunner {

  private final ContentRepository repository;
  private final ObjectMapper objectMapper;

  public DataLoader(ContentRepository repository, ObjectMapper objectMapper) {
    this.repository = repository;
    this.objectMapper = objectMapper;
  }

  @Override
  public void run(String... args) throws IOException {
    if (repository.count() == 0) {
      try (InputStream inputStream = TypeReference.class.getResourceAsStream(
          "/data/content.json")) {
        repository.saveAll(objectMapper.readValue(inputStream, new TypeReference<>() {
        }));
      }
    }
  }
}
