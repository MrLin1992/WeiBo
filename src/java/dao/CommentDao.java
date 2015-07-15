package dao;

import domain.Comment;
import java.util.List;

public interface CommentDao {

    void add(Comment comment);

    void delete(long id);

    List<Comment> getAll(long id);
    
}
