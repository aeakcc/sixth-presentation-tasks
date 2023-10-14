import java.util.Random;
import java.util.Scanner;

class EmailApplication {
    private String firstname;
    private String lastname;
    private String department;
    private String companyEmail;
    private String password;
    private int mailBoxCapacity;

    public int getMailBoxCapacity() {
        return mailBoxCapacity;
    }

    public void setMailBoxCapacity(int mailBoxCapacity) {
        this.mailBoxCapacity = mailBoxCapacity;
    }

    public void setPassword(){
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~!@#$%^&*()_+{}:<>?[];'./,";
        int passwordLength = 10;

        Random random = new Random();
        String generatedPassword = "";

        for (int i = 0; i < passwordLength; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            generatedPassword += randomChar;
        }

        password = generatedPassword;
    }
    public String getPassword(){
        return password;
    }
    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail() {
        companyEmail = firstname.toLowerCase() + "." + lastname.toLowerCase() + "."
                + "@" + department + ".aecompany.com";
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}

class Application {
    public static void Sout(EmailApplication emailApplication){
        Scanner scan = new Scanner(System.in);
        int input;
        System.out.println("New worker: " + emailApplication.getFirstname() + ". Department Codes:");
        System.out.println("1 for Sales");
        System.out.println("2 for Development");
        System.out.println("3 for Accounting");
        System.out.println("0 for none");
        System.out.println("Enter the department code:");
        input = scan.nextInt();
        ForNone forNone = new ForNone(input, emailApplication);
        ForAccounting forAccounting = new ForAccounting(input, emailApplication);
        ForDevelopment forDevelopment = new ForDevelopment(input, emailApplication);
        ForSales forSales = new ForSales(input, emailApplication);
    }
}
class ForNone {
    public ForNone(int condition, EmailApplication emailApplication){
        if (condition == 0){
            emailApplication.setDepartment("");
            emailApplication.setCompanyEmail();
            System.out.println("Department: ");
            System.out.println("Your password: " + emailApplication.getPassword());
            System.out.println("Display name: " + emailApplication.getFirstname() + " " + emailApplication.getLastname());
            System.out.println("Company email: " + emailApplication.getCompanyEmail());
            System.out.println("Mailbox capacity: " + emailApplication.getMailBoxCapacity() + "mb");
        }
    }
}
class ForAccounting {
    public ForAccounting(int condition, EmailApplication emailApplication){
        if (condition == 3){
            emailApplication.setDepartment("acct");
            emailApplication.setCompanyEmail();
            System.out.println("Department: " + emailApplication.getDepartment());
            System.out.println("Your password: " + emailApplication.getPassword());
            System.out.println("Display name: " + emailApplication.getFirstname() + " " + emailApplication.getLastname());
            System.out.println("Company email: " + emailApplication.getCompanyEmail());
            System.out.println("Mailbox capacity: " + emailApplication.getMailBoxCapacity() + "mb");
        }
    }
}
class ForDevelopment {
    public ForDevelopment(int condition, EmailApplication emailApplication){
        if (condition == 2){
            emailApplication.setDepartment("dev");
            emailApplication.setCompanyEmail();
            System.out.println("Department: " + emailApplication.getDepartment());
            System.out.println("Your password: " + emailApplication.getPassword());
            System.out.println("Display name: " + emailApplication.getFirstname() + " " + emailApplication.getLastname());
            System.out.println("Company email: " + emailApplication.getCompanyEmail());
            System.out.println("Mailbox capacity: " + emailApplication.getMailBoxCapacity() + "mb");
        }
    }
}
class ForSales {
    public ForSales(int condition, EmailApplication emailApplication){
        if (condition == 1){
            emailApplication.setDepartment("sales");
            emailApplication.setCompanyEmail();
            System.out.println("Department: " + emailApplication.getDepartment());
            System.out.println("Your password: " + emailApplication.getPassword());
            System.out.println("Display name: " + emailApplication.getFirstname() + " " + emailApplication.getLastname());
            System.out.println("Company email: " + emailApplication.getCompanyEmail());
            System.out.println("Mailbox capacity: " + emailApplication.getMailBoxCapacity() + "mb");
        }
    }
}
class Main {
    public static void main(String[] args) {
        EmailApplication emailApplication = new EmailApplication();
        emailApplication.setFirstname("John");
        emailApplication.setLastname("Smith");
        emailApplication.setPassword();
        emailApplication.setMailBoxCapacity(500);
        Application.Sout(emailApplication);
    }
}
