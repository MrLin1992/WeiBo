package service;

import domain.Message;
import java.util.List;

public interface MessageService {

    void delete(long id);

    List<Message> homeList(long id);

    void publish(Message message);
    
}
