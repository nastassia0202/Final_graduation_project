package baseEntities;


import pages.*;

public class InitPages {

    public LoginPage loginPage;
    public HomePage homePage;
    public InvoicesPage invoicesPage;
    public InvoiceAddPage invoiceAddPage;
    public InvoicesImportPage invoicesImportPage;
    public PersonalDataPage personalDataPage;
    public ServicesPage servicesPage;


    public InitPages() {
        loginPage = PageBuilder.buildLoginPage();
        homePage = PageBuilder.buildHomePage();
        invoicesPage = PageBuilder.buildInvoicesPage();
        invoiceAddPage = PageBuilder.buildInvoiceAddPage();
        invoicesImportPage = PageBuilder.buildInvoicesImportPage();
        personalDataPage = PageBuilder.buildPersonalDataPage();
        servicesPage = PageBuilder.buildServicesPage();

    }
}
