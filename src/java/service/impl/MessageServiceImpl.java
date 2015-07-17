package service.impl;

import dao.MessageDao;
import dao.impl.MessageDaoImpl;
import domain.Message;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.MessageService;

public class MessageServiceImpl implements MessageService {

    private MessageDao dao = new MessageDaoImpl();

    @Override
    public void publish(Message message) {
        dao.add(message);
    }

    @Override
    public void delete(long id) {
        dao.delete(id);
    }

    public List<Message> userList(long id) {
        List<Message> tempList = dao.userList(id);
        List<Message> newList = new ArrayList();

        for (int i = 0; i < tempList.size(); i++) {
            Message m1 = tempList.get(i);
            long forwardId = m1.getForwardMessageId();
            while (forwardId != 0) {
                Message m2 = dao.find(forwardId);
                List<Message> listtest = m1.getForwardMessageList();
                m1.getForwardMessageList().add(m2);
                forwardId = m2.getForwardMessageId();
            }
            newList.add(m1);
        }
        return newList;
    }

    public void forward(Message message) {
        dao.Forward(message);
    }

    @Override
    public List<Message> homeList(long id) {
        List<Message> tempList = dao.getAll(id);
        List<Message> newList = new ArrayList();

        for (int i = 0; i < tempList.size(); i++) {
            Message m1 = tempList.get(i);
            long forwardId = m1.getForwardMessageId();
            while (forwardId != 0) {
                Message m2 = dao.find(forwardId);
                m1.getForwardMessageList().add(m2);
                forwardId = m2.getForwardMessageId();
            }
            newList.add(m1);
        }
        return newList;
    }
    
    public Message find(long id){
        Message tempMessage = dao.find(id);
        long forwardId = tempMessage.getForwardMessageId();
        while (forwardId != 0) {
                Message m2 = dao.find(forwardId);
                tempMessage.getForwardMessageList().add(m2);
                forwardId = m2.getForwardMessageId();
            }
        return tempMessage;
    }
}
