package com.sw.acs.domain;

/**
 * @author: ZZP
 * @time: 2021/4/3 17:31
 */
public class Question {
    private Integer id;
    private String describe;
    private String standardAns;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getStandardAns() {
        return standardAns;
    }

    public void setStandardAns(String standardAns) {
        this.standardAns = standardAns;
    }

    @Override
    public String toString() {
        return "question{" +
                "id=" + id +
                ", describe='" + describe + '\'' +
                ", standardAns='" + standardAns + '\'' +
                '}';
    }
}
