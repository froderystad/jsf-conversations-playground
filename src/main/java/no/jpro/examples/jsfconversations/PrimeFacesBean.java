package no.jpro.examples.jsfconversations;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;

@Named
@ConversationScoped
public class PrimeFacesBean extends AbstractConversationBean {

    public PrimeFacesBean() {
        System.out.println("*** Created PrimeBean");
    }

    public String welcome() {
        System.out.println("*** Controller greets " + getName());
        return "pWelcome";
    }
}
