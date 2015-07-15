package service.impl;

import service.CommentService;
import dao.CommentDao;
import dao.impl.CommentDaoImpl;
import domain.Comment;
import java.util.List;

public class CommentServiceImpl implements CommentService {
    private CommentDao dao = new CommentDaoImpl();
    
    @Override
    public void add(Comment comment){
        dao.add(comment);
    }
    
    @Override
    public void delete(long id){
        dao.delete(id);
    }
    
    @Override
    public List<Comment> CommentList(long id){
        return dao.getAll(id);
    }
}
