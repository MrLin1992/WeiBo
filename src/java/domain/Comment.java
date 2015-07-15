package domain;

public class Comment {

    private long id;
    private long messageId;
    private long accountId;
    private String accountName;
    private String content;
    private boolean isDeleted;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public long getMessageId() {
        return messageId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setIsDeletad(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public boolean getIsDeletad() {
        return isDeleted;
    }
    
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountName() {
        return accountName;
    }
}
