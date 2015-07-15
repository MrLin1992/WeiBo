package service;

import domain.Comment;
import java.util.List;

public interface CommentService {

    List<Comment> CommentList(long id);

    void add(Comment comment);

    void delete(long id);
    
}
