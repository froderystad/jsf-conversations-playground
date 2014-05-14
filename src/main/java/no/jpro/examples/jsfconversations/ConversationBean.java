package no.jpro.examples.jsfconversations;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named("helloBean")
@ConversationScoped
public class ConversationBean implements Serializable {
    @Inject
    private Conversation conversation;

    private String name;

    public ConversationBean() {
        System.out.println("*** Created ConversationBean");
    }

    @PostConstruct
    public void postConstruct() {
        //wrongConversationHandling();
        correctConversationHandling();
    }

    private void wrongConversationHandling() {
        if (!conversation.isTransient()) {
            conversation.end();
        }
        conversation.begin();
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
