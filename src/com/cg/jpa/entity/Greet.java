package com.cg.jpa.entity;

import javax.persistence.*;

@Entity
@Table(name="greet")
public class Greet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "message_id_gen")
    @Column(name = "messageid")
    private int messageId;
    @Column(name = "message")
    private String message;

    public Greet() {
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
