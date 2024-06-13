package com.vhsdev.contentcalendar.repository;

import com.vhsdev.contentcalendar.model.Content;
import com.vhsdev.contentcalendar.model.Status;
import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

public interface ContentRepository extends ListCrudRepository<Content, Integer> {

  /**
   * Abstract method to find all content by title containing a keyword.
   * This will be generated as a query method by Spring Data.
   */
  List<Content> findAllByTitleContains(String keyword);

  /**
   * Here we define a custom query method to find all content by status.
   */
  @Query("""
     select * from content where status = :status
   """)
  List<Content> listByStatus(@Param("status") Status status);
}
