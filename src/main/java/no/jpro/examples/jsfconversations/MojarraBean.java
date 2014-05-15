package no.jpro.examples.jsfconversations;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ConversationScoped
public class MojarraBean implements Serializable {
    @Inject
    private Conversation conversation;

    private String name;

    public MojarraBean() {
        System.out.println("*** Created MojarraBean");
    }

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
