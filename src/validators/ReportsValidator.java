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

        String content_error=_validateContent(r.getContent());
        if(!content_error.equals("")){
            errors.add(content_error);
        }

        String industry_error=_validateIndustry(r.getIndustry());
        if(!industry_error.equals("")){
            errors.add(industry_error);
        }

        String budget_error=_validateBudget(r.getBudget());
        if(!budget_error.equals("")){
            errors.add(budget_error);
        }

        String place_prefecture_error=_validatePlace_prefecture(r.getPlace_prefecture());
        if(!place_prefecture_error.equals("")){
            errors.add(place_prefecture_error);
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

    private static String _validatePlace_prefecture(String place_prefecture) {
        if(place_prefecture == null || place_prefecture.equals("未登録")) {
            return "お悩みに関係の都道府県を入力してください。";
            }

        return "";
    }

    private static String _validateIndustry(String industry) {
        if(industry == null || industry.equals("未登録")) {
            return "お悩みに関係の業種を入力してください。";
            }

        return "";
    }

    private static String _validateBudget(Integer budget) {
        if(budget == null || budget == 0) {
            return "ご予算を入力してください。";
            }

        return "";
    }

}
