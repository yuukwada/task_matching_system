package validators;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import models.Company;
import utils.DBUtil;


public class CompaniesValidator {

    public static List<String> validate(Company c , Boolean emailDuplicateCheckFlag , Boolean passwordCheckFlag){
        List<String> errors=new ArrayList<String>();

        String name_error=_validateName(c.getName());
        if(!name_error.equals("")){
            errors.add(name_error);
        }

        String email_error=_validateEmail(c.getEmail(),emailDuplicateCheckFlag);
        if(!email_error.equals("")){
            errors.add(email_error);
        }

        String password_error=validatePassword(c.getPassword(),passwordCheckFlag);
        if(!password_error.equals("")){
            errors.add(password_error);
        }





        return errors;


    }

    private  static String _validateName(String name){
        if(name == null || name.equals("")) {
            return "企業名を入力してください。";
            }

        return "";
    }

    private static String _validateEmail(String email , Boolean emailDuplicateCheckFlag) {
        if(email == null || email.equals("")) {
            return "企業のEmailアドレスを入力してください。";
        }

        if(emailDuplicateCheckFlag) {
            EntityManager em = DBUtil.createEntityManager();
            long users_count = (long)em.createNamedQuery("checkRegisteredCode_c", Long.class)
                                               .setParameter("email", email)
                                               .getSingleResult();
            em.close();
            if(users_count > 0) {
                return "入力されたemailは重複のため、利用できません。";
            }
        }

        return "";
    }

    private static String validatePassword(String password, Boolean passwordCheckFlag) {

        if(passwordCheckFlag && (password == null || password.equals(""))) {
            return "! パスワードを入力してください !";
        }
        return "";
    }



}
