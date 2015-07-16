package service.impl;

import service.AccountService;
import dao.AccountDao;
import dao.impl.AccountDaoImpl;
import domain.Account;
import exception.AccountExistException;
import java.util.List;
import utils.ServiceUtils;

public class AccountServiceImpl implements AccountService {

    private AccountDao dao = new AccountDaoImpl();

    public void register(Account account) throws AccountExistException {
        boolean isRegisterd = dao.find(account.getName());
        if (isRegisterd) {
            throw new AccountExistException();
        } else {
            account.setPassword(ServiceUtils.md5(account.getPassword()));
            dao.add(account);
            Account temp = dao.find(account.getName(),account.getPassword());
            dao.addFollow(temp.getId(), temp.getId());
        }
    }

    public Account login(String name, String password) {
        password = ServiceUtils.md5(password);
        return dao.find(name, password);
 
    }
    
    public List<Account> followeeList(long id){
        
        
        return dao.getFolloweeList(id);       
    }
    
    public List<Account> followerList(long id){
        return dao.getFollowerList(id);       
    }
    
    public void addFollow(long follower, long followee){
        dao.addFollow(follower, followee);
    }
    
    public void deleteFollow(long follower, long followee){
        dao.deleteFollow(follower, followee);
    }
    
    public List<Account> search(String name,long id){
        return dao.search(name,id);
    }
    
    public boolean isFollowed(long id1,long id2){
        return dao.isFollowed(id1, id2);
    }

}
