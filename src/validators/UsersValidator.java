package validators;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import models.User;
import utils.DBUtil;


public class UsersValidator {

    public static List<String> validate(User u , Boolean emailDuplicateCheckFlag , Boolean passwordCheckFlag){
        List<String> errors=new ArrayList<String>();

        String name_error=_validateName(u.getName());
        if(!name_error.equals("")){
            errors.add(name_error);
        }

        String email_error=_validateEmail(u.getEmail() , emailDuplicateCheckFlag);
        if(!email_error.equals("")){
            errors.add(email_error);
        }

        String password_error=validatePassword(u.getPassword(),passwordCheckFlag);
        if(!password_error.equals("")){
            errors.add(password_error);
        }

        String birthday_error=_validateBirthday(u.getBirthday());
        if(!birthday_error.equals("")){
            errors.add(birthday_error);
        }


        return errors;

    }


    private  static String _validateName(String name){
        if(name == null || name.equals("")) {
            return "氏名を入力してください。";
            }

        return "";
    }

    private static String _validateEmail(String email ,  Boolean emailDuplicateCheckFlag) {
        if(email == null || email.equals("")) {
            return "Emailアドレスを入力してください。";
            }

        if(emailDuplicateCheckFlag) {
            EntityManager em = DBUtil.createEntityManager();
            long users_count = (long)em.createNamedQuery("checkRegisteredCode_u", Long.class)
                                               .setParameter("email", email)
                                               .getSingleResult();
            em.close();
            if(users_count > 0) {
                return "入力されたemailは重複のため、利用できません。";
            }
        }


        return "";
    }

    private static String _validateBirthday(Date birthday) {
        if(birthday == null || birthday.equals("0000-00-00") ) {
            return "生年月日を入力してください。";
            }


        return "";
    }


    private static String validatePassword(String password, Boolean passwordDuplicateCheckFlag) {

        if(passwordDuplicateCheckFlag && (password == null || password.equals(""))) {
            return "! パスワードを入力してください !";
        }

        return "";
    }


}
