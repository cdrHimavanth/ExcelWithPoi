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
public class Bid {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;

    @Column
    private int orderNumber;

    @Column
    private int positionNumber;

    @Column
    private int bidRate;

    @Column
    private String profileSumitted;

    @Column
    private String bidStatus;

    @Column
    private Date bidReceivedDate;

    @Column
    private String overTarget;

    @Column
    private Date interviewDate;

    @Column
    private String interviewResult;

    @Column
    private String declinedCode;

    @Column
    private String declinedReason;

    @Column
    private Date declinedDate;

    @Override
    public String toString() {
        return "Bid{" +
                "id=" + id +
                ", orderNumber=" + orderNumber +
                ", positionNumber=" + positionNumber +
                ", bidRate=" + bidRate +
                ", profileSumitted='" + profileSumitted + '\'' +
                ", bidStatus='" + bidStatus + '\'' +
                ", bidReceivedDate='" + bidReceivedDate + '\'' +
                ", overTarget='" + overTarget + '\'' +
                ", interviewDate='" + interviewDate + '\'' +
                ", interviewResult='" + interviewResult + '\'' +
                ", declinedCode='" + declinedCode + '\'' +
                ", declinedReason='" + declinedReason + '\'' +
                ", declinedDate='" + declinedDate + '\'' +
                ", poNumber='" + poNumber + '\'' +
                '}';
    }

    @Column
    private String poNumber;


}
