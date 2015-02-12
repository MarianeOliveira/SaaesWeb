/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.saaes.app.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class JsfUtil {

    /**
     * @deprecated @param entities
     * @param selectOne
     * @return
     */

    public static boolean isValidationFailed() {
        return FacesContext.getCurrentInstance().isValidationFailed();
    }

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
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_WARN, msg, msg);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }


    public static void addErrorMessage(String sumary, String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, sumary, msg);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    public static void addSuccessMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
        FacesContext.getCurrentInstance().addMessage("Operação Completada com Sucesso.", facesMsg);
    }

    public static String getRequestParameter(String key) {
        return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(key);
    }

    public static Object getRequestAttribute(String key) {
        return JsfUtil.getCurrentHttpServletRequest().getAttribute(key);
    }

    public static Object getObjectFromRequestParameter(String requestParameterName, Converter converter, UIComponent component) {
        String id = JsfUtil.getRequestParameter(requestParameterName);
        return converter.getAsObject(FacesContext.getCurrentInstance(), component, id);
    }

    public static HttpServletRequest getCurrentHttpServletRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    }

    public static HttpServletResponse getCurrentHttpServletResponse() {
        return (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
    }

    public static EntityManager getEm() {
        return (EntityManager) JsfUtil.getRequestAttribute("em");
    }

    public static void log(Object object) {
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        System.out.println(methodName + ": " + object);
    }

    public static HttpSession getSession() {
        return JsfUtil.getCurrentHttpServletRequest().getSession();
    }

    public static Object getHttpSessionAttribute(String key) {
        return JsfUtil.getSession().getAttribute(key);
    }

    public static void redirectOutcome(String outcome) throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext extContext = context.getExternalContext();
        String url = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context, outcome));
        extContext.redirect(url);
    }

    public static String getURLWithContextPath() {
        HttpServletRequest request = JsfUtil.getCurrentHttpServletRequest();
        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }

    public static void redirect(String domain, String uri) throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect(String.format("%s/%s", domain, uri));
    }

    public static Boolean validarNumeroInteiro(String numero) {

        Pattern pattern;
        Matcher matcher;
        String PATTERN_NUMERO = "^\\d+$";

        try {

            pattern = Pattern.compile(PATTERN_NUMERO);
            matcher = pattern.matcher(numero.trim());

            if (matcher.matches()) {
                return matcher.matches();
            } else {
                return false;
            }

        } catch (Exception e) {
            throw new ExceptionInInitializerError("Error  Valor Invalido   " + e.getLocalizedMessage());
        }
    }//numero Valido.

    //verifique se uma String está vazia.
    public static Boolean stringIsEmpty(String string) {
        if (!string.trim().isEmpty() || !string.equals("") || !string.contains("") || string.trim().length() < 2) {
            return true;
        }
        return false;
    }

    public static Object getObjetoEL(Class<?> clazz, String nome) {
        FacesContext fc = FacesContext.getCurrentInstance();
        return clazz.cast(fc.getApplication().getELResolver().getValue(fc.getELContext(), null, nome));

    }

}

