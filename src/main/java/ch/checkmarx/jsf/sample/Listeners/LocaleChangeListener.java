package ch.checkmarx.jsf.sample.Listeners;

import ch.checkmarx.jsf.sample.LocaleBean;

import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

public class LocaleChangeListener implements ValueChangeListener {

    @Override
    public void processValueChange(ValueChangeEvent event)
            throws AbortProcessingException {

        //access country bean directly
        LocaleBean userData = (LocaleBean) FacesContext.getCurrentInstance().
                getExternalContext().getSessionMap().get("localeData");
        userData.setSelectedCountry(event.getNewValue().toString());
    }
}