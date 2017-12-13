package cn.xu419.dao;

import cn.xu419.domain.Radio;

import java.util.List;

public interface RadioDao{
    public boolean addRadio(Radio radio);
    public boolean delRadioByNum(int num);
    public List<Radio> findAllRadioByCourse(String course);
    public List<Radio> getAllRadio();
    public boolean updateRadio(Radio radio);
    public Radio findRadioByNum(String num);
    public List<Radio> findAllRadioBySomething(String option);
}
