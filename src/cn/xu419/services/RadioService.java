package cn.xu419.services;

import cn.xu419.dao.DaoFactory;
import cn.xu419.dao.RadioDao;
import cn.xu419.domain.Answer;
import cn.xu419.domain.Radio;

public class RadioService {
    private RadioDao radioDao = DaoFactory.createRadioDao();

    public RadioService(){
    }

    public Answer getAnswer(String num, String answer){
        Answer result = new Answer();
        Radio radio = radioDao.findRadioByNum(num);
        result.setAnswer(answer);
        result.setRightAnswer(radio.getOptionOne());
        if(radio.getOptionOne().equals(answer)){
            result.setScore(radio.getScore());
        }
        else {
            result.setScore(0);
        }
        result.setStem(radio.getStem());
        return result;
    }
    public boolean addRadio(Radio radio){
        boolean result = false;
        if(radioDao.addRadio(radio)){
            result = true;
        }
        return result;
    }
}
