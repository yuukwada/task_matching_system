package validators;

import java.util.ArrayList;
import java.util.List;

import models.Report;

public class ReportsValidator {

    public static List<String> validate(Report r){
        List<String> errors=new ArrayList<String>();

        String name_error=_validateTitle(r.getTitle());
        if(!name_error.equals("")){
            errors.add(name_error);
        }

        String email_error=_validateContent(r.getContent());
        if(!email_error.equals("")){
            errors.add(email_error);
        }

        String industry_error=_validateIndustry(r.getIndustry());
        if(!industry_error.equals("")){
            errors.add(industry_error);
        }

        String budget_error=_validateBudget(r.getBudget());
        if(!budget_error.equals("")){
            errors.add(budget_error);
        }





        return errors;


    }

    private  static String _validateTitle(String title){
        if(title == null || title.equals("")) {
            return "タイトルを入力してください。";
            }

        return "";
    }

    private static String _validateContent(String content) {
        if(content == null || content.equals("")) {
            return "内容を入力してください。";
            }


        return "";
    }

    private static String _validateIndustry(String industry) {
        if(industry == null || industry.equals("") ) {
            return "お悩みに関係の業種を入力してください。";
            }


        return "";
    }

    private static String _validateBudget(Integer budget) {
        if(budget == null || budget.equals("") ) {
            return "パスワードを入力してください。";
            }


        return "";
    }

}
