package com.vhsdev.contentcalendar.repository;

import com.vhsdev.contentcalendar.model.Content;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
}
