package dao;

import domain.Account;
import java.util.List;

public interface AccountDao {

    void add(Account account);

    Account find(String name, String password);

    boolean find(String name);

    public void deleteFollow(long follower, long followee);

    public void addFollow(long follower, long followee);
    
    public List<Account> getFolloweeList(long id);
    
    public List<Account> getFollowerList(long id);
    
    public List<Account> search(String name);

}
