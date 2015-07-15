package service.impl;

import dao.MessageDao;
import dao.impl.MessageDaoImpl;
import domain.Message;
import java.util.List;
import service.MessageService;

public class MessageServiceImpl implements MessageService {
    
    private MessageDao dao = new MessageDaoImpl();
    
    @Override
    public void publish(Message message){
        dao.add(message);
    }
    
    @Override
    public void delete(long id){
        dao.delete(id);
    }
    
    @Override
    public List<Message> homeList(long id){
        return dao.getAll(id);
    }
   
}
