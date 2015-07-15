package dao.impl;



import dao.CommentDao;
import domain.Comment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.JdbcUtils;

public class CommentDaoImpl implements CommentDao{


    @Override
    public void add(Comment comment) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "insert into comment (message_id,account_id,content) values (?,?,?)";
            st = conn.prepareStatement(sql);
            st.setLong(1, comment.getMessageId());
            st.setLong(2, comment.getAccountId());
            st.setString(3, comment.getContent());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MessageDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            JdbcUtils.release(conn, st, rs);
        }
    }

   
    @Override
    public void delete(long id) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "update comment set is_deleted=true where id=?";
            st = conn.prepareStatement(sql);
            st.setLong(1, id);
            st.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(MessageDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            JdbcUtils.release(conn, st, rs);
        }
    }

  
    @Override
    public List<Comment> getAll(long id) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select comment.id,account.name,comment.content,comment.message_id,comment.account_id,comment.is_deleted from comment left join account on account.id=comment.account_id where comment.message_id=?";
            st = conn.prepareStatement(sql);
            st.setLong(1, id);
            rs = st.executeQuery();
            List list = new ArrayList();
            while (rs.next()) {
                Comment c = new Comment();
                c.setId(rs.getLong(1));
                c.setAccountName(rs.getString(2));
                c.setContent(rs.getString(3));    
                c.setMessageId(rs.getLong(4));
                c.setAccountId(rs.getLong(5));
                             
                if (!rs.getBoolean(6)) {
                    list.add(c);
                }
            }
            return list;
        } catch (Exception ex) {
            Logger.getLogger(MessageDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            JdbcUtils.release(conn, st, rs);
        }
        return null;
    }
}
