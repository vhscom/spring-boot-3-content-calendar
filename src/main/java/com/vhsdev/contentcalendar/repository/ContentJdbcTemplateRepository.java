package com.vhsdev.contentcalendar.repository;

import com.vhsdev.contentcalendar.model.Content;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ContentJdbcTemplateRepository {

  private final JdbcTemplate jdbcTemplate;

  public ContentJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  private static Object mapRowToContent(ResultSet rs, int rowNum) throws SQLException {
    return new Content(
        rs.getInt("id"),
        rs.getString("title"),
        rs.getString("description"),
        rs.getString("status"),
        rs.getString("type"),
        rs.getTimestamp("date_created").toLocalDateTime(),
        rs.getTimestamp("date_updated").toLocalDateTime(),
        rs.getString("url")
    );
  }

  public List<Content> getAllContent() {
    var sql = "SELECT * FROM content";
    List<Content> contentList = jdbcTemplate.query(sql, ContentJdbcTemplateRepository::mapRowToContent);
    return contentList;
  }

  public void createContent(Content content) {
    var sql = "INSERT INTO content (title, description, status, type, date_created, date_updated, url) VALUES (?, ?, ?, ?, ?, ?, ?)";
    jdbcTemplate.update(
        sql,
        content.title(),
        content.description(),
        content.status().name(),
        content.contentType().name(),
        content.dateCreated(),
        content.dateUpdated(),
        content.url()
    );
  }

  public void updateContent(Content content) {
    var sql = "UPDATE content SET title = ?, description = ?, status = ?, type = ?, date_created = ?, date_updated = ?, url = ? WHERE id = ?";
    jdbcTemplate.update(
        sql,
        content.title(),
        content.description(),
        content.status().name(),
        content.contentType().name(),
        content.dateCreated(),
        content.dateUpdated(),
        content.url(),
        content.id()
    );
  }

  public void deleteContent(Integer id) {
    var sql = "DELETE FROM content WHERE id = ?";
    jdbcTemplate.update(sql, id);
  }

  public Content getContentById(Integer id) {
    var sql = "SELECT * FROM content WHERE id = ?";
    // This is using a deprecated method. It is just for demonstration purposes.
    Content content = (Content) jdbcTemplate.queryForObject(sql, new Object[]{id}, ContentJdbcTemplateRepository::mapRowToContent);
    return content;
  }
}
