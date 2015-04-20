package br.com.saaes.app.util;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JsfUtil {

 

    public static void addErrorMessage(Exception ex, String defaultMsg) {
        String msg = ex.getLocalizedMessage();
        if (msg != null && msg.length() > 0) {
            addErrorMessage(msg);
        } else {
            addErrorMessage(defaultMsg);
        }
    }

    public static void addErrorMessages(List<String> messages) {
        for (String message : messages) {
            addErrorMessage(message);
        }
    }

    public static void addErrorMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    /**
     * Formata mensagens de erro como lista numerada
     *
     * @param msgList
     */
    public static void addValidationMessages(List<String> msgList) {
        int i = 1;
        List<String> newMsgList = new ArrayList<>();
        for (String m : msgList) {
            newMsgList.add(String.format("%d. %s", i++, m));
        }
        JsfUtil.addErrorMessages(newMsgList);
    }

    public static void addInfoMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    public static void addAlertMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção!", msg);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    public static void addErrorMessage(String sumary, String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, sumary, msg);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    public static void addSuccessMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", msg);
        FacesContext.getCurrentInstance().addMessage("Operação Completada com Sucesso.", facesMsg);
    }

    public static HttpServletRequest getCurrentHttpServletRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    }

    public static HttpServletResponse getCurrentHttpServletResponse() {
        return (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
    }


    

}
