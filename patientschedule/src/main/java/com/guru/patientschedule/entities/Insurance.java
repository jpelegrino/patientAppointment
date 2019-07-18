package com.guru.patientschedule.entities;

import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
public class Insurance {

    private String providerName;
    private BigDecimal copay;

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public BigDecimal getCopay() {
        return copay;
    }

    public void setCopay(BigDecimal copay) {
        this.copay = copay;
    }
}
