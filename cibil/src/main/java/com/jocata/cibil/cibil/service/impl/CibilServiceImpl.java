package com.jocata.cibil.cibil.service.impl;

import com.jocata.cibil.cibil.Dao.*;
import com.jocata.cibil.cibil.entity.*;
import com.jocata.cibil.cibil.form.*;
import com.jocata.cibil.cibil.service.CibilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CibilServiceImpl implements CibilService {

    @Autowired
    private RemarkDao remarkDao;
    @Autowired
    private EnquiryDao enquiryDao;
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private CreditReportDao creditReportDao;
    @Autowired
    private CibilScoreDao cibilScoreDao;
    @Autowired
    private AddressDao addressDao;
    @Autowired
    private AccountDao accountDao;

    public CreditReportsResForm createCibil(@RequestBody CreditReportsReqForm reqForm) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // Save Credit Report
        CreditReports report = new CreditReports();
        report.setGeneratedOn(reqForm.getGeneratedOn() != null ? Date.valueOf(reqForm.getGeneratedOn()).toLocalDate() : null);
        CreditReports savedReport = creditReportDao.saveCreditReport(report);

        // Save Customer
        CustomerReqForm customerReq = reqForm.getCustomers();
        Customers customer = new Customers();
        customer.setFullName(customerReq.getFullName());
        customer.setDob(Date.valueOf(customerReq.getDob()));
        customer.setGender(customerReq.getGender());
        customer.setPan(customerReq.getPan());
        customer.setMobile(customerReq.getMobile());
        customer.setEmail(customerReq.getEmail());
        customer.setAadhar(customerReq.getAadhar());
        customer.setReport(report);
        Customers savedCustomer = customerDao.saveCustomer(customer);

        // Save Address
        AddressReqForm addressReq = customerReq.getAddress();
        Address address = new Address();
        address.setLine(addressReq.getLine());
        address.setStreet(addressReq.getStreet());
        address.setCity(addressReq.getCity());
        address.setState(addressReq.getState());
        address.setPincode(addressReq.getPincode());
        address.setCustomers(savedCustomer);
        Address savedAddress = addressDao.saveAddress(address);

        // Save Score
        CibilScoreReqForm scoreReq = reqForm.getCibilScores();
        CbilScores score = new CbilScores();
        score.setScore(Integer.valueOf((scoreReq.getScore())));
        score.setScoreDate(Date.valueOf(scoreReq.getScoreDate()));
        score.setRiskGrade(scoreReq.getRiskGrade());
        score.setReport(savedReport);
        CbilScores savedScore = cibilScoreDao.saveCibilScore(score);

        // Save Accounts
        List<AccountResForm> accountResForms = new ArrayList<>();
        for (AccountReqForm accountReq : reqForm.getAccounts()) {
            Accounts account = new Accounts();
            account.setAccountNumber(accountReq.getAccountNumber());
            account.setAccountType(accountReq.getAccountType());
            account.setMemberName(accountReq.getMemberName());
            account.setOwnership(accountReq.getOwnership());
            account.setDateOpened(Date.valueOf(accountReq.getDateOpened()));
            account.setLastPaymentDate(Date.valueOf(accountReq.getLastPaymentDate()));
            account.setCurrentBalance(new BigDecimal(accountReq.getCurrentBalance()));
            account.setCreditLimit(new BigDecimal(accountReq.getCreditLimit()));
            account.setSanctionedLimit(new BigDecimal(accountReq.getSanctionedLimit()));
            account.setEmiAmount(new BigDecimal(accountReq.getEmiAmount()));
            account.setTenureMonthly(Integer.valueOf((accountReq.getTenureMonthly())));
            account.setPaymentHistory(accountReq.getPaymentHistory());
            account.setAccountStatus(accountReq.getAccountStatus());
            account.setReport(savedReport);
            Accounts savedAccount = accountDao.saveAccount(account);

            AccountResForm res = new AccountResForm();
            res.setAccountNumber(savedAccount.getAccountNumber());
            res.setMemberName(savedAccount.getMemberName());
            res.setAccountType(savedAccount.getAccountType());
            res.setOwnership(savedAccount.getOwnership());
            res.setCurrentBalance(savedAccount.getCurrentBalance().toPlainString());
            res.setCreditLimit(savedAccount.getCreditLimit().toPlainString());
            res.setDateOpened(savedAccount.getDateOpened().toString());
            res.setSanctionedLimit(savedAccount.getSanctionedLimit().toPlainString());
            res.setEmiAmount(savedAccount.getEmiAmount().toPlainString());
            res.setLastPaymentDate(savedAccount.getLastPaymentDate().toString());
            res.setTenureMonthly(String.valueOf(savedAccount.getTenureMonthly()));
            res.setPaymentHistory(savedAccount.getPaymentHistory());
            res.setAccountStatus(savedAccount.getAccountStatus());

            accountResForms.add(res);
        }

        // Save Enquiries
        List<EnquriesResForm> enquiryResForms = new ArrayList<>();
        for (EnquriesReqForm enquiryReq : reqForm.getEnquries()) {
            Enquries enquiry = new Enquries();
            enquiry.setEnquryDate(Date.valueOf(enquiryReq.getEnquryDate()));
            enquiry.setMemberName(enquiryReq.getMemberName());
            enquiry.setEnquryPurpose(enquiryReq.getEnquryPurpose());
            enquiry.setEnquryAmount(new BigDecimal(enquiryReq.getEnquryAmount()));
            enquiry.setReport(savedReport);
            Enquries savedEnquiry = enquiryDao.saveEnquiry(enquiry);

            EnquriesResForm res = new EnquriesResForm();
            res.setMemberName(savedEnquiry.getMemberName());
            res.setEnquryDate(savedEnquiry.getEnquryDate().toString());
            res.setEnquryAmount(savedEnquiry.getEnquryAmount().toPlainString());
            res.setEnquryPurpose(savedEnquiry.getEnquryPurpose());

            enquiryResForms.add(res);
        }
        

        // Save Remarks
        List<RemarkResForm> remarkResForms = new ArrayList<>();
        for (RemarkReqForm remarkReq : reqForm.getRemarks()) {
            Remarks remark = new Remarks();
            remark.setDescription(remarkReq.getDescription());
            remark.setReport(savedReport);
            Remarks savedRemark = remarkDao.saveRemark(remark);

            RemarkResForm res = new RemarkResForm();
            res.setDescription(savedRemark.getDescription());
            remarkResForms.add(res);
        }

        // Prepare final response
        CreditReportsResForm response = new CreditReportsResForm();
        response.setReportId(String.valueOf(savedReport.getReportId()));
        response.setGeneratedOn(savedReport.getGeneratedOn() != null ? savedReport.getGeneratedOn().format(formatter) : "N/A");

        CustomerResForm customerRes = new CustomerResForm();
        customerRes.setFullName(savedCustomer.getFullName());
        customerRes.setMobile(savedCustomer.getMobile());
        customerRes.setGender(savedCustomer.getGender());
        customerRes.setEmail(savedCustomer.getEmail());
        customerRes.setPan(savedCustomer.getPan());
        customerRes.setDob(savedCustomer.getDob().toString());
        customerRes.setAadhar(savedCustomer.getAadhar());

        AddressResForm addressRes = new AddressResForm();
        addressRes.setLine(savedAddress.getLine());
        addressRes.setStreet(savedAddress.getStreet());
        addressRes.setCity(savedAddress.getCity());
        addressRes.setState(savedAddress.getState());
        addressRes.setPincode(savedAddress.getPincode());
        customerRes.setAddress(addressRes);

        response.setCustomers(customerRes);

        CibilScoreResForm scoreRes = new CibilScoreResForm();
        scoreRes.setScore(String.valueOf(savedScore.getScore()));
        scoreRes.setScoreDate(savedScore.getScoreDate().toString());
        scoreRes.setRiskGrade(savedScore.getRiskGrade());
        response.setCibilScores(scoreRes);

        response.setAccounts(accountResForms);
        response.setEnquries(enquiryResForms);
        response.setRemarks(remarkResForms);

        return response;
    }

    public CreditReportsResForm getCibil(String pan) {
        try {
            if (pan == null || pan.trim().isEmpty()) {
                throw new IllegalArgumentException("PAN must not be null or empty");
            }

            Customers customer = customerDao.findCustomerByPan(pan);
            if (customer == null) {
                throw new RuntimeException("Customer not found with PAN: " + pan);
            }

            CreditReports report = customer.getReport();
            if (report == null) {
                throw new RuntimeException("Credit report not found for PAN: " + pan);
            }

            Integer reportId = report.getReportId();
            if (reportId == null) {
                throw new RuntimeException("Report ID is null for PAN: " + pan);
            }

            // Defensive loading of child data
            List<Accounts> accounts = Optional.ofNullable(accountDao.findAccountsByReportId(String.valueOf(reportId)))
                    .orElse(new ArrayList<>());

            List<Enquries> enquiries = Optional.ofNullable(enquiryDao.findEnquiriesByReportId(String.valueOf(reportId)))
                    .orElse(new ArrayList<>());

            List<Remarks> remarks = Optional.ofNullable(remarkDao.findRemarksByReportId(String.valueOf(reportId)))
                    .orElse(new ArrayList<>());

            CbilScores score = cibilScoreDao.findScoreByReportId(String.valueOf(reportId));
            Address address = addressDao.findAddressByCustomerId(String.valueOf(customer.getCustomerId()));

            CreditReportsResForm response = new CreditReportsResForm();
            response.setReportId(String.valueOf(reportId));
            response.setGeneratedOn(report.getGeneratedOn() != null
                    ? report.getGeneratedOn().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                    : "N/A");

            // Fill customer details
            CustomerResForm customerRes = new CustomerResForm();
            customerRes.setFullName(customer.getFullName());
            customerRes.setDob(customer.getDob() != null ? customer.getDob().toString() : "N/A");
            customerRes.setGender(customer.getGender());
            customerRes.setPan(customer.getPan());
            customerRes.setMobile(customer.getMobile());
            customerRes.setEmail(customer.getEmail());
            customerRes.setAadhar(customer.getAadhar());

            // Address
            if (address != null) {
                AddressResForm addressRes = new AddressResForm();
                addressRes.setLine(address.getLine());
                addressRes.setStreet(address.getStreet());
                addressRes.setCity(address.getCity());
                addressRes.setState(address.getState());
                addressRes.setPincode(address.getPincode());
                customerRes.setAddress(addressRes);
            } else {
                System.out.println("No address found for customerId = " + customer.getCustomerId());
                customerRes.setAddress(null);
            }

            response.setCustomers(customerRes);

            // Score
            if (score != null) {
                CibilScoreResForm scoreRes = new CibilScoreResForm();
                scoreRes.setScore(String.valueOf(score.getScore()));
                scoreRes.setScoreDate(score.getScoreDate() != null ? score.getScoreDate().toString() : "N/A");
                scoreRes.setRiskGrade(score.getRiskGrade());
                response.setCibilScores(scoreRes);
            } else {
                System.out.println("No score found for reportId = " + reportId);
            }

            // Accounts
            List<AccountResForm> accountResList = new ArrayList<>();
            for (Accounts acc : accounts) {
                AccountResForm accRes = new AccountResForm();
                accRes.setAccountNumber(acc.getAccountNumber());
                accRes.setAccountType(acc.getAccountType());
                accRes.setMemberName(acc.getMemberName());
                accRes.setOwnership(acc.getOwnership());
                accRes.setDateOpened(String.valueOf(acc.getDateOpened().toLocalDate()));
                accRes.setLastPaymentDate(String.valueOf(acc.getLastPaymentDate().toLocalDate()));
                accRes.setCurrentBalance(String.valueOf(acc.getCurrentBalance()));
                accRes.setCreditLimit(String.valueOf(acc.getCreditLimit()));
                accRes.setSanctionedLimit(String.valueOf(acc.getSanctionedLimit()));
                accRes.setEmiAmount(String.valueOf(acc.getEmiAmount()));
                accRes.setTenureMonthly(String.valueOf(acc.getTenureMonthly()));
                accRes.setPaymentHistory(acc.getPaymentHistory());
                accRes.setAccountStatus(acc.getAccountStatus());
                accountResList.add(accRes);
            }
            response.setAccounts(accountResList);

            // Enquiries
            List<EnquriesResForm> enquiryResList = new ArrayList<>();
            for (Enquries enq : enquiries) {
                EnquriesResForm enqRes = new EnquriesResForm();
                enqRes.setMemberName(enq.getMemberName());
                enqRes.setEnquryPurpose(enq.getEnquryPurpose());
                enqRes.setEnquryAmount(String.valueOf(enq.getEnquryAmount()));
                enqRes.setEnquryDate(enq.getEnquryDate() != null ? enq.getEnquryDate().toString() : "N/A");
                enquiryResList.add(enqRes);
            }
            response.setEnquries(enquiryResList);

            // Remarks
            List<RemarkResForm> remarkResList = new ArrayList<>();
            for (Remarks rem : remarks) {
                RemarkResForm remRes = new RemarkResForm();
                remRes.setDescription(rem.getDescription());
                remarkResList.add(remRes);
            }
            response.setRemarks(remarkResList);

            return response;

        } catch (Exception e) {
            System.err.println("Error in getCibil: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Internal error while processing getCibil: " + e.getMessage(), e);
        }
    }

}
