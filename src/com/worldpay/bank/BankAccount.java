package com.worldpay.bank;

public class BankAccount {
	
	//instance variables
	public long accNo;
	public String cust_Name;
	public double balance;
	public String accType;
	
	//static variables
	public static int totalDepositors;
	public static int totalWithdrawers;
	
	public static double totalDeposits;
	public static double totalWithdraws;
	
	
	//initialize method
	public void initialize(long accNum,String name,double bal,String type)
	{
		this.accNo=accNum;
		this.cust_Name=name;
		this.balance=bal;
		this.accType=type;
		
	}
	
	//display Account Details
	public void displayAccount()
	{
		System.out.println("Account No is "+this.accNo);
		System.out.println("Customer Name is "+this.cust_Name);
		System.out.println("Account Balance is "+this.balance);
		System.out.println("Account Type is "+this.accType);
		System.out.println("...................................");
	}
	
	
	//Withdraw Money
	public void withdrawMoney(double amt)
	{
		if(this.balance<amt)
		{
			System.out.println("Insufficient Balance");
		}
		else
		{
		this.balance=this.balance-amt;
		System.out.println("Amount of "+amt+" withdraw successfully");
		System.out.println("Available Balance "+this.balance);
		System.out.println("...................................");
		totalWithdrawers++;
		totalWithdraws+=amt;
		}
		
	}
	
	//Deposit Money
	public void depositMoney(double amt)
	{
		this.balance=this.balance+amt;
		System.out.println("Amount of "+amt+" deposited successfully");
		System.out.println("Available Balance "+this.balance);
		System.out.println("...................................");
		totalDepositors++;
		totalDeposits+=amt;
			
	}
	
	//Display Provisions
	
	public static void displayProvisions()
	{
		System.out.println("Total Depositors= "+totalDepositors+" Total Withdrawers= "+totalWithdrawers);
		System.out.println("...................................");
	}
	
	
	//Display Total deposits
	public static void displayTotalDeposits()
	{
		System.out.println("Total Deposits= "+totalDeposits);
		System.out.println("...................................");
	}
	
	//Display Total Withdraws
	public static void displayTotalWithdraws()
	{
		System.out.println("Total Withdraws= "+totalWithdraws);
		System.out.println("...................................");
	}
	
	
	//Display Average Balance
	public static void avg_Balance(BankAccount...accounts)
	{
		double sum=0;
		for(BankAccount ba:accounts)
		{
			sum+=ba.balance;
		}
		double avg_Balance=sum/accounts.length;
		System.out.println("Average Balance of "+accounts.length+" accounts is "+avg_Balance);
		System.out.println("...................................");
	}
	
	//Constructors
	
	public BankAccount()
	{
		
	}
	
	public BankAccount(long accNum,String name,double bal,String type)
	{
		this.accNo=accNum;
		this.cust_Name=name;
		this.balance=bal;
		this.accType=type;
	}
	
	
	
	
//Main Function
	public static void main(String[] args) {
		
		//First Account
		BankAccount bac=new BankAccount();
		bac.initialize(193101, "Manav",50000,"Saving");
		bac.displayAccount();
		bac.depositMoney(500);
		bac.withdrawMoney(200);
		
		//Second Account
		BankAccount bac1=new BankAccount();
		bac1.initialize(193102, "Anuj",70000,"Saving");
		bac1.displayAccount();
		bac1.depositMoney(400);
		bac1.withdrawMoney(400);
		
		//Third Account
		BankAccount bac2=new BankAccount(193102,"Shivam",90000,"Saving");
		bac2.displayAccount();
        BankAccount.displayTotalDeposits();
        BankAccount.displayTotalWithdraws();
		BankAccount.displayProvisions();
		BankAccount.avg_Balance(bac,bac1,bac2);
		
	
		
	}

}
