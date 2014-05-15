package no.jpro.examples.jsfconversations;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.inject.Inject;
import java.io.Serializable;

public abstract class AbstractConversationBean implements Serializable {
    @Inject
    private Conversation conversation;

    private String name;

    @PostConstruct
    public void postConstruct() {
        correctConversationHandling();
    }

    private void correctConversationHandling() {
        boolean isTransient = conversation.isTransient();
        System.out.println("*** Conversation is active: " + !isTransient);

        if (isTransient) {
            conversation.begin();
            System.out.println("*** Started conversation :)");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
