/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Message;
import java.util.List;

/**
 *
 * @author linshangzhen
 */
public interface MessageDao {

    void add(Message message);

    void delete(long id);

    List<Message> getAll(long id);
    
}
