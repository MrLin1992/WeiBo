package service;

import domain.Account;
import exception.AccountExistException;
import java.util.List;

public interface AccountService {

    Account login(String name, String password);

    void register(Account account) throws AccountExistException;
    
    public List<Account> followeeList(long id);
    
    public List<Account> followerList(long id);
    
    public List<Account> search(String name,long id);
    
    public boolean isFollowed(long id1,long id2);
    
    public void addFollow(long follower, long followee);
    
    public void deleteFollow(long follower, long followee);
    
}
