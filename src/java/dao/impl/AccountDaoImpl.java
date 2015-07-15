package dao.impl;

import dao.AccountDao;
import domain.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.JdbcUtils;

public class AccountDaoImpl implements AccountDao {

    public void add(Account account) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "insert into account(email,name,password) values (?,?,?)";
            st = conn.prepareStatement(sql);
            st.setString(1, account.getEmail());
            st.setString(2, account.getName());
            st.setString(3, account.getPassword());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            JdbcUtils.release(conn, st, rs);
        }

    }

    public Account find(String name, String password) {

        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from account where name=? and password=?";
            st = conn.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, password);
            rs = st.executeQuery();
            if (rs.next()) {
                Account account = new Account();
                account.setId(rs.getLong("id"));
                account.setEmail(rs.getString("email"));
                account.setPassword(rs.getString("password"));
                account.setName(rs.getString("name"));
                return account;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AccountDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            JdbcUtils.release(conn, st, rs);
        }
        return null;
    }

    public boolean find(String name) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from account where name=?";
            st.setString(1, name);
            rs = st.executeQuery();
            if (rs.next()) {
                return true;
            }
            return false;
        } catch (Exception ex) {
            Logger.getLogger(AccountDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            JdbcUtils.release(conn, st, rs);
        }
        return false;
    }

    public void addFollow(long follower, long followee) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "insert into follow(follower,followee) values(?,?)";
            st = conn.prepareStatement(sql);
            st.setLong(1, follower);
            st.setLong(2, followee);
            st.executeUpdate();
        } catch (SQLException ex) {
        } finally {
            JdbcUtils.release(conn, st, rs);
        }
    }

    public void deleteFollow(long follower, long followee) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "delete from follow where follower=? and followee=?";
            st = conn.prepareStatement(sql);
            st.setLong(1, follower);
            st.setLong(2, followee);
            st.executeUpdate();
        } catch (SQLException ex) {
        } finally {
            JdbcUtils.release(conn, st, rs);
        }

    }

    public List<Account> getFolloweeList(long id) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select account.id,account.name from follow left join account on account.id=follow.followee where (follow.follower=? and account.id !=?)";
            st = conn.prepareStatement(sql);
            st.setLong(1, id);
            st.setLong(2, id);
            rs = st.executeQuery();
            List list = new ArrayList();
            while (rs.next()) {
                Account a = new Account();
                a.setId(rs.getLong(1));
                a.setName(rs.getString(2));
                list.add(a);
            }
            
            System.out.println("test_dao");
            
            return list;

        } catch (Exception ex) {
            Logger.getLogger(MessageDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            JdbcUtils.release(conn, st, rs);
        }

        return null;
    }

    public List<Account> getFollowerList(long id) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select account.id,account.name from follow left join account on account.id=follow.follower where (follow.followee=? and account.id !=?)";
            st = conn.prepareStatement(sql);
            st.setLong(1, id);
            st.setLong(2, id);
            rs = st.executeQuery();
            List list = new ArrayList();
            while (rs.next()) {
                Account a = new Account();
                a.setId(rs.getLong(1));
                a.setName(rs.getString(2));
                list.add(a);
            }
            return list;

        } catch (Exception ex) {
            Logger.getLogger(MessageDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            JdbcUtils.release(conn, st, rs);
        }

        return null;
    }
    
    public List<Account> search(String name){
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            Object[] para = new Object[]{"%c%"};
            
            String sql = "select id,name from account where name like '%'||?||'%'";
            st = conn.prepareStatement(sql);
            st.setString(1,name);
            rs = st.executeQuery();
            List list = new ArrayList();
            while (rs.next()) {
                Account a = new Account();
                a.setId(rs.getLong(1));
                a.setName(rs.getString(2));
                list.add(a);
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
