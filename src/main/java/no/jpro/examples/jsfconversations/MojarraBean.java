package no.jpro.examples.jsfconversations;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;

@Named
@ConversationScoped
public class MojarraBean extends AbstractConversationBean {

    public MojarraBean() {
        System.out.println("*** Created MojarraBean");
    }

}
