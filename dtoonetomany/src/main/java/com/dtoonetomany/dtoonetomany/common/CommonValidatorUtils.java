package com.dtoonetomany.dtoonetomany.common;

import com.dtoonetomany.dtoonetomany.exception.FieldNotUniqueException;
import com.dtoonetomany.dtoonetomany.exception.MissingRequiredFieldException;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Component;

@Component
public class CommonValidatorUtils <T, S>{

    public void validateUniqueField(String fieldName, T checkingObj, S foundObj) {
        // Use BeanWrapper to get the value of a field that is specified on runtime
        BeanWrapperImpl checkingObjWrapper = new BeanWrapperImpl(checkingObj);
        Object checkingObjId = checkingObjWrapper.getPropertyValue("id");
        String checkingObjFieldValue = checkingObjWrapper.getPropertyValue(fieldName).toString();

        BeanWrapperImpl foundObjWrapper = new BeanWrapperImpl(foundObj);
        Object foundObjId = foundObjWrapper.getPropertyValue("id");

        // Save case
        if (checkingObjId == null) {
            throw new FieldNotUniqueException(checkingObjFieldValue);
        }

        // Update case
        if(checkingObjId != null) {
            // Trying to update an object, using a taken(not unique) value
            if(checkingObjId != foundObjId) {
                throw new FieldNotUniqueException(checkingObjFieldValue);
            }
        }
    }

    public void validateRequiredField(String fieldLabel, T fieldValue) {
        if(fieldValue == null)
            throw new MissingRequiredFieldException(fieldLabel);
    }
}
