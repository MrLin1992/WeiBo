package domain;

import java.util.ArrayList;
import java.util.List;

public class Message {

    private long id;
    private long accountId;
    private String accountName;
    private String content;
    private boolean isDeleted;
    private long forwardMessageId;
    private List<Message> forwardMessageList = new ArrayList();

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setForwardMessageId(long forwardMessageId) {
        this.forwardMessageId = forwardMessageId;
    }

    public long getForwardMessageId() {
        return forwardMessageId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public boolean getIsDeleted() {
        return this.isDeleted;
    }

    public void setForwardMessageList(List<Message> forwardMessageList) {
        this.forwardMessageList = forwardMessageList;
    }

    public List<Message> getForwardMessageList() {
        return forwardMessageList;
    }

}
