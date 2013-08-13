/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.controller.FlashScope;
import net.sourceforge.stripes.validation.BooleanTypeConverter;
import net.sourceforge.stripes.validation.DateTypeConverter;
import net.sourceforge.stripes.validation.EmailTypeConverter;
import net.sourceforge.stripes.validation.SimpleError;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidateNestedProperties;
import net.sourceforge.stripes.validation.ValidationErrorHandler;
import net.sourceforge.stripes.validation.ValidationErrors;
import net.sourceforge.stripes.validation.ValidationMethod;

/**
 *
 * @author hantsy
 */
public class RegisterActionBean extends BaseActionBean implements ValidationErrorHandler {

    @Validate(required = true, mask = "[0-9a-zA-Z]{6,20}")
    private String username;
    @Validate(required = true, minlength = 6, maxlength = 20, mask = "[0-9a-zA-Z]+")
    private String password;
    @Validate(required = true, converter = EmailTypeConverter.class)
    private String email;
    @Validate(required = true, expression = "this eq password")
    private String confirmPassword;
    @Validate(converter = DateTypeConverter.class)
    Date birthDate;
    @Validate(converter = BooleanTypeConverter.class)
    boolean subscriptionEnabled;
    @ValidateNestedProperties({
        @Validate(field = "zipcode", required = true),
        @Validate(field = "addressLine1", required = true),
        @Validate(field = "addressLine2", required = true)
    })
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isSubscriptionEnabled() {
        return subscriptionEnabled;
    }

    public void setSubscriptionEnabled(boolean subscriptionEnabled) {
        this.subscriptionEnabled = subscriptionEnabled;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Resolution register() {
        addMessage("Registered successfully!");
        addMessage("Congratulations!");
        return new RedirectResolution("/success.jsp").flash(this);
    }

    public void addMessage(String message) {
        FlashScope scope = FlashScope.getCurrent(getContext().getRequest(), true);
        List<String> messages = (List<String>) scope.get("messages");
        if (messages == null) {
            messages = new ArrayList<String>();
            scope.put("messages", messages);
        }
        messages.add(message);
    }

    @ValidationMethod(on = "register")
    public void userExsited(ValidationErrors errors) {
        if ("testuser".equals(username)) {
            errors.add("username", new SimpleError("This username is taken , please select a different one."));
        }
        if (!errors.isEmpty()) {
            errors.addGlobalError(new SimpleError("Error ocurs on save. Please fix it firstly."));
        }
    }

    public Resolution handleValidationErrors(ValidationErrors errors) throws Exception {
        //errors.addGlobalError(new SimpleError("Errors occured on registration."));
        return new ForwardResolution("/error.jsp");
    }
}
