package com.stg.excel_work.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Position{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;

    @Column
    private int orderNumber;

    @Column
    private int noOfPositions;

    @Column
    private int targetRate;

    @Column
    private String productLine;

    @Column
    private String recruiter;

    @Column
    private Date positionBroadcastedDate;

    @Column
    private String stratification;

    @Column
    private String skillGroup;

    @Column
    private String primarySkill;

    @Column(length = 3000)
    private String skillset;

    @Column(length = 5000)
    private String jobDescription;

    @Column
    private String positionType;

    @Column
    private String didCustomerReachedOut;

    @Column
    private int probability;

    @Column
    private String submittedAboveTarget;

    @Column
    private String region;

    @Column
    private String lineOfBusiness;

    @Column
    private String ll6;

    @Column
    private String LL5;

    @Column
    private String LL4;

    @Column
    private String LL3;

    @Column
    private String positionOpenMonth;


    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", orderNumber=" + orderNumber +
                ", noOfPositions=" + noOfPositions +
                ", targetRate=" + targetRate +
                ", productLine=" + productLine +
                ", recruiter='" + recruiter + '\'' +
                ", positionBroadcastedDate=" + positionBroadcastedDate +
                ", stratification='" + stratification + '\'' +
                ", skillGroup='" + skillGroup + '\'' +
                ", primarySkill='" + primarySkill + '\'' +
                ", skillset='" + skillset + '\'' +
                ", jobDescription='" + jobDescription + '\'' +
                ", positionType='" + positionType + '\'' +
                ", didCustomerReachedOut='" + didCustomerReachedOut + '\'' +
                ", probability='" + probability + '\'' +
                ", submittedAboveTarget='" + submittedAboveTarget + '\'' +
                ", region='" + region + '\'' +
                ", lineOfBusiness='" + lineOfBusiness + '\'' +
                ", ll6='" + ll6 + '\'' +
                ", LL5='" + LL5 + '\'' +
                ", LL4='" + LL4 + '\'' +
                ", LL3='" + LL3 + '\'' +
                ", positionOpenMonth='" + positionOpenMonth + '\'' +
                '}';
    }
}
