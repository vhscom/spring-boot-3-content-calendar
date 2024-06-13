package com.vhsdev.contentcalendar.repository;

import com.vhsdev.contentcalendar.model.Content;
import java.util.List;
import org.springframework.data.repository.ListCrudRepository;

public interface ContentRepository extends ListCrudRepository<Content, Integer> {

  /**
   * Abstract method to find all content by title containing a keyword.
   * This will be generated as a query method by Spring Data.
   */
  List<Content> findAllByTitleContains(String keyword);
}
