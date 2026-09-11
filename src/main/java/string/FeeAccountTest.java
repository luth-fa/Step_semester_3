package string;

import java.util.Scanner;

class FeeAccount {

    private String regNo;
    private double totalFee;
    private double amountPaid;

    FeeAccount(String regNo, double totalFee) {
        this.regNo = regNo;
        this.totalFee = totalFee;
        this.amountPaid = 0;
    }

    void pay(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid payment");
        } else {
            amountPaid += amount;
        }
    }

    double getDue() {
        return totalFee - amountPaid;
    }
}


class HostelFeeAccount extends FeeAccount {

    HostelFeeAccount(String regNo, double totalFee) {
        super(regNo, totalFee);
    }

    void payInTwoInstallments(double amount) {

        pay(amount);
        pay(amount);
    }
}


class ScholarshipFeeAccount extends FeeAccount {

    private double scholarshipPercent;

    ScholarshipFeeAccount(String regNo, double totalFee, double scholarshipPercent) {
        super(regNo, totalFee);
        this.scholarshipPercent = scholarshipPercent;
    }

    double effectiveDue() {

        double due = getDue();
        double discount = due * scholarshipPercent / 100;

        return due - discount;
    }
}


public class FeeAccountTest {

    public static void main(String[] args) {

        FeeAccount plain = new FeeAccount("RA001", 100000);

        HostelFeeAccount hostel = new HostelFeeAccount("RA002", 200000);

        ScholarshipFeeAccount scholarship =
                new ScholarshipFeeAccount("RA003", 200000, 20);

        plain.pay(100000);

        hostel.payInTwoInstallments(30000);

        scholarship.pay(20000);

        System.out.println("Plain Account Due: " + plain.getDue());
        System.out.println("Hostel Account Due: " + hostel.getDue());
        System.out.println("Scholarship Effective Due: "
                + scholarship.effectiveDue());

        if (hostel instanceof HostelFeeAccount) {
            System.out.println("Hostel account supports two installments.");
        }

        if (scholarship instanceof ScholarshipFeeAccount) {
            System.out.println("Scholarship account has discount.");
        }
    }
}