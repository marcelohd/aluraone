package br.dev.marcelohd.conversor.moedas.dominio;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Currency{

    @SerializedName("base_code")
    private String currencyBase;
    @SerializedName("target_code")
    private String currencyTarget;
    private Double conversion_rate;

    public String getCurrencyBase() {
        return currencyBase;
    }
    
    public void setCurrencyBase(String currencyBase) {
        this.currencyBase = currencyBase;
    }
    
    public String getCurrencyTarget() {
        return currencyTarget;
    }
    
    public void setCurrencyTarget(String currencyTarget) {
        this.currencyTarget = currencyTarget;
    }
    
    public Double getConversion_rate() {
        return conversion_rate;
    }
    
    public void setConversion_rate(Double conversion_rate) {
        this.conversion_rate = conversion_rate;
    }

    @Override
    public String toString() {
        return "Currency [currencyBase=" + currencyBase + ", currencyTarget=" + currencyTarget + ", conversion_rate="
                + conversion_rate + "]";
    }

    
    
}