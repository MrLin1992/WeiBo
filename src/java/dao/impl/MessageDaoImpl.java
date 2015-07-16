package dao.impl;


import dao.MessageDao;
import domain.Message;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.JdbcUtils;

public class MessageDaoImpl implements MessageDao  {

  
    @Override
    public void add(Message message) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "insert into message (account_id,content) values (?,?)";
            st = conn.prepareStatement(sql);
            st.setLong(1, message.getAccountId());
            st.setString(2, message.getContent());
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
            String sql = "update message set is_deleted=true where id=?";
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
    public List<Message> getAll(long id) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select account.name,message.content,account.id,message.id,message.forward_message_id,message.is_deleted from account right join follow on account.id=follow.followee right join message on follow.followee=message.account_id where follow.follower=? order by message.id DESC";
            st = conn.prepareStatement(sql);
            st.setLong(1, id);
            rs = st.executeQuery();
            List list = new ArrayList();
            while (rs.next()) {
                Message m = new Message();
                m.setAccountName(rs.getString(1));
                m.setContent(rs.getString(2));
                m.setAccountId(rs.getLong(3));
                m.setId(rs.getLong(4));
                m.setForwardMessageId(rs.getLong(5));
                
                if (!rs.getBoolean(6)) {
                    list.add(m);
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
    
      
    public List<Message> userList(long id) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select id,content,is_deleted from message where account_id =? order by id DESC";
            st = conn.prepareStatement(sql);
            st.setLong(1, id);
            rs = st.executeQuery();
            List list = new ArrayList();
            while (rs.next()) {
                Message m = new Message();
                m.setId(rs.getLong(1));
                m.setContent(rs.getString(2));
                if (!rs.getBoolean(3)) {
                    list.add(m);
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
    
    public Message find(long id){
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql="select message.id,message.account_id,account.name,message.content,message.forward_message_id from account right join message on account.id=message.account_id where message.id=?";
            st = conn.prepareStatement(sql);
            st.setLong(1, id);
            rs = st.executeQuery();
            Message m = new Message();
            if(rs.next()) {                
                m.setId(rs.getLong(1));
                m.setAccountId(rs.getLong(2));
                m.setAccountName(rs.getString(3));
                m.setContent(rs.getString(4));
                m.setForwardMessageId(rs.getLong(5));
            }
            return m;
        } catch (Exception ex) {
            Logger.getLogger(MessageDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            JdbcUtils.release(conn, st, rs);
        }
        return null;
    }
    
    public void Forward(Message message) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "insert into message (account_id,content,forward_message_id) values (?,?,?)";
            st = conn.prepareStatement(sql);
            st.setLong(1, message.getAccountId());
            st.setString(2, message.getContent());
            st.setLong(3, message.getForwardMessageId());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MessageDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            JdbcUtils.release(conn, st, rs);
        }
    }
}
